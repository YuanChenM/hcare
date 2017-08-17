package com.hoperun.versioning.service;

import com.hoperun.core.bean.CommonEntity;
import com.hoperun.core.bean.ModuleVersion;
import com.hoperun.core.bean.SysEnvModule;
import com.hoperun.versioning.dao.RuningVersionDao;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.hoperun.versioning.entity.SysEnvEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class RuningVersionService {

    //获取当前运行的环境版本
    public List<RuningVersionEntity> findRunVer()throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.findRunVer();
    }
    //获取大版本运行环境是否存在
    public RuningVersionEntity findSysEnvByVersion(Long sysEnvId,String svnVersion) throws SQLException {
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.findOne(sysEnvId,svnVersion);
    }
    //更新环境
    public int updateSysEnv(Long sysEnvId)throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.modifySysEnv(sysEnvId);
    }
    //新增环境版本
    public RuningVersionEntity addSysEnv(RuningVersionEntity versionSysEnv)
            throws SQLException {
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.insert(versionSysEnv);
    }
    //设置不是这个小版本的模块不在运行
    public int updateModuleVer(Long sysEnvId)throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.modifyModuleVer(sysEnvId);
    }
    //获取历史记录
    public CommonEntity historyVerCount(Long sysEnvId)throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.historyVerCount(sysEnvId);
    }
    //新增模块版本
    public ModuleVersionEntity addModuleVersion(ModuleVersion moduleVersion) throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.addModuleVersion(moduleVersion);
    }
    //查询模块版本List信息
    public List<ModuleVersionEntity> findModule(Long sysEnvId) throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.findModule(sysEnvId);
    }
    //查询所有的接口路径
    public List<SysEnvModule> findInterFaceUrlList() throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.findInterFaceUrl();
    }
    //如果环境版本主表没数据时查询环境表
    public List<SysEnvEntity> findSysEnvList() throws SQLException{
        RuningVersionDao runingVersionDao = new RuningVersionDao();
        return runingVersionDao.findSysEnvList();
    }
}
