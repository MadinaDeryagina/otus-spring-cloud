package otus.deryagina.spring.library.data.docker.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import otus.deryagina.spring.library.data.docker.domain.Author;
import otus.deryagina.spring.library.data.docker.domain.Book;
import otus.deryagina.spring.library.data.docker.domain.Comment;
import otus.deryagina.spring.library.data.docker.domain.Genre;
import otus.deryagina.spring.library.data.docker.dto.AuthorDTO;
import otus.deryagina.spring.library.data.docker.dto.BookDTO;
import otus.deryagina.spring.library.data.docker.dto.CommentDTO;
import otus.deryagina.spring.library.data.docker.dto.GenreDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-25T21:01:38+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Override
    public BookDTO entityToDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setAuthorDTOS( authorEntityListToAuthorDtoList( book.getAuthors() ) );
        bookDTO.setGenreDTOS( genreEntityListToGenreDtoList( book.getGenres() ) );
        bookDTO.setId( book.getId() );
        bookDTO.setTitle( book.getTitle() );

        return bookDTO;
    }

    @Override
    public List<BookDTO> entityToDto(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( books.size() );
        for ( Book book : books ) {
            list.add( entityToDto( book ) );
        }

        return list;
    }

    @Override
    public List<GenreDTO> genreEntityListToGenreDtoList(List<Genre> genres) {
        if ( genres == null ) {
            return null;
        }

        List<GenreDTO> list = new ArrayList<GenreDTO>( genres.size() );
        for ( Genre genre : genres ) {
            list.add( entityToDto( genre ) );
        }

        return list;
    }

    @Override
    public List<AuthorDTO> authorEntityListToAuthorDtoList(List<Author> authors) {
        if ( authors == null ) {
            return null;
        }

        List<AuthorDTO> list = new ArrayList<AuthorDTO>( authors.size() );
        for ( Author author : authors ) {
            list.add( entityToDto( author ) );
        }

        return list;
    }

    @Override
    public AuthorDTO entityToDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setFullName( author.getFullName() );

        return authorDTO;
    }

    @Override
    public GenreDTO entityToDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();

        genreDTO.setName( genre.getName() );

        return genreDTO;
    }

    @Override
    public Author dtoToEntity(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setFullName( authorDTO.getFullName() );

        return author;
    }

    @Override
    public Genre dtoToEntity(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( genreDTO.getName() );

        return genre;
    }

    @Override
    public Book dtoToEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setGenres( genreDTOListToGenreList( bookDTO.getGenreDTOS() ) );
        book.setAuthors( authorDTOListToAuthorList( bookDTO.getAuthorDTOS() ) );
        book.setTitle( bookDTO.getTitle() );

        return book;
    }

    @Override
    public Comment dtoToEntity(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( commentDTO.getText() );

        return comment;
    }

    @Override
    public CommentDTO dtoToEntity(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setBookId( commentBookId( comment ) );
        commentDTO.setText( comment.getText() );

        return commentDTO;
    }

    @Override
    public List<CommentDTO> commentEntitiesToDTOS(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( dtoToEntity( comment ) );
        }

        return list;
    }

    protected Genre genreDTOToGenre(GenreDTO genreDTO) {
        if ( genreDTO == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setName( genreDTO.getName() );

        return genre;
    }

    protected List<Genre> genreDTOListToGenreList(List<GenreDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>( list.size() );
        for ( GenreDTO genreDTO : list ) {
            list1.add( genreDTOToGenre( genreDTO ) );
        }

        return list1;
    }

    protected Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setFullName( authorDTO.getFullName() );

        return author;
    }

    protected List<Author> authorDTOListToAuthorList(List<AuthorDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Author> list1 = new ArrayList<Author>( list.size() );
        for ( AuthorDTO authorDTO : list ) {
            list1.add( authorDTOToAuthor( authorDTO ) );
        }

        return list1;
    }

    private long commentBookId(Comment comment) {
        if ( comment == null ) {
            return 0L;
        }
        Book book = comment.getBook();
        if ( book == null ) {
            return 0L;
        }
        long id = book.getId();
        return id;
    }
}
