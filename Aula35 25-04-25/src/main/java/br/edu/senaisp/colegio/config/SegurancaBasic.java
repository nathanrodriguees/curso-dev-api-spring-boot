package br.edu.senaisp.colegio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SegurancaBasic {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) 
													throws Exception {
		return http.csrf().disable()
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						)
				.authorizeHttpRequests(a ->	
				a.requestMatchers(HttpMethod.POST, "/api/login/**").permitAll()
					.anyRequest().authenticated()
					).addFilterBefore(NOIS, UsernamePasswordAuthenticationFilter.class)
					 .build();
	}
	
	@Bean
	public UserDetailsService userDetailsService(
			               PasswordEncoder passwordEncoder) {
		return new InMemoryUserDetailsManager(
				User.withUsername("Nathan")
				.password(passwordEncoder.encode("123456") )
				.roles("USER")
				.build()
				);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
