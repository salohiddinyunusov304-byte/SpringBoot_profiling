package uz.pdp.spring_profiling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@RequiredArgsConstructor
@OpenAPIDefinition(
        info = @Info(
                title = "Working with Profiling | G58 Open Specification | Swagger",
                version = "1.0",
                description = "API for using Task Profiling",
                contact = @Contact(
                        name = "Salohiddin Yunusov",
                        email = "salohiddinyunusov377@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Local Server"
                )
        }
)

@ConfigurationPropertiesScan
@EnableScheduling
public class SpringProfilingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilingApplication.class, args);
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Spring Swagger Example")
                        .description("Spring Boot + Swagger + MapStruct Example")
                        .version("1.0")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Salohiddin Yunusov")
                                .email("salohiddinyunusov377@gmail.com")
                                .url("https://github.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://springdoc.org"))
                .servers(List.of(
                        new io.swagger.v3.oas.models.servers.Server()
                                .url("http://localhost:8080")
                                .description("Production"),
                        new io.swagger.v3.oas.models.servers.Server()
                                .url("http://localhost:9090")
                                .description("Test Server")
                ));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}
