package com.hoperun.versioning.service;

import com.hoperun.versioning.dao.LoginCheckDao;
import com.hoperun.versioning.entity.UserEntity;

import java.sql.SQLException;

/**
 * Created by yuan_chen1 on 2016/5/11.
 */
public class LoginCheckService {

    public UserEntity loginCheck(String account,String password)
            throws SQLException {
        LoginCheckDao loginDao = new LoginCheckDao();
        return loginDao.loginCheck(account, password);
    }
}
