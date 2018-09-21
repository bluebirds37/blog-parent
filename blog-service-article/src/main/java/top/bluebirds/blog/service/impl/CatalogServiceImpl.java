package top.bluebirds.blog.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.dao.CatalogRepository;
import top.bluebirds.blog.pojo.Catalog;
import top.bluebirds.blog.service.CatalogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Catalog服务层实现类
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CatalogServiceImpl implements CatalogService {

    private static Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Resource
    private CatalogRepository catalogRepository;

    @Override
    public Result insert(Catalog catalog) {
        logger.info("新增【catalog】>>>" + catalog.toString());
        catalogRepository.save(catalog);
        return new Result(200, "OK", null);
    }

    @Override
    public Result update(Catalog catalog) {
        logger.info("修改【catalog】>>>" + catalog.toString());
        catalogRepository.save(catalog);
        return new Result(200, "OK", null);
    }

    @Override
    public Result deleteInBatch(List<Catalog> catalogList) {
        catalogRepository.deleteAll(catalogList);
        logger.info("批量删除【catalogList】>>>" + catalogList);
        return new Result(200, "OK", null);
    }

    @Override
    public Result findOne(Integer id) {
        Catalog catalog = catalogRepository.findCatalogById(id);
        return new Result(200, "OK", catalog);
    }

    @Override
    public Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Catalog catalog) {
        Page<Catalog> page = catalogRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
        return new Result(200, "OK", page);
    }
}
