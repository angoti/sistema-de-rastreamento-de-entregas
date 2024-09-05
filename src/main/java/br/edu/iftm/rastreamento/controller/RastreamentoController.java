package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.RastreamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rastreamentos")
@Tag(name = "Rastreamento", description = "Endpoint para rastreamento de pacotes.")
public class RastreamentoController {

	@Autowired
	private RastreamentoService rastreamentoService;

	@GetMapping("/{id}")
	@Operation(summary = "Busca todos os rastreamentos de um pacote.", description = "Retorna uma lista com todos os rastreamentos de um pacote gravados no BD.", tags = {
			"Rastreamento" }, responses = {
					@ApiResponse(description = "Sucesso", responseCode = "200", content = {
							@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Pacote.class)))
					}),
					@ApiResponse(description = "Bad Request", responseCode = "400"),
					@ApiResponse(description = "Unauthorized", responseCode = "401"),
					@ApiResponse(description = "Not Found", responseCode = "404"),
					@ApiResponse(description = "Internal Server Error", responseCode = "500") })
	public List<Rastreamento> getRastreamentosPacote(@PathVariable Long id) {
		return rastreamentoService.getRastreamentos(id);
	}

}
