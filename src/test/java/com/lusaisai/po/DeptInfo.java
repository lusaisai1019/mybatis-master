package com.lusaisai.po;

/**
 * Created by admin on 2019/9/20.
 */
public class DeptInfo {

  private Integer DEPTNO;
  private String DNAME;
  private String LOC;

  public Integer getDEPTNO() {
    return DEPTNO;
  }

  public void setDEPTNO(Integer DEPTNO) {
    this.DEPTNO = DEPTNO;
  }

  public String getDNAME() {
    return DNAME;
  }

  public void setDNAME(String DNAME) {
    this.DNAME = DNAME;
  }

  public String getLOC() {
    return LOC;
  }

  public void setLOC(String LOC) {
    this.LOC = LOC;
  }

  @Override
  public String toString() {
    return "DeptInfo{" +
      "DEPTNO=" + DEPTNO +
      ", DNAME='" + DNAME + '\'' +
      ", LOC='" + LOC + '\'' +
      '}';
  }
}
