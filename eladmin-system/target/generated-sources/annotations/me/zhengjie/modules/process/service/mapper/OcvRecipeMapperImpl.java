package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.OcvRecipe;
import me.zhengjie.modules.process.service.dto.OcvRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class OcvRecipeMapperImpl implements OcvRecipeMapper {

    @Override
    public OcvRecipe toEntity(OcvRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OcvRecipe ocvRecipe = new OcvRecipe();

        ocvRecipe.setId( dto.getId() );
        ocvRecipe.setName( dto.getName() );

        return ocvRecipe;
    }

    @Override
    public OcvRecipeDTO toDto(OcvRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        OcvRecipeDTO ocvRecipeDTO = new OcvRecipeDTO();

        ocvRecipeDTO.setId( entity.getId() );
        ocvRecipeDTO.setName( entity.getName() );

        return ocvRecipeDTO;
    }

    @Override
    public List<OcvRecipe> toEntity(List<OcvRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<OcvRecipe> list = new ArrayList<OcvRecipe>( dtoList.size() );
        for ( OcvRecipeDTO ocvRecipeDTO : dtoList ) {
            list.add( toEntity( ocvRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<OcvRecipeDTO> toDto(List<OcvRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OcvRecipeDTO> list = new ArrayList<OcvRecipeDTO>( entityList.size() );
        for ( OcvRecipe ocvRecipe : entityList ) {
            list.add( toDto( ocvRecipe ) );
        }

        return list;
    }
}
