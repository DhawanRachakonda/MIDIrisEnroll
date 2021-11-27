package com.mantra.midirisenroll;

import com.mantra.midirisenroll.enums.DeviceDetection;
import com.mantra.midirisenroll.enums.IrisSide;
import com.mantra.midirisenroll.model.ImagePara;
import com.mantra.midirisenroll.model.ImageQuality;

public interface MIDIrisEnrollCallback {
  void OnDeviceDetection(String paramString, IrisSide paramIrisSide, DeviceDetection paramDeviceDetection);
  
  void OnPreview(int paramInt, ImageQuality paramImageQuality, ImagePara paramImagePara);
  
  void OnComplete(int paramInt, ImageQuality paramImageQuality, ImagePara paramImagePara);
}