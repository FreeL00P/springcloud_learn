package com.atguigu.springcould.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CommonResult
 *
 * @author fj
 * @date 2022/11/15 20:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private Object data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
