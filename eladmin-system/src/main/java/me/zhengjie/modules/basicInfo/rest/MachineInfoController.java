package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.MachineInfo;
import me.zhengjie.modules.basicInfo.service.MachineInfoService;
import me.zhengjie.modules.basicInfo.service.dto.MachineInfoDTO;
import me.zhengjie.modules.basicInfo.service.query.MachineInfoQueryService;
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
public class MachineInfoController {

    @Autowired
    private MachineInfoService machineInfoService;

    @Autowired
    private MachineInfoQueryService machineInfoQueryService;

    private static final String ENTITY_NAME = "machineInfo";

    @Log("查询MachineInfo")
    @GetMapping(value = "/machineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getMachineInfos(MachineInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(machineInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增MachineInfo")
    @PostMapping(value = "/machineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody MachineInfo resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(machineInfoService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改MachineInfo")
    @PutMapping(value = "/machineInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody MachineInfo resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        machineInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除MachineInfo")
    @DeleteMapping(value = "/machineInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        machineInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}