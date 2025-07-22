package base.backend.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("테스트 API 목록")
                        .description("Swagger 시리즈 실습을 위한 API 목록입니다.")
                        .version("v1.0.0"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:6280")
                                .description("개발용 서버")
                ));
    }
    
}
