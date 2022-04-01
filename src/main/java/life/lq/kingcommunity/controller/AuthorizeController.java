package life.lq.kingcommunity.controller;

import life.lq.kingcommunity.dto.AccessTokenDTO;
import life.lq.kingcommunity.dto.GithubUser;
import life.lq.kingcommunity.mapper.UserMapper;
import life.lq.kingcommunity.model.User;
import life.lq.kingcommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, HttpServletResponse response){
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id(clientId);
        dto.setClient_secret(secret);
        dto.setCode(code);
        dto.setRedirect_uri(redirectUri);
        String accessToken = gitHubProvider.getAccessToken(dto);
        GithubUser githubUser = gitHubProvider.getUser(accessToken);
        if(githubUser != null && githubUser.getId() != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            //登录成功 写cookie 和session
            response.addCookie(new Cookie("token",token));
            //request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else{
            //登录失败 重新登录
            return "redirect:/";
        }
    }
}
