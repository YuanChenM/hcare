package com.hoperun.versioning.entity;


import com.hoperun.core.bean.BaseEntity;

import java.util.Date;

/**
 * 各模块运行版本Entity
 */
public class ModuleVersionEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;
    /** 运行版本ID */
    private Long versionId;
    /** 系统环境ID */
    private Long sysEnvId;
    /** 模块ID */
    private Long moduleId;
    /** 模块名称 */
    private String moduleName;
    /** 模块英文简称 */
    private String moduleShort;
    /** 模块大版本*/
    private String svnVersion;
    /** 模块小版本 */
    private String svnSubVersion;
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
     * Getter method for property <tt>versionId</tt>.
     *
     * @return property value of versionId
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * Setter method for property <tt>versionId</tt>.
     *
     * @param versionId value to be assigned to property versionId
     */
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
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
     * Getter method for property <tt>moduleId</tt>.
     *
     * @return property value of moduleId
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * Setter method for property <tt>moduleId</tt>.
     *
     * @param moduleId value to be assigned to property moduleId
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * Getter method for property <tt>moduleName</tt>.
     *
     * @return property value of moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Setter method for property <tt>moduleName</tt>.
     *
     * @param moduleName value to be assigned to property moduleName
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * Getter method for property <tt>moduleShort</tt>.
     *
     * @return property value of moduleShort
     */
    public String getModuleShort() {
        return moduleShort;
    }

    /**
     * Setter method for property <tt>moduleShort</tt>.
     *
     * @param moduleShort value to be assigned to property moduleShort
     */
    public void setModuleShort(String moduleShort) {
        this.moduleShort = moduleShort;
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

    /**
     * Getter method for property <tt>svnSubVersion</tt>.
     *
     * @return property value of svnSubVersion
     */
    public String getSvnSubVersion() {
        return svnSubVersion;
    }

    /**
     * Setter method for property <tt>svnSubVersion</tt>.
     *
     * @param svnSubVersion value to be assigned to property svnSubVersion
     */
    public void setSvnSubVersion(String svnSubVersion) {
        this.svnSubVersion = svnSubVersion;
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
}
