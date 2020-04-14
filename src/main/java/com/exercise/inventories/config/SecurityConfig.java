package com.exercise.inventories.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Value( "${secrets.acl.name.user}" )
	private String nameUser;
	@Value( "${secrets.acl.pass.user}" )
	private String passUser;
	@Value( "${secrets.acl.role.user}" )
	private String roleUser;
	@Value( "${secrets.acl.name.admin}" )
	private String nameAdmin;
	@Value( "${secrets.acl.pass.admin}" )
	private String passAdmin;
	@Value( "${secrets.acl.role.admin}" )
	private String roleAdmin;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.GET,"/inventories/**").hasAnyRole("ADMIN","USER")
			.and()
			.authorizeRequests().antMatchers(HttpMethod.PUT,"/inventories/**").hasAnyRole("ADMIN")
			.and()
			.httpBasic();
	}

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(nameUser).password(passwordEncoder().encode(passUser)).roles(roleUser).build());
        manager.createUser(User.withUsername(nameAdmin).password(passwordEncoder().encode(passAdmin)).roles(roleAdmin).build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }	
}
