package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.LineType;
import me.zhengjie.modules.basicInfo.service.LineTypeService;
import me.zhengjie.modules.basicInfo.service.dto.LineTypeDTO;
import me.zhengjie.modules.basicInfo.service.query.LineTypeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-10
 */
@RestController
@RequestMapping("api")
public class LineTypeController {

    @Autowired
    private LineTypeService lineTypeService;

    @Autowired
    private LineTypeQueryService lineTypeQueryService;

    private static final String ENTITY_NAME = "lineType";

    @Log("查询LineType")
    @GetMapping(value = "/lineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getLineTypes(LineTypeDTO resources, Pageable pageable) {
        return new ResponseEntity(lineTypeQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增LineType")
    @PostMapping(value = "/lineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody LineType resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(lineTypeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改LineType")
    @PutMapping(value = "/lineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody LineType resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        lineTypeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除LineType")
    @DeleteMapping(value = "/lineType/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        lineTypeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/lineType/names")
    public ResponseEntity getTypeNames() {
        return new ResponseEntity(lineTypeQueryService.queryAllName(), HttpStatus.OK);
    }
}