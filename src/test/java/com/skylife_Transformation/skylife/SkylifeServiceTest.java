package com.skylife_Transformation.skylife;

import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.mapper.SkylifeMapper;
import com.skylife_Transformation.service.SkylifeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
@RunWith(SpringRunner.class)
@AutoConfigureMybatis
public class SkylifeServiceTest {
    @Autowired
    SkylifeService skylifeService;
    @Autowired
    Skylife skylife;
    @Autowired
    SkylifeMapper skylifeMapper;

    @Test
    void 회원가입() {
        // given
        Skylife skylife = new Skylife();
        skylife.setBno(1);
        skylife.setId("Park");
        skylife.setPw("1234");
        skylife.setName("Park");
        skylife.setBday(Date.valueOf("1997-01-31"));
        skylife.setEmail("1234@1234");
        skylife.setPhone("01012341234");

        System.out.println(skylife);
        // when
        skylifeMapper.register(skylife);
        System.out.println();
        // then
        int findMember = skylifeMapper.idCheck(skylife.getId());
        Assertions.assertThat(1).isEqualTo(findMember);

    }
}
