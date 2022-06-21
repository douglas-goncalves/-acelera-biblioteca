package br.com.aceleragep.api_biblioteca.converties;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.aceleragep.api_biblioteca.dtos.inputs.LivroInput;
import br.com.aceleragep.api_biblioteca.dtos.outputs.LivroOutput;
import br.com.aceleragep.api_biblioteca.entities.LivroEntity;

@Component
public class LivroConvert {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AutorConvert autorConvert;



	public LivroEntity inputToEntity(LivroInput livroInput) {
		LivroEntity livro = modelMapper.map(livroInput, LivroEntity.class);
		livro.setAutores(autorConvert.longToEntity(livroInput.getAutores()));
		return livro;
	}

	public LivroOutput entityToOutput(LivroEntity livrosEncontrado) {
		return modelMapper.map(livrosEncontrado, LivroOutput.class);
	}

	public void copyInputToEntity(LivroEntity livroEncontrado, LivroInput livroInput) {
		modelMapper.map(livroInput, livroEncontrado);
		livroEncontrado.setAutores(autorConvert.longToEntity(livroInput.getAutores()));
	}

	public Page<LivroOutput> ListEntityToListOutput(Page<LivroEntity> livrosEncontrados) {
		return livrosEncontrados.map(this::entityToOutput);
	}

}
