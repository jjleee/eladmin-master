package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.ExpBatteryInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class ExpBatteryInfoMapperImpl implements ExpBatteryInfoMapper {

    @Override
    public ExpBatteryInfo toEntity(ExpBatteryInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ExpBatteryInfo expBatteryInfo = new ExpBatteryInfo();

        expBatteryInfo.setId( dto.getId() );
        expBatteryInfo.setNumber( dto.getNumber() );
        expBatteryInfo.setTypeName( dto.getTypeName() );
        expBatteryInfo.setFormationRecipeName( dto.getFormationRecipeName() );
        expBatteryInfo.setDivisionRecipeName( dto.getDivisionRecipeName() );
        expBatteryInfo.setDcrRecipeName( dto.getDcrRecipeName() );
        expBatteryInfo.setChargeRecipeName( dto.getChargeRecipeName() );
        expBatteryInfo.setProtectParamName( dto.getProtectParamName() );
        expBatteryInfo.setNgRuleName( dto.getNgRuleName() );
        expBatteryInfo.setCreatorName( dto.getCreatorName() );
        expBatteryInfo.setCreateTime( dto.getCreateTime() );
        expBatteryInfo.setAvailable( dto.getAvailable() );

        return expBatteryInfo;
    }

    @Override
    public ExpBatteryInfoDTO toDto(ExpBatteryInfo entity) {
        if ( entity == null ) {
            return null;
        }

        ExpBatteryInfoDTO expBatteryInfoDTO = new ExpBatteryInfoDTO();

        expBatteryInfoDTO.setId( entity.getId() );
        expBatteryInfoDTO.setNumber( entity.getNumber() );
        expBatteryInfoDTO.setTypeName( entity.getTypeName() );
        expBatteryInfoDTO.setFormationRecipeName( entity.getFormationRecipeName() );
        expBatteryInfoDTO.setDivisionRecipeName( entity.getDivisionRecipeName() );
        expBatteryInfoDTO.setDcrRecipeName( entity.getDcrRecipeName() );
        expBatteryInfoDTO.setChargeRecipeName( entity.getChargeRecipeName() );
        expBatteryInfoDTO.setProtectParamName( entity.getProtectParamName() );
        expBatteryInfoDTO.setNgRuleName( entity.getNgRuleName() );
        expBatteryInfoDTO.setCreatorName( entity.getCreatorName() );
        expBatteryInfoDTO.setCreateTime( entity.getCreateTime() );
        expBatteryInfoDTO.setAvailable( entity.getAvailable() );

        return expBatteryInfoDTO;
    }

    @Override
    public List<ExpBatteryInfo> toEntity(List<ExpBatteryInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ExpBatteryInfo> list = new ArrayList<ExpBatteryInfo>( dtoList.size() );
        for ( ExpBatteryInfoDTO expBatteryInfoDTO : dtoList ) {
            list.add( toEntity( expBatteryInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<ExpBatteryInfoDTO> toDto(List<ExpBatteryInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ExpBatteryInfoDTO> list = new ArrayList<ExpBatteryInfoDTO>( entityList.size() );
        for ( ExpBatteryInfo expBatteryInfo : entityList ) {
            list.add( toDto( expBatteryInfo ) );
        }

        return list;
    }
}
