package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.ProcessRecipe;
import me.zhengjie.modules.process.service.ProcessRecipeService;
import me.zhengjie.modules.process.service.dto.FormationRecipeDTO;
import me.zhengjie.modules.process.service.dto.ProcessRecipeDTO;
import me.zhengjie.modules.process.service.query.ProcessRecipeQueryService;
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
public class ProcessRecipeController {

    @Autowired
    private ProcessRecipeService processRecipeService;

    @Autowired
    private ProcessRecipeQueryService processRecipeQueryService;

    private static final String ENTITY_NAME = "processRecipe";

    @Log("查询ProcessRecipe")
    @GetMapping(value = "/processRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getProcessRecipes(ProcessRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(processRecipeQueryService.queryAllPlus(resources, pageable), HttpStatus.OK);
    }

    @Log("新增ProcessRecipe")
    @PostMapping(value = "/processRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody ProcessRecipeDTO resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(processRecipeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改ProcessRecipe")
    @PutMapping(value = "/processRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody ProcessRecipeDTO resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty!!!");
        }
        processRecipeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ProcessRecipe")
    @DeleteMapping(value = "/processRecipe/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable String id) {
        processRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/processRecipe/names")
    public ResponseEntity getProcessNames() {
        return new ResponseEntity(processRecipeQueryService.queryAllName(), HttpStatus.OK);
    }
}