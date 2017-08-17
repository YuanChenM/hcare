package com.hoperun.versioning.service;

import com.hoperun.versioning.dao.AddSysEnvDao;
import com.hoperun.versioning.dao.FindSysEnvDao;
import com.hoperun.versioning.entity.SysEnvEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class FindSysEnvService {

    public List<SysEnvEntity> find()throws SQLException{
        FindSysEnvDao findSysEnvDao = new FindSysEnvDao();
        return findSysEnvDao.find();
    }
}
