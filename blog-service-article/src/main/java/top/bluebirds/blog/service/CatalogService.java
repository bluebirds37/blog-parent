package top.bluebirds.blog.service;

import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.Catalog;

import java.util.List;


/**
 * Catalog服务层接口
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
public interface CatalogService {

    /**
     * 新增
     *
     * @param catalog 实体
     * @return 结果数据
     */
    Result insert(Catalog catalog);

    /**
     * 修改
     *
     * @param catalog 实体
     * @return 结果数据
     */
    Result update(Catalog catalog);

    /**
     * 批量删除
     *
     * @param catalogList 实体数组
     * @return 结果数据
     */
    Result deleteInBatch(List<Catalog> catalogList);

    /**
    * 根据主键查询
    *
    * @param id 栏目id
    * @return 结果数据
    */
    Result findOne(Integer id);

    /**
    * 条件分页查询
    *
    * @param pageNum 当前页码
    * @param pageSize 分页大小
    * @param orderBy 排序字段
    * @param catalog 实体
    * @return 结果数据
    */
    Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Catalog catalog);
}
