package br.com.lognetbr.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lognetbr.filters.JwtAuthFilter;

@Configuration
public class FilterConfiguration {

	@Value("${chave_token}")
	private String chaveToken;

	@Bean
	FilterRegistrationBean<JwtAuthFilter> jwtAuthFilter() {

		// Registrando o filter criado
		FilterRegistrationBean<JwtAuthFilter> registration = new FilterRegistrationBean<>();

		// Configurando a classe filter
		registration.setFilter(new JwtAuthFilter(chaveToken));

		// Configurando os endpoints que serão verificados pelo Filter
		// Inserir /api/*
		registration.addUrlPatterns("");
		
		// Adicionando exceções (esses endpoints passam direto pelo filter)
		registration.addInitParameter("excludeUrl", "/api/v1/usuario/criar");
		registration.addInitParameter("excludeUrl", "/api/v1/usuario/autenticar");

		// retornando o filter
		return registration;
	}
}