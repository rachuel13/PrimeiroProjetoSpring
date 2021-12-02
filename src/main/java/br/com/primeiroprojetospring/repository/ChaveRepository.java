package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroprojetospring.domain.Chave;

public interface ChaveRepository extends JpaRepository<Chave, Integer> {

}
