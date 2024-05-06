package com.warecase.filter;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.warecase.constant.HttpStatus;
import com.warecase.core.common.AjaxResult;
import com.warecase.util.permission.PermissionService;
import com.warecase.util.token.TokenService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenHandlerInterceptor implements HandlerInterceptor {

    /**
     * token header
     */
    @Value("${token.header}")
    private String header;

    @Resource
    private TokenService tokenService;

    @Resource
    private PermissionService permissionService;

    /**
     * 拦截请求，判断是否有token，如果没有token，则返回错误信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 允许跨域请求
        if(request.getMethod().equalsIgnoreCase("OPTIONS")){
            return true;
        }

        String token = request.getHeader(this.header);
        // 判断token是否为空
        if(token==null){
            this.responseError(response, HttpStatus.UNAUTHORIZED, "登录已过期，请重新登录！");
            return false;
        }
        // 验证token是否有效
        DecodedJWT verify = this.tokenService.verify(token);
        if(verify == null){
            this.responseError(response, HttpStatus.UNAUTHORIZED, "登录已过期，请重新登录！");
            return false;
        }
        // 判断是否有权限
        if(!this.permissionService.hasPermission(request.getRequestURI(),verify.getClaim("permission").asString())){
            this.responseError(response, HttpStatus.FORBIDDEN, "没有该操作权限，请联系管理员！");
            return false;
        }
        return true;
    }

    private void responseError(HttpServletResponse response, int code, String msg) throws Exception {
        AjaxResult ajax = new AjaxResult(code,msg);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(ajax));
        response.setStatus(code);
        response.flushBuffer();
    }
}
