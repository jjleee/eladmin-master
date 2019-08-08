package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.service.DcrStepService;
import me.zhengjie.modules.process.service.query.DcrStepQueryService;
import me.zhengjie.modules.system.domain.Permission;
import me.zhengjie.modules.system.service.PermissionService;
import me.zhengjie.modules.system.service.dto.PermissionDTO;
import me.zhengjie.modules.system.service.query.PermissionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jie
 * @date 2018-12-03
 */
@RestController
@RequestMapping("api")
public class DcrStepController {

    @Autowired
    private DcrStepService dcrStepService;

    @Autowired
    private DcrStepQueryService dcrStepQueryService;

    private static final String ENTITY_NAME = "dcrStep";




}
