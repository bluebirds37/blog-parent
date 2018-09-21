package top.bluebirds.blog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bluebirds.blog.pojo.Catalog;

public interface CatalogRepository  extends MongoRepository<Catalog,Long> {

    Catalog findCatalogById(Integer id);
}
