package com.beans;

import java.io.Serializable;

public class WeatherData implements Serializable {
   
  /**
   *
   */
  private static final long serialVersionUID = -3680419725100083029L;
  private long id;
  private String timestamp;
  private long tempInF;
 
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
  public long getTempInF() {
    return tempInF;
  }
  public void setTempInF(long tempInF) {
    this.tempInF = tempInF;
  }
}