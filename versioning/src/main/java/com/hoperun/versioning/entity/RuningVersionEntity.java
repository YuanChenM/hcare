package com.hoperun.versioning.entity;


import com.hoperun.core.bean.BaseEntity;

import java.util.Date;

/**
 * 环境运行版本Entity
 */
public class RuningVersionEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 运行版本ID */
    private Long id;
    /** 系统环境ID */
    private Long sysEnvId;
    /** 系统环境名称 */
    private String sysEnvName;
    /** 工程版本*/
    private String projectVersion;
    /** SVN版本*/
    private String svnVersion;
    /** 是否稳定版本 */
    private String isSteady;
    /** 是否运行版本 */
    private String isRuning;
    /** 版本发布时间 */
    private Date publishTime;
    /** 版本发布者 */
    private String publisher;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Getter method for property <tt>isSteady</tt>.
     *
     * @return property value of isSteady
     */
    public String getIsSteady() {
        return isSteady;
    }

    /**
     * Setter method for property <tt>isSteady</tt>.
     *
     * @param isSteady value to be assigned to property isSteady
     */
    public void setIsSteady(String isSteady) {
        this.isSteady = isSteady;
    }

    /**
     * Getter method for property <tt>isRuning</tt>.
     *
     * @return property value of isRuning
     */
    public String getIsRuning() {
        return isRuning;
    }

    /**
     * Setter method for property <tt>isRuning</tt>.
     *
     * @param isRuning value to be assigned to property isRuning
     */
    public void setIsRuning(String isRuning) {
        this.isRuning = isRuning;
    }

    /**
     * Getter method for property <tt>publishTime</tt>.
     *
     * @return property value of publishTime
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * Setter method for property <tt>publishTime</tt>.
     *
     * @param publishTime value to be assigned to property publishTime
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * Getter method for property <tt>publisher</tt>.
     *
     * @return property value of publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Setter method for property <tt>publisher</tt>.
     *
     * @param publisher value to be assigned to property publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Getter method for property <tt>projectVersion</tt>.
     *
     * @return property value of projectVersion
     */
    public String getProjectVersion() {
        return projectVersion;
    }

    /**
     * Setter method for property <tt>projectVersion</tt>.
     *
     * @param projectVersion value to be assigned to property projectVersion
     */
    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    /**
     * Getter method for property <tt>svnVersion</tt>.
     *
     * @return property value of svnVersion
     */
    public String getSvnVersion() {
        return svnVersion;
    }

    /**
     * Setter method for property <tt>svnVersion</tt>.
     *
     * @param svnVersion value to be assigned to property svnVersion
     */
    public void setSvnVersion(String svnVersion) {
        this.svnVersion = svnVersion;
    }
}
