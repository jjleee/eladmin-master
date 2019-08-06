package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.Section;
import me.zhengjie.modules.basicInfo.service.SectionService;
import me.zhengjie.modules.basicInfo.service.dto.SectionDTO;
import me.zhengjie.modules.basicInfo.service.query.SectionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-03-29
 */
@RestController
@RequestMapping("api")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private SectionQueryService sectionQueryService;

    private static final String ENTITY_NAME = "section";

    @Log("查询Section")
    @GetMapping(value = "/section")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getSections(SectionDTO resources, Pageable pageable) {
        return new ResponseEntity(sectionQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增Section")
    @PostMapping(value = "/section")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody Section resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(sectionService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改Section")
    @PutMapping(value = "/section")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody Section resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        sectionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Section")
    @DeleteMapping(value = "/section/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        sectionService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/section/names")
    public ResponseEntity getBatteryInfos() {
        return new ResponseEntity(sectionQueryService.queryAllName(), HttpStatus.OK);
    }
}