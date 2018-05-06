package com.snipe.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig springSwaggerConfig;


    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }


    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework -
     * allowing for multiple swagger groups i.e. same code base multiple swagger
     * resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Test项目API",
                "spring-API swagger测试",
                "My Apps API terms of service",
                "iot_wangshuyu@126.com",
                "web app",
                "My Apps API License URL");
        return apiInfo;
    }

}