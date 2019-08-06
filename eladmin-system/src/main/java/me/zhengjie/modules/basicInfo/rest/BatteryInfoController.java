package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.service.BatteryInfoService;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.query.BatteryInfoQueryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-01
 */
@RestController
@RequestMapping("api")
public class BatteryInfoController {

    @Autowired
    private BatteryInfoService batteryInfoService;

    @Autowired
    private BatteryInfoQueryService batteryInfoQueryService;

    private static final String ENTITY_NAME = "batteryInfo";

    @Log("查询BatteryInfo")
    @GetMapping(value = "/batteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getBatteryInfos(BatteryInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(batteryInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增BatteryInfo")
    @PostMapping(value = "/batteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody BatteryInfoDTO resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        BatteryInfo batteryInfo = new BatteryInfo();
        BeanUtils.copyProperties(resources, batteryInfo);
        batteryInfo.setLineName(String.join("|", resources.getLineNames()));
        return new ResponseEntity(batteryInfoService.create(batteryInfo), HttpStatus.CREATED);
    }

    @Log("修改BatteryInfo")
    @PutMapping(value = "/batteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody BatteryInfoDTO resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty!!");
        }
        batteryInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除BatteryInfo")
    @DeleteMapping(value = "/batteryInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        batteryInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @Log("查询所有电池型号")
    @GetMapping(value = "/batteryInfo/names")
    public ResponseEntity getBatteryInfos() {
        return new ResponseEntity(batteryInfoQueryService.queryAllName(), HttpStatus.OK);
    }
}