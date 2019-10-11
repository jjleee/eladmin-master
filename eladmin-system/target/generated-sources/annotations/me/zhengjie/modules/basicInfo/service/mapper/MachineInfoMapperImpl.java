package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.MachineInfo;
import me.zhengjie.modules.basicInfo.service.dto.MachineInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class MachineInfoMapperImpl implements MachineInfoMapper {

    @Override
    public MachineInfo toEntity(MachineInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MachineInfo machineInfo = new MachineInfo();

        machineInfo.setId( dto.getId() );
        machineInfo.setName( dto.getName() );
        machineInfo.setCode( dto.getCode() );
        machineInfo.setDescription( dto.getDescription() );
        machineInfo.setLineName( dto.getLineName() );
        machineInfo.setSectionName( dto.getSectionName() );
        machineInfo.setPosition( dto.getPosition() );
        machineInfo.setCreatorName( dto.getCreatorName() );
        machineInfo.setCreateTime( dto.getCreateTime() );
        machineInfo.setAvailable( dto.getAvailable() );

        return machineInfo;
    }

    @Override
    public MachineInfoDTO toDto(MachineInfo entity) {
        if ( entity == null ) {
            return null;
        }

        MachineInfoDTO machineInfoDTO = new MachineInfoDTO();

        machineInfoDTO.setId( entity.getId() );
        machineInfoDTO.setName( entity.getName() );
        machineInfoDTO.setCode( entity.getCode() );
        machineInfoDTO.setDescription( entity.getDescription() );
        machineInfoDTO.setLineName( entity.getLineName() );
        machineInfoDTO.setSectionName( entity.getSectionName() );
        machineInfoDTO.setPosition( entity.getPosition() );
        machineInfoDTO.setCreatorName( entity.getCreatorName() );
        machineInfoDTO.setCreateTime( entity.getCreateTime() );
        machineInfoDTO.setAvailable( entity.getAvailable() );

        return machineInfoDTO;
    }

    @Override
    public List<MachineInfo> toEntity(List<MachineInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MachineInfo> list = new ArrayList<MachineInfo>( dtoList.size() );
        for ( MachineInfoDTO machineInfoDTO : dtoList ) {
            list.add( toEntity( machineInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<MachineInfoDTO> toDto(List<MachineInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MachineInfoDTO> list = new ArrayList<MachineInfoDTO>( entityList.size() );
        for ( MachineInfo machineInfo : entityList ) {
            list.add( toDto( machineInfo ) );
        }

        return list;
    }
}
