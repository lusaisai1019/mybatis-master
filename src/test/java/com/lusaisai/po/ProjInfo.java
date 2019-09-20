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
