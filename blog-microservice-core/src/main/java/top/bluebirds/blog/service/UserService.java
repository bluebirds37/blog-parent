package top.bluebirds.blog.service;


import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.entity.User;

import java.util.List;

/**
 * User服务层接口
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
public interface UserService {

    /**
     * 新增
     *
     * @param user 实体
     * @return 结果数据
     */
    Result insert(User user);

    /**
     * 修改
     *
     * @param user 实体
     * @return 结果数据
     */
    Result update(User user);

    /**
     * 批量删除
     *
     * @param userList 实体数组
     * @return 结果数据
     */
    Result deleteInBatch(List<User> userList);

    /**
    * 根据主键查询
    *
    * @param id 用户主键
    * @return 结果数据
    */
    Result findOne(Integer id);

    /**
    * 条件分页查询
    *
    * @param pageNum 当前页码
    * @param pageSize 分页大小
    * @param orderBy 排序字段
    * @param user 实体
    * @return 结果数据
    */
    Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, User user);
}
