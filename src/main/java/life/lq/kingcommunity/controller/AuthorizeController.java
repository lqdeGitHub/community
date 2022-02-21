package life.lq.kingcommunity.controller;

import life.lq.kingcommunity.dto.AccessTokenDTO;
import life.lq.kingcommunity.dto.GithubUser;
import life.lq.kingcommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code){
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id("bc3705d443e9ac5ff1a4");
        dto.setClient_secret("6d57c80617873a9001f3d7af16cc27893793cf06");
        dto.setCode(code);
        dto.setRedirect_uri("http://localhost:8887/callback");
        String accessToken = gitHubProvider.getAccessToken(dto);
        GithubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
