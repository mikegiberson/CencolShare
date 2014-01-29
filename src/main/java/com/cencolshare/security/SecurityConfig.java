package com.cencolshare.security;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.cencolshare.repository.UserRepository;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserRepository userRepository;

	@Autowired
    private DataSource dataSource;
	
	public SecurityConfig() {
		log.debug("creating spring security configuration");
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    	 auth
         .jdbcAuthentication()
         	 .dataSource(dataSource)
         	 .usersByUsernameQuery("select username, password, true from tbl_user where username=?")
         	 .authoritiesByUsernameQuery("select username as username, role from tbl_user where username = ?");
    	
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	AccessDeniedHandlerImpl hl = new AccessDeniedHandlerImpl();
    	hl.setErrorPage("/accessdenied");
    	
        http
        	.csrf().disable()
        	.authorizeRequests()
            	.antMatchers("/shop/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
            .logout()
            	.logoutSuccessUrl("/login")
            	.and()
            .formLogin()
                .loginPage("/login") 
                .permitAll();
        
        http.exceptionHandling().accessDeniedHandler(hl);
    	
    }

}