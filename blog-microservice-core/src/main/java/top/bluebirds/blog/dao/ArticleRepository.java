package top.bluebirds.blog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bluebirds.blog.entity.Article;

public interface ArticleRepository extends MongoRepository<Article,Long> {

    Article findArticleById(Integer id);
}
