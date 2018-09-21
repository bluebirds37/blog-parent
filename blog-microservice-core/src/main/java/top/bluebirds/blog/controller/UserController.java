package top.bluebirds.blog.controller;


import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.*;
import top.bluebirds.blog.Utils.AlipayUtils;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.pojo.User;
import top.bluebirds.blog.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User控制层
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Autowired
    private TaskExecutor taskExecutor;


    public static Logger getLogger() {
        return LoggerFactory.getLogger(AlipayUtils.class);
    }


    @GetMapping(value = "/goLogin")
    public void goLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.sendRedirect("login.html");

        /*taskExecutor.execute(() -> {
            System.out.println("测试:线程名" + Thread.currentThread().getName());
            taskExecutor.execute(() -> {
                System.out.println("测试:线程名" + Thread.currentThread().getName());
                taskExecutor.execute(() -> {
                    System.out.println("测试:线程名" + Thread.currentThread().getName());
                });
            });
        });*/

        getLogger().info("用户:"+request.getSession().getId()+"连接了");

        AlipayUtils.payTrade();

    }

    @PostMapping("/insert")
    @ApiOperation(value = "增加", notes = "增加")
    public Result insert(@RequestBody User user, @RequestParam(required = false) Integer userId) {
        user.setCreateTime(new Date());
        user.setCreateUserId(userId);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        user.setId(uuid);
        return userService.insert(user);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user, @RequestParam Integer userId) {
        user.setUpdateTime(new Date());
        user.setUpdateUserId(userId);
        return userService.update(user);
    }

    @PostMapping("/deleteInBatch")
    public Result deleteInBatch(@RequestBody List<User> userList, @RequestParam Integer userId) {
        for (User user : userList) {
            user.setDeleteTime(new Date());
            user.setDeleteUserId(userId);
        }
        return userService.deleteInBatch(userList);
    }

    @GetMapping("/findOne")
    public Result findOne(@RequestParam Integer id) {
        return userService.findOne(id);
    }

    @PostMapping("/pageQuery")
    public Result pageQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false) String sort, @RequestBody User user) {
        return userService.pageQuery(page, size, sort, user);
    }
}
