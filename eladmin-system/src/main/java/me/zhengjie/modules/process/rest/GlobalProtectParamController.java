package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.GlobalProtectParam;
import me.zhengjie.modules.process.service.GlobalProtectParamService;
import me.zhengjie.modules.process.service.dto.GlobalProtectParamDTO;
import me.zhengjie.modules.process.service.query.GlobalProtectParamQueryService;
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
public class GlobalProtectParamController {

    @Autowired
    private GlobalProtectParamService globalProtectParamService;

    @Autowired
    private GlobalProtectParamQueryService globalProtectParamQueryService;

    private static final String ENTITY_NAME = "globalProtectParam";

    @Log("查询GlobalProtectParam")
    @GetMapping(value = "/globalProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getglobalProtectParams(GlobalProtectParamDTO resources, Pageable pageable) {
        return new ResponseEntity(globalProtectParamQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增GlobalProtectParam")
    @PostMapping(value = "/globalProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody GlobalProtectParam resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(globalProtectParamService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改GlobalProtectParam")
    @PutMapping(value = "/globalProtectParam")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody GlobalProtectParam resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        globalProtectParamService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除GlobalProtectParam")
    @DeleteMapping(value = "/globalProtectParam/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        globalProtectParamService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/globalProtectParam/names")
    public ResponseEntity getProtectNames() {
        return new ResponseEntity(globalProtectParamQueryService.queryAllName(), HttpStatus.OK);
    }
}