package com.hoperun.versioning.entity;


import com.hoperun.core.bean.BaseEntity;

/**
 * 系统环境Entity
 */
public class SysEnvEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 系统环境ID */
    private Long sysEnvId;
    /** 系统环境名称 */
    private String sysEnvName;
    /** 系统环境访问IP */
    private String sysEnvIpAddr;
    /** 系统环境war包存放路径 */
    private String sysEnvURL;

    /**
     * Getter method for property <tt>sysEnvId</tt>.
     *
     * @return property value of sysEnvId
     */
    public Long getSysEnvId() {
        return sysEnvId;
    }

    /**
     * Setter method for property <tt>sysEnvId</tt>.
     *
     * @param sysEnvId value to be assigned to property sysEnvId
     */
    public void setSysEnvId(Long sysEnvId) {
        this.sysEnvId = sysEnvId;
    }

    /**
     * Getter method for property <tt>sysEnvName</tt>.
     *
     * @return property value of sysEnvName
     */
    public String getSysEnvName() {
        return sysEnvName;
    }

    /**
     * Setter method for property <tt>sysEnvName</tt>.
     *
     * @param sysEnvName value to be assigned to property sysEnvName
     */
    public void setSysEnvName(String sysEnvName) {
        this.sysEnvName = sysEnvName;
    }

    /**
     * Getter method for property <tt>sysEnvIpAddr</tt>.
     *
     * @return property value of sysEnvIpAddr
     */
    public String getSysEnvIpAddr() {
        return sysEnvIpAddr;
    }

    /**
     * Setter method for property <tt>sysEnvIpAddr</tt>.
     *
     * @param sysEnvIpAddr value to be assigned to property sysEnvIpAddr
     */
    public void setSysEnvIpAddr(String sysEnvIpAddr) {
        this.sysEnvIpAddr = sysEnvIpAddr;
    }

    /**
     * Getter method for property <tt>sysEnvURL</tt>.
     *
     * @return property value of sysEnvURL
     */
    public String getSysEnvURL() {
        return sysEnvURL;
    }

    /**
     * Setter method for property <tt>sysEnvURL</tt>.
     *
     * @param sysEnvURL value to be assigned to property sysEnvURL
     */
    public void setSysEnvURL(String sysEnvURL) {
        this.sysEnvURL = sysEnvURL;
    }
}
