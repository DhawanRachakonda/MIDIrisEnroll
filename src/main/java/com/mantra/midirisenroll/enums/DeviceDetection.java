package com.mantra.midirisenroll.enums;

public enum DeviceDetection {
  DISCONNECTED(0),
  CONNECTED(1);
  
  private final int value;
  
  DeviceDetection(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return this.value;
  }
}
