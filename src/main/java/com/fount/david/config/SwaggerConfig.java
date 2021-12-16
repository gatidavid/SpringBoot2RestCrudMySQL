
  package com.fount.david.config;
  
  import java.util.Collections;

import org.springframework.context.annotation.Bean;
import
  org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.PathSelectors;
import
  springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import
  springfox.documentation.spi.DocumentationType;
import
  springfox.documentation.spring.web.plugins.Docket;
import
  springfox.documentation.swagger2.annotations.EnableSwagger2;
  
  @Configuration
  @EnableSwagger2 
  @Profile({"default", "qa"})
  public class SwaggerConfig {
  
  @Bean 
  public Docket createDocket() { 
	  return new Docket(DocumentationType.SWAGGER_2)
			  .select()
			  .apis(RequestHandlerSelectors.basePackage("com.fount.david.rest"))
			  .paths(PathSelectors.regex("/api.*")) 
			  .build() 
			  .apiInfo(apiInfo())
			  
			  ; 
 
  }

private ApiInfo apiInfo() {
	
	return new ApiInfo("My Simple EmployeeRest App",//title
			           "Implementing Basic Crud Operations",//description
			            "1.0 GA",//Version
			            "http://fount.com",// Terms of Service Url
			            new Contact("David Gati", "http://fount.com", "dgatious@gmail.com"),
			            "FOUNT License",
			            "http://fount.com/license",
			            Collections.emptyList());
}

  }
 