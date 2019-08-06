package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.modules.basicInfo.service.LineInfoService;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import me.zhengjie.modules.basicInfo.service.query.LineInfoQueryService;
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
public class LineInfoController {

    @Autowired
    private LineInfoService lineInfoService;

    @Autowired
    private LineInfoQueryService lineInfoQueryService;

    private static final String ENTITY_NAME = "lineInfo";

    @Log("查询LineInfo")
    @GetMapping(value = "/lineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getLineInfos(LineInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(lineInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增LineInfo")
    @PostMapping(value = "/lineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody LineInfo resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(lineInfoService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改LineInfo")
    @PutMapping(value = "/lineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody LineInfo resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        lineInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除LineInfo")
    @DeleteMapping(value = "/lineInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        lineInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/lineInfo/names")
    public ResponseEntity getLineNames() {
        return new ResponseEntity(lineInfoQueryService.queryAllName(), HttpStatus.OK);
    }
}