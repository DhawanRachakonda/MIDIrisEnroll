package com.mantra.midirisenroll;

import com.mantra.midirisenroll.enums.DeviceDetection;
import com.mantra.midirisenroll.enums.DeviceModel;
import com.mantra.midirisenroll.enums.ImageFormat;
import com.mantra.midirisenroll.enums.IrisSide;
import com.mantra.midirisenroll.enums.LogLevel;
import com.mantra.midirisenroll.model.ImagePara;
import com.mantra.midirisenroll.model.ImageQuality;
import java.util.List;

public class MIDIrisEnroll implements MIDIrisEnrollNative.Callback {
  private static MIDIrisEnrollCallback mIDIrisEnrollCallback = null;
  
  private static final int fd = -1;
  
  private static DeviceInfo info = null;
  
  private static boolean isCaptureRunning = false;
  
  private static boolean isAsync = false;
  
  private DeviceModel deviceModel = null;
  
  public MIDIrisEnroll(MIDIrisEnrollCallback mIDIrisEnrollCallback) {
    MIDIrisEnroll.mIDIrisEnrollCallback = mIDIrisEnrollCallback;
    MIDIrisEnrollNative.RegisterCallback(this);
    MIDIrisEnrollNative.RegisterDetectionCallback();
  }
  
  public int GetConnectedDevices(List<String> lists) {
    try {
      int[] siz = new int[1];
      int ret = MIDIrisEnrollNative.GetDeviceList(null, siz);
      if (ret != 0)
        return ret; 
      if (siz[0] == 0)
        return -2027; 
      DeviceList[] deviceLists = new DeviceList[siz[0]];
      ret = MIDIrisEnrollNative.GetDeviceList(deviceLists, siz);
      if (ret == 0)
        for (DeviceList list : deviceLists)
          lists.add(list.Model);  
      return ret;
    } catch (Exception e) {
      e.printStackTrace();
      return -3001;
    } 
  }
  
  public int GetSupportedDevices(List<String> lists) {
    try {
      int[] siz = new int[1];
      int ret = MIDIrisEnrollNative.GetSupportedDeviceList(null, siz);
      if (ret != 0)
        return ret; 
      if (siz[0] == 0)
        return ret; 
      DeviceList[] deviceLists = new DeviceList[siz[0]];
      ret = MIDIrisEnrollNative.GetSupportedDeviceList(deviceLists, siz);
      if (ret == 0)
        for (DeviceList list : deviceLists)
          lists.add(list.Model);  
      return ret;
    } catch (Exception e) {
      e.printStackTrace();
      return -3001;
    } 
  }
  
  public synchronized int Init(DeviceModel modelName, DeviceInfo deviceInfo, IrisSide[] irisSides) {
    try {
      if (modelName == null)
        return -2027; 
      info = new DeviceInfo();
      int[] side = new int[1];
      int ret = MIDIrisEnrollNative.Init(-1, modelName.getDeviceName(), info, side);
      if (ret == 0) {
        info.Make = info.Make.trim();
        info.Model = info.Model.trim();
        info.SerialNo = info.SerialNo.trim();
        info.Firmware = info.Firmware.trim();
        if (deviceInfo != null) {
          deviceInfo.Make = info.Make.trim();
          deviceInfo.Model = info.Model.trim();
          deviceInfo.SerialNo = info.SerialNo.trim();
          deviceInfo.Firmware = info.Firmware.trim();
          deviceInfo.Width = info.Width;
          deviceInfo.Height = info.Height;
        } 
        if (irisSides != null)
          irisSides[0] = IrisSide.valueFor(side[0]); 
      } 
      this.deviceModel = modelName;
      return ret;
    } catch (Exception e) {
      e.printStackTrace();
      return -3001;
    } 
  }
  
  public int Uninit() {
    try {
      info = null;
      isCaptureRunning = false;
      isAsync = false;
      return MIDIrisEnrollNative.Uninit();
    } catch (Exception e) {
      e.printStackTrace();
      return -3001;
    } 
  }
  
  public String GetSDKVersion() {
    return MIDIrisEnrollNative.GetVersion();
  }
  
