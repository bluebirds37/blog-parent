package top.bluebirds.blog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bluebirds.blog.pojo.Report;

public interface ReportRepository extends MongoRepository<Report,Integer> {

    Report findReportById(Integer id);

}
