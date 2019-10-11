package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DivisionRecipeMapperImpl implements DivisionRecipeMapper {

    @Override
    public DivisionRecipe toEntity(DivisionRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DivisionRecipe divisionRecipe = new DivisionRecipe();

        divisionRecipe.setId( dto.getId() );
        divisionRecipe.setRecipeName( dto.getRecipeName() );
        divisionRecipe.setEditorName( dto.getEditorName() );
        divisionRecipe.setCreateTime( dto.getCreateTime() );
        divisionRecipe.setUpdaterName( dto.getUpdaterName() );
        divisionRecipe.setUpdateTime( dto.getUpdateTime() );
        divisionRecipe.setFrequency( dto.getFrequency() );
        divisionRecipe.setRecipeType( dto.getRecipeType() );
        divisionRecipe.setRecipeVersion( dto.getRecipeVersion() );
        divisionRecipe.setDescription( dto.getDescription() );
        divisionRecipe.setValid( dto.getValid() );

        return divisionRecipe;
    }

    @Override
    public DivisionRecipeDTO toDto(DivisionRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        DivisionRecipeDTO divisionRecipeDTO = new DivisionRecipeDTO();

        divisionRecipeDTO.setId( entity.getId() );
        divisionRecipeDTO.setRecipeName( entity.getRecipeName() );
        divisionRecipeDTO.setEditorName( entity.getEditorName() );
        divisionRecipeDTO.setCreateTime( entity.getCreateTime() );
        divisionRecipeDTO.setUpdaterName( entity.getUpdaterName() );
        divisionRecipeDTO.setUpdateTime( entity.getUpdateTime() );
        divisionRecipeDTO.setFrequency( entity.getFrequency() );
        divisionRecipeDTO.setRecipeVersion( entity.getRecipeVersion() );
        divisionRecipeDTO.setDescription( entity.getDescription() );
        divisionRecipeDTO.setValid( entity.getValid() );
        divisionRecipeDTO.setRecipeType( entity.getRecipeType() );

        return divisionRecipeDTO;
    }

    @Override
    public List<DivisionRecipe> toEntity(List<DivisionRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DivisionRecipe> list = new ArrayList<DivisionRecipe>( dtoList.size() );
        for ( DivisionRecipeDTO divisionRecipeDTO : dtoList ) {
            list.add( toEntity( divisionRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<DivisionRecipeDTO> toDto(List<DivisionRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DivisionRecipeDTO> list = new ArrayList<DivisionRecipeDTO>( entityList.size() );
        for ( DivisionRecipe divisionRecipe : entityList ) {
            list.add( toDto( divisionRecipe ) );
        }

        return list;
    }
}
