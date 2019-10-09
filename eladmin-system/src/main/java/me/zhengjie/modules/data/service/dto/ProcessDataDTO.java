package me.zhengjie.modules.data.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-05-22
 */
@Data
public class ProcessDataDTO implements Serializable {
    String rowKey;
    Double batteryTemperature;
    Integer lineNo;
    Integer cabNo;
    Integer channelNo;
    Double capacity;
    Integer cellNo;
    Double current;
    Long currentTime;
    Double energy;
    Integer funcCode;
    Integer loopNo;
    Double povl;
    Double ratio;
    Integer runState;
    Long runTime;
    Integer stepNo;
    Integer stepType;
    Integer sumStep;
    Double voltage;
    Long startTime;
    Long endTime;
}