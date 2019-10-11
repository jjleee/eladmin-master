package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class LineInfoMapperImpl implements LineInfoMapper {

    @Override
    public LineInfo toEntity(LineInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LineInfo lineInfo = new LineInfo();

        lineInfo.setId( dto.getId() );
        lineInfo.setName( dto.getName() );
        lineInfo.setCode( dto.getCode() );
        lineInfo.setDescription( dto.getDescription() );
        lineInfo.setLineTypeName( dto.getLineTypeName() );
        lineInfo.setFactoryName( dto.getFactoryName() );
        lineInfo.setCreatorName( dto.getCreatorName() );
        lineInfo.setCreateTime( dto.getCreateTime() );
        lineInfo.setUpdateTime( dto.getUpdateTime() );
        lineInfo.setAvailable( dto.getAvailable() );

        return lineInfo;
    }

    @Override
    public LineInfoDTO toDto(LineInfo entity) {
        if ( entity == null ) {
            return null;
        }

        LineInfoDTO lineInfoDTO = new LineInfoDTO();

        lineInfoDTO.setId( entity.getId() );
        lineInfoDTO.setName( entity.getName() );
        lineInfoDTO.setCode( entity.getCode() );
        lineInfoDTO.setDescription( entity.getDescription() );
        lineInfoDTO.setLineTypeName( entity.getLineTypeName() );
        lineInfoDTO.setFactoryName( entity.getFactoryName() );
        lineInfoDTO.setCreatorName( entity.getCreatorName() );
        lineInfoDTO.setCreateTime( entity.getCreateTime() );
        lineInfoDTO.setUpdateTime( entity.getUpdateTime() );
        lineInfoDTO.setAvailable( entity.getAvailable() );

        return lineInfoDTO;
    }

    @Override
    public List<LineInfo> toEntity(List<LineInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LineInfo> list = new ArrayList<LineInfo>( dtoList.size() );
        for ( LineInfoDTO lineInfoDTO : dtoList ) {
            list.add( toEntity( lineInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<LineInfoDTO> toDto(List<LineInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LineInfoDTO> list = new ArrayList<LineInfoDTO>( entityList.size() );
        for ( LineInfo lineInfo : entityList ) {
            list.add( toDto( lineInfo ) );
        }

        return list;
    }
}
