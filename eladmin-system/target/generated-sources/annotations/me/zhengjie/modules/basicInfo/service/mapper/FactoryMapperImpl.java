package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.Factory;
import me.zhengjie.modules.basicInfo.service.dto.FactoryDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class FactoryMapperImpl implements FactoryMapper {

    @Override
    public Factory toEntity(FactoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Factory factory = new Factory();

        factory.setId( dto.getId() );
        factory.setName( dto.getName() );
        factory.setCode( dto.getCode() );
        factory.setDescription( dto.getDescription() );
        factory.setCreatorName( dto.getCreatorName() );
        factory.setCreateTime( dto.getCreateTime() );
        factory.setUpdateTime( dto.getUpdateTime() );
        factory.setAvailable( dto.getAvailable() );

        return factory;
    }

    @Override
    public FactoryDTO toDto(Factory entity) {
        if ( entity == null ) {
            return null;
        }

        FactoryDTO factoryDTO = new FactoryDTO();

        factoryDTO.setId( entity.getId() );
        factoryDTO.setName( entity.getName() );
        factoryDTO.setCode( entity.getCode() );
        factoryDTO.setDescription( entity.getDescription() );
        factoryDTO.setCreatorName( entity.getCreatorName() );
        factoryDTO.setCreateTime( entity.getCreateTime() );
        factoryDTO.setUpdateTime( entity.getUpdateTime() );
        factoryDTO.setAvailable( entity.getAvailable() );

        return factoryDTO;
    }

    @Override
    public List<Factory> toEntity(List<FactoryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Factory> list = new ArrayList<Factory>( dtoList.size() );
        for ( FactoryDTO factoryDTO : dtoList ) {
            list.add( toEntity( factoryDTO ) );
        }

        return list;
    }

    @Override
    public List<FactoryDTO> toDto(List<Factory> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FactoryDTO> list = new ArrayList<FactoryDTO>( entityList.size() );
        for ( Factory factory : entityList ) {
            list.add( toDto( factory ) );
        }

        return list;
    }
}
