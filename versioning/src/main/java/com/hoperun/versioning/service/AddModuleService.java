package com.hoperun.versioning.service;

import com.hoperun.versioning.dao.AddModuleDao;
import com.hoperun.versioning.dao.AddSysEnvDao;
import com.hoperun.versioning.entity.ModuleEntity;
import com.hoperun.versioning.entity.SysEnvEntity;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class AddModuleService {

    public ModuleEntity add(ModuleEntity moduleEntity)
            throws SQLException {
        AddModuleDao addModuleDao = new AddModuleDao();
        return addModuleDao.insert(moduleEntity);
    }

    public ModuleEntity find(Long moduleId)throws SQLException{
        AddModuleDao addModuleDao = new AddModuleDao();
        return addModuleDao.find(moduleId);
    }
}
