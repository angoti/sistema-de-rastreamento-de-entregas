package br.edu.iftm.rastreamento.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@GetMapping
	public List<Pacote> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@PostMapping
	public Pacote createPacote(@RequestBody Pacote pacote) {
		return pacoteService.createPacote(pacote);
	}

	@GetMapping("/{id}")
	public Pacote getPacoteById(@PathVariable Long id) {
		return pacoteService.getPacoteById(id);
	}

	@Operation(description = "Busca pacotes pelo status")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna o pacote"),
			@ApiResponse(responseCode = "400", description = "Não existe o pacote com o status informado")
	})
	@GetMapping("/status/{status}")
	public  List<Pacote> getPacoteByStatus(@PathVariable String status) {
		return pacoteService.findPacoteByStatus(status);
	}

	@Operation(description = "Busca pacotes pelo destinatário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna o pacote"),
			@ApiResponse(responseCode = "400", description = "Não existe o pacote para este destinatário")
	})
	@GetMapping("/destinatario/{destinatario}")
	public  List<Pacote> getPacoteByDestinatario(@PathVariable String destinatario) {
		return pacoteService.findPacoteByDestinatario(destinatario);
	}

	@PutMapping("/{id}")
	public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
		return pacoteService.updatePacote(id, pacoteDetails);
	}

	@DeleteMapping("/{id}")
	public void deletePacote(@PathVariable Long id) {
		pacoteService.deletePacote(id);
	}
}