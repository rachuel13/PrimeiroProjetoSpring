package br.com.primeiroprojetospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.primeiroprojetospring.domain.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
