package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Endereco;
import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pacotes")
@Tag(name = "Pacote", description = "Endpoint para CRUD de pacotes.")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@GetMapping
	@Operation(summary = "Busca todos os pacotes.", description = "Retorna uma lista com todos os pacotes gravados no BD.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Pacote.class)))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public List<Pacote> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@PostMapping
	@Operation(summary = "Cria um novo pacote.", description = "Cria um novo pacote e o grava no BD.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "201", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Pacote.class))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public Pacote createPacote(@RequestBody Pacote pacote) {
		return pacoteService.createPacote(pacote);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca um pacote por ID.", description = "Retorna um pacote específico gravado no BD.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "302", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Pacote.class))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public Pacote getPacoteById(@PathVariable Long id) {
		return pacoteService.getPacoteById(id);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualiza um pacote.", description = "Atualiza um pacote específico gravado no BD.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Pacote.class))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public Pacote updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
		return pacoteService.updatePacote(id, pacoteDetails);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta um pacote.", description = "Deleta um pacote específico gravado no BD.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "204"),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public void deletePacote(@PathVariable Long id) {
		pacoteService.deletePacote(id);
	}

	//busca pacotes por status
	@GetMapping("/status/{status}")
	@Operation(summary = "Busca pacotes por status.", description = "Retorna uma lista com todos os pacotes gravados no BD com o status informado.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Pacote.class))
					)}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public List<Pacote> getPacotesByStatus(@PathVariable String status) {
		return pacoteService.getPacotesByStatus(status);
	}

	//busca pacotes por endereco
	@GetMapping("/endereco/{enderecoID}")
	@Operation(summary = "Busca pacotes por endereço.", description = "Retorna uma lista com todos os pacotes gravados no BD com o endereço informado.", tags = {
			"Pacote" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Pacote.class))
					)}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public List<Pacote> getPacotesByEndereco(@PathVariable Long enderecoID) {
		Endereco endereco = new Endereco();
		endereco.setId(enderecoID);
		return pacoteService.getPacotesByEndereco(endereco);
	}
}