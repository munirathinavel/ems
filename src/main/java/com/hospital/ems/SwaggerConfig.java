package com.hospital.ems;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is responsible for configuring swagger configuration. So that, we
 * can access/test our rest services through it.
 * 
 * @author munirathinavel
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(false);

	}

	private ApiInfo apiInfo() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("Generic REST Entity API");
		apiInfoBuilder.description("Simple REST Entity API Generation");
		apiInfoBuilder.version("0.0.1-SNAPSHOT");
		apiInfoBuilder.contact(new Contact("Munirathinavel Chinnasamy", "http://github.com/munirathinavel",
				"munirathinavel@gmail.com"));

		return apiInfoBuilder.build();
	}

}
