/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.lusaisai.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

  public static void main(String[] args) throws Exception {
    //连接数据库
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost/kaikeba?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    String user="root";
    String password="root";
    //建立连接
    Connection conn = DriverManager.getConnection(url, user, password);
    //sql语句
    String sql="INSERT INTO dept(DNAME)VALUES (?)";
    //获得预处理对象
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    //将SQL语句占位符位置设置实际参数
    preparedStatement.setString(1, "T"); //为问号赋值
    //增删改都使用executeUpdate()提交,返回值是int，表示有多少条数据受到了影响
    int i = preparedStatement.executeUpdate();
    System.out.println(i);
    //释放资源
    preparedStatement.close();
    conn.close();

    //preparedStatement.setInt(1, 10);    //为第一个问号赋值
    //preparedStatement.setString(1, "T");    //为第二个问号赋值
    /*String sql = "  SELECT t2.id AS sectionId , t2.proj_id AS projId , t2.section_name AS sectionName " +
      "FROM b_proj_base_info AS t1 JOIN b_proj_section_info AS t2 ON t1.id=t2.proj_id " +
      "WHERE t2.proj_id=? AND t2.section_name LIKE CONCAT('%',?,'%')";*/
    //String sql="SELECT * FROM dept WHERE DEPTNO=? AND DNAME LIKE CONCAT('%',?,'%')";
    //得到ResultSet结果集
    /*ResultSet resultSet = preparedStatement.executeQuery();
    //遍历结果集
    while (resultSet.next()) {
      int DEPTNO = resultSet.getInt("DEPTNO");
      String DNAME = resultSet.getString("DNAME");
      String LOC = resultSet.getString("LOC");

      System.out.println(DEPTNO+"----->"+DNAME+"----->"+LOC);
    }

    resultSet.close();*/

  }

}
