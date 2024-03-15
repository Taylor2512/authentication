package com.monodev.authentication.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.monodev.authentication.models.dto.UserDto;
import com.monodev.authentication.models.entity.Usuario;
import com.monodev.authentication.models.request.UsertRequest;

@Mapper(componentModel = "spring")
@Component
public interface IMapper {
    
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);
    
    UserDto map(Usuario usuario);
    
    Usuario map(UserDto userDto);
    
    Usuario map(UsertRequest usuario);
    
    Usuario map(UsertRequest personaRequest, @MappingTarget Usuario personas);
    
}
