package br.com.primeiroprojetospring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.primeiroprojetospring.domain.Acessorio;
import br.com.primeiroprojetospring.domain.QAcessorio;
import br.com.primeiroprojetospring.repository.AcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Acessorio> buscarTodosAcessorios() {
		return acessorioRepository.findAll();
	}
	
	public Acessorio salvar(Acessorio acessorio) {
		return acessorioRepository.save(acessorio);
	}
	
	
	public Acessorio buscarAcessorioID(Integer id) {
		Optional<Acessorio> acessorio = acessorioRepository.findById(id);
		return acessorio.orElseThrow(() -> new ObjectNotFoundException(new Acessorio(), "Acessorio não encontrado. Id: "+id));
	}
	
	public Acessorio salvarAlteracao(Acessorio acessorioAlterado) throws ObjectNotFoundException {
		Acessorio acessorio = buscarAcessorioID(acessorioAlterado.getId());
		acessorio.setId(acessorioAlterado.getId());
		acessorio.setNome(acessorioAlterado.getNome());
		return salvar(acessorio);
	}
	
	public void excluir(Integer id) {
		acessorioRepository.deleteById(id);	
	}
	
	public List<Acessorio> findByNome(String nome) {
		QAcessorio acessorio = QAcessorio.acessorio;
		
		return new JPAQueryFactory(entityManager).selectFrom(acessorio)
		.where(acessorio.nome.eq(nome)).fetch();
	}
	
}