package top.bluebirds.blog.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.dao.ReportRepository;
import top.bluebirds.blog.pojo.Report;
import top.bluebirds.blog.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Report服务层实现类
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

    private static Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Resource
    private ReportRepository reportRepository;

    @Override
    public Result insert(Report report) {
        logger.info("新增【report】>>>" + report.toString());
        reportRepository.save(report);
        return new Result(200, "OK", null);
    }

    @Override
    public Result update(Report report) {
        logger.info("修改【report】>>>" + report.toString());
        reportRepository.save(report);
        return new Result(200, "OK", null);
    }

    @Override
    public Result deleteInBatch(List<Report> reportList) {
        reportRepository.deleteAll(reportList);
        logger.info("批量删除【reportList】>>>" + reportList);
        return new Result(200, "OK", null);
    }

    @Override
    public Result findOne(Integer id) {
        Report report = reportRepository.findReportById(id);
        return new Result(200, "OK", report);
    }

    @Override
    public Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, Report report) {
        Page<Report> page = reportRepository.findAll(PageRequest.of(pageNum-1, pageSize));
        return new Result(200, "OK", page);
    }
}
