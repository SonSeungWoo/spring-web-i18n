package me.seungwoo;

import lombok.Data;

import java.util.List;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 12:21
 */
@Data
public class ErrorResponse {

    private List<ErrorDetails> errors;

    private ErrorDetails error;

    private String msg;

    @Data
    public static class ErrorDetails {
        private String fieldName;
        private String message;
    }
}
