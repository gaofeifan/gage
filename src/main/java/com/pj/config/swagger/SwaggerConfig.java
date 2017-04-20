package com.pj.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.pj")
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	*//**
	 * Required to autowire SpringSwaggerConfig
	 *//*
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	*//**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 *//*
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("swagger showcase", "swagger简单示例", "开发者: Rui Guo", "gr_neverlose@163.com",
				"MIT License", "/LICENSE");
		return apiInfo;
	}
}*/
@Configuration
@EnableWebMvc  
@EnableSwagger2 
public class SwaggerConfig {
	   @Bean  
	   public Docket customDocket(){  
	      return new Docket(DocumentationType.SWAGGER_2).select()
		            .apis(RequestHandlerSelectors.basePackage("com.pj.*"))
		            .build();  
	  
	   }  
}