package co.edu.icesi.dev.sat.alert.entity.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlertMapper {

	AlertMapper INSTANCE = Mappers.getMapper(AlertMapper.class);
	
}
