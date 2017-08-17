package com.hoperun.core.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Base Entity
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 删除标志 */
    private String delFlg;
    /** 创建者ID */
    private String crtId;
    /** 创建日时 */
    private Date crtTime;
    /** 更新者ID */
    private String updId;
    /** 更新日时 */
    private Date updTime;
    /** 版本号 */
    private Integer ver;

    /**
     * Get the delFlg.
     *
     * @return delFlg
     *
     * @author administator
     */
    public String getDelFlg() {
        return this.delFlg;
    }

    /**
     * Set the delFlg.
     *
     * @param delFlg delFlg
     *
     * @author administator
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * Get the crtId.
     *
     * @return crtId
     *
     * @author administator
     */
    public String getCrtId() {
        return this.crtId;
    }

    /**
     * Set the crtId.
     *
     * @param crtId crtId
     *
     * @author administator
     */
    public void setCrtId(String crtId) {
        this.crtId = crtId;
    }

    /**
     * Get the crtTime.
     *
     * @return crtTime
     *
     * @author administator
     */
    public Date getCrtTime() {
        return this.crtTime;
    }

    /**
     * Set the crtTime.
     *
     * @param crtTime crtTime
     *
     * @author administator
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * Get the updId.
     *
     * @return updId
     *
     * @author administator
     */
    public String getUpdId() {
        return this.updId;
    }

    /**
     * Set the updId.
     *
     * @param updId updId
     *
     * @author administator
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * Get the updTime.
     *
     * @return updTime
     *
     * @author administator
     */
    public Date getUpdTime() {
        return this.updTime;
    }

    /**
     * Set the updTime.
     *
     * @param updTime updTime
     *
     * @author administator
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    /**
     * Get the ver.
     *
     * @return ver
     *
     * @author administator
     */
    public Integer getVer() {
        return this.ver;
    }

    /**
     * Set the ver.
     *
     * @param ver ver
     *
     * @author administator
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
