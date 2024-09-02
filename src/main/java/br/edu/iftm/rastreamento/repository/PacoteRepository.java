package br.edu.iftm.rastreamento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.rastreamento.model.Pacote;

import java.util.List;

@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long> {
	@Query
    List<Pacote> findByStatusContaining(String status);

    @Query
    List<Pacote> findByDestinatarioContaining(String destinatario);
}
