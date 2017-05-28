package com.demo.www.test.service;

import java.sql.Connection;

import com.demo.www.test.entity.User;

import core.BaseService;
import core.ORM;

public class UserService extends BaseService {

  public int save( Connection con, User u) throws Exception {
    return this.dao.saveBean(con, u);
  }
  
  public int delete(Connection con, int userId) throws Exception {
    StringBuffer sql = new StringBuffer();
    ORM orm = new ORM( new User());
    sql.append( orm.getDeleteSQL()+" where id=? ");
    return this.dao.deleteBean(con, sql.toString(), new Object[]{ userId });
  }
  
  public User findUser( Connection con, int id ) throws Exception {
    StringBuffer sql = new StringBuffer();
    ORM orm = new ORM( new User());
    sql.append( orm.getSelectSQL() );
    sql.append(" where id=? ");
    return this.dao.queryBean(con, sql.toString(), User.class, new Object[]{id});
  }
}
