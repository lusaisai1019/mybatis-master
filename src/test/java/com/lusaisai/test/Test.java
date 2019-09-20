package com.lusaisai.test;


import com.lusaisai.dao.DemoMapper;
import com.lusaisai.po.ProjInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class Test {

  public static void main(String[] args) throws Exception {
    String resource = "mybatis.xml";
    //读取配置文件,
    InputStream inputStream = Resources.getResourceAsStream(resource);
    // Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //从调用者角度来讲 与数据库打交道的对象 SqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //通过动态代理 去帮我们执行SQL
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    String projId="0124569b738e405fb20b68bfef37f487";
    String sectionName="标段";
    List<ProjInfo> projInfos = mapper.selectAll(projId, sectionName);
    System.out.println(projInfos);
    sqlSession.close();
  }

}
