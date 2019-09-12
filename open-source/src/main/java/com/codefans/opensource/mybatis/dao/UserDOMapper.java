package com.codefans.opensource.mybatis.dao;

import com.codefans.opensource.mybatis.domain.UserDO;

public interface UserDOMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(UserDO record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(UserDO record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    UserDO selectByPrimaryKey(Long id);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(UserDO record);


    /**
     * 查询用户
     * @param id
     * @return
     */
    UserDO queryUser(Long id);

    /**
     * 减少金额
     * @param userDO
     * @return
     */
    int minusAmount(UserDO userDO);

    /**
     * 增加金额
     * @param userDO
     * @return
     */
    int addAmount(UserDO userDO);


}