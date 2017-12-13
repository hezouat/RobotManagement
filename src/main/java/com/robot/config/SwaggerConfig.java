package com.robot.config;

/**
 * Created by hezouatz on 11/12/17.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket robotApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());

    }


    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "ROBOT MANAGEMENT REST API",
                "ROBOT MANAGENMENT",
                "0.1",
                "Terms of service",
                new Contact("ZAHIR HEZOUAT", "https://github.com/hezouat", "zhezouat@yahoo.fr"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
        return apiInfo;
    }
}