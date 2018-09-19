package top.bluebirds.blog.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.dao.ArticleRepository;
import top.bluebirds.blog.entity.Article;
import top.bluebirds.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Article服务层实现类
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Result insert(Article article) {
        logger.info("新增【article】>>>" + article.toString());
        articleRepository.save(article);
        return new Result(200, "OK", null);
    }

    @Override
    public Result update(Article article) {
        logger.info("修改【article】>>>" + article.toString());
        articleRepository.save(article);
        return new Result(200, "OK", null);
    }

    @Override
    public Result deleteInBatch(List<Article> articleList) {
        articleRepository.deleteAll(articleList);
        logger.info("批量删除【articleList】>>>" + articleList);
        return new Result(200, "OK", null);
    }

    @Override
    public Result findOne(Integer id) {
        Article article = articleRepository.findArticleById(id);
        return new Result(200, "OK", article);
    }

    @Override
    public Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Article article) {
        Page<Article> page = articleRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
        return new Result(200, "OK", page);
    }
}
