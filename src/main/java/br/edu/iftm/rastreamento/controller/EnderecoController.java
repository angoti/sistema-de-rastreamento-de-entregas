package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.dto.EnderecoDTO;
import br.edu.iftm.rastreamento.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereco", description = "Endpoint para CRUD de endereços.")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	@Operation(summary = "Busca todos os endereços.", description = "Retorna uma lista com todos os endereços gravados no BD.", tags = {
			"Endereco" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EnderecoDTO.class)))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
			})
	public List<EnderecoDTO> getAllEnderecos() {
		System.out.println("-----------------------------------------");
		return enderecoService.getAllEnderecos();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Busca um endereço por ID.", description = "Retorna um endereço específico gravado no BD.", tags = {
			"Endereco" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "302", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EnderecoDTO.class))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
			})
	public ResponseEntity<EnderecoDTO> getById(@PathVariable Long id) {
		EnderecoDTO endereco = enderecoService.getEnderecoById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(endereco);
	}

	@PostMapping
	@Operation(summary = "Cria um novo endereço.", description = "Cria um novo endereço no BD.", tags = {
			"Endereco" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "201", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EnderecoDTO.class))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
			})
	public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		EnderecoDTO novoRecursEnderecoDTO = enderecoService.createEndereco(enderecoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoRecursEnderecoDTO);
	}
}
