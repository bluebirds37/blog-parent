package top.bluebirds.blog.controller;


import org.springframework.web.bind.annotation.*;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.Catalog;
import top.bluebirds.blog.service.CatalogService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Catalog控制层
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@CrossOrigin
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Resource
    private CatalogService catalogService;

    @PostMapping("/insert")
    public Result insert(@RequestBody Catalog catalog, @RequestParam Integer userId) {
        catalog.setCreateTime(new Date());
        catalog.setCreateUserId(userId);
        return catalogService.insert(catalog);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Catalog catalog, @RequestParam Integer userId) {
        catalog.setUpdateTime(new Date());
        catalog.setUpdateUserId(userId);
        return catalogService.update(catalog);
    }

    @PostMapping("/deleteInBatch")
    public Result deleteInBatch(@RequestBody List<Catalog> catalogList, @RequestParam Integer userId) {
        for (Catalog catalog : catalogList) {
            catalog.setDeleteTime(new Date());
            catalog.setDeleteUserId(userId);
        }
        return catalogService.deleteInBatch(catalogList);
    }

    @GetMapping("/findOne")
    public Result findOne(@RequestParam Integer id) {
        return catalogService.findOne(id);
    }

    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sort, @RequestBody Catalog catalog) {
        return catalogService.pageQuery(page, size, sort, catalog);
    }
}
