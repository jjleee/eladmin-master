package me.zhengjie.modules.warning.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class PowerWarningMapperImpl implements PowerWarningMapper {

    @Override
    public PowerWarning toEntity(PowerWarningDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PowerWarning powerWarning = new PowerWarning();

        powerWarning.setId( dto.getId() );
        powerWarning.setLine( dto.getLine() );
        powerWarning.setCabinet( dto.getCabinet() );
        powerWarning.setCell( dto.getCell() );
        powerWarning.setChannel( dto.getChannel() );
        powerWarning.setFuncCode( dto.getFuncCode() );
        powerWarning.setSubFuncCode( dto.getSubFuncCode() );
        powerWarning.setErrorCode( dto.getErrorCode() );
        powerWarning.setMessage( dto.getMessage() );
        powerWarning.setCreateTime( dto.getCreateTime() );

        return powerWarning;
    }

    @Override
    public PowerWarningDTO toDto(PowerWarning entity) {
        if ( entity == null ) {
            return null;
        }

        PowerWarningDTO powerWarningDTO = new PowerWarningDTO();

        powerWarningDTO.setId( entity.getId() );
        powerWarningDTO.setLine( entity.getLine() );
        powerWarningDTO.setCabinet( entity.getCabinet() );
        powerWarningDTO.setCell( entity.getCell() );
        powerWarningDTO.setChannel( entity.getChannel() );
        powerWarningDTO.setFuncCode( entity.getFuncCode() );
        powerWarningDTO.setSubFuncCode( entity.getSubFuncCode() );
        powerWarningDTO.setErrorCode( entity.getErrorCode() );
        powerWarningDTO.setMessage( entity.getMessage() );
        powerWarningDTO.setCreateTime( entity.getCreateTime() );

        return powerWarningDTO;
    }

    @Override
    public List<PowerWarning> toEntity(List<PowerWarningDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PowerWarning> list = new ArrayList<PowerWarning>( dtoList.size() );
        for ( PowerWarningDTO powerWarningDTO : dtoList ) {
            list.add( toEntity( powerWarningDTO ) );
        }

        return list;
    }

    @Override
    public List<PowerWarningDTO> toDto(List<PowerWarning> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PowerWarningDTO> list = new ArrayList<PowerWarningDTO>( entityList.size() );
        for ( PowerWarning powerWarning : entityList ) {
            list.add( toDto( powerWarning ) );
        }

        return list;
    }
}
