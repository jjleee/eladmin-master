package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class BatteryTypeMapperImpl implements BatteryTypeMapper {

    @Override
    public BatteryType toEntity(BatteryTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BatteryType batteryType = new BatteryType();

        batteryType.setId( dto.getId() );
        batteryType.setName( dto.getName() );
        batteryType.setCode( dto.getCode() );
        batteryType.setDescription( dto.getDescription() );
        batteryType.setCreatorName( dto.getCreatorName() );
        batteryType.setCreateTime( dto.getCreateTime() );
        batteryType.setAvailable( dto.getAvailable() );

        return batteryType;
    }

    @Override
    public BatteryTypeDTO toDto(BatteryType entity) {
        if ( entity == null ) {
            return null;
        }

        BatteryTypeDTO batteryTypeDTO = new BatteryTypeDTO();

        batteryTypeDTO.setId( entity.getId() );
        batteryTypeDTO.setName( entity.getName() );
        batteryTypeDTO.setCode( entity.getCode() );
        batteryTypeDTO.setDescription( entity.getDescription() );
        batteryTypeDTO.setCreatorName( entity.getCreatorName() );
        batteryTypeDTO.setCreateTime( entity.getCreateTime() );
        batteryTypeDTO.setAvailable( entity.getAvailable() );

        return batteryTypeDTO;
    }

    @Override
    public List<BatteryType> toEntity(List<BatteryTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BatteryType> list = new ArrayList<BatteryType>( dtoList.size() );
        for ( BatteryTypeDTO batteryTypeDTO : dtoList ) {
            list.add( toEntity( batteryTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<BatteryTypeDTO> toDto(List<BatteryType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BatteryTypeDTO> list = new ArrayList<BatteryTypeDTO>( entityList.size() );
        for ( BatteryType batteryType : entityList ) {
            list.add( toDto( batteryType ) );
        }

        return list;
    }
}
