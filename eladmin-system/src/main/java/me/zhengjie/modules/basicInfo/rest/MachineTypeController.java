package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.MachineType;
import me.zhengjie.modules.basicInfo.service.MachineTypeService;
import me.zhengjie.modules.basicInfo.service.dto.MachineTypeDTO;
import me.zhengjie.modules.basicInfo.service.query.MachineTypeQueryService;
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
public class MachineTypeController {

    @Autowired
    private MachineTypeService machineTypeService;

    @Autowired
    private MachineTypeQueryService machineTypeQueryService;

    private static final String ENTITY_NAME = "machineType";

    @Log("查询MachineType")
    @GetMapping(value = "/machineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getMachineTypes(MachineTypeDTO resources, Pageable pageable) {
        return new ResponseEntity(machineTypeQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增MachineType")
    @PostMapping(value = "/machineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody MachineType resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(machineTypeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改MachineType")
    @PutMapping(value = "/machineType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody MachineType resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        machineTypeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除MachineType")
    @DeleteMapping(value = "/machineType/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        machineTypeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}