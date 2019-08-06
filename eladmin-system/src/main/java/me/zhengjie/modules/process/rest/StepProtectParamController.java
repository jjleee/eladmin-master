package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.service.StepProtectParamService;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import me.zhengjie.modules.process.service.query.StepProtectParamQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-25
 */
@RestController
@RequestMapping("api")
public class StepProtectParamController {

    @Autowired
    private StepProtectParamService stepProtectParamService;

    @Autowired
    private StepProtectParamQueryService stepProtectParamQueryService;

    private static final String ENTITY_NAME = "stepProtectParam";

    @Log("查询StepProtectParam")
    @GetMapping(value = "/stepProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getStepProtectParams(StepProtectParamDTO resources, Pageable pageable) {
        return new ResponseEntity(stepProtectParamQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增StepProtectParam")
    @PostMapping(value = "/stepProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody StepProtectParam resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(stepProtectParamService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改StepProtectParam")
    @PutMapping(value = "/stepProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody StepProtectParam resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        stepProtectParamService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除StepProtectParam")
    @DeleteMapping(value = "/stepProtectParam/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        stepProtectParamService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/stepProtectParam/getByStroke/{stroke}")
    public ResponseEntity getByStroke(@PathVariable String stroke) {
        return new ResponseEntity(stepProtectParamQueryService.queryBystroke(stroke), HttpStatus.OK);
    }

    @GetMapping(value = "/stepProtectParam/getByName/{protectName}")
    public ResponseEntity getByName(@PathVariable String protectName) {
        System.out.println(stepProtectParamQueryService.queryByName(protectName));
        return new ResponseEntity(stepProtectParamQueryService.queryByName(protectName), HttpStatus.OK);
    }
}