package com.spike.endava.limitsservice.bean;

public class Limits {
  private int maximum;
  private int minimum;

  protected Limits() {
    super();
  }

  public Limits(int maximum, int minimum) {
    super();
    this.maximum = maximum;
    this.minimum = minimum;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public int getMaximum() {
    return maximum;
  }

  public void setMaximum(int maximum) {
    this.maximum = maximum;
  }

}

