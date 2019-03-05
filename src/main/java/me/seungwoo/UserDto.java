package me.seungwoo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 12:04
 */
@Data
public class UserDto {

    @NotNull(message = "{not.null.msg}")
    private String userName;

    private String password;

    private String email;
}
