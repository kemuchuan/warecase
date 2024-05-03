package com.warecase.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * token工具类
 */
@Component
public class TokenService {

    @Value("${token.header}")
    private String header;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.expireTime}")
    private int expireTime;

    /**
     * 根据userId和permission生成token
     * @param userId 用户名
     * @param permission 用户权限
     * @return token
     */
    public String getToken(String userId,String permission){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE,expireTime);
        JWTCreator.Builder builder = JWT.create();
        return JWT.create()
                .withClaim("userId",userId)
                .withClaim("permission",permission)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token是否有效
     * @param token token
     * @return true or false
     */
    public DecodedJWT verify(String token){
        try{
            // 设置签名的加密算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            return verifier.verify(token);
        }catch (Exception e){
            return null;
        }

    }
}
