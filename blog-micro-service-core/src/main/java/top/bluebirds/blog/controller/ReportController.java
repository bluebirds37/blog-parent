package top.bluebirds.blog.controller;


import org.springframework.web.bind.annotation.*;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.Report;
import top.bluebirds.blog.service.ReportService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Report控制层
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @PostMapping("/insert")
    public Result insert(@RequestBody Report report, @RequestParam Integer userId) {
        report.setCreateTime(new Date());
        report.setCreateUserId(userId);
        return reportService.insert(report);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Report report, @RequestParam Integer userId) {
        report.setUpdateTime(new Date());
        report.setUpdateUserId(userId);
        return reportService.update(report);
    }

    @PostMapping("/deleteInBatch")
    public Result deleteInBatch(@RequestBody List<Report> reportList, @RequestParam Integer userId) {
        for (Report report : reportList) {
            report.setDeleteTime(new Date());
            report.setDeleteUserId(userId);
        }
        return reportService.deleteInBatch(reportList);
    }

    @GetMapping("/findOne")
    public Result findOne(@RequestParam Integer id) {
        return reportService.findOne(id);
    }

    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sort, @RequestBody Report report) {
        return reportService.pageQuery(page, size, sort, report);
    }
}
