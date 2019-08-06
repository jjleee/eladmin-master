package me.zhengjie.modules.system.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.modules.system.service.DepartmentInfoService;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import me.zhengjie.modules.system.service.query.DepartmentInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-03-28
 */
@RestController
@RequestMapping("api")
public class DepartmentInfoController {

    @Autowired
    private DepartmentInfoService departmentInfoService;

    @Autowired
    private DepartmentInfoQueryService departmentInfoQueryService;

    private static final String ENTITY_NAME = "departmentInfo";

    @Log("查询DepartmentInfo")
    @GetMapping(value = "/departmentInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getDepartmentInfos(DepartmentInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(departmentInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增DepartmentInfo")
    @PostMapping(value = "/departmentInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody DepartmentInfo resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(departmentInfoService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改DepartmentInfo")
    @PutMapping(value = "/departmentInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody DepartmentInfo resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        departmentInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除DepartmentInfo")
    @DeleteMapping(value = "/departmentInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        departmentInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}