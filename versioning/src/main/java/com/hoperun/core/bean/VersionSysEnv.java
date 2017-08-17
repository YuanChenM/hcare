package com.hoperun.core.bean;

import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;

import java.util.List;

/**
 * VersionSysEnv.
 */
public class VersionSysEnv extends RuningVersionEntity{

    private static final long serialVersionUID = 1L;

    private int historyCount;

    private List<ModuleVersionEntity> moduleVersionList;

    /**
     * Getter method for property <tt>historyCount</tt>.
     *
     * @return property value of historyCount
     */
    public int getHistoryCount() {
        return historyCount;
    }

    /**
     * Setter method for property <tt>historyCount</tt>.
     *
     * @param historyCount value to be assigned to property historyCount
     */
    public void setHistoryCount(int historyCount) {
        this.historyCount = historyCount;
    }

    /**
     * Getter method for property <tt>moduleVersionList</tt>.
     *
     * @return property value of moduleVersionList
     */
    public List<ModuleVersionEntity> getModuleVersionList() {
        return moduleVersionList;
    }

    /**
     * Setter method for property <tt>moduleVersionList</tt>.
     *
     * @param moduleVersionList value to be assigned to property moduleVersionList
     */
    public void setModuleVersionList(List<ModuleVersionEntity> moduleVersionList) {
        this.moduleVersionList = moduleVersionList;
    }
}
