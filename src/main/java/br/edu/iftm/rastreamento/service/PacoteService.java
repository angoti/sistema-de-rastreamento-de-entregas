package br.edu.iftm.rastreamento.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.PacoteRepository;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Pacote> findPacoteByStatus(String status) {
        Iterable<Pacote> pacoteIterable = pacoteRepository.findByStatusContaining(status);
        List<Pacote> pacoteList = new ArrayList<>();
        pacoteIterable.forEach(pacoteList::add);
        return pacoteList;
    }

    public List<Pacote> findPacoteByDestinatario(String destinatario) {
        Iterable<Pacote> pacoteIterable = pacoteRepository.findByDestinatarioContaining(destinatario);
        List<Pacote> pacoteList = new ArrayList<>();
        pacoteIterable.forEach(pacoteList::add);
        return pacoteList;
    }

    public List<Pacote> getAllPacotes() {
        Iterable<Pacote> pacotesIterable = pacoteRepository.findAll();
        List<Pacote> pacotesList = new ArrayList<>();
        pacotesIterable.forEach(pacotesList::add);
        return pacotesList;
    }

    public Pacote getPacoteById(Long id) {
        return pacoteRepository.findById(id).orElseThrow(
                () -> new  NaoAcheiException("Pacote não existente, id incorreto")
        );
    }

    public Pacote createPacote(Pacote pacote) {
        Rastreamento primeiroRastreio = pacote.getRastreamentos().get(pacote.getRastreamentos().size() - 1);
        rastreamentoRepository.save(primeiroRastreio);
        return pacoteRepository.save(pacote);
    }

    public Pacote updatePacote(Long id, Pacote pacoteDetails) {
        Pacote pacote = pacoteRepository.findById(id).orElseThrow(
                () -> new  NaoAcheiException("Pacote não existente, id incorreto")
        );
        pacote.setId(id);
        pacote.atualizarStatus(pacoteDetails.getStatus(), Date.from(Instant.now()), "não implementado");
        //obter o ultimo rastreamento
        Rastreamento ultiRastreamento = pacote.getRastreamentos().get(pacote.getRastreamentos().size() - 1);
        rastreamentoRepository.save(ultiRastreamento);
        return pacoteRepository.save(pacote);
    }

    public void deletePacote(Long id) {
        Pacote pacote = pacoteRepository.findById(id).get();
        pacoteRepository.delete(pacote);
    }
}
