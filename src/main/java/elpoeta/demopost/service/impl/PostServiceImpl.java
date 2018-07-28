package elpoeta.demopost.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elpoeta.demopost.domain.Post;
import elpoeta.demopost.repository.PostRepository;
import elpoeta.demopost.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	private final PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post buscarPostPorId(Integer id) {
		
		return this.postRepository.findById(id).orElse(null);
	}

	@Override
	public List<Post> buscarTodosPostOrdenDesc() {

		return this.postRepository.findAllByOrderByFechaCreacionDesc();
	}

	@Override
	public Post crearPost(Post post) {
		
		return this.postRepository.save(post);
	}

}
