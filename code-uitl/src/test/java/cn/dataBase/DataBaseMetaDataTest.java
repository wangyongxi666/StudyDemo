package cn.dataBase;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class DataBaseMetaDataTest {

    private Connection conn;
    private Connection conn2;

    @Before
    public void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Properties props =new Properties();
        //设置连接属性,使得可获取到表的REMARK(备注)
        props.put("remarksReporting","true");
        props.put("user", "root");
        props.put("password", "1234");
        conn = java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?useUnicode=true&amp;characterEncoding=UTF8", props);
        conn2 = java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ihrm?useUnicode=true&amp;characterEncoding=UTF8", props);
   }

    @Test
    public void testDatabaseMetaData() throws SQLException {
        //获取数据库元数据
        DatabaseMetaData dbMetaData =  conn.getMetaData();
        //获取数据库产品名称
        String productName = dbMetaData.getDatabaseProductName();
        System.out.println(productName);
        //获取数据库版本号
        String productVersion = dbMetaData.getDatabaseProductVersion();
        System.out.println(productVersion);
        //获取数据库用户名
        String userName = dbMetaData.getUserName();
        System.out.println(userName);
        //获取数据库连接URL
        String userUrl = dbMetaData.getURL();
        System.out.println(userUrl);
        //获取数据库驱动
        String driverName = dbMetaData.getDriverName();
        System.out.println(driverName);
        //获取数据库驱动版本号
        String driverVersion = dbMetaData.getDriverVersion();
        System.out.println(driverVersion);
        //查看数据库是否允许读操作
        boolean isReadOnly = dbMetaData.isReadOnly();
        System.out.println(isReadOnly);
        //查看数据库是否支持事务操作
        boolean supportsTransactions = dbMetaData.supportsTransactions();
        System.out.println(supportsTransactions);
   }

    @Test
    public void testFindAllCatalogs() throws Exception {
        //获取元数据
        DatabaseMetaData metaData = conn.getMetaData();
        //获取数据库列表
        ResultSet rs = metaData.getCatalogs();
        //遍历获取所有数据库表
        while(rs.next()){
            //打印数据库名称
            System.out.println(rs.getString(1));
        }
        //释放资源
        rs.close();
        conn.close();
    }

    @Test
    public void testFindAllTable() throws Exception{
        //获取元数据
        DatabaseMetaData metaData = conn2.getMetaData();
        ResultSet catalogs = metaData.getCatalogs();
        ResultSetMetaData metaDataTable = null;
        //获取所有的数据库表信息
        ResultSet tablers = metaData.getTables("ihrm", "", "bs_user", new String[]{"TABLE"});
        //拼装table
        while(tablers.next()) {
            //所属数据库
            System.out.println(tablers.getString(1));
            //所属schema
            System.out.println(tablers.getString(2));
            //表名
            System.out.println(tablers.getString(3));
            //数据库表类型
            System.out.println(tablers.getString(4));
            //数据库表备注
            System.out.println(tablers.getString(5));
        }
    }

    @Test
    public void test() throws Exception {
        String sql = "select * from bs_user where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "1063705482939731968");
        //获取ParameterMetaData对象
        ParameterMetaData paramMetaData = pstmt.getParameterMetaData();
        //获取参数个数
        int paramCount = paramMetaData.getParameterCount();
        System.out.println(paramCount);
    }

    @Test
    public void test2() throws Exception {
        String sql = "select * from bs_user where username=?";
        PreparedStatement pstmt = conn2.prepareStatement(sql);
        pstmt.setString(1, "test001");

        //执行sql语句
        ResultSet rs = pstmt.executeQuery();
        //获取ResultSetMetaData对象
        ResultSetMetaData metaData = rs.getMetaData();
        //获取查询字段数量
        int columnCount = metaData.getColumnCount() ;
        for (int i=1;i<=columnCount;i++) {
            //获取表名称
            String columnName = metaData.getColumnName(i);
            //获取java类型
            String columnClassName = metaData.getColumnClassName(i);
            //获取sql类型
            String columnTypeName = metaData.getColumnTypeName(i);
            System.out.println(columnName);
            System.out.println(columnClassName);
            System.out.println(columnTypeName);
        }
        System.out.println(columnCount);
    }



}
