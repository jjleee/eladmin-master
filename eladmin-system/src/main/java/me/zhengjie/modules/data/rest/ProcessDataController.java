package me.zhengjie.modules.data.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.data.domain.ProcessData;
import me.zhengjie.modules.data.service.ProcessDataService;
import me.zhengjie.modules.data.service.dto.ProcessDataDTO;
import me.zhengjie.modules.data.service.query.ProcessDataQueryService;
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
public class ProcessDataController {

    @Autowired
    private ProcessDataService processDataService;

    @Autowired
    private ProcessDataQueryService processDataQueryService;

    private static final String ENTITY_NAME = "processData";

    @Log("查询ProcessData")
    @GetMapping(value = "/processData")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getProcessDatas(ProcessDataDTO resources, Pageable pageable) {
        return new ResponseEntity(processDataQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增ProcessData")
    @PostMapping(value = "/processData")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody ProcessData resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(processDataService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改ProcessData")
    @PutMapping(value = "/processData")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody ProcessData resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        processDataService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ProcessData")
    @DeleteMapping(value = "/processData/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        processDataService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}