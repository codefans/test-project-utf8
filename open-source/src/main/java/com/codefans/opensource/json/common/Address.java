/**
 * Copyright (C), 2015-2020, 京东
 * FileName: Address
 * Author:   codefans
 * Date:     2020/6/8 11:00
 * Description: 地址
 */
package com.codefans.opensource.json.common;


import lombok.Data;

/**
 *
 * 地址
 *
 * @author codefans
 * @date 2020/06/08 11:00
 * @since 1.0.0
 */
@Data
public class Address {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postcode;

}