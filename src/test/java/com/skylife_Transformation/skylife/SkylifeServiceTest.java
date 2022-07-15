package com.skylife_Transformation.skylife;

import com.skylife_Transformation.domain.Skylife;
import com.skylife_Transformation.mapper.SkylifeMapper;
import com.skylife_Transformation.service.SkylifeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
public class SkylifeServiceTest {

    @Autowired
    private SkylifeMapper mapper;

    @Test
    void 회원가입() throws Exception {
        Skylife skylife = Skylife.builder().id("1234567").pw("12311").name("태평양").bday(Date.valueOf("2022-06-20")).email("ks12b2222@12341").phone("01000000000").build();
        mapper.register(skylife);
        Assertions.assertThat(skylife.getId()).isEqualTo("1234567");

        Skylife login = mapper.login(skylife);
        Assertions.assertThat(login).isNotNull();
        Assertions.assertThat(login.getName()).isEqualTo(skylife.getName());
        Assertions.assertThat(login.getEmail()).isEqualTo(skylife.getEmail());
        Assertions.assertThat(login.getId()).isEqualTo("1234567");

    }
    @Test
    void 로그인() throws Exception {

    }
}
