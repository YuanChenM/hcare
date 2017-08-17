package com.hoperun.versioning.service;

import com.hoperun.versioning.dao.AddSysEnvDao;
import com.hoperun.versioning.entity.SysEnvEntity;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class AddSysEnvService {

    public SysEnvEntity add(SysEnvEntity sysEnvEntity)
            throws SQLException {
        AddSysEnvDao addSysEnvDao = new AddSysEnvDao();
        return addSysEnvDao.insert(sysEnvEntity);
    }

    public SysEnvEntity find(Long sysEnvId)throws SQLException{
        AddSysEnvDao addSysEnvDao = new AddSysEnvDao();
        return addSysEnvDao.find(sysEnvId);
    }
}
