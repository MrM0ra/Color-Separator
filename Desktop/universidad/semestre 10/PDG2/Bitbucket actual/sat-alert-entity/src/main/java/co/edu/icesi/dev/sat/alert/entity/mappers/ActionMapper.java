package co.edu.icesi.dev.sat.alert.entity.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {

	ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);
	
}
