package spring;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {


		List<Member> results = getResultForQuery("select * from MEMBER where EMAIL = \"" + email + "\"");
		return results.isEmpty() ? null : results.get(0);
	}

	public List<Member> selectAll() {
		List<Member> results = getResultForQuery("select * from member");
		return results;
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


	public List<Member> getResultForQuery(String sql) {

		/* 정석
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER wher EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet resultSet, int i) throws SQLException {
						Member member = new Member(
								resultSet.getString("EMAIL"),
								resultSet.getString("PASSWORD"),
								resultSet.getString("NAME"),
								resultSet.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(resultSet.getLong("ID"));
						return member;
					}
				}, email);*/

		// 람다 식
		List <Member> results = jdbcTemplate.query(sql,
				(ResultSet rs, int rowNum) -> {
					Member member = new Member(
							rs.getString("EMAIL"),
							rs.getString("PASSWORD"),
							rs.getString("NAME"),
							rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				});
		return results;
	}
}
