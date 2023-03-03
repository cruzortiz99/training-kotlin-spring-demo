package com.training.demo.config
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {
    @Bean
    fun openAPIDoc(): OpenAPI {
        return OpenAPI()
            .info(this.apiInfo())
    }

    private fun apiInfo(): Info {
        return Info().title("Kotlin Spring Demo Training")
            .version("0.0.1")
            .description("API for Spring-Kotlin training")
            .contact(Contact()
                .name("Cruz Ortiz")
                .email("cruz.ortiz@bairesdev.com"))
    }
}