package cool.lytton.doc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import cool.lytton.doc.exception.exceptions.TokenException;

import java.util.Date;

public class JwtUtil {
    private static final long EXPIRE_TIME = 24 * 3600 * 1000;
    private static final String SECRET_KEY = "huili_cool";

    //  生成签名token
    public String sign(String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create().withAudience(username).withExpiresAt(date).sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }
    //  验证token
    public static boolean checkToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            System.out.printf(decodedJWT.toString());
            return true;
        } catch (JWTVerificationException e) {
//            throw new RuntimeException("无效的token");
            throw new TokenException("这是无效的token");
        }
    }

    // 解析获取用户名
    public static String getUsername(String token) {
        try {
            String username = JWT.decode(token).getAudience().get(0);
            return username;
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
