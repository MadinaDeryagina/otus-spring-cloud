package otus.deryagina.spring.library.data.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class LibraryRestDockerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryRestDockerApplication.class, args);
    }

}
