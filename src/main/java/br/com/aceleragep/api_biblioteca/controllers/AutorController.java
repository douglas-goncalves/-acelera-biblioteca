package br.com.aceleragep.api_biblioteca.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.aceleragep.api_biblioteca.configs.ControllerConfig;
import br.com.aceleragep.api_biblioteca.converties.AutorConvert;
import br.com.aceleragep.api_biblioteca.dtos.inputs.AutorInput;
import br.com.aceleragep.api_biblioteca.dtos.outputs.AutorOutput;
import br.com.aceleragep.api_biblioteca.entities.AutorEntity;
import br.com.aceleragep.api_biblioteca.services.AutorService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "autores")
public class AutorController {

	@Autowired
	AutorService autorService;

	@Autowired
	AutorConvert autorConvert;

	// FindAll
	@GetMapping("listar")
	public Page<AutorOutput> listarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable paginacao) {
		Page<AutorEntity> autoresEncontrados = autorService.listarTodos(paginacao);
		return autorConvert.pageEntityParaPageOutput(autoresEncontrados);
	}

	// FindAllById
	@GetMapping("buscar/{autorId}")
	public AutorOutput buscarPorId(@PathVariable Long autorId) {
		AutorEntity autoresEncontrados = autorService.buscarPeloId(autorId);
		return autorConvert.entityParaOutput(autoresEncontrados);
	}

	// Post
	@PostMapping("cadastar")
	public ResponseEntity<AutorEntity> cadastrar(@Valid @RequestBody AutorInput autorInput, UriComponentsBuilder uriBuild) {
		AutorEntity autorNovo = autorConvert.inputParaEntity(autorInput);
		AutorEntity autorSalvo = autorService.cadastrar(autorNovo);

		URI uri = uriBuild.path(ControllerConfig.PRE_URL + "autores/{id}").buildAndExpand(autorSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(autorSalvo);
	}

	// Delete
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("deletar/{autorId}")
	public void deletar(@PathVariable Long autorId) {
		AutorEntity autoresEncontrados = autorService.buscarPeloId(autorId);
		autorService.deletar(autoresEncontrados);
	}

	// Put
	@PutMapping("atualizar/{autorId}")
	public AutorOutput atualizar(@PathVariable Long autorId, @Valid @RequestBody AutorInput autorInput) {
		AutorEntity autorEncontrado = autorService.buscarPeloId(autorId);
		autorConvert.copyInputToEntity(autorEncontrado, autorInput);
		AutorEntity autorSalvo = autorService.atualizar(autorEncontrado);
		return autorConvert.entityParaOutput(autorSalvo);
	}
}
