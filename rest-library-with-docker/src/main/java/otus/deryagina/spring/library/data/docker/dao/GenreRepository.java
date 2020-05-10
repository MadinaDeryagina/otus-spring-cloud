package otus.deryagina.spring.library.data.docker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import otus.deryagina.spring.library.data.docker.domain.Genre;


import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findAllByNameIn(List<String> names);
    Optional<Genre> findByName(String name);
}
