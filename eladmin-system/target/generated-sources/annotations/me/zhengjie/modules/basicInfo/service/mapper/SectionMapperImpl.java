package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.Section;
import me.zhengjie.modules.basicInfo.service.dto.SectionDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class SectionMapperImpl implements SectionMapper {

    @Override
    public Section toEntity(SectionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Section section = new Section();

        section.setId( dto.getId() );
        section.setName( dto.getName() );
        section.setCode( dto.getCode() );
        section.setDescription( dto.getDescription() );
        section.setCreatorName( dto.getCreatorName() );
        section.setCreateTime( dto.getCreateTime() );

        return section;
    }

    @Override
    public SectionDTO toDto(Section entity) {
        if ( entity == null ) {
            return null;
        }

        SectionDTO sectionDTO = new SectionDTO();

        sectionDTO.setId( entity.getId() );
        sectionDTO.setName( entity.getName() );
        sectionDTO.setCode( entity.getCode() );
        sectionDTO.setDescription( entity.getDescription() );
        sectionDTO.setCreatorName( entity.getCreatorName() );
        sectionDTO.setCreateTime( entity.getCreateTime() );

        return sectionDTO;
    }

    @Override
    public List<Section> toEntity(List<SectionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Section> list = new ArrayList<Section>( dtoList.size() );
        for ( SectionDTO sectionDTO : dtoList ) {
            list.add( toEntity( sectionDTO ) );
        }

        return list;
    }

    @Override
    public List<SectionDTO> toDto(List<Section> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SectionDTO> list = new ArrayList<SectionDTO>( entityList.size() );
        for ( Section section : entityList ) {
            list.add( toDto( section ) );
        }

        return list;
    }
}
