package com.lovers.common.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lovers.common.base.dto.AccessTokenDTO;
import com.lovers.common.base.dto.GithubUser;
import com.lovers.common.utils.HttpUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    private String users_url="https://github.com/login/oauth/access_token";
    private ObjectMapper json=new ObjectMapper();

    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws JsonProcessingException {

        String post = HttpUtils.post(users_url, json.writeValueAsString(accessTokenDTO));
        String[] split = post.split("&");
        String access_token = split[0].split("=")[1];
        return access_token;
    }

    public GithubUser getGithubUser(String access_token) throws IOException {
        String userJson = HttpUtils.get("https://api.github.com/user?access_token=" + access_token);
        GithubUser githubUser = json.readValue(userJson, GithubUser.class);
        return githubUser;
    }
}
