package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.ProcessRecipe;
import me.zhengjie.modules.process.service.dto.ProcessRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class ProcessRecipeMapperImpl implements ProcessRecipeMapper {

    @Override
    public ProcessRecipe toEntity(ProcessRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProcessRecipe processRecipe = new ProcessRecipe();

        processRecipe.setId( dto.getId() );
        processRecipe.setName( dto.getName() );
        processRecipe.setCode( dto.getCode() );
        processRecipe.setDescription( dto.getDescription() );
        processRecipe.setCreateTime( dto.getCreateTime() );
        processRecipe.setCreatorName( dto.getCreatorName() );
        processRecipe.setVersion( dto.getVersion() );
        processRecipe.setValid( dto.getValid() );

        return processRecipe;
    }

    @Override
    public ProcessRecipeDTO toDto(ProcessRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        ProcessRecipeDTO processRecipeDTO = new ProcessRecipeDTO();

        processRecipeDTO.setId( entity.getId() );
        processRecipeDTO.setName( entity.getName() );
        processRecipeDTO.setCode( entity.getCode() );
        processRecipeDTO.setDescription( entity.getDescription() );
        processRecipeDTO.setCreateTime( entity.getCreateTime() );
        processRecipeDTO.setCreatorName( entity.getCreatorName() );
        processRecipeDTO.setVersion( entity.getVersion() );
        processRecipeDTO.setValid( entity.getValid() );

        return processRecipeDTO;
    }

    @Override
    public List<ProcessRecipe> toEntity(List<ProcessRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ProcessRecipe> list = new ArrayList<ProcessRecipe>( dtoList.size() );
        for ( ProcessRecipeDTO processRecipeDTO : dtoList ) {
            list.add( toEntity( processRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<ProcessRecipeDTO> toDto(List<ProcessRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProcessRecipeDTO> list = new ArrayList<ProcessRecipeDTO>( entityList.size() );
        for ( ProcessRecipe processRecipe : entityList ) {
            list.add( toDto( processRecipe ) );
        }

        return list;
    }
}
