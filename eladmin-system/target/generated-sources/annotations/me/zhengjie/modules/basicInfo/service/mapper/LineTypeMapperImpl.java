package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.LineType;
import me.zhengjie.modules.basicInfo.service.dto.LineTypeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:18+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class LineTypeMapperImpl implements LineTypeMapper {

    @Override
    public LineType toEntity(LineTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LineType lineType = new LineType();

        lineType.setId( dto.getId() );
        lineType.setName( dto.getName() );
        lineType.setCode( dto.getCode() );
        lineType.setDescription( dto.getDescription() );
        lineType.setCreatorName( dto.getCreatorName() );
        lineType.setCreateTime( dto.getCreateTime() );
        lineType.setUpdateTime( dto.getUpdateTime() );
        lineType.setAvailable( dto.getAvailable() );

        return lineType;
    }

    @Override
    public LineTypeDTO toDto(LineType entity) {
        if ( entity == null ) {
            return null;
        }

        LineTypeDTO lineTypeDTO = new LineTypeDTO();

        lineTypeDTO.setId( entity.getId() );
        lineTypeDTO.setName( entity.getName() );
        lineTypeDTO.setCode( entity.getCode() );
        lineTypeDTO.setDescription( entity.getDescription() );
        lineTypeDTO.setCreatorName( entity.getCreatorName() );
        lineTypeDTO.setCreateTime( entity.getCreateTime() );
        lineTypeDTO.setUpdateTime( entity.getUpdateTime() );
        lineTypeDTO.setAvailable( entity.getAvailable() );

        return lineTypeDTO;
    }

    @Override
    public List<LineType> toEntity(List<LineTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LineType> list = new ArrayList<LineType>( dtoList.size() );
        for ( LineTypeDTO lineTypeDTO : dtoList ) {
            list.add( toEntity( lineTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<LineTypeDTO> toDto(List<LineType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LineTypeDTO> list = new ArrayList<LineTypeDTO>( entityList.size() );
        for ( LineType lineType : entityList ) {
            list.add( toDto( lineType ) );
        }

        return list;
    }
}
