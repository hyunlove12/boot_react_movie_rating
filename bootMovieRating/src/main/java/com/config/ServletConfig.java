package com.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ServletConfig implements WebMvcConfigurer {	
	
	private final List<String> resourceList = Arrays.asList("/css/**", "/js/**", "/img/**", "/movie_img/**", "/result_img/**", "/vendor/**", "/dist/**"); 	
	
	@Bean 
	public ServletRegistrationBean servletRegistrationBean(WebApplicationContext webApplicationContext) {
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
	  
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new ReactFilter());
		registrationBean.setOrder(Integer.MIN_VALUE);
	registrationBean.setUrlPatterns(Arrays.asList("/board/*"));
		return registrationBean;
	}
	  
	/*
	 * @Bean public ServletRegistrationBean
	 * deServletRegistrationBean(WebApplicationContext webApplicationContext) {
	 * DefaultServlet disServlet = new DefaultServlet(); disServlet. DefaultSer
	 * ServletRegistrationBean servlet = new ServletRegistrationBean(disServlet,
	 * false, "/"); servlet.setLoadOnStartup(-1); return servlet; }
	 */
	
	
	/*
	@Bean
	public HandlerMapping handlerMapping() {
		// 요청을 처리할 수 있는 메소드를 찾아주는 역할
		// app/hello -> app까지는 disapcher에 매핑 그 후 hello에 대한 처리 부분 확인 해주는 역할 
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		// 처리 전에 적용되는 인터셉터
		// handlerMapping.setInterceptors();
		// 핸들러 매핑 순서 -> 우선순위 설정
		handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return handlerMapping;
	}
	
	@Bean
	public HandlerAdapter handlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
		// pathvariable, requestparam 등의 아규먼트 설정
		//handlerAdapter.setArgumentResolvers();
		return handlerAdapter;		
	}
	
	@Bean 
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();		
		viewResolver.setPrefix("/WEB-INF");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
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

