package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DcrRecipeMapperImpl implements DcrRecipeMapper {

    @Override
    public DcrRecipe toEntity(DcrRecipeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DcrRecipe dcrRecipe = new DcrRecipe();

        dcrRecipe.setId( dto.getId() );
        dcrRecipe.setName( dto.getName() );
        dcrRecipe.setRecipeType( dto.getRecipeType() );
        dcrRecipe.setVersion( dto.getVersion() );
        dcrRecipe.setValid( dto.getValid() );
        dcrRecipe.setCreatorName( dto.getCreatorName() );
        dcrRecipe.setCreateTime( dto.getCreateTime() );
        dcrRecipe.setUpdaterName( dto.getUpdaterName() );
        dcrRecipe.setUpdateTime( dto.getUpdateTime() );

        return dcrRecipe;
    }

    @Override
    public DcrRecipeDTO toDto(DcrRecipe entity) {
        if ( entity == null ) {
            return null;
        }

        DcrRecipeDTO dcrRecipeDTO = new DcrRecipeDTO();

        dcrRecipeDTO.setId( entity.getId() );
        dcrRecipeDTO.setName( entity.getName() );
        dcrRecipeDTO.setRecipeType( entity.getRecipeType() );
        dcrRecipeDTO.setVersion( entity.getVersion() );
        dcrRecipeDTO.setValid( entity.getValid() );
        dcrRecipeDTO.setCreatorName( entity.getCreatorName() );
        dcrRecipeDTO.setCreateTime( entity.getCreateTime() );
        dcrRecipeDTO.setUpdateTime( entity.getUpdateTime() );
        dcrRecipeDTO.setUpdaterName( entity.getUpdaterName() );

        return dcrRecipeDTO;
    }

    @Override
    public List<DcrRecipe> toEntity(List<DcrRecipeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DcrRecipe> list = new ArrayList<DcrRecipe>( dtoList.size() );
        for ( DcrRecipeDTO dcrRecipeDTO : dtoList ) {
            list.add( toEntity( dcrRecipeDTO ) );
        }

        return list;
    }

    @Override
    public List<DcrRecipeDTO> toDto(List<DcrRecipe> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DcrRecipeDTO> list = new ArrayList<DcrRecipeDTO>( entityList.size() );
        for ( DcrRecipe dcrRecipe : entityList ) {
            list.add( toDto( dcrRecipe ) );
        }

        return list;
    }
}
