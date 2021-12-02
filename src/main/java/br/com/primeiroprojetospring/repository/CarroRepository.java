package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroprojetospring.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
