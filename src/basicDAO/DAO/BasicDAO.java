package basicDAO.DAO;

import basicDAO.jdbcutil.JdbcUtilbyDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @auther 苏小牧
 */
public class BasicDAO<T> {
  //使用apache的方法QueryRunner操作数据库
  private QueryRunner qr = new QueryRunner();

  //只会返回影响行数的数据库操作
  public int update(String sql, Class<T> cl, Object... obj) {
    Connection connection = JdbcUtilbyDruid.getConnection();
    int update = 0;
    try {
       update = qr.update(connection, sql, obj);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      JdbcUtilbyDruid.closeConnection(null, null, connection);
    }
    return update;
  }

  //返回单行单列即一个元素的数据库操作
  public Object queryScalar(String sql,Class<T> cla, Object... obj){
    Connection connection = JdbcUtilbyDruid.getConnection();
    Object execute = null;
    try {
      execute = qr.query(connection, sql, new ScalarHandler<>(), obj);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
      JdbcUtilbyDruid.closeConnection(null,null,connection);
    }
    return execute;
  }

  //返回单行的数据库操作即一个对象
  public T querySingle(String sql, Class<T> cla, Object... obj){
    Connection connection = JdbcUtilbyDruid.getConnection();
    T query = null;
    try {
      query = qr.query(connection, sql, new BeanHandler<>(cla), obj);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
      JdbcUtilbyDruid.closeConnection(null,null,connection);
    }
    return query;
  }

  //返回多个对象的数据库操作结果，即多行
  public List<T> queryMulti(String sql,Class<T> cla, Object... obj){
    Connection connection = JdbcUtilbyDruid.getConnection();
    List<T> query = null;
    try {
      query = qr.query(connection, sql, new BeanListHandler<>(cla), obj);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally {
      JdbcUtilbyDruid.closeConnection(null,null,connection);
    }
    return query;
  }
}
