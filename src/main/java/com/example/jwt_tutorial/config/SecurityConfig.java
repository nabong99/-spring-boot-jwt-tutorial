package com.example.jwt_tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //기본적인 웹 보안 활성하겠다는 annotation
//추가적인 설정을 위해서 WebSecurityConfigurer를 inplements 하거나
//WebSecurityConfigurerAdapter를 extends 하는 방법이 있다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**"
                        ,"favicon.ico"
                );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //HttpServletRequest를 사용하는 요청들에 대한 접근제한 설정
                .antMatchers("/api/hello").permitAll() //인증없이 접근 허용
                .anyRequest().authenticated(); //나머지 요청 인증 받아야한다.
    }

}
