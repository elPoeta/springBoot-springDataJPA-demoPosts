package elpoeta.demopost.service;

import java.util.List;

import elpoeta.demopost.domain.Categoria;


public interface CategoriaService {
	
	Categoria buscarCategoriaPorId(Integer id);
	List<Categoria> buscarTodasCategorias();
}
