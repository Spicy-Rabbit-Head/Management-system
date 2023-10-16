package com.zzk.entity.response;

import lombok.Getter;
import org.springframework.util.Assert;

/**
 * 统一响应实体类<br>
 * <p>
 * <p>
 * 1.0版本：2023-03-06 16:00<br>
 * 使用泛型实现响应数据的类型转换 , 以及响应数据的封装<br>
 * <p>
 * 1.1版本：2023-10-12 11:40<br>
 * 增加了建造者模式<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.1
 * @apiNote 该类用于统一响应实体类
 * @since 2023-03-06 16:00
 */
@Getter
public class Response<T> {
    // 响应码
    private final Integer code;
    // 响应消息
    private final String message;
    // 响应状态
    private final Boolean status;
    // 响应数据
    private final T data;

    // 响应数据构造
    private Response(Integer code, String message, Boolean status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }


    /**
     * 成功响应 (无响应数据)
     *
     * @param code    响应码
     * @param message 响应消息
     *
     * @return Response 响应实体
     *
     * @apiNote 该方法用于响应成功但无响应数据的情况
     * @since 1.0
     */
    public static Response<Void> success(Integer code, String message) {
        return new Response<>(code, message, true, null);
    }

    /**
     * 成功响应 (有响应数据)
     *
     * @param code    响应码
     * @param message 响应消息
     * @param data    响应数据
     *
     * @return Response 响应实体
     *
     * @apiNote 该方法用于响应成功且有响应数据的情况
     * @since 1.0
     */
    public static <T> Response<T> success(Integer code, String message, T data) {
        return new Response<>(code, message, true, data);
    }

    /**
     * 失败响应 (无响应数据)
     *
     * @param code    响应码
     * @param message 响应消息
     *
     * @return Response 响应实体
     *
     * @apiNote 该方法用于响应失败但无响应数据的情况
     * @since 1.0
     */
    public static Response<Void> failed(Integer code, String message) {
        return new Response<>(code, message, false, null);
    }

    /**
     * 失败响应 (有响应数据)
     *
     * @param code    响应码
     * @param message 响应消息
     * @param data    响应数据
     *
     * @return Response 响应实体
     *
     * @apiNote 该方法用于响应失败且有响应数据的情况
     * @since 1.0
     */
    public static <T> Response<T> failed(Integer code, String message, T data) {
        return new Response<>(code, message, false, data);
    }


    /**
     * 响应建造者构建
     *
     * @param <T> 响应数据类型
     *
     * @return ResponseBuilder 响应建造者
     *
     * @apiNote 该方法用于响应建造者构建
     * @since 1.1
     */
    public static <T> ResponseBuilder<T> builder() {
        return new ResponseBuilder<>();
    }

    /**
     * 响应建造者<br>
     * <p>
     * <p>
     * 1.0版本：响应建造者构建<br>
     * <p>
     *
     * @author zhao'zi'kui
     * @version 1.0
     * @apiNote 该类用于响应建造者构建
     * @since 1.1
     */
    public static final class ResponseBuilder<T> {
        // 响应码
        private Integer code;
        // 响应消息
        private String message;
        // 响应状态
        private Boolean status;
        // 响应数据
        private T data;

        // 私有化构造器
        private ResponseBuilder() {
        }

        /**
         * 构建响应码
         *
         * @param code 响应码
         *
         * @return ResponseBuilder 响应建造者
         *
         * @apiNote 该方法用于响应建造者构建响应码
         * @since 1.0
         */
        public ResponseBuilder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        /**
         * 构建响应消息
         *
         * @param message 响应消息
         *
         * @return ResponseBuilder 响应建造者
         *
         * @apiNote 该方法用于响应建造者构建响应消息
         * @since 1.0
         */
        public ResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        /**
         * 构建成功响应状态
         *
         * @return ResponseBuilder 响应建造者
         *
         * @apiNote 该方法用于响应建造者构建成功响应状态
         * @since 1.0
         */
        public ResponseBuilder<T> success() {
            this.status = true;
            return this;
        }

        /**
         * 构建失败响应状态
         *
         * @return ResponseBuilder 响应建造者
         *
         * @apiNote 该方法用于响应建造者构建失败响应状态
         * @since 1.0
         */
        public ResponseBuilder<T> failed() {
            this.status = false;
            return this;
        }

        /**
         * 构建响应数据
         *
         * @param data 响应数据
         *
         * @return ResponseBuilder 响应建造者
         *
         * @apiNote 该方法用于响应建造者构建响应数据
         * @since 1.0
         */
        public ResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        /**
         * 构建响应实体<br>
         * 并判断响应码、响应消息、响应状态是否为空
         *
         * @return Response 响应实体
         *
         * @throws NullPointerException 响应码、响应消息、响应状态不能为空
         * @apiNote 该方法用于响应建造者构建响应实体
         * @since 1.0
         */
        public Response<T> build() {
            Assert.notNull(this.code, "响应码不能为空");
            Assert.notNull(this.message, "响应消息不能为空");
            Assert.notNull(this.status, "响应状态不能为空");
            return new Response<>(this.code, this.message, this.status, this.data);
        }
    }

}
