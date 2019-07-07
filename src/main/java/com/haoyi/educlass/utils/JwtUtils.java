package com.haoyi.educlass.utils;

import com.haoyi.educlass.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {
    public static final String SUBJECT="haoyi";
    public static final long  EXPIRE=1000*60*60*24*7; //过期时间,毫秒,一周
    public static final String APPSECRET="haoyi666";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        if(user==null || user.getId()==null || user.getName()==null || user.getHeadImg()==null){
            return null;
        }
        String  token=Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getName())
                .claim("img",user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }

    public static Claims checkJWT(String token){
        try {
            final Claims claims=Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
