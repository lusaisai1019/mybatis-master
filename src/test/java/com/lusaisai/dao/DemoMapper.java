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
package com.lusaisai.dao;

import com.lusaisai.po.Dept;
import com.lusaisai.po.DeptInfo;
import com.lusaisai.po.ProjInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DemoMapper {

  Integer insertDept(@Param("dName")String dName);

  DeptInfo selectOne(@Param("deptNum")Integer deptNum, @Param("dName")String dName);



}
