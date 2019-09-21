package com.lusaisai.po;

/**
 * Created by admin on 2019/9/20.
 */
public class Dept {

  private String dName;
  private String loc;

  public String getdName() {
    return dName;
  }

  public void setdName(String dName) {
    this.dName = dName;
  }

  public String getLoc() {
    return loc;
  }

  public void setLoc(String loc) {
    this.loc = loc;
  }

  @Override
  public String toString() {
    return "Dept{" +
      "dName='" + dName + '\'' +
      ", loc='" + loc + '\'' +
      '}';
  }
}
