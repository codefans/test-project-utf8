/**
 * Copyright (C), 2015-2020, 京东
 * FileName: UserInfo
 * Author:   codefans
 * Date:     2020/6/8 11:00
 * Description: 用户信息
 */
package com.codefans.opensource.json.common;


import lombok.Data;

/**
 *
 * 用户信息
 *
 * @author codefans
 * @date 2020/06/08 11:00
 * @since 1.0.0
 */
@Data
public class UserInfo {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 地址
     */
    private Address address;

    /**
     * 姓名
     */
    private String name;

}