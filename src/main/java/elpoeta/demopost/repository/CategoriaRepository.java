package elpoeta.demopost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elpoeta.demopost.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
