package com.mantra.midirisenroll.enums;

public enum ImageFormat {
  RAW(0),
  BMP(1),
  JPEG2000(2),
  K3(3),
  IIR_K7_2011(4);
  
  private final int value;
  
  ImageFormat(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return this.value;
  }
}