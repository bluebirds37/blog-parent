package top.bluebirds.blog.service;

import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.Report;

import java.util.List;

/**
 * Report服务层接口
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
public interface ReportService {

    /**
     * 新增
     *
     * @param report 实体
     * @return 结果数据
     */
    Result insert(Report report);

    /**
     * 修改
     *
     * @param report 实体
     * @return 结果数据
     */
    Result update(Report report);

    /**
     * 批量删除
     *
     * @param reportList 实体数组
     * @return 结果数据
     */
    Result deleteInBatch(List<Report> reportList);

    /**
    * 根据主键查询
    *
    * @param id 举报id
    * @return 结果数据
    */
    Result findOne(Integer id);

    /**
    * 条件分页查询
    *
    * @param pageNum 当前页码
    * @param pageSize 分页大小
    * @param orderBy 排序字段
    * @param report 实体
    * @return 结果数据
    */
    Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Report report);
}
