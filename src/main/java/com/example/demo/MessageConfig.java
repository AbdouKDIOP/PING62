package com.example.demo;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class MessageConfig{
	@Bean
	public LocaleResolver localeResolver() {
		
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.FRANCE);
		return localeResolver;
	}
	 @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	        messageSource.setBasename("classpath:/messages");
	        messageSource.setDefaultEncoding("UTF-8");
	        messageSource.setCacheSeconds(3600); // Refresh cache every hour
	        return messageSource;
	    }
}







