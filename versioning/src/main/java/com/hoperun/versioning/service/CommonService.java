package com.hoperun.versioning.service;

import com.hoperun.core.bean.CommonEntity;
import com.hoperun.versioning.dao.CommonDao;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class CommonService extends BaseService{

    public CommonEntity findMaxId(String tableName,String tableField)
            throws SQLException {
        CommonDao commonDao = new CommonDao();
        return commonDao.findMaxId(tableName,tableField);
    }
}
