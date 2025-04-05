package br.edu.senaiso.Aula22_04_04_25.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class Internationalizacao {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messSource = new ReloadableResourceBundleMessageSource();
		messSource.setBasename("classpath:message");
		messSource.setDefaultEncoding("ISO-8859-1");

		return messSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver locResolver = new AcceptHeaderLocaleResolver();
		locResolver.setDefaultLocale(new Locale("pt", "BR"));
		return locResolver;
	}

}
