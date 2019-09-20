package com.lusaisai.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

  public static void main(String[] args) throws Exception {
    //连接数据库
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://10.3.11.64:3306/pdzx?characterEncoding=utf8&useSSL=false&allowMultiQueries=true";
    String user="pdzx_pro";
    String password="cde35TGB3910";
    //建立连接
    Connection conn = DriverManager.getConnection(url, user, password);
    //sql语句
    String sql = "  SELECT t2.id AS sectionId , t2.proj_id AS projId , t2.section_name AS sectionName " +
      "FROM b_proj_base_info AS t1 JOIN b_proj_section_info AS t2 ON t1.id=t2.proj_id " +
      "WHERE t2.proj_id=? AND t2.section_name LIKE CONCAT('%',?,'%')";
    //获得预处理对象
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    //将SQL语句占位符位置设置实际参数
    preparedStatement.setString(1, "0124569b738e405fb20b68bfef37f487");    //为第一个问号赋值
    preparedStatement.setString(2, "标段");    //为第二个问号赋值
    //得到ResultSet结果集
    ResultSet resultSet = preparedStatement.executeQuery();
    //遍历结果集
    while (resultSet.next()) {
      int sectionId = resultSet.getInt("sectionId");
      String projId = resultSet.getString("projId");
      String sectionName = resultSet.getString("sectionName");
      System.out.println(sectionId+"----->"+projId+"----->"+sectionName);
    }
    //释放资源
    resultSet.close();
    preparedStatement.close();
    conn.close();
  }

}
