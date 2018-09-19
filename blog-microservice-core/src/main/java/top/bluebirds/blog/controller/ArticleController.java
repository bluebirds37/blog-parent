package top.bluebirds.blog.controller;



import org.springframework.web.bind.annotation.*;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.entity.Article;
import top.bluebirds.blog.service.ArticleService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Article控制层
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/insert")
    public Result insert(@RequestBody Article article, @RequestParam Integer userId) {
        article.setCreateTime(new Date());
        article.setCreateUserId(userId);
        return articleService.insert(article);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article, @RequestParam Integer userId) {
        article.setUpdateTime(new Date());
        article.setUpdateUserId(userId);
        return articleService.update(article);
    }

    @PostMapping("/deleteInBatch")
    public Result deleteInBatch(@RequestBody List<Article> articleList, @RequestParam Integer userId) {
        for (Article article : articleList) {
            article.setDeleteTime(new Date());
            article.setDeleteUserId(userId);
        }
        return articleService.deleteInBatch(articleList);
    }

    @GetMapping("/findOne")
    public Result findOne(@RequestParam Integer id) {
        return articleService.findOne(id);
    }

    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sort, @RequestBody Article article) {
        return articleService.pageQuery(page, size, sort, article);
    }
}
