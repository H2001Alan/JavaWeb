package first.dao.impl;

import first.pojo.User;
import first.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.naming.event.ObjectChangeListener;
import java.io.ObjectStreamException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用dbUtils操作数据库
    private QueryRunner qr=new QueryRunner();

    //用来执行insert，update,delete语句
    public int update(String sql, Object...args){
        Connection conn=JdbcUtils.getConnections();
        try {
            return qr.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    //查询语句
    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection conn=JdbcUtils.getConnections();
        try {
            conn=JdbcUtils.getConnections();
            return qr.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
    public <T> List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection conn= null;
        try {
            conn = JdbcUtils.getConnections();
            return qr.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn=null;
        try {
            conn=JdbcUtils.getConnections();
            return qr.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}