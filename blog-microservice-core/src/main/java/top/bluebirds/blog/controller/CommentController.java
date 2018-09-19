package top.bluebirds.blog.controller;


import org.springframework.web.bind.annotation.*;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.entity.Comment;
import top.bluebirds.blog.service.CommentService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Comment控制层
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/insert")
    public Result insert(@RequestBody Comment comment, @RequestParam Integer userId) {
        comment.setCreateTime(new Date());
        comment.setCreateUserId(userId);
        return commentService.insert(comment);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Comment comment, @RequestParam Integer userId) {
        comment.setUpdateTime(new Date());
        comment.setUpdateUserId(userId);
        return commentService.update(comment);
    }

    @PostMapping("/deleteInBatch")
    public Result deleteInBatch(@RequestBody List<Comment> commentList, @RequestParam Integer userId) {
        for (Comment comment : commentList) {
            comment.setDeleteTime(new Date());
            comment.setDeleteUserId(userId);
        }
        return commentService.deleteInBatch(commentList);
    }

    @GetMapping("/findOne")
    public Result findOne(@RequestParam Integer id) {
        return commentService.findOne(id);
    }

    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sort, @RequestBody Comment comment) {
        return commentService.pageQuery(page, size, sort, comment);
    }
}
