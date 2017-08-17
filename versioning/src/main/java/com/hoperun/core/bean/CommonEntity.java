package com.hoperun.core.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Base Entity
 */
public class CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private int historyCount;

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
}
