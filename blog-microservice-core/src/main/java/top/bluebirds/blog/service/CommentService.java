package top.bluebirds.blog.service;


import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.entity.Comment;

import java.util.List;

/**
 * Comment服务层接口
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
public interface CommentService {

    /**
     * 新增
     *
     * @param comment 实体
     * @return 结果数据
     */
    Result insert(Comment comment);

    /**
     * 修改
     *
     * @param comment 实体
     * @return 结果数据
     */
    Result update(Comment comment);

    /**
     * 批量删除
     *
     * @param commentList 实体数组
     * @return 结果数据
     */
    Result deleteInBatch(List<Comment> commentList);

    /**
    * 根据主键查询
    *
    * @param id 评论id
    * @return 结果数据
    */
    Result findOne(Integer id);

    /**
    * 条件分页查询
    *
    * @param pageNum 当前页码
    * @param pageSize 分页大小
    * @param orderBy 排序字段
    * @param comment 实体
    * @return 结果数据
    */
    Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Comment comment);
}
