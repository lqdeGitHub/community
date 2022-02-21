package life.lq.kingcommunity.provider;

import com.alibaba.fastjson.JSON;
import life.lq.kingcommunity.dto.AccessTokenDTO;
import life.lq.kingcommunity.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//（把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>）
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO dto){
       MediaType mediaType = MediaType.get("application/json; charset=utf-8");
//令牌：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
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(dto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String access_token = string.split("&")[0].split("=")[1];
            System.out.println(access_token);
            return access_token;
        }catch (IOException e){
            e.printStackTrace();
        }
        return "出错";
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+ accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }
}
