package com.veadan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/** API文档插件配置文件
 * Created by Veadan on 2017/2/27.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
            //  .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
            //    .pathMapping("/pda")
                .select()
                .paths((regex("/api/.*")))//过滤的接口
                .build()
                .apiInfo(apiInfo());
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo("条码管理后台API接口手册", "此API手册为PDA客户端提供开发参考", "0.0.1",
                "/api/v1","徐新平|xuxp@veadan.com","SHASTEEL_计算机应用中心ERP","192.169.250.126:10010");
        return apiInfo;
    }
}