  public boolean IsDeviceConnected(DeviceModel name, IrisSide[] irisSides) {
    int ret = 0;
    if (name == null)
      return false; 
    int[] side = new int[1];
    ret = MIDIrisEnrollNative.IsDeviceConnected(-1, name.getDeviceName(), side);
    if (ret == 0 && irisSides != null)
      irisSides[0] = IrisSide.valueFor(side[0]); 
    return (ret == 0);
  }
  
  public int StartCapture(IrisSide irisSide, int minQuality, int timeOut) {
    if (isCaptureRunning)
      return -2023; 
    if (this.deviceModel == null) {
      isCaptureRunning = false;
      return -2027;
    } 
    int ret = MIDIrisEnrollNative.StartCapture(irisSide.getValue(), minQuality, timeOut);
    if (ret == 0) {
      isCaptureRunning = true;
      isAsync = true;
    } 
    return ret;
  }
  
  public int AutoCapture(IrisSide irisSide, int minQuality, int timeOut, ImageQuality imageQuality, ImagePara imagePara) {
    if (isCaptureRunning)
      return -2023; 
    if (this.deviceModel == null) {
      isCaptureRunning = false;
      return -2027;
    } 
    if (imageQuality == null || imagePara == null)
      return -2026; 
    isCaptureRunning = true;
    isAsync = false;
    int ret = MIDIrisEnrollNative.AutoCapture(irisSide.getValue(), minQuality, timeOut, imageQuality, imagePara);
    isCaptureRunning = false;
    if (ret == -5)
      ret = -2027; 
    return ret;
  }
  
  public int StopCapture() {
    if (this.deviceModel == null)
      return -2027; 
    int ret = MIDIrisEnrollNative.StopCapture();
    isCaptureRunning = false;
    isAsync = false;
    return ret;
  }
  
  public boolean IsCaptureRunning() {
    return isCaptureRunning;
  }
  
  public int GetImage(ImagePara imagePara, int compressionRatio, ImageFormat format) {
    if (this.deviceModel == null)
      return -2027; 
    if (imagePara == null)
      return -2026; 
    int ret = MIDIrisEnrollNative.GetImage(imagePara, format.getValue(), compressionRatio);
    return ret;
  }
  
  public String GetErrorMessage(int errorCode) {
    return MIDIrisEnrollNative.GetErrorMessage(errorCode);
  }
  
  public void SetLogProperties(String file, LogLevel level) {
    if (file == null || file.length() == 0)
      return; 
    MIDIrisEnrollNative.EnableLogs(level.getValue(), file);
  }
  
  public void Dispose() {
    this.deviceModel = null;
    info = null;
    isCaptureRunning = false;
    isAsync = false;
  }
  
  public void DeviceCallback(String deviceName, int irisSide, int dvcStatus) {
    if (mIDIrisEnrollCallback != null)
      if (dvcStatus == 0) {
        if (this.deviceModel != null && deviceName.equalsIgnoreCase(this.deviceModel.getDeviceName())) {
          if (isAsync)
            CompleteCallback(-2027, null, null); 
          info = null;
        } 
        mIDIrisEnrollCallback.OnDeviceDetection(deviceName, IrisSide.valueFor(irisSide), DeviceDetection.DISCONNECTED);
      } else {
        if (info == null)
          this.deviceModel = DeviceModel.valueFor(deviceName); 
        mIDIrisEnrollCallback.OnDeviceDetection(deviceName, IrisSide.valueFor(irisSide), DeviceDetection.CONNECTED);
      }  
  }
  
  public void PreviewCallback(int ErrorCode, ImageQuality imageQuality, ImagePara imagePara) {
    if (mIDIrisEnrollCallback != null)
      mIDIrisEnrollCallback.OnPreview(ErrorCode, imageQuality, imagePara); 
  }
  
  public void CompleteCallback(int ErrorCode, ImageQuality imageQuality, ImagePara imagePara) {
    isCaptureRunning = false;
    if (mIDIrisEnrollCallback != null)
      mIDIrisEnrollCallback.OnComplete(ErrorCode, imageQuality, imagePara); 
  }
}