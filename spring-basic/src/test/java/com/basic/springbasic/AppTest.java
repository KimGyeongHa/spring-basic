package com.basic.springbasic;

import com.basic.springbasic.member.MemberService;
import com.basic.springbasic.store.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class AppTest {

    @Test
    public void saveApp(){

        AppConfig appConfig = new AppConfig();
        AppService appService = appConfig.appService();

        App app = new App();
        app.setAppId(1L);
        app.setAppPrice(3000);
        app.setAppName("티빙");

        appService.saveApp(app);
    }


}
