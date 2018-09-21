package top.bluebirds.blog.service;



import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.Article;
import java.util.List;


/**
 * Article服务层接口
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
public interface ArticleService {

    /**
     * 新增
     *
     * @param article 实体
     * @return 结果数据
     */
    Result insert(Article article);

    /**
     * 修改
     *
     * @param article 实体
     * @return 结果数据
     */
    Result update(Article article);

    /**
     * 批量删除
     *
     * @param articleList 实体数组
     * @return 结果数据
     */
    Result deleteInBatch(List<Article> articleList);

    /**
    * 根据主键查询
    *
    * @param id 文章id
    * @return 结果数据
    */
    Result findOne(Integer id);

    /**
    * 条件分页查询
    *
    * @param pageNum 当前页码
    * @param pageSize 分页大小
    * @param orderBy 排序字段
    * @param article 实体
    * @return 结果数据
    */
    Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Article article);
}
