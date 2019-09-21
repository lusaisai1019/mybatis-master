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


import com.lusaisai.dao.DemoMapper;
import com.lusaisai.po.Dept;
import com.lusaisai.po.DeptInfo;
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
    //读取配置文件,生成读取流
    InputStream inputStream = Resources.getResourceAsStream(resource);
    //返回的DefaultSqlSessionFactory是SqlSessionFactory接口的实现类,
    //这个类只有一个属性,就是Configuration对象,Configuration对象用来存放读取xml配置的信息
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //SqlSession是与数据库打交道的对象 SqlSession对象中有上面传来的Configuration对象,
    //SqlSession对象还有executor处理器对象,executor处理器有一个dirty属性,默认为false
    //返回的DefaultSqlSession是SqlSession接口的实现类
    SqlSession sqlSession = sqlSessionFactory.openSession();
    String dName="test";
    //sqlSession执行添加操作
    Integer integer = sqlSession.insert("insertDept",dName);
    System.out.println(integer);
    //加入commit语句，手动执行提交事件，将数据提交到数据库中，才真正成功插入到数据库中,否则会回滚
    sqlSession.commit();
    sqlSession.close();


    //通过动态代理实现接口 ,用动态代理对象去帮我们执行SQL
    //这里生成mapper实际类型是org.apache.ibatis.binding.MapperProxy
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
    String projId="0124569b738e405fb20b68bfef37f487";
    String sectionName="标段";
    //Integer deptNum=10;
    //String dName="T";
    //List<ProjInfo> projInfos = mapper.selectAll(projId, sectionName);
    //这里用生成的动态代理对象执行
    //DeptInfo deptInfo = mapper.selectOne(deptNum, dName);
    //System.out.println(projInfos);

  }

}
