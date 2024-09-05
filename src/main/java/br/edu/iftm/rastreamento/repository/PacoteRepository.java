package br.edu.iftm.rastreamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.model.Pacote;
@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long> {
	List<Pacote> findByStatus(String status);
	List<Pacote> findByEndereco(Endereco endereco);
	
}
