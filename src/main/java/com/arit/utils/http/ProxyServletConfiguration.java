package com.arit.utils.http;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ProxyServletConfiguration implements EnvironmentAware {

	  @Bean
	  public ServletRegistrationBean servletRegistrationBean(){
	    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new URITemplateProxyServlet(), propertyResolver.getProperty("servlet_url"));
	    servletRegistrationBean.addInitParameter(ProxyServlet.P_TARGET_URI, propertyResolver.getProperty("target_url"));
	    servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
	    return servletRegistrationBean;
	  }

	  private RelaxedPropertyResolver propertyResolver;

	  @Override
	  public void setEnvironment(Environment environment) {
	    this.propertyResolver = new RelaxedPropertyResolver(environment, "http.proxy.");
	  }
	}
