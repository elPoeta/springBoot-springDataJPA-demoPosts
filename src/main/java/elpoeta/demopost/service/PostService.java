package elpoeta.demopost.service;

import java.util.List;

import elpoeta.demopost.domain.Post;


public interface PostService{
	Post buscarPostPorId(Integer id);
	List<Post> buscarTodosPostOrdenDesc();
	Post crearPost(Post post);
}
