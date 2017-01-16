package com.softserve.academy.configurations;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(passEncoder()).withUser("admin").password(passEncoder().encode("1111")).roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("mike").password("2222").roles("USER");
//        auth.inMemoryAuthentication().withUser("nick").password("3333").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .and().httpBasic();
//
//        http.authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/user/**").access("hasRole('ADMIN') or hasRole('USER')");
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/accessDenied");
//    }
//
//    @Bean
//    public PasswordEncoder passEncoder(){
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }
//}