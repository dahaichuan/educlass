package com.haoyi.educlass.provider;

import com.haoyi.educlass.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UsreProvider {
    public String updateUser(final User user){
        return new SQL() {{
            UPDATE("user");
            if(user.getName()!=null){
                SET("username=#{username}");
            }
            if(user.getHeadImg()!=null){
                SET("userHeadImag=#{userHeadImag}");
            }

        }}.toString();
    }
}
