package otus.deryagina.spring.cloud.libraryclient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import otus.deryagina.spring.cloud.libraryclient.dto.BookDTO;

import java.util.List;

@FeignClient("library")
public interface BookClient {

    @GetMapping("/books")
    List<BookDTO> getBooks();

}
