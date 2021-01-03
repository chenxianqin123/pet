package pri.cxq.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 数据库操作工具类
 *
 * @autor 陈咸钦
 */
public class DBUtils {
    /**
     * 获取数据库连接
     *
     * @return connection 数据库连接对象
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection connection = null;//需要获取的连接
        /**读取配置文件*/
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        properties.load(in);
        /**配置数据库连接池*/
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        connection = dataSource.getConnection();
        return connection;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn  连接对象
     * @param state 执行对象
     * @param rs    结果集对象
     */
    public static void close(Connection conn, Statement state, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (state != null) {
            try {
                state.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询单个信息
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T check(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T bean = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
//        执行sql语句，将结果保存在结果集中
            rs = ps.executeQuery();
//        获取结果集元数据
            ResultSetMetaData rsmd = ps.getMetaData();
//        获取结果集的列数
            int colnum = rsmd.getColumnCount();
            while (rs.next()) {
//          key存放列名,value存放值.一个循环下来,rowmap就存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查询出来列值的类型,如果是java.sql.Date就转成java.util.date
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                bean = clazz.newInstance();
//           取出Map集合中一条记录的信息并封装成对象
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String columnName = entry.getKey();
                    Object columnValue = entry.getValue();
                    BeanUtils.setProperty(bean, columnName, columnValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return bean;
    }

    /**
     * 查询多个信息
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> userList = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
//        执行sql语句，将结果保存在结果集中
            rs = ps.executeQuery();
//        用于存放结果集元素的集合
            userList = new ArrayList<T>();
//        获取结果集元数据
            ResultSetMetaData rsmd = ps.getMetaData();
//        获取结果集的列数
            int colnum = rsmd.getColumnCount();
            while (rs.next()) {
//          key存放列名,value存放值.一个循环下来,rowmap就存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查询出来列值的类型,如果是java.sql.Date就转成java.util.date
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) columnValue;
                        columnValue = new Date(date.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                T bean = clazz.newInstance();
//           取出Map集合中一条记录的信息并封装成对象
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String columnName = entry.getKey();
                    Object columnValue = entry.getValue();
                    BeanUtils.setProperty(bean, columnName, columnValue);
                }
                userList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return userList;
    }

    /**
     * 增删改信息
     *
     * @param sql
     * @param args
     * @return
     */
    public static boolean update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) args[i];
                        args[i] = new Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
//          executeUpdate返回更新的记录数
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return count != null && count > 0 ? true : false;
    }

    /**
     * 增删改信息并获得主键值
     *
     * @param sql
     * @param args
     * @return
     */
    public static Integer updateForPrimary(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer pk = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof java.sql.Date) {
                        java.sql.Date date = (java.sql.Date) args[i];
                        args[i] = new Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
//            执行更新操作
            ps.executeUpdate();
//            生成主键
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                pk = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return pk;
    }

    /**
     * 查询记录条数
     *
     * @param sql
     * @param args
     * @return
     */
    public static Integer checkCount(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
//        执行sql语句，将结果保存在结果集中
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return count;
    }
}
