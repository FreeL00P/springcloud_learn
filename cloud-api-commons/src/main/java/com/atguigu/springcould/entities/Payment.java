package com.atguigu.springcould.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Payment
 *
 * @author fj
 * @date 2022/11/15 20:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private long id;

    private String serial;
}
