package br.com.aceleragep.api_biblioteca.converties;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.aceleragep.api_biblioteca.dtos.inputs.AutorInput;
import br.com.aceleragep.api_biblioteca.dtos.outputs.AutorOutput;
import br.com.aceleragep.api_biblioteca.entities.AutorEntity;
import br.com.aceleragep.api_biblioteca.services.AutorService;

@Component
public class AutorConvert {

	@Autowired
	ModelMapper modelMapper;
			
	@Autowired
	AutorService autorService;

	public AutorEntity inputToEntity(AutorInput autorInput) {
		return modelMapper.map(autorInput, AutorEntity.class);
	}

	public AutorOutput entityToOutput(AutorEntity autoresEncontrado) {
		return modelMapper.map(autoresEncontrado, AutorOutput.class);
	}

	public void copyInputToEntity(AutorEntity autorEncontrado, AutorInput autorInput) {
		modelMapper.map(autorInput, autorEncontrado);
	}

	public Page<AutorOutput> ListEntityToListOutput(Page<AutorEntity> autoresEncontrados) {
		return autoresEncontrados.map(this::entityToOutput);
	}
	
	public List<AutorEntity> longToEntity(List<Long> listLong){
		List<AutorEntity> autores = new ArrayList<>();
		listLong.forEach(autor -> autores.add(autorService.buscarPeloId(autor)));
		return autores;
	}
}
