package br.edu.senaisp.colegio.config;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.senaisp.colegio.model.EPerfil;

@Component
@EnableWebSecurity
public class SegurancaFilterChain {
	
	@Autowired
	private SegurancaFilter segurancaFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) 
													throws Exception {
		return http.csrf().disable()
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						)
				.authorizeHttpRequests(a ->	
				a.requestMatchers(HttpMethod.POST, "/api/login/").permitAll()
				.requestMatchers(HttpMethod.GET, "/api/usuario/").hasRole(EPerfil.ADMIN.toString())
					.anyRequest().authenticated()
					).addFilterBefore(segurancaFilter, UsernamePasswordAuthenticationFilter.class)
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
