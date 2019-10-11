package me.zhengjie.modules.data.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class CutoffDataMapperImpl implements CutoffDataMapper {

    @Override
    public CutoffData toEntity(CutoffDataDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CutoffData cutoffData = new CutoffData();

        cutoffData.setId( dto.getId() );
        cutoffData.setLineNo( dto.getLineNo() );
        cutoffData.setCabNo( dto.getCabNo() );
        cutoffData.setCellNo( dto.getCellNo() );
        cutoffData.setChannelNo( dto.getChannelNo() );
        cutoffData.setFuncCode( dto.getFuncCode() );
        cutoffData.setRunState( dto.getRunState() );
        cutoffData.setRunTime( dto.getRunTime() );
        cutoffData.setVoltage( dto.getVoltage() );
        cutoffData.setCurrent( dto.getCurrent() );
        cutoffData.setCapacity( dto.getCapacity() );
        cutoffData.setBatteryTemperature( dto.getBatteryTemperature() );
        cutoffData.setStepNo( dto.getStepNo() );
        cutoffData.setStepType( dto.getStepType() );
        cutoffData.setLoopNo( dto.getLoopNo() );
        cutoffData.setCurrentTime( dto.getCurrentTime() );
        cutoffData.setSumStep( dto.getSumStep() );
        cutoffData.setRatio( dto.getRatio() );
        cutoffData.setEnergy( dto.getEnergy() );
        cutoffData.setPovl( dto.getPovl() );

        return cutoffData;
    }

    @Override
    public CutoffDataDTO toDto(CutoffData entity) {
        if ( entity == null ) {
            return null;
        }

        CutoffDataDTO cutoffDataDTO = new CutoffDataDTO();

        cutoffDataDTO.setId( entity.getId() );
        cutoffDataDTO.setLineNo( entity.getLineNo() );
        cutoffDataDTO.setCabNo( entity.getCabNo() );
        cutoffDataDTO.setCellNo( entity.getCellNo() );
        cutoffDataDTO.setChannelNo( entity.getChannelNo() );
        cutoffDataDTO.setFuncCode( entity.getFuncCode() );
        cutoffDataDTO.setRunState( entity.getRunState() );
        cutoffDataDTO.setRunTime( entity.getRunTime() );
        cutoffDataDTO.setVoltage( entity.getVoltage() );
        cutoffDataDTO.setCurrent( entity.getCurrent() );
        cutoffDataDTO.setCapacity( entity.getCapacity() );
        cutoffDataDTO.setBatteryTemperature( entity.getBatteryTemperature() );
        cutoffDataDTO.setStepNo( entity.getStepNo() );
        cutoffDataDTO.setStepType( entity.getStepType() );
        cutoffDataDTO.setLoopNo( entity.getLoopNo() );
        cutoffDataDTO.setCurrentTime( entity.getCurrentTime() );
        cutoffDataDTO.setSumStep( entity.getSumStep() );
        cutoffDataDTO.setRatio( entity.getRatio() );
        cutoffDataDTO.setEnergy( entity.getEnergy() );
        cutoffDataDTO.setPovl( entity.getPovl() );

        return cutoffDataDTO;
    }

    @Override
    public List<CutoffData> toEntity(List<CutoffDataDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CutoffData> list = new ArrayList<CutoffData>( dtoList.size() );
        for ( CutoffDataDTO cutoffDataDTO : dtoList ) {
            list.add( toEntity( cutoffDataDTO ) );
        }

        return list;
    }

    @Override
    public List<CutoffDataDTO> toDto(List<CutoffData> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CutoffDataDTO> list = new ArrayList<CutoffDataDTO>( entityList.size() );
        for ( CutoffData cutoffData : entityList ) {
            list.add( toDto( cutoffData ) );
        }

        return list;
    }
}
