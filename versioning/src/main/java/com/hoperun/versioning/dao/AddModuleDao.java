package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.ModuleEntity;
import com.hoperun.versioning.entity.SysEnvEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class AddModuleDao extends BaseDao {

    public ModuleEntity insert(ModuleEntity moduleEntity) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "insert into module(id,moduleId,sysEnvId,sysEnvName,moduleName,moduleShort,interfaceId,interfaceURL,delFlg,ver)VALUES(?,?,?,?,?,?,?,?,?,?)";
        Object params[] = {moduleEntity.getId(),moduleEntity.getModuleId(),moduleEntity.getSysEnvId(),moduleEntity.getSysEnvName(),moduleEntity.getModuleName(),moduleEntity.getModuleShort(),moduleEntity.getInterfaceId(),moduleEntity.getInterfaceURL(),0,1};
        return qr.insert(conn,sql,new BeanHandler<>(ModuleEntity.class),params);
    }
    public ModuleEntity find(Long moduleId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM module m INNER JOIN sys_env s ON m.sysEnvId = s.sysEnvId AND s.delFlg = 0 WHERE m.delFlg = 0 AND m.moduleId = ?";
        Object params[] = {moduleId};
        return qr.query(conn,sql,new BeanHandler<>(ModuleEntity.class),params);
    }
}
