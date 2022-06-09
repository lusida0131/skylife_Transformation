package com.skylife_Transformation.skylifeTest;

import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.service.SkylifeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class SkyLifeTest {

    @Autowired
    private SkylifeService skylifeService;
    @Autowired
    private Skylife skylife;

    @Test
    void 회원가입() throws Exception {
        // given
        //Skylife skylife = new Skylife();
        skylife.setName("이름");
        //when
        Skylife member = skylifeService.register(skylife);
        // then
        Assertions.assertThat(skylife).isEqualTo(skylifeService.Login(member));
    }
    @Autowired

    @Test
    void 메일전송() {
        String email = "ks12b9189@naver.com";
        skylifeService.mailCheckGET(email);
    }
}
