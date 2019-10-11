package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class BatteryInfoMapperImpl implements BatteryInfoMapper {

    @Override
    public BatteryInfo toEntity(BatteryInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BatteryInfo batteryInfo = new BatteryInfo();

        batteryInfo.setId( dto.getId() );
        batteryInfo.setNumber( dto.getNumber() );
        batteryInfo.setTypeName( dto.getTypeName() );
        batteryInfo.setFormationRecipeName( dto.getFormationRecipeName() );
        batteryInfo.setDivisionRecipeName( dto.getDivisionRecipeName() );
        batteryInfo.setOcvRecipeName( dto.getOcvRecipeName() );
        batteryInfo.setDcrRecipeName( dto.getDcrRecipeName() );
        batteryInfo.setChargeRecipeName( dto.getChargeRecipeName() );
        batteryInfo.setProtectParamName( dto.getProtectParamName() );
        batteryInfo.setNgRuleName( dto.getNgRuleName() );
        batteryInfo.setCreatorName( dto.getCreatorName() );
        batteryInfo.setCreateTime( dto.getCreateTime() );
        batteryInfo.setAvailable( dto.getAvailable() );

        return batteryInfo;
    }

    @Override
    public BatteryInfoDTO toDto(BatteryInfo entity) {
        if ( entity == null ) {
            return null;
        }

        BatteryInfoDTO batteryInfoDTO = new BatteryInfoDTO();

        batteryInfoDTO.setId( entity.getId() );
        batteryInfoDTO.setNumber( entity.getNumber() );
        batteryInfoDTO.setTypeName( entity.getTypeName() );
        batteryInfoDTO.setFormationRecipeName( entity.getFormationRecipeName() );
        batteryInfoDTO.setDivisionRecipeName( entity.getDivisionRecipeName() );
        batteryInfoDTO.setOcvRecipeName( entity.getOcvRecipeName() );
        batteryInfoDTO.setDcrRecipeName( entity.getDcrRecipeName() );
        batteryInfoDTO.setChargeRecipeName( entity.getChargeRecipeName() );
        batteryInfoDTO.setProtectParamName( entity.getProtectParamName() );
        batteryInfoDTO.setNgRuleName( entity.getNgRuleName() );
        batteryInfoDTO.setCreatorName( entity.getCreatorName() );
        batteryInfoDTO.setCreateTime( entity.getCreateTime() );
        batteryInfoDTO.setAvailable( entity.getAvailable() );

        return batteryInfoDTO;
    }

    @Override
    public List<BatteryInfo> toEntity(List<BatteryInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BatteryInfo> list = new ArrayList<BatteryInfo>( dtoList.size() );
        for ( BatteryInfoDTO batteryInfoDTO : dtoList ) {
            list.add( toEntity( batteryInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<BatteryInfoDTO> toDto(List<BatteryInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BatteryInfoDTO> list = new ArrayList<BatteryInfoDTO>( entityList.size() );
        for ( BatteryInfo batteryInfo : entityList ) {
            list.add( toDto( batteryInfo ) );
        }

        return list;
    }
}
