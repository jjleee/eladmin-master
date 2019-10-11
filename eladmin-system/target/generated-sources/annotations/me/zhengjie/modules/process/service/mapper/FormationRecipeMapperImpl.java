package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.FormationRecipe;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class FormationRecipeMapperImpl implements FormationRecipeMapper {

    @Override
    public FormationRecipe toEntity(FormationRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FormationRecipe formationRecipe = new FormationRecipe();

        formationRecipe.setId( dto.getId() );
        formationRecipe.setCreateTime( dto.getCreateTime() );
        formationRecipe.setDescription( dto.getDescription() );
        formationRecipe.setEditorName( dto.getEditorName() );
        formationRecipe.setName( dto.getName() );
        formationRecipe.setRecipeType( dto.getRecipeType() );
        formationRecipe.setUpdateTime( dto.getUpdateTime() );
        formationRecipe.setUpdaterName( dto.getUpdaterName() );
        formationRecipe.setVersion( dto.getVersion() );
        formationRecipe.setFrequency( dto.getFrequency() );
        formationRecipe.setValid( dto.getValid() );

        return formationRecipe;
    }

    @Override
    public FormationRecipeDTO toDto(FormationRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        FormationRecipeDTO formationRecipeDTO = new FormationRecipeDTO();

        formationRecipeDTO.setId( entity.getId() );
        formationRecipeDTO.setCreateTime( entity.getCreateTime() );
        formationRecipeDTO.setDescription( entity.getDescription() );
        formationRecipeDTO.setEditorName( entity.getEditorName() );
        formationRecipeDTO.setName( entity.getName() );
        formationRecipeDTO.setUpdateTime( entity.getUpdateTime() );
        formationRecipeDTO.setUpdaterName( entity.getUpdaterName() );
        formationRecipeDTO.setVersion( entity.getVersion() );
        formationRecipeDTO.setFrequency( entity.getFrequency() );
        formationRecipeDTO.setValid( entity.getValid() );
        formationRecipeDTO.setRecipeType( entity.getRecipeType() );

        return formationRecipeDTO;
    }

    @Override
    public List<FormationRecipe> toEntity(List<FormationRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FormationRecipe> list = new ArrayList<FormationRecipe>( dtoList.size() );
        for ( FormationRecipeDTO formationRecipeDTO : dtoList ) {
            list.add( toEntity( formationRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<FormationRecipeDTO> toDto(List<FormationRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FormationRecipeDTO> list = new ArrayList<FormationRecipeDTO>( entityList.size() );
        for ( FormationRecipe formationRecipe : entityList ) {
            list.add( toDto( formationRecipe ) );
        }

        return list;
    }
}
