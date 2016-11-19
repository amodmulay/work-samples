/**
 * 
 */
package com.avm.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author amodmulay
 * 
 *         Fix for issue when an email id is sent as a parameter to a rest
 *         endpoint with .com. Rest all extensions work
 */
@Configuration
public class WorkWebMvcConfigurationAdapter extends WebMvcConfigurerAdapter implements EnvironmentAware {
	private final Logger slf4jLogger = LoggerFactory.getLogger(WorkWebMvcConfigurationAdapter.class);
	private RelaxedPropertyResolver propertyResolver;

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON).favorPathExtension(false).favorParameter(false)
				.parameterName("mediaType").ignoreAcceptHeader(false).useJaf(false);
	}

	public void setEnvironment(Environment environment) {
		slf4jLogger.info(environment.getProperty("JAVA_HOME"));
		String str = environment.getProperty("spring.datasource.url");
		slf4jLogger.info(str);
		propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
		String url = propertyResolver.getProperty("url");
		slf4jLogger.info(url);

	}

}
