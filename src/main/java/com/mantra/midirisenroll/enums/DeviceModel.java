package com.mantra.midirisenroll.enums;

import java.util.HashMap;
import java.util.Map;

public enum DeviceModel {
  MATISX("MATISX");
  
  private static final Map<String, DeviceModel> map;
  
  private String deviceModel;
  
  DeviceModel(String deviceModel) {
    this.deviceModel = deviceModel;
  }
  
  public String getDeviceName() {
    return this.deviceModel;
  }
  
  static {
    map = new HashMap<String, DeviceModel>();
    for (DeviceModel en : values())
      map.put(en.deviceModel, en); 
  }
  
  public static DeviceModel valueFor(String name) {
    return map.get(name);
  }
}