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
package com.lusaisai.po;

/**
 * Created by admin on 2019/9/20.
 */
public class ProjInfo {

  private Integer sectionId;
  private String projId;
  private String sectionName;

  public Integer getSectionId() {
    return sectionId;
  }

  public void setSectionId(Integer sectionId) {
    this.sectionId = sectionId;
  }

  public String getProjId() {
    return projId;
  }

  public void setProjId(String projId) {
    this.projId = projId;
  }

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  @Override
  public String toString() {
    return "ProjInfo{" +
      "sectionId=" + sectionId +
      ", projId='" + projId + '\'' +
      ", sectionName=" + sectionName +
      '}';
  }
}
