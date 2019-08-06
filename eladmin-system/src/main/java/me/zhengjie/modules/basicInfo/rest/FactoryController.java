package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.Factory;
import me.zhengjie.modules.basicInfo.service.FactoryService;
import me.zhengjie.modules.basicInfo.service.dto.FactoryDTO;
import me.zhengjie.modules.basicInfo.service.query.FactoryQueryService;
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
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @Autowired
    private FactoryQueryService factoryQueryService;

    private static final String ENTITY_NAME = "factory";

    @Log("查询Factory")
    @GetMapping(value = "/factory")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getFactorys(FactoryDTO resources, Pageable pageable) {
        return new ResponseEntity(factoryQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增Factory")
    @PostMapping(value = "/factory")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody Factory resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(factoryService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改Factory")
    @PutMapping(value = "/factory")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody Factory resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        factoryService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Factory")
    @DeleteMapping(value = "/factory/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        factoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/factory/names")
    public ResponseEntity getFactoryNames() {
        return new ResponseEntity(factoryQueryService.queryAllName(), HttpStatus.OK);
    }
}