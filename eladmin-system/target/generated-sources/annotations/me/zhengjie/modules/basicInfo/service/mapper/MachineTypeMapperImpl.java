package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.MachineType;
import me.zhengjie.modules.basicInfo.service.dto.MachineTypeDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class MachineTypeMapperImpl implements MachineTypeMapper {

    @Override
    public MachineType toEntity(MachineTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MachineType machineType = new MachineType();

        machineType.setId( dto.getId() );
        machineType.setName( dto.getName() );
        machineType.setCode( dto.getCode() );
        machineType.setDescription( dto.getDescription() );
        machineType.setCreatorName( dto.getCreatorName() );
        machineType.setCreateTime( dto.getCreateTime() );
        machineType.setAvailable( dto.getAvailable() );

        return machineType;
    }

    @Override
    public MachineTypeDTO toDto(MachineType entity) {
        if ( entity == null ) {
            return null;
        }

        MachineTypeDTO machineTypeDTO = new MachineTypeDTO();

        machineTypeDTO.setId( entity.getId() );
        machineTypeDTO.setName( entity.getName() );
        machineTypeDTO.setCode( entity.getCode() );
        machineTypeDTO.setDescription( entity.getDescription() );
        machineTypeDTO.setCreatorName( entity.getCreatorName() );
        machineTypeDTO.setCreateTime( entity.getCreateTime() );
        machineTypeDTO.setAvailable( entity.getAvailable() );

        return machineTypeDTO;
    }

    @Override
    public List<MachineType> toEntity(List<MachineTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MachineType> list = new ArrayList<MachineType>( dtoList.size() );
        for ( MachineTypeDTO machineTypeDTO : dtoList ) {
            list.add( toEntity( machineTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<MachineTypeDTO> toDto(List<MachineType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MachineTypeDTO> list = new ArrayList<MachineTypeDTO>( entityList.size() );
        for ( MachineType machineType : entityList ) {
            list.add( toDto( machineType ) );
        }

        return list;
    }
}
