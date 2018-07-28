package elpoeta.demopost.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import elpoeta.demopost.domain.Autor;
import elpoeta.demopost.service.AutorService;

@RestController
@RequestMapping("/api/autorServer")
public class AutorRestControler {
	@Autowired
	private AutorService autorService;
	
	@GetMapping("/autor/{id}")
	public Autor tarerAutor(@PathVariable Integer id) {
		return this.autorService.buscarAutorPorId(id);
	}
}
