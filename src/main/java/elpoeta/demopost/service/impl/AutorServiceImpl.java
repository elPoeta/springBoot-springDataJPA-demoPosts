package elpoeta.demopost.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elpoeta.demopost.domain.Autor;
import elpoeta.demopost.repository.AutorRepository;
import elpoeta.demopost.service.AutorService;

@Service
@Transactional
public class AutorServiceImpl implements AutorService {
	private final AutorRepository autorRepository;
	
	public AutorServiceImpl(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public Autor buscarAutorPorId(Integer id) {
		return this.autorRepository.findById(id).orElse(null);
	}

}
