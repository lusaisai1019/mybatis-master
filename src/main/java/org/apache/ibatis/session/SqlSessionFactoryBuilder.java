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
package org.apache.ibatis.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * Builds {@link SqlSession} instances.
 *
 * @author Clinton Begin
 */
public class SqlSessionFactoryBuilder {

  //Reader读取mybatis配置文件，传入构造方法
  //除了Reader外，其实还有对应的inputStream作为参数的构造方法，
   //这也体现了mybatis配置的灵活性
  public SqlSessionFactory build(Reader reader) {
    return build(reader, null, null);
  }

  public SqlSessionFactory build(Reader reader, String environment) {
    return build(reader, environment, null);
  }

  //mybatis配置文件 + properties, 此时mybatis配置文件中可以不配置properties，也能使用${}形式
  public SqlSessionFactory build(Reader reader, Properties properties) {
    return build(reader, null, properties);
  }

  //通过XMLConfigBuilder解析mybatis配置，然后创建SqlSessionFactory对象
  public SqlSessionFactory build(Reader reader, String environment, Properties properties) {
    try {
      XMLConfigBuilder parser = new XMLConfigBuilder(reader, environment, properties);
      //下面看看这个方法的源码
      return build(parser.parse());
    } catch (Exception e) {
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {
      ErrorContext.instance().reset();
      try {
        reader.close();
      } catch (IOException e) {
        // Intentionally ignore. Prefer previous error.
      }
    }
  }

  //这个方法啥都没有,我们继续点进去
  public SqlSessionFactory build(InputStream inputStream) {
    //这是一个重载方法,environment和Properties均传入空
    return build(inputStream, null, null);
  }

  public SqlSessionFactory build(InputStream inputStream, String environment) {
    return build(inputStream, environment, null);
  }

  public SqlSessionFactory build(InputStream inputStream, Properties properties) {
    return build(inputStream, null, properties);
  }

  //就是这个方法,注意后面两个参数均为空
  public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
    try {
      //XMLConfigBuilder看这个名字就是对mybatis的配置文件进行解析的类,现在他还是一个初始化对象,没有开始解析.用的是java的dom解析
      XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
      //这个就是读取方法,parser.parse()返回一个Configuration对象,该对象将存放读取配置文件的信息
      //build(parser.parse())传入一个Configuration对象,并使用多态返回SqlSessionFactory接口的实体类DefaultSqlSessionFactory
      //DefaultSqlSessionFactory只有一个属性,就是Configuration对象
      return build(parser.parse());
    } catch (Exception e) {
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {
      ErrorContext.instance().reset();
      try {
        //这里关闭了读取流inputStream,我们不用再手动关闭了
        inputStream.close();
      } catch (IOException e) {
        // Intentionally ignore. Prefer previous error.
      }
    }
  }

  //这里就是返回SqlSessionFactory方法
  public SqlSessionFactory build(Configuration config) {
    //DefaultSqlSessionFactory就是SqlSessionFactory接口的实现类,
    //这个类只有一个属性,就是Configuration对象,Configuration对象就是刚刚获取的用来存放读取xml配置的信息
    return new DefaultSqlSessionFactory(config);
  }

}
