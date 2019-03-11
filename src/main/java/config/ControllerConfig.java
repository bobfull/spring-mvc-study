package config;

import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private MemberRegisterService memberRegSvc;

    @Autowired
    private AuthService authService;

    @Autowired
    private ChangePasswordService changePwdService;

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegSvc);

        return controller;
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setAuthService(authService);

        return controller;
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangePwdController changePwdController() {
        ChangePwdController controller = new ChangePwdController();
        controller.setChangePasswordService(changePwdService);

        return controller;
    }

    @Bean
    public MemberListController memberListController() {
        MemberListController controller = new MemberListController();
        controller.setMemberDao(memberDao);

        return controller;
    }
}
