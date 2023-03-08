package com.zzk.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Web工具类
 *
 * @author zhaozikui
 * @since 2021-03-08 22:02
 */
public class WebUtils {
    /**
     * 将字符串渲染到页面
     *
     * @param response 响应
     * @param string   字符串
     * @return null
     */
    public static String renderstring(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

