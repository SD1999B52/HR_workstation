package com.workstation.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders
.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration
.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration
.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
    
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandler() {
            
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, 
            HttpServletResponse response, AuthenticationException e) 
            throws IOException, ServletException {
                
                System.out.println("------------------------------------");
                System.out.println("Неверная пара логин-пароль");
                System.out.println("IP: " + request.getLocalAddr());
                System.out.println("Логин: " + request.getParameter("username"));
                System.out.println("Пароль: " + request.getParameter("password"));
                
                response.sendRedirect("/auth");
            }
        };
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from users where username = ?");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**")
                    .permitAll()
                
                .antMatchers("/main")
                    .hasAnyAuthority("limited", "full")
                
                .antMatchers("/main/**")
                    .hasAuthority("full")
                
                .anyRequest()
                    .authenticated()
                
            .and()
                .formLogin()
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .loginPage("/auth")
                .defaultSuccessUrl("/main", true)
                
            .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSIONID")
            .and()
                .rememberMe();
    }
}