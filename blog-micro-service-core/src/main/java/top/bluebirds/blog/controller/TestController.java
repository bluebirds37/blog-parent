package top.bluebirds.blog.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping(value = "/testParams")
    public void goLogin( String  username,String password) throws IOException {


    }

}
