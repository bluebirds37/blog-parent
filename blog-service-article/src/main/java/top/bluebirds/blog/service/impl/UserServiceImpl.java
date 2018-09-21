package top.bluebirds.blog.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bluebirds.blog.Utils.Result;
import top.bluebirds.blog.dao.UserRepository;
import top.bluebirds.blog.pojo.User;
import top.bluebirds.blog.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * User服务层实现类
 *
 * @author
 * @date 2018-8-1 15:39:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    @Override
    public Result insert(User user) {
        logger.info("新增【user】>>>" + user.toString());
        userRepository.save(user);
        return new Result(200, "OK", null);
    }

    @Override
    public Result update(User user) {
        logger.info("修改【user】>>>" + user.toString());
        userRepository.save(user);
        return new Result(200, "OK", null);
    }

    @Override
    public Result deleteInBatch(List<User> userList) {
        userRepository.deleteAll(userList);
        logger.info("批量删除【userList】>>>" + userList);
        return new Result(200, "OK", null);
    }

    @Override
    public Result findOne(Integer id) {
        User user = userRepository.findUserById(id);
        return new Result(200, "OK", user);
    }

    @Override
    public Result pageQuery(Integer pageNum, Integer pageSize, String orderBy, User user) {
        Page<User> page = userRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
        return new Result(200, "OK", page);
    }
}
