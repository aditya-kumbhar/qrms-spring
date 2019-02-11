package com.qrms.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.qrms.spring.repository.UsersRepository;
import com.qrms.spring.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
		
		@Autowired
		private CustomUserDetailsService userDetailsService;

		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			
			auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
		}
		
		@Bean
	    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	        return new UserAuthenticationSuccessHandler();
	    }
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable();
			http.authorizeRequests() 
				.antMatchers("/u/admin/*").hasRole("ADMIN")
				.antMatchers("/u/student/*").hasRole("STUDENT")
				.antMatchers("/u/faculty/*").hasRole("FACULTY")
				.and()
				.formLogin()
				.successHandler(myAuthenticationSuccessHandler()).permitAll()
				.loginPage("/login")
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

		}
		
		private PasswordEncoder getPasswordEncoder() {
			return new PasswordEncoder() {
				
				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					
					return true;
//					return new BCryptPasswordEncoder().encode(rawPassword.toString())
//	                        .equals(encodedPassword);
				}
				
				@Override
				public String encode(CharSequence rawPassword) {
					return rawPassword.toString();
//					return new BCryptPasswordEncoder().encode(rawPassword.toString());
				}
			};
		}

}
