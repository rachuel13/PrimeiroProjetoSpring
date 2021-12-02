package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.primeiroprojetospring.domain.Carro;
import br.com.primeiroprojetospring.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> buscarTodosCarros() {

		return carroRepository.findAll();

	}

	public Carro salvar(Carro carro) {

		return carroRepository.save(carro);

	}
	
	public Carro buscarPorID(Integer id) throws ObjectNotFoundException {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.orElseThrow(()   -> 
		new ObjectNotFoundException(new Carro(), "Carro não encontrado. id: " + id));
	}
	
	public Carro salvarAlteracao(Carro carroAlterado) throws ObjectNotFoundException {
		Carro carro = buscarPorID(carroAlterado.getId());
		carro.setId(carroAlterado.getId());
		carro.setModelo(carroAlterado.getModelo());
		carro.setChaveCarro(carroAlterado.getChaveCarro());
		return carro;
	}
	
	public void excluir(Integer id) {
		carroRepository.deleteById(id);
	}
	}