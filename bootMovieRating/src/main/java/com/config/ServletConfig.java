package com.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServletConfig implements WebMvcConfigurer {	
	
     private final List<String> resourceList = Arrays.asList("/css/**", "/js/**", "/img/**", "/movie_img/**", "/result_img/**", "/vendor/**", "/dist/**"); 	
	
	  @Bean 
	  public ServletRegistrationBean	 servletRegistrationBean(WebApplicationContext webApplicationContext) {
		  DispatcherServlet disServlet = new DispatcherServlet(webApplicationContext);
		  ServletRegistrationBean servlet = new ServletRegistrationBean(disServlet, false, "/"); 
		  servlet.setLoadOnStartup(1); 
		  return servlet; 
	  }
	 
	  public void addInterceptors(InterceptorRegistry registry) {
		  //registry.addInterceptor(new CustomHandlerInterceptor()).order(0); 
		  registry.addInterceptor(new CustomHandlerInterceptor())				     
				    .excludePathPatterns("/api/**")
				    .excludePathPatterns("/main")
				    .excludePathPatterns(resourceList)				    
				    .order(-1); 
		  
	  }
	  
	  
	/*
	 * @Bean public ServletRegistrationBean
	 * deServletRegistrationBean(WebApplicationContext webApplicationContext) {
	 * DefaultServlet disServlet = new DefaultServlet(); disServlet. DefaultSer
	 * ServletRegistrationBean servlet = new ServletRegistrationBean(disServlet,
	 * false, "/"); servlet.setLoadOnStartup(-1); return servlet; }
	 */
}

/*
 * 
 * 29.1.13 CORS Support
Cross-origin resource sharing (CORS) is a W3C specification implemented by most browsers that lets you specify in a flexible way what kind of cross-domain requests are authorized., instead of using some less secure and less powerful approaches such as IFRAME or JSONP.

As of version 4.2, Spring MVC supports CORS. Using controller method CORS configuration with @CrossOrigin annotations in your Spring Boot application does not require any specific configuration. Global CORS configuration can be defined by registering a WebMvcConfigurer bean with a customized addCorsMappings(CorsRegistry) method, as shown in the following example:

@Configuration
public class MyConfiguration {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**");
			}
		};
	}
}
 * 
 * */

