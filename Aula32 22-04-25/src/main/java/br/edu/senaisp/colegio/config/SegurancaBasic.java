package br.edu.senaisp.colegio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SegurancaBasic {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(a -> a.anyRequest().authenticated()).httpBasic().and().build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		return new InMemoryUserDetailsManager(
				User.withUsername("Nathan")
				.password(encoder.encode("123456"))
				.roles("USER")
				.build()
				);
		
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("Nathan")
//				.password("123456")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
	}
}
