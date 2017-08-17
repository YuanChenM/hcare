package com.hoperun.versioning.entity;


import com.hoperun.core.bean.BaseEntity;

/**
 * Base Entity
 */
public class UserEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;
    /** 账户名 */
    private String userAccount;
    /** 密码 */
    private String userPwd;
    /** 用户姓名 */
    private String userName;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>userAccount</tt>.
     *
     * @return property value of userAccount
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * Setter method for property <tt>userAccount</tt>.
     *
     * @param userAccount value to be assigned to property userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * Getter method for property <tt>userPwd</tt>.
     *
     * @return property value of userPwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * Setter method for property <tt>userPwd</tt>.
     *
     * @param userPwd value to be assigned to property userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
