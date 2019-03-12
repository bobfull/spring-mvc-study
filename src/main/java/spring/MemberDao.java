package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	private RowMapper<Member> memRowMapper =
			(ResultSet rs, int i) -> {
				Member member = new Member(rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			};

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
		return count;
	}

	public void update(Member member) {
		jdbcTemplate.update(
				"update member set name = ?, password = ? where email = ? ",
				member.getName(), member.getPassword(), member.getEmail());
	}

	public void insert(final Member member){
		KeyHolder keyHolder = new GeneratedKeyHolder();

		/*
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into " +
								"member(email, password, name, regdate" +
								"values(?, ?, ?, ?)",
						new String[]{"id"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		}, keyHolder);
		*/

		jdbcTemplate.update((Connection con) -> {
				PreparedStatement pstmt = con.prepareStatement("insert into " +
								"member(email, password, name, regdate) " +
								"values(?, ?, ?, ? ) ",
						new String[]{"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());

	}

	public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to) {

		List<Member> results = jdbcTemplate.query(
				"select * from member where regdate between ? and ? order by regdate desc",
				memRowMapper, from, to);

		return results;

	}

	public Member selectByEmail(String email) {

		List<Member> results = jdbcTemplate.query(
				"select * from member where email = ?",
				memRowMapper, email);


		return results.isEmpty() ? null : results.get(0);
	}

	public Member selectById(Long id) {

		List<Member> results = jdbcTemplate.query(
				"select * from member where id = ?",
				memRowMapper, id);


		return results.isEmpty() ? null : results.get(0);
	}


	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from member",
				memRowMapper);
		return results;
	}

}
