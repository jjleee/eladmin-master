package me.zhengjie.modules.data.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.client.ProviderClient;
import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2019-05-22
 */
@RestController
@RequestMapping("api")
public class ProcessDataController {

    @Autowired
    ProviderClient providerClient;

    private static final String ENTITY_NAME = "processData";

    @Log("查询ProcessData")
    @GetMapping("/processData")
    public ResponseEntity getProcessDatas(ProcessDataDTO processData, Pageable pageable) {
        final String tableName = "lbfs";
        String start = null;
        String end = null;
        String prefix = null;
        List<ProcessData> hi =new ArrayList<>();
        if (processData.getChannelNo()!=null) {
            start = String.format("%d-%d-%d-%d-%d", processData.getLineNo(),
                    processData.getCabNo(), processData.getCellNo(), processData.getChannelNo(), processData.getStartTime());
            end = String.format("%d-%d-%d-%d-%d", processData.getLineNo(), processData.getCabNo(),
                    processData.getCellNo(), processData.getChannelNo(), processData.getEndTime());
            prefix = String.format("%d-%d-%d-%d", processData.getLineNo(), processData.getCabNo(),
                    processData.getCellNo(), processData.getChannelNo());
            hi = providerClient.hi(tableName, prefix, start, end);
        } else {
            for (int i=1;i<49;i++){
                start = String.format("%d-%d-%d-"+i+"-%d", processData.getLineNo(),
                        processData.getCabNo(), processData.getCellNo(), processData.getStartTime());
                end = String.format("%d-%d-%d-"+i+"-%d", processData.getLineNo(), processData.getCabNo(),
                        processData.getCellNo(),  processData.getEndTime());
                prefix = String.format("%d-%d-%d-"+i, processData.getLineNo(), processData.getCabNo(),
                        processData.getCellNo());
                List<ProcessData> dataList = providerClient.hi(tableName, prefix, start, end);
                hi.addAll(dataList);
            }
        }
        List pageList = PageUtil.toPage(pageable.getPageNumber(), 20000, hi);
        Page page = new PageImpl(pageList,pageable,hi.size());
        return new ResponseEntity(PageUtil.toPage(page), HttpStatus.OK);
    }
}