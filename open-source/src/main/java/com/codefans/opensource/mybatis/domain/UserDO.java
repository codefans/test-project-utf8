package com.codefans.opensource.mybatis.domain;

public class UserDO {
    /**
     * 主键ID
     * 对应字段 : id
     */
    private Long id;

    /**
     * 用户名
     * 对应字段 : username
     */
    private String username;

    /**
     * 密码
     * 对应字段 : password
     */
    private String password;

    /**
     * 账户余额(单位分)
     * 对应字段 : amount
     */
    private Long amount;

    /**
     * get method 
     *
     * @return user.id：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * set method 
     *
     * @param id  主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get method 
     *
     * @return user.username：用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * set method 
     *
     * @param username  用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * get method 
     *
     * @return user.password：密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * set method 
     *
     * @param password  密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * get method 
     *
     * @return user.amount：账户余额(单位分)
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * set method 
     *
     * @param amount  账户余额(单位分)
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }
}