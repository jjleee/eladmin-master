package me.zhengjie.modules.data.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class ProcessDataMapperImpl implements ProcessDataMapper {

    @Override
    public ProcessData toEntity(ProcessDataDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProcessData processData = new ProcessData();

        processData.setRowKey( dto.getRowKey() );
        processData.setBatteryTemperature( dto.getBatteryTemperature() );
        processData.setLineNo( dto.getLineNo() );
        processData.setCabNo( dto.getCabNo() );
        processData.setChannelNo( dto.getChannelNo() );
        processData.setCapacity( dto.getCapacity() );
        processData.setCellNo( dto.getCellNo() );
        processData.setCurrent( dto.getCurrent() );
        processData.setCurrentTime( dto.getCurrentTime() );
        processData.setEnergy( dto.getEnergy() );
        processData.setFuncCode( dto.getFuncCode() );
        processData.setLoopNo( dto.getLoopNo() );
        processData.setPovl( dto.getPovl() );
        processData.setRatio( dto.getRatio() );
        processData.setRunState( dto.getRunState() );
        processData.setRunTime( dto.getRunTime() );
        processData.setStepNo( dto.getStepNo() );
        processData.setStepType( dto.getStepType() );
        processData.setSumStep( dto.getSumStep() );
        processData.setVoltage( dto.getVoltage() );

        return processData;
    }

    @Override
    public ProcessDataDTO toDto(ProcessData entity) {
        if ( entity == null ) {
            return null;
        }

        ProcessDataDTO processDataDTO = new ProcessDataDTO();

        processDataDTO.setRowKey( entity.getRowKey() );
        processDataDTO.setBatteryTemperature( entity.getBatteryTemperature() );
        processDataDTO.setLineNo( entity.getLineNo() );
        processDataDTO.setCabNo( entity.getCabNo() );
        processDataDTO.setChannelNo( entity.getChannelNo() );
        processDataDTO.setCapacity( entity.getCapacity() );
        processDataDTO.setCellNo( entity.getCellNo() );
        processDataDTO.setCurrent( entity.getCurrent() );
        processDataDTO.setCurrentTime( entity.getCurrentTime() );
        processDataDTO.setEnergy( entity.getEnergy() );
        processDataDTO.setFuncCode( entity.getFuncCode() );
        processDataDTO.setLoopNo( entity.getLoopNo() );
        processDataDTO.setPovl( entity.getPovl() );
        processDataDTO.setRatio( entity.getRatio() );
        processDataDTO.setRunState( entity.getRunState() );
        processDataDTO.setRunTime( entity.getRunTime() );
        processDataDTO.setStepNo( entity.getStepNo() );
        processDataDTO.setStepType( entity.getStepType() );
        processDataDTO.setSumStep( entity.getSumStep() );
        processDataDTO.setVoltage( entity.getVoltage() );

        return processDataDTO;
    }

    @Override
    public List<ProcessData> toEntity(List<ProcessDataDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ProcessData> list = new ArrayList<ProcessData>( dtoList.size() );
        for ( ProcessDataDTO processDataDTO : dtoList ) {
            list.add( toEntity( processDataDTO ) );
        }

        return list;
    }

    @Override
    public List<ProcessDataDTO> toDto(List<ProcessData> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProcessDataDTO> list = new ArrayList<ProcessDataDTO>( entityList.size() );
        for ( ProcessData processData : entityList ) {
            list.add( toDto( processData ) );
        }

        return list;
    }
}
