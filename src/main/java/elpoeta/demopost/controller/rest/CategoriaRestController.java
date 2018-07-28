package elpoeta.demopost.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import elpoeta.demopost.domain.Categoria;
import elpoeta.demopost.service.CategoriaService;

@RestController
@RequestMapping("/api/categoriaServer")
public class CategoriaRestController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/buscarTodas")
	public List<Categoria> traerCategorias() {
		return this.categoriaService.buscarTodasCategorias();
	}
}
