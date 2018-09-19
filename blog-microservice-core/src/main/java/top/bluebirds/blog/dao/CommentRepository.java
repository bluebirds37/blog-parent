package top.bluebirds.blog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bluebirds.blog.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment,Long> {

    Comment findCommentById(Integer id);

}
