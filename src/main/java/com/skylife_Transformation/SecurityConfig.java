package com.skylife_Transformation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //시큐리티 필터가 등록
@EnableGlobalMethodSecurity(securedEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePwd() {  //비밀번호 암호화를 위해 사용 시큐리티는 비밀번호가 암호화 되있어야 사용가능하다
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //csrf토큰 비활성화(테스트시 걸어두는게 좋음) 시큐리티는 csrf토큰이 있어야 접근가능함
        http.authorizeRequests().antMatchers("/**").permitAll()
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/auth/loginForm") //로그인 페이지를 우리가 만든 페이지로 등록한다.
                .loginProcessingUrl("/auth/loginc") //로그인 주소가 호출되면 시큐리티가 낚아채서 대신 로그인 진행
                .defaultSuccessUrl("/")  //정상일떄
                //.and()
                ;
    }
}
