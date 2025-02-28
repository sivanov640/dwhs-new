package io.darasa.dwhsnew;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;

@SpringBootApplication
@EnableElasticsearchAuditing
@OpenAPIDefinition(servers = {@Server(url = "/dwhs")}, info = @Info(title = "DWHS", description = "This is core service for dwhs management"))
public class DwhsNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwhsNewApplication.class, args);
    }

}
