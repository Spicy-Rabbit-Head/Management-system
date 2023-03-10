package com.zzk.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Web工具类
 * <p>
 * <p>
 * 1.0版本：实现将字符串渲染到页面的方法<br>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-08 22:02
 */
public class WebUtils {
    /**
     * 将字符串渲染到页面
     *
     * @param response 响应
     * @param string   字符串
     * @return null
     * @since 1.0
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

