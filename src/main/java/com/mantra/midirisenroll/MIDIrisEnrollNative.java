package com.mantra.midirisenroll;

import com.mantra.midirisenroll.model.ImagePara;
import com.mantra.midirisenroll.model.ImageQuality;
import java.io.IOException;

public class MIDIrisEnrollNative {
  private static Callback callback;
  
  public static final int MIDIRIS_ENROLL_SUCCESS = 0;
  
  public static final int MIDIRIS_ENROLL_INVLD_INPUT = -1;
  
  public static final int IMG_PROCESS_E_NO_DEVICE = -1601;
  
  public static final int IMG_PROCESS_E_MEMORY = -1602;
  
  public static final int IMG_PROCESS_E_BAD_LICENSE = -1603;
  
  public static final int IMG_PROCESS_E_OTHER = -1604;
  
  public static final int IMG_PROCESS_E_INVALIDPARAM = -1605;
  
  public static final int IMG_PROCESS_VID_NOTMATCH = -1606;
  
  public static final int IMG_PROCESS_PID_NOTMATCH = -1607;
  
  public static final int IMG_PROCESS_CID_NOTMATCH = -1608;
  
  public static final int IMG_PROCESS_E_NOSERIAL = -1609;
  
  public static final int IMG_PROCESS_E_NOTINITIALIZED = -1610;
  
  public static final int IMG_PROCESS_E_NO_FILE = -1611;
  
  public static final int INVLD_PRODUCT_NAME_LEN = -2001;
  
  public static final int INVLD_PRODUCT_NAME = -2002;
  
  public static final int FAILED_TO_GET_PRODUCT_ID = -2003;
  
  public static final int FAILED_TO_INIT_COMM = -2004;
  
  public static final int FAILED_TO_INIT_DEVICE = -2005;
  
  public static final int FAILED_TO_GET_HWID = -2006;
  
  public static final int FAILED_TO_REGISTER_CALLBACK = -2007;
  
  public static final int FAILED_TO_CREATE_THREAD = -2008;
  
  public static final int FAILED_TO_CREATE_TIMEOUT_THREAD = -2009;
  
  public static final int FAILED_TO_CREATE_CLBK_THREAD = -2010;
  
  public static final int FAILED_TO_START_CAPTURE = -2011;
  
  public static final int FAILED_TO_STOP_CAPTURE = -2012;
  
  public static final int FAILED_TO_UINIT_DEVICE = -2013;
  
  public static final int FAILED_TO_UINIT_LIBS = -2014;
  
  public static final int FAILED_TO_RESTORE_MFG_DATA = -2015;
  
  public static final int FAILED_TO_GET_MFG_DATA = -2016;
  
  public static final int FAILED_TO_FPS_GET_DATA = -2017;
  
  public static final int INVLD_LIC_KEY = -2018;
  
  public static final int NATIVE_CAPTURE_TIMEOUT = -2019;
  
  public static final int FAILED_TO_ALLOC_MEM = -2020;
  
  public static final int FAILED_TO_GET_SER_NO = 2021;
  
  public static final int NULL_DEVICE_INFO_STRUCT = -2022;
  
  public static final int CAPTURE_ALREADY_STARTED = -2023;
  
  public static final int DEVICE_ALREADY_INITIALIZED = -2024;
  
  public static final int DEVICE_NOT_INITIALIZED = -2025;
  
  public static final int OBJECT_CANNOT_BE_NULL_OR_EMPTY = -2026;
  
  public static final int DEVICE_NOT_CONNECTED = -2027;
  
  public static final int NULL_CALLBACK_FUNC_FOUND = -2028;
  
  public static final int FAILED_TO_CREATE_PARSE_ARR = -2029;
  
  public static final int FAILED_TO_READ_DEV_MFG_DATA = -2030;
  
  public static final int IPL_DEV_INIT_FAILED = -2031;
  
  public static final int IPL_INIT_FAILED = -2032;
  
  public static final int FAILED_TO_GET_IMG_QLTY = -2033;
  
  public static final int FAILED_TO_PROCESS_RAW_DATA = -2034;
  
  public static final int FAILED_TO_PROCESS_MFG_DATA = -2035;
  
  public static final int FAILED_TO_SET_ENC_KEY = -2036;
  
  public static final int FAILED_TO_GET_TEMPLATE = -2037;
  
  public static final int IMAGE_NOT_CAPTURED = -2038;
  
  public static final int CAPTURE_STOP = -2039;
  
  public static final int UNSUPPORTED_IMAGE_FORMAT = -2040;
  
  public static final int UNSUPPORTED_TEMPLATE_FORMAT = -2041;
  
  public static final int INVLD_COMPRESSION_RATIO = -2042;
  
  public static final int DEVICE_NOT_STREAMING = -2043;
  
