package com.hoperun.versioning.dao;

import com.hoperun.core.bean.*;
import com.hoperun.versioning.entity.ModuleVersionEntity;
import com.hoperun.versioning.entity.RuningVersionEntity;
import com.hoperun.versioning.entity.SysEnvEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class RuningVersionDao extends BaseDao {

    //获取当前运行的环境版本
    public List<RuningVersionEntity> findRunVer() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where delFlg = 0 and isRuning = 1";
        return qr.query(conn,sql,new BeanListHandler<>(RuningVersionEntity.class));
    }
    //判断大版本是否存在
    public RuningVersionEntity findOne(Long sysEnvId,String svnVersion) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "select * from runing_version where delFlg = 0 and isRuning = 1 and sysEnvId = ? and svnVersion = ?";
        Object params[] = {sysEnvId,svnVersion};
        return qr.query(conn,sql,new BeanHandler<>(VersionSysEnv.class),params);
    }
    //设置环境版本不在运行
    public int modifySysEnv(Long sysEnvId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "UPDATE runing_version set isRuning = 0 where delFlg = 0 and sysEnvId = ? and isRuning = 1";
        Object params[] = {sysEnvId};
        return qr.update(conn,sql,params);
    }
    //获取历史记录
    public CommonEntity historyVerCount(Long sysEnvId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select count(*) as historyCount from runing_version where delFlg = 0 and sysEnvId = ? and isRuning = 0";
        Object params[] = {sysEnvId};
        return qr.query(conn,sql,new BeanHandler<>(CommonEntity.class),params);
    }
    //新增环境版本
    public RuningVersionEntity insert(RuningVersionEntity versionSysEnv) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into runing_version(id,sysEnvId,sysEnvName,projectVersion,svnVersion,isSteady,isRuning,publishTime,publisher,delFlg,ver) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object params[] = {versionSysEnv.getId(),versionSysEnv.getSysEnvId(),versionSysEnv.getSysEnvName(),versionSysEnv.getProjectVersion(),versionSysEnv.getSvnVersion(),versionSysEnv.getIsSteady(),versionSysEnv.getIsRuning(),versionSysEnv.getPublishTime(),versionSysEnv.getPublisher(),0,1};
        return qr.insert(conn,sql,new BeanHandler<>(RuningVersionEntity.class),params);
    }
    //设置不是这个小版本的模块不在运行
    public int modifyModuleVer(Long sysEnvId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "update module_version set isRuning = 0 where delFlg = 0 and sysEnvId = ? and isRuning = 1";
        Object params[] = {sysEnvId};
        return qr.update(conn,sql,params);
    }
    //新增模块版本
    public ModuleVersionEntity addModuleVersion(ModuleVersion moduleVersion) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "insert into module_version(id,versionId,sysEnvId,moduleId,moduleName,moduleShort,svnVersion,svnSubVersion,isRuning,publishTime,publisher,delFlg,ver)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object params[] = {moduleVersion.getId(),moduleVersion.getVersionId(),moduleVersion.getSysEnvId(),moduleVersion.getModuleId(),moduleVersion.getModuleName(),moduleVersion.getModuleShort(),moduleVersion.getSvnVersion(),moduleVersion.getSvnSubVersion(),moduleVersion.getIsRuning(),moduleVersion.getPublishTime(),moduleVersion.getPublisher(),0,1};
        return qr.insert(conn,sql,new BeanHandler<>(ModuleVersionEntity.class),params);
    }
    //获取对应环境版本下的各模块的版本
    public List<ModuleVersionEntity> findModule(Long sysEnvId)throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select * from module_version where delFlg = 0 and sysEnvId = ? and isRuning = 1";
        Object params[] = {sysEnvId};
        return qr.query(conn,sql,new BeanListHandler<>(ModuleVersionEntity.class),params);
    }
    //查询所有的接口路径
    public List<SysEnvModule> findInterFaceUrl() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "select sys.sysEnvId,sys.sysEnvName,sysEnvIpAddr,sysEnvURL,moduleId,moduleName,moduleShort,interfaceId,interfaceURL from sys_env sys LEFT JOIN module mo ON sys.sysEnvId = mo.sysEnvId and sys.delFlg = 0 and mo.delFlg = 0";
        return qr.query(conn,sql,new BeanListHandler<>(SysEnvModule.class));
    }
    //如果环境版本主表没数据时查询环境表
    public List<SysEnvEntity> findSysEnvList() throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sys_env where delFlg = 0";
        return qr.query(conn,sql,new BeanListHandler<>(SysEnvEntity.class));
    }
}
