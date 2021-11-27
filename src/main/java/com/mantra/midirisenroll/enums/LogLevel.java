package com.mantra.midirisenroll.enums;

public enum LogLevel {
  MIDIRIS_ENROLL_LVL_LOG_OFF(0),
  MIDIRIS_ENROLL_LVL_LOG_ERROR(1);
  
  private final int value;
  
  LogLevel(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return this.value;
  }
}