  public static final int INVLD_TEMPLATE_VERSION = -2044;
  
  public static final int FAILED_TO_INIT_SEGMENTAION = -2045;
  
  public static final int FAILED_TO_UPDATE_LEDS = -2046;
  
  public static final int FAILED_TO_UPDATE_DUTY_CYCLE = -2047;
  
  public static final int INVLD_LOG_LEVEL = -2048;
  
  public static final int FAILED_TO_CREATE_LOG_FILE = -2049;
  
  public static final int MIDIRIS_ENROLL_FAILED_TO_UPDATE_LED = -2050;
  
  public static final int MIDIRIS_ENROLL_UNSUPPORTED_FEATURE = -2051;
  
  public static final int MIDIRIS_ENROLL_FAILED_TO_GET_IMAGE = -2052;
  
  public static final int QTY_OUT_OF_RANGE = -2053;
  
  public static final int INVLD_FIRMWARE = -2054;
  
  public static final int MFG_LIB_ERROR = -3000;
  
  public static final int MIDIRIS_ENROLL_E_EXCEPTION_OCCURRED = -3001;
  
  protected static void RegisterCallback(Callback callback) {
    MIDIrisEnrollNative.callback = callback;
  }
  
  protected static native int RegisterDetectionCallback();
  
  protected static native int Init(int paramInt, String paramString, DeviceInfo paramDeviceInfo, int[] paramArrayOfint);
  
  protected static native int IsDeviceConnected(int paramInt, String paramString, int[] paramArrayOfint);
  
  protected static native String GetVersion();
  
  protected static native int StartCapture(int paramInt1, int paramInt2, int paramInt3);
  
  protected static native int AutoCapture(int paramInt1, int paramInt2, int paramInt3, ImageQuality paramImageQuality, ImagePara paramImagePara);
  
  protected static native int StopCapture();
  
  protected static native int Uninit();
  
  protected static native String GetErrorMessage(int paramInt);
  
  protected static native void EnableLogs(int paramInt, String paramString);
  
  protected static native int GetImage(ImagePara paramImagePara, int paramInt1, int paramInt2);
  
  protected static native int GetDeviceList(DeviceList[] paramArrayOfDeviceList, int[] paramArrayOfint);
  
  protected static native int GetSupportedDeviceList(DeviceList[] paramArrayOfDeviceList, int[] paramArrayOfint);
  
  public static void DeviceCallback(String deviceName, int irisSide, int dvcStatus) {
    if (callback != null)
      callback.DeviceCallback(deviceName, irisSide, dvcStatus); 
  }
  
  public static void PreviewCallback(int ErrorCode, ImageQuality imageQuality, ImagePara imagePara) {
    if (callback != null)
      callback.PreviewCallback(ErrorCode, imageQuality, imagePara); 
  }
  
  public static void CompleteCallback(int ErrorCode, ImageQuality imageQuality, ImagePara imagePara) {
    if (callback != null)
      callback.CompleteCallback(ErrorCode, imageQuality, imagePara); 
  }
  
  static {
    try {
      String bits = System.getProperty("os.arch").toLowerCase();
      String OS = System.getProperty("os.name").toLowerCase();
      if (OS != null)
        OS = OS.toLowerCase(); 
      if (OS.indexOf("windows") >= 0) {
        String AbsFolder = "MIDIris_Enroll";
        System.out.println(OS + " " + bits + " Unspported OS");
        if (bits.indexOf("64") >= 0) {
          NativeUtils.ExtractLibraryFromJar("/win/x64/iris_engine_v3.dll", "iris_engine_v3.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x64/iris_image_record.dll", "iris_image_record.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x64/MIDIris_Enroll_Core.dll", "MIDIris_Enroll_Core.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x64/MIDIris_Enroll.dll", "MIDIris_Enroll.dll", AbsFolder, true);
        } else {
          NativeUtils.ExtractLibraryFromJar("/win/x86/iris_engine_v3.dll", "iris_engine_v3.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x86/iris_image_record.dll", "iris_image_record.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x86/MIDIris_Enroll_Core.dll", "MIDIris_Enroll_Core.dll", AbsFolder, true);
          NativeUtils.ExtractLibraryFromJar("/win/x86/MIDIris_Enroll.dll", "MIDIris_Enroll.dll", AbsFolder, true);
        } 
      } 
    } catch (IOException e) {}
  }
  
  protected static interface Callback {
    void DeviceCallback(String param1String, int param1Int1, int param1Int2);
    
    void PreviewCallback(int param1Int, ImageQuality param1ImageQuality, ImagePara param1ImagePara);
    
    void CompleteCallback(int param1Int, ImageQuality param1ImageQuality, ImagePara param1ImagePara);
  }
}