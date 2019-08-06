package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.service.DivisionRecipeService;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import me.zhengjie.modules.process.service.query.DivisionRecipeQueryService;
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
 * @date 2019-04-26
 */
@RestController
@RequestMapping("api")
public class DivisionRecipeController {

    @Autowired
    private DivisionRecipeService divisionRecipeService;

    @Autowired
    private DivisionRecipeQueryService divisionRecipeQueryService;

    private static final String ENTITY_NAME = "divisionRecipe";

    @Log("查询DivisionRecipe")
    @GetMapping(value = "/divisionRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getDivisionRecipes(DivisionRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(divisionRecipeQueryService.queryAllPlus(resources, pageable), HttpStatus.OK);
    }


    @Log("新增DivisionRecipe")
    @PostMapping(value = "/divisionRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody DivisionRecipeDTO resources) {
        if (resources.getId() != null && resources.getId() != "") {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(divisionRecipeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改DivisionRecipe")
    @PutMapping(value = "/divisionRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody DivisionRecipeDTO resources, Principal principal) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty！");
        }
        divisionRecipeService.update(resources, principal);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除DivisionRecipe")
    @DeleteMapping(value = "/divisionRecipe/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable String id) {
        divisionRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/divisionRecipe/names")
    public ResponseEntity getDivisionNames() {
        return new ResponseEntity(divisionRecipeQueryService.queryAllName(), HttpStatus.OK);
    }
}