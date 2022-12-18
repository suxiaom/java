package basicDAO.jdbcutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @auther 苏小牧
 */
public class JdbcUtilbyDruid {
  private static DataSource dataSource = null;
  static {
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("C:\\db\\demo\\classes\\druid.properties"));
      dataSource = DruidDataSourceFactory.createDataSource(properties);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  public static Connection getConnection(){
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void closeConnection(PreparedStatement preparedStatement, ResultSet resultSet,Connection connection){
    if (preparedStatement != null){
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    if (resultSet != null){
      try {
        resultSet.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    if (connection != null){
      try {
        connection.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
