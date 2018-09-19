package top.bluebirds.blog.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.dao.CommentRepository;
import top.bluebirds.blog.entity.Comment;
import top.bluebirds.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Comment服务层实现类
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService {

    private static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Resource
    private CommentRepository commentRepository;

    @Override
    public Result insert(Comment comment) {
        logger.info("新增【comment】>>>" + comment.toString());
        commentRepository.save(comment);
        return new Result(200, "OK", null);
    }

    @Override
    public Result update(Comment comment) {
        logger.info("修改【comment】>>>" + comment.toString());
        commentRepository.save(comment);
        return new Result(200, "OK", null);
    }

    @Override
    public Result deleteInBatch(List<Comment> commentList) {
        commentRepository.deleteAll(commentList);
        logger.info("批量删除【commentList】>>>" + commentList);
        return new Result(200, "OK", null);
    }

    @Override
    public Result findOne(Integer id) {
        Comment comment = commentRepository.findCommentById(id);
        return new Result(200, "OK", comment);
    }

    @Override
    public Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Comment comment) {
        Page<Comment> page = commentRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
        return new Result(200, "OK", page);
    }
}
