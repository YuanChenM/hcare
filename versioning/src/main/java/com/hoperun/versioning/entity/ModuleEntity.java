package com.hoperun.versioning.entity;


import com.hoperun.core.bean.BaseEntity;

/**
 * 模块信息Entity
 */
public class ModuleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    /** 模块ID */
    private Long moduleId;
    /** 所在系统环境ID */
    private Long sysEnvId;
    /** 所在系统环境名称 */
    private String sysEnvName;
    /** 模块名称 */
    private String moduleName;
    /** 模块英文简称 */
    private String moduleShort;
    /** 接口ID */
    private String interfaceId;
    /** 接口访问路径 */
    private String interfaceURL;

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
     * Getter method for property <tt>interfaceId</tt>.
     *
     * @return property value of interfaceId
     */
    public String getInterfaceId() {
        return interfaceId;
    }

    /**
     * Setter method for property <tt>interfaceId</tt>.
     *
     * @param interfaceId value to be assigned to property interfaceId
     */
    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    /**
     * Getter method for property <tt>interfaceURL</tt>.
     *
     * @return property value of interfaceURL
     */
    public String getInterfaceURL() {
        return interfaceURL;
    }

    /**
     * Setter method for property <tt>interfaceURL</tt>.
     *
     * @param interfaceURL value to be assigned to property interfaceURL
     */
    public void setInterfaceURL(String interfaceURL) {
        this.interfaceURL = interfaceURL;
    }
}
