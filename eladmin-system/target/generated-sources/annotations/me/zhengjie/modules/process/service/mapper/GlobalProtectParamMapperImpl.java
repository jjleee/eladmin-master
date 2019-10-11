package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.GlobalProtectParam;
import me.zhengjie.modules.process.service.dto.GlobalProtectParamDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class GlobalProtectParamMapperImpl implements GlobalProtectParamMapper {

    @Override
    public GlobalProtectParam toEntity(GlobalProtectParamDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GlobalProtectParam globalProtectParam = new GlobalProtectParam();

        globalProtectParam.setId( dto.getId() );
        globalProtectParam.setName( dto.getName() );
        globalProtectParam.setChargeVoltage( dto.getChargeVoltage() );
        globalProtectParam.setChargeCurrent( dto.getChargeCurrent() );
        globalProtectParam.setChargeCapacity( dto.getChargeCapacity() );
        globalProtectParam.setDischargeVoltage( dto.getDischargeVoltage() );
        globalProtectParam.setDischargeCurrent( dto.getDischargeCurrent() );
        globalProtectParam.setDischargeCapacity( dto.getDischargeCapacity() );
        globalProtectParam.setUpperLimitTemperature( dto.getUpperLimitTemperature() );
        globalProtectParam.setReverseProtect( dto.getReverseProtect() );
        globalProtectParam.setVoltageFluctuation( dto.getVoltageFluctuation() );
        globalProtectParam.setCurrentFluctuation( dto.getCurrentFluctuation() );
        globalProtectParam.setOhm( dto.getOhm() );
        globalProtectParam.setOcd( dto.getOcd() );
        globalProtectParam.setOvd( dto.getOvd() );
        globalProtectParam.setDcLimit( dto.getDcLimit() );
        globalProtectParam.setLoopImpedance( dto.getLoopImpedance() );

        return globalProtectParam;
    }

    @Override
    public GlobalProtectParamDTO toDto(GlobalProtectParam entity) {
        if ( entity == null ) {
            return null;
        }

        GlobalProtectParamDTO globalProtectParamDTO = new GlobalProtectParamDTO();

        globalProtectParamDTO.setId( entity.getId() );
        globalProtectParamDTO.setName( entity.getName() );
        globalProtectParamDTO.setChargeVoltage( entity.getChargeVoltage() );
        globalProtectParamDTO.setChargeCurrent( entity.getChargeCurrent() );
        globalProtectParamDTO.setChargeCapacity( entity.getChargeCapacity() );
        globalProtectParamDTO.setDischargeVoltage( entity.getDischargeVoltage() );
        globalProtectParamDTO.setDischargeCurrent( entity.getDischargeCurrent() );
        globalProtectParamDTO.setDischargeCapacity( entity.getDischargeCapacity() );
        globalProtectParamDTO.setUpperLimitTemperature( entity.getUpperLimitTemperature() );
        globalProtectParamDTO.setReverseProtect( entity.getReverseProtect() );
        globalProtectParamDTO.setVoltageFluctuation( entity.getVoltageFluctuation() );
        globalProtectParamDTO.setCurrentFluctuation( entity.getCurrentFluctuation() );
        globalProtectParamDTO.setOhm( entity.getOhm() );
        globalProtectParamDTO.setOcd( entity.getOcd() );
        globalProtectParamDTO.setOvd( entity.getOvd() );
        globalProtectParamDTO.setDcLimit( entity.getDcLimit() );
        globalProtectParamDTO.setLoopImpedance( entity.getLoopImpedance() );

        return globalProtectParamDTO;
    }

    @Override
    public List<GlobalProtectParam> toEntity(List<GlobalProtectParamDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<GlobalProtectParam> list = new ArrayList<GlobalProtectParam>( dtoList.size() );
        for ( GlobalProtectParamDTO globalProtectParamDTO : dtoList ) {
            list.add( toEntity( globalProtectParamDTO ) );
        }

        return list;
    }

    @Override
    public List<GlobalProtectParamDTO> toDto(List<GlobalProtectParam> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GlobalProtectParamDTO> list = new ArrayList<GlobalProtectParamDTO>( entityList.size() );
        for ( GlobalProtectParam globalProtectParam : entityList ) {
            list.add( toDto( globalProtectParam ) );
        }

        return list;
    }
}
