package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.service.ProcessItemService;
import me.zhengjie.modules.process.service.dto.ProcessItemDTO;
import me.zhengjie.modules.process.service.query.ProcessItemQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-08
 */
@RestController
@RequestMapping("api")
public class ProcessItemController {

    @Autowired
    private ProcessItemService processItemService;

    @Autowired
    private ProcessItemQueryService processItemQueryService;

    private static final String ENTITY_NAME = "processItem";

    @Log("查询ProcessItem")
    @GetMapping(value = "/processItem")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getProcessItems(ProcessItemDTO resources, Pageable pageable) {
        return new ResponseEntity(processItemQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增ProcessItem")
    @PostMapping(value = "/processItem")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody ProcessItem resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(processItemService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改ProcessItem")
    @PutMapping(value = "/processItem")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody ProcessItem resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        processItemService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ProcessItem")
    @DeleteMapping(value = "/processItem/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable String id) {
        processItemService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}