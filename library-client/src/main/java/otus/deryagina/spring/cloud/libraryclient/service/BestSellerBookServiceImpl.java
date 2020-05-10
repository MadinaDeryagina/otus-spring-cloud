package otus.deryagina.spring.cloud.libraryclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import otus.deryagina.spring.cloud.libraryclient.client.BookClient;
import otus.deryagina.spring.cloud.libraryclient.dto.AuthorDTO;
import otus.deryagina.spring.cloud.libraryclient.dto.BookDTO;
import otus.deryagina.spring.cloud.libraryclient.dto.GenreDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BestSellerBookServiceImpl implements BestSellerBookService {

    private static final String NOT_AVAILABLE = "N/A" ;
    private final BookClient bookClient;

    @HystrixCommand(commandKey = "getBestBooks", fallbackMethod = "buildFallbackBestBooks")
    @Override
    public List<BookDTO> getBestSellerBooks() {
        return bookClient.getBooks();
    }

    public List<BookDTO> buildFallbackBestBooks(){
        List<BookDTO> dummyList= new ArrayList<>();
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(NOT_AVAILABLE);
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFullName(NOT_AVAILABLE);
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setName(NOT_AVAILABLE);
        bookDTO.setAuthorDTOS(Collections.singletonList(authorDTO));
        bookDTO.setGenreDTOS(Collections.singletonList(genreDTO));
        dummyList.add(bookDTO);
        return dummyList;
    }
}
