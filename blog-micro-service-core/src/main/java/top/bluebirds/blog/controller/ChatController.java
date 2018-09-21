package top.bluebirds.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @GetMapping("/index")
    public void goIndexHtml(HttpServletResponse response) throws IOException {
        //response.sendRedirect("/index.html");
    }
}
