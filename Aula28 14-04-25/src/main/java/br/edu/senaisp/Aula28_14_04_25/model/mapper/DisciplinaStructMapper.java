package br.edu.senaisp.Aula28_14_04_25.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.edu.senaisp.Aula28_14_04_25.model.Disciplina;
import br.edu.senaisp.Aula28_14_04_25.model.dto.DisciplinaClassDTO;

@Mapper
public interface DisciplinaStructMapper {

	DisciplinaStructMapper INSTANCE = Mappers.getMapper(DisciplinaStructMapper.class);

	@Mapping(source = "nomeDisciplina", target = "titulo")
	@Mapping(source = "horas", target = "duracaoH", numberFormat = "###")
	Disciplina toDisciplina(DisciplinaClassDTO dto);

	@Mapping(source = "titulo", target = "nomeDisciplina")
	@Mapping(source = "duracaoH", target = "horas")
	DisciplinaClassDTO toDisciplinaClassDTO(Disciplina disciplina);
}