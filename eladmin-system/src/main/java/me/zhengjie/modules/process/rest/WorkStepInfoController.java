package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.service.WorkStepInfoService;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import me.zhengjie.modules.process.service.query.WorkStepInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-03
 */
@RestController
@RequestMapping("api")
public class WorkStepInfoController {

    @Autowired
    private WorkStepInfoService workStepInfoService;

    @Autowired
    private WorkStepInfoQueryService workStepInfoQueryService;

    private static final String ENTITY_NAME = "workStepInfo";

    @Log("查询WorkStepInfo")
    @GetMapping(value = "/workStepInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getWorkStepInfos(WorkStepInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(workStepInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增WorkStepInfo")
    @PostMapping(value = "/workStepInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody WorkStepInfo resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(workStepInfoService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改WorkStepInfo")
    @PutMapping(value = "/workStepInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody WorkStepInfo resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        workStepInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除WorkStepInfo")
    @DeleteMapping(value = "/workStepInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable String id) {
        workStepInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}