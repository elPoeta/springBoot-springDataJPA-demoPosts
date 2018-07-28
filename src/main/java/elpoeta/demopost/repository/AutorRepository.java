package elpoeta.demopost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elpoeta.demopost.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

}
