package elpoeta.demopost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import elpoeta.demopost.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findAllByOrderByFechaCreacionDesc();
}
