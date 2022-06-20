package cn.tedu.csmall.product.webapi.controller;

import cn.tedu.csmall.common.web.JsonResult;
import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.pojo.dto.CategoryUpdateDTO;
import cn.tedu.csmall.pojo.vo.CategoryDetailsVO;
import cn.tedu.csmall.pojo.vo.CategorySimpleListItemVO;
import cn.tedu.csmall.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories", produces = "application/json; charset=utf-8")
public class CategoryController {

    public CategoryController() {
        System.out.println("CategoryController.CategoryController()");
    }

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add-new")
    public JsonResult<Void> addNew(@Validated CategoryAddNewDTO categoryAddNewDTO) {
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

    @GetMapping("/{id}")
    public JsonResult<CategoryDetailsVO> getDetailsById(@PathVariable Long id) {
        CategoryDetailsVO category = categoryService.getDetailsById(id);
        return JsonResult.ok(category);
    }

    @GetMapping("/list-by-parent")
    public JsonResult<List<CategorySimpleListItemVO>> listByParentId(Long parentId) {
        // 调用service并将结果封装到JsonResult中
        List<CategorySimpleListItemVO> list = categoryService.listByParentId(parentId);
        return JsonResult.ok(list);
    }

    @GetMapping("/{id}/update-disable-by-id")
    public JsonResult<Void> updateEnableById(@PathVariable Long id) {
        categoryService.updateEnableById(id);
        return JsonResult.ok();
    }
    @GetMapping("/{id}/update-display-by-id")
    public JsonResult<Void> updateDisplayById(@PathVariable Long id) {
        categoryService.updateDisplayById(id);
        return JsonResult.ok();
    }
    @GetMapping("/{id}/deleye-by-id")
    public JsonResult<Void> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return JsonResult.ok();
    }

    @PostMapping("/{id}/update-category")
    public JsonResult<Void> updateCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return JsonResult.ok();
    }


}
