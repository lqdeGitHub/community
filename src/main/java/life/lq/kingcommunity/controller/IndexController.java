package life.lq.kingcommunity.controller;

import life.lq.kingcommunity.Service.QuestionService;
import life.lq.kingcommunity.dto.PaginationDTO;
import life.lq.kingcommunity.dto.QuestionDTO;
import life.lq.kingcommunity.mapper.QuestionMapper;
import life.lq.kingcommunity.mapper.UserMapper;
import life.lq.kingcommunity.model.Question;
import life.lq.kingcommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
