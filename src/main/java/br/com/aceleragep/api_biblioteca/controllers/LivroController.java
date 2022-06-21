package br.com.aceleragep.api_biblioteca.controllers;

import java.net.URI;

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
import br.com.aceleragep.api_biblioteca.converties.LivroConvert;
import br.com.aceleragep.api_biblioteca.dtos.inputs.LivroInput;
import br.com.aceleragep.api_biblioteca.dtos.outputs.LivroOutput;
import br.com.aceleragep.api_biblioteca.entities.LivroEntity;
import br.com.aceleragep.api_biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@Autowired
	LivroConvert livroConvert;

	// FindAll
	@GetMapping("listar")
	public Page<LivroOutput> listarTodos(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable paginacao) {
		Page<LivroEntity> livroesEncontrados = livroService.listarTodos(paginacao);
		return livroConvert.ListEntityToListOutput(livroesEncontrados);
	}

	// FindAllById
	@GetMapping("buscar/{livroId}")
	public LivroOutput buscarPorId(@PathVariable Long livroId) {
		System.out.println("Buscar");
		LivroEntity livroesEncontrados = livroService.buscarPeloId(livroId);
		return livroConvert.entityToOutput(livroesEncontrados);
	}

	// Post
	@PostMapping("cadastar")
	public ResponseEntity<LivroEntity> cadastrar(@RequestBody LivroInput livroInput, UriComponentsBuilder uriBuild) {
		LivroEntity livroNovo = livroConvert.inputToEntity(livroInput);
		LivroEntity livroSalvo = livroService.cadastrar(livroNovo);

		URI uri = uriBuild.path(ControllerConfig.PRE_URL + "livros/{id}").buildAndExpand(livroSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(livroSalvo);
	}

	// Delete
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("deletar/{livroId}")
	public void deletar(@PathVariable Long livroId) {
		LivroEntity livroesEncontrados = livroService.buscarPeloId(livroId);
		livroService.deletar(livroesEncontrados);
	}

	// Put
	@PutMapping("atualizar/{livroId}")
	public LivroOutput atualizar(@PathVariable Long livroId, @RequestBody LivroInput livroInput) {
		LivroEntity livroEncontrado = livroService.buscarPeloId(livroId);
		livroConvert.copyInputToEntity(livroEncontrado, livroInput);
		LivroEntity livroSalvo = livroService.atualizar(livroEncontrado);
		return livroConvert.entityToOutput(livroSalvo);
	}
}
