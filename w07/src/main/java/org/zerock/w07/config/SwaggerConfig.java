package org.zerock.w07.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "Zerock App", version="V0.1"))
@RequiredArgsConstructor
@Configuration

public class SwaggerConfig {

//    @Bean
//    public OpenAPI api(){
//        Info info = new Info()
//                .title("Swagger Test")
//
//                .version("1.0")
//                .description("API 설명");
//
//        return new OpenAPI()
//                .components(new Components())
//                .info(info);
//    }
//
//    @Bean
//    public OpenAPI api() {
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("org.zerock.w07.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Boot W07 Project Swagger")
//                .build();
//    }
//}

    @Bean
    public GroupedOpenApi chatOPenApi(){
        String[] paths = {"/**"};

        return GroupedOpenApi.builder()
                .group("Zerock OPEN API V1")
                .pathsToMatch(paths)
                .build();
    }


}

