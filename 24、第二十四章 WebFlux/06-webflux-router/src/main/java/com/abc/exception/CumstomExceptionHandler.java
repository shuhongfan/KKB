package com.abc.exception;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * 自定义异常处理器：当异常发生时返回400，并返回异常信息。
 */
@Component
@Order(-99)
public class CumstomExceptionHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        // 获取到响应对象
        ServerHttpResponse response = exchange.getResponse();

//        设置响应码
        response.setStatusCode(HttpStatus.BAD_REQUEST);

//        指定响应类型为普通文本
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);

//        获取到异常信息
        String message = this.formatExceptionMassage(ex);

        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());

//        指定响应体为异常信息
        return response.writeWith(Mono.just(buffer));
    }

    /**
     * 格式化异常信息
     * @param ex
     * @return
     */
    private String formatExceptionMassage(Throwable ex) {
        String msg = "发生异常：" + ex.getMessage();
        if(ex instanceof StudentException) {
            StudentException e = (StudentException) ex;
            msg = msg + "【" + e.getField() + ":" + e.getValue() + "】";
        }
        return msg;
    }
}
