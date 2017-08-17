package com.hoperun.versioning.service;

import com.hoperun.versioning.dao.SysEnvEditVerDao;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class SysEnvEditVerService {

    //根据版本ID获取模块版本信息
    public RuningVersionEntity findSysEnvVer(Long id) throws SQLException{
        SysEnvEditVerDao sysEnvEditVerDao = new SysEnvEditVerDao();
        return sysEnvEditVerDao.findSysEnvVer(id);
    }

    //保存编辑
    public int editSave(Long id,String isSteady) throws SQLException{
        SysEnvEditVerDao sysEnvEditVerDao = new SysEnvEditVerDao();
        return sysEnvEditVerDao.editSave(id, isSteady);
    }
}
