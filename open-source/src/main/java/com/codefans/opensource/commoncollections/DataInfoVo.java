/**
 * Copyright (C), 2015-2021, 京东
 * FileName: DataInfoVo
 * Author:   caishengzhi
 * Date:     2021/8/24 16:22
 * Description:
 */
package com.codefans.opensource.commoncollections;


import lombok.Data;

/**
 *
 *
 *
 * @author: codefans
 * @Date: 2021/08/24 16:22
 * @since: 1.0.0
 */
@Data
public class DataInfoVo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否是新数据
     */
    private boolean isNew;
}