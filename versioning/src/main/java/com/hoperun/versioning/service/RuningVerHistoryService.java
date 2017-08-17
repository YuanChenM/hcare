package com.hoperun.versioning.service;

import com.hoperun.core.bean.ModuleVersion;
import com.hoperun.core.bean.SysEnvModule;
import com.hoperun.versioning.dao.RuningVerHistoryDao;
import com.hoperun.versioning.dao.RuningVersionDao;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.hoperun.versioning.entity.SysEnvEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class RuningVerHistoryService {

    //根据系统环境ID获取历史运行版本
    public List<RuningVersionEntity> findRunVerHistory(Long sysEnvId)throws SQLException{
        RuningVerHistoryDao runingVerHistoryDao = new RuningVerHistoryDao();
        return runingVerHistoryDao.findRunVerHistory(sysEnvId);
    }
    //获取全部历史运行版本
    public List<RuningVersionEntity> findRunVerHistory()throws SQLException{
        RuningVerHistoryDao runingVerHistoryDao = new RuningVerHistoryDao();
        return runingVerHistoryDao.findRunVerHistory();
    }
    //获取该环境下的模块历史版本
    public List<ModuleVersionEntity> findHistoryModule(Long sysEnvId,Long versionId)throws SQLException{
        RuningVerHistoryDao runingVerHistoryDao = new RuningVerHistoryDao();
        return runingVerHistoryDao.findHistoryModule(sysEnvId,versionId);
    }

    //根据查询条件获取历史运行版本
    public List<RuningVersionEntity> searchRunVerHistory(String sysEnvName,String svnVersion,String isSteady,String isRuning)throws SQLException{
        RuningVerHistoryDao runingVerHistoryDao = new RuningVerHistoryDao();
        return runingVerHistoryDao.searchRunVerHistory(sysEnvName,svnVersion,isSteady,isRuning);
    }
}
