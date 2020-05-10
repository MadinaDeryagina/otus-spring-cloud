package otus.deryagina.spring.cloud.libraryclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import otus.deryagina.spring.cloud.libraryclient.dto.BookDTO;
import otus.deryagina.spring.cloud.libraryclient.service.BestSellerBookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BestSellerController {

    private final BestSellerBookService bestSellerBookService;

    @GetMapping("/best")
    public ResponseEntity<List<BookDTO>> getBestSellers() {
        List<BookDTO> bookDTOList = bestSellerBookService.getBestSellerBooks();
        return ResponseEntity.ok(bookDTOList);
    }

}
