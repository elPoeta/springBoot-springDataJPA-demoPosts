package elpoeta.demopost.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import elpoeta.demopost.domain.Post;
import elpoeta.demopost.service.PostService;

@RestController
@RequestMapping(value = "/api/postServer", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@JsonIgnoreProperties(ignoreUnknown=true)
public class PostRestController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/post/{id}")
	public Post traerPost(@PathVariable Integer id){
		return this.postService.buscarPostPorId(id);
	}
	
	@GetMapping("/post/todos")
	public List<Post> traerTodos(){
		return this.postService.buscarTodosPostOrdenDesc();
	}
	
	@PostMapping(value="/crearPost")
	Post crearPost(@RequestBody Post post) {
		System.out.println(post);
		return this.postService.crearPost(post);
	}
}
