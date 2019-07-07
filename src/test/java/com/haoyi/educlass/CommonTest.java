package com.haoyi.educlass;

import com.haoyi.educlass.domain.User;
import com.haoyi.educlass.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

public class CommonTest {
    @Test
    public void testGeneJwt(){
        User user=new User();
        user.setId(999);
        user.setHeadImg("www.haoyi.com");
        user.setName("haoyi");

        String token= JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    public void testCheck(){
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoYW95aSIsImlkIjo5OTksIm5hbWUiOiJoYW95aSIsImltZyI6Ind3dy5oYW95aS5jb20iLCJpYXQiOjE1NjE1MTY5MDUsImV4cCI6MTU2MjEyMTcwNX0.td7tZ_oHGJ5dxN4yK5mz4LMdrJ6GXlx6KKTFdhBqMgw";
        Claims claims=JwtUtils.checkJWT(token);
        if(claims!=null){
            String name=(String)claims.get("name");
            String img=(String)claims.get("img");
            int id=(Integer) claims.get("id");

            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        }else {
            System.out.println("非法token");
        }
    }
}
