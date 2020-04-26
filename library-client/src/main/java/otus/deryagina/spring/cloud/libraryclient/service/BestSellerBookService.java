package otus.deryagina.spring.cloud.libraryclient.service;

import otus.deryagina.spring.cloud.libraryclient.dto.BookDTO;

import java.util.List;

public interface BestSellerBookService {

    List<BookDTO> getBestSellerBooks();

}
