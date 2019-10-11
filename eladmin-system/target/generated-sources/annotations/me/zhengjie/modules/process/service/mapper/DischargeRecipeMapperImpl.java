package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.service.dto.DischargeRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DischargeRecipeMapperImpl implements DischargeRecipeMapper {

    @Override
    public DischargeRecipe toEntity(DischargeRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DischargeRecipe dischargeRecipe = new DischargeRecipe();

        dischargeRecipe.setId( dto.getId() );
        dischargeRecipe.setRecipeType( dto.getRecipeType() );
        dischargeRecipe.setRecipeName( dto.getRecipeName() );
        dischargeRecipe.setEditorName( dto.getEditorName() );
        dischargeRecipe.setCreateTime( dto.getCreateTime() );
        dischargeRecipe.setUpdaterName( dto.getUpdaterName() );
        dischargeRecipe.setUpdateTime( dto.getUpdateTime() );
        dischargeRecipe.setFrequency( dto.getFrequency() );
        dischargeRecipe.setRecipeVersion( dto.getRecipeVersion() );
        dischargeRecipe.setDescription( dto.getDescription() );
        dischargeRecipe.setValid( dto.getValid() );

        return dischargeRecipe;
    }

    @Override
    public DischargeRecipeDTO toDto(DischargeRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        DischargeRecipeDTO dischargeRecipeDTO = new DischargeRecipeDTO();

        dischargeRecipeDTO.setId( entity.getId() );
        dischargeRecipeDTO.setRecipeName( entity.getRecipeName() );
        dischargeRecipeDTO.setEditorName( entity.getEditorName() );
        dischargeRecipeDTO.setCreateTime( entity.getCreateTime() );
        dischargeRecipeDTO.setUpdaterName( entity.getUpdaterName() );
        dischargeRecipeDTO.setUpdateTime( entity.getUpdateTime() );
        dischargeRecipeDTO.setFrequency( entity.getFrequency() );
        dischargeRecipeDTO.setRecipeVersion( entity.getRecipeVersion() );
        dischargeRecipeDTO.setDescription( entity.getDescription() );
        dischargeRecipeDTO.setRecipeType( entity.getRecipeType() );
        dischargeRecipeDTO.setValid( entity.getValid() );

        return dischargeRecipeDTO;
    }

    @Override
    public List<DischargeRecipe> toEntity(List<DischargeRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DischargeRecipe> list = new ArrayList<DischargeRecipe>( dtoList.size() );
        for ( DischargeRecipeDTO dischargeRecipeDTO : dtoList ) {
            list.add( toEntity( dischargeRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<DischargeRecipeDTO> toDto(List<DischargeRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DischargeRecipeDTO> list = new ArrayList<DischargeRecipeDTO>( entityList.size() );
        for ( DischargeRecipe dischargeRecipe : entityList ) {
            list.add( toDto( dischargeRecipe ) );
        }

        return list;
    }
}
