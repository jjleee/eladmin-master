package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.service.query.BatteryInfoQueryService;
import me.zhengjie.modules.process.service.FormationRecipeService;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import me.zhengjie.modules.process.service.query.FormationRecipeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author jie
 * @date 2019-04-03
 */
@RestController
@RequestMapping("api")
public class FormationRecipeController {

    @Autowired
    private FormationRecipeService formationRecipeService;

    @Autowired
    private FormationRecipeQueryService formationRecipeQueryService;

    @Autowired
    private BatteryInfoQueryService batteryInfoQueryService;

    private static final String ENTITY_NAME = "formationRecipe";

    @Log("查询FormationRecipe")
    @GetMapping(value = "/formationRecipe")
    public ResponseEntity getFormationRecipes(FormationRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(formationRecipeQueryService.queryAllPlus(resources, pageable), HttpStatus.OK);
    }

    @Log("新增FormationRecipe")
    @PostMapping(value = "/formationRecipe")
    public ResponseEntity create(@Validated @RequestBody FormationRecipeDTO resources,Principal principal) {
        if (resources.getId() != null && resources.getId() != "") {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(formationRecipeService.create(resources,principal.getName()), HttpStatus.CREATED);
    }

    @Log("修改FormationRecipe")
    @PutMapping(value = "/formationRecipe")
    public ResponseEntity update(@Validated @RequestBody FormationRecipeDTO resources, Principal principal) {
        if (resources.getId() == null || resources.getId() == "") {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        formationRecipeService.update(resources, principal);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除FormationRecipe")
    @DeleteMapping(value = "/formationRecipe/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        formationRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/formationRecipe/names/{type}")
    public ResponseEntity getFormationNames(@Validated @PathVariable Integer type) {
        return new ResponseEntity(formationRecipeQueryService.queryAllName(type), HttpStatus.OK);
    }

    @Log("复制FormationRecipe")
    @PostMapping(value = "/formationRecipe/copy")
    public ResponseEntity copy(@RequestParam(value = "id" ) String id,@RequestParam(value = "name") String name,Principal principal) {
        return new ResponseEntity(formationRecipeService.copy(id,name,principal), HttpStatus.CREATED);
    }

}