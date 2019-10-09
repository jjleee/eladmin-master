package me.zhengjie.modules.data.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.service.CutoffDataService;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import me.zhengjie.modules.data.service.query.CutoffDataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-05-22
 */
@RestController
@RequestMapping("api")
public class CutoffDataController {

    @Autowired
    private CutoffDataService cutoffDataService;

    @Autowired
    private CutoffDataQueryService cutoffDataQueryService;

    private static final String ENTITY_NAME = "cutoffData";

    @Log("查询CutoffData")
    @GetMapping(value = "/cutoffData")
    public ResponseEntity getCutoffDatas(CutoffDataDTO resources, Pageable pageable) {
        return new ResponseEntity(cutoffDataQueryService.queryAll(resources,pageable), HttpStatus.OK);
    }
}