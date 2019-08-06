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
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getCutoffDatas(CutoffDataDTO resources) {
        return new ResponseEntity(cutoffDataQueryService.queryAll(resources), HttpStatus.OK);
    }

    @Log("新增CutoffData")
    @PostMapping(value = "/cutoffData")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody CutoffData resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(cutoffDataService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改CutoffData")
    @PutMapping(value = "/cutoffData")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody CutoffData resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        cutoffDataService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除CutoffData")
    @DeleteMapping(value = "/cutoffData/{id}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        cutoffDataService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}