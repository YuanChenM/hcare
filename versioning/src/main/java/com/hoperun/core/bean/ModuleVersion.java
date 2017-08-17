package com.hoperun.core.bean;

import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;

import java.util.List;

/**
 * VersionSysEnv.
 */
public class ModuleVersion extends ModuleVersionEntity{

    private static final long serialVersionUID = 1L;

    private String buildTime;
    /** 系统环境名称 */
    private String sysEnvName;

    private String projectVersion;
    /**
     * Getter method for property <tt>buildTime</tt>.
     *
     * @return property value of buildTime
     */
    public String getBuildTime() {
        return buildTime;
    }

    /**
     * Setter method for property <tt>buildTime</tt>.
     *
     * @param buildTime value to be assigned to property buildTime
     */
    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
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
}
