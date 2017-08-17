package com.hoperun.versioning.dao;

import com.hoperun.core.bean.BaseDao;
import com.hoperun.versioning.entity.SysEnvEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class AddSysEnvDao extends BaseDao {

    public SysEnvEntity insert(SysEnvEntity sysEnvEntity) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "insert into sys_env(sysEnvId,sysEnvName,sysEnvIpAddr,sysEnvURL,delFlg,ver)values(?,?,?,?,?,?)";
        Object params[] = {sysEnvEntity.getSysEnvId(),sysEnvEntity.getSysEnvName(),sysEnvEntity.getSysEnvIpAddr(),sysEnvEntity.getSysEnvURL(),0,1};
        return qr.insert(conn,sql,new BeanHandler<>(SysEnvEntity.class),params);
    }
    public SysEnvEntity find(Long sysEnvId) throws SQLException{
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM sys_env WHERE delFlg = 0 AND sysEnvId = ?";
        Object params[] = {sysEnvId};
        return qr.query(conn,sql,new BeanHandler<>(SysEnvEntity.class),params);
    }
}
