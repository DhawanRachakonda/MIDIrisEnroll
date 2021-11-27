package com.mantra.midirisenroll.enums;

import java.util.HashMap;
import java.util.Map;

public enum IrisSide {
  MIDIRIS_ENROLL_IRIS_SIDE_BOTH(0),
  MIDIRIS_ENROLL_IRIS_SIDE_LEFT(1),
  MIDIRIS_ENROLL_IRIS_SIDE_RIGHT(2);
  
  private final int value;
  
  private static final Map<Integer, IrisSide> map;
  
  IrisSide(int value) {
    this.value = value;
  }
  
  public int getValue() {
    return this.value;
  }
  
  static {
    map = new HashMap<Integer, IrisSide>();
    for (IrisSide en : values())
      map.put(Integer.valueOf(en.value), en); 
  }
  
  public static IrisSide valueFor(int val) {
    return map.get(Integer.valueOf(val));
  }
}