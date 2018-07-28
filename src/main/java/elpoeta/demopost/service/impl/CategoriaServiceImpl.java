package elpoeta.demopost.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elpoeta.demopost.domain.Categoria;
import elpoeta.demopost.repository.CategoriaRepository;
import elpoeta.demopost.service.CategoriaService;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
	private final CategoriaRepository catgoriaRepository;
	
	public CategoriaServiceImpl(CategoriaRepository catgoriaRepository) {
		this.catgoriaRepository = catgoriaRepository;
	}

	@Override
	public Categoria buscarCategoriaPorId(Integer id) {
	
		return this.catgoriaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> buscarTodasCategorias() {
		
		return this.catgoriaRepository.findAll();
	}

}
