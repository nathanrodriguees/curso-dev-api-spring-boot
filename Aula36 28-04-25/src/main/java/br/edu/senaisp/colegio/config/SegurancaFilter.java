package br.edu.senaisp.colegio.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.senaisp.colegio.service.LoginService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SegurancaFilter extends OncePerRequestFilter {

	@Autowired
	private LoginService loginService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader("Authorization");

		if (token != null && token.startsWith("Bearer ")) {
//			token = token.substring(7);
			token = token.replace("Bearer ", "");
		}

		if (token != null && !token.isEmpty()) {
			String tokenValidado = loginService.validaToken(token);

			UserDetails userDetails = loginService.loadUserByUsername(tokenValidado);

			UsernamePasswordAuthenticationToken autenticacao = new UsernamePasswordAuthenticationToken(tokenValidado,
					null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(autenticacao);
		}

		filterChain.doFilter(request, response);

	}

}
