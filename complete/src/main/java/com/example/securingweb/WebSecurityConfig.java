package com.example.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				// .successForwardUrl("/dashboard")
				.defaultSuccessUrl("/dashboard")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll().logoutUrl("/logout").logoutSuccessUrl("/login?logout"));

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// UserDetails user =
		// 	 User.withDefaultPasswordEncoder()
		// 		.username("user")
		// 		.password("password")
		// 		.roles("USER")
		// 		.build();

		return new UserDetailsService(){
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// Always return a user with the given username and a fixed password 
				return User.withDefaultPasswordEncoder() 
					.username(username)
					.password("password")
					.roles("USER")
					.build(); 
			}
		};
	}
}

