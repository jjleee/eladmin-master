package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.modules.basicInfo.service.BatteryTypeService;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import me.zhengjie.modules.basicInfo.service.query.BatteryTypeQueryService;
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
public class BatteryTypeController {

    @Autowired
    private BatteryTypeService batteryTypeService;

    @Autowired
    private BatteryTypeQueryService batteryTypeQueryService;

    private static final String ENTITY_NAME = "batteryType";

    @Log("查询BatteryType")
    @GetMapping(value = "/batteryType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getBatteryTypes(BatteryTypeDTO resources, Pageable pageable) {
        return new ResponseEntity(batteryTypeQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增BatteryType")
    @PostMapping(value = "/batteryType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody BatteryType resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(batteryTypeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改BatteryType")
    @PutMapping(value = "/batteryType")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody BatteryType resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        batteryTypeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除BatteryType")
    @DeleteMapping(value = "/batteryType/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        batteryTypeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/batteryType/names")
    public ResponseEntity getTypeNames() {
        return new ResponseEntity(batteryTypeQueryService.queryAllName(), HttpStatus.OK);
    }
}