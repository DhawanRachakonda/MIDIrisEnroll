package com.mantra.midirisenroll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NativeUtils {
  static void loadLibraryFromJar(String path) throws IOException {
    if (!path.startsWith("/"))
      throw new IllegalArgumentException("The path to be absolute (start with '/')."); 
    String[] parts = path.split("/");
    String filename = (parts.length > 1) ? parts[parts.length - 1] : null;
    String prefix = "";
    String suffix = null;
    if (filename != null) {
      parts = filename.split("\\.", 2);
      prefix = parts[0];
      suffix = (parts.length > 1) ? ("." + parts[parts.length - 1]) : null;
    } 
    if (filename == null || prefix.length() < 3)
      throw new IllegalArgumentException("The filename has to be at least 3 characters long."); 
    File temp = File.createTempFile(prefix, suffix);
    temp.deleteOnExit();
    if (!temp.exists())
      throw new FileNotFoundException("File " + temp.getAbsolutePath() + " does not exist."); 
    byte[] buffer = new byte[1024];
    InputStream is = NativeUtils.class.getResourceAsStream(path);
    if (is == null)
      throw new FileNotFoundException("File " + path + " was not found inside JAR."); 
    OutputStream os = new FileOutputStream(temp);
    try {
      int readBytes;
      while ((readBytes = is.read(buffer)) != -1)
        os.write(buffer, 0, readBytes); 
    } finally {
      os.close();
      is.close();
    } 
    System.load(temp.getAbsolutePath());
  }
  
  static void ExtractLibraryFromJar(String path, String FileName) throws IOException {
    try {
      if (!path.startsWith("/"))
        throw new IllegalArgumentException("The path to be absolute (start with '/')."); 
      String tempFolderpath = System.getProperty("java.io.tmpdir");
      InputStream is = NativeUtils.class.getResourceAsStream(path);
      if (is == null)
        throw new FileNotFoundException("File " + path + " was not found inside JAR."); 
      String temppath = tempFolderpath + "\\" + FileName;
      System.out.println(temppath);
      File file = new File(temppath);
      if (file.exists())
        file.delete(); 
      if (!file.exists())
        file.createNewFile(); 
      OutputStream outputStream = new FileOutputStream(new File(temppath));
      int read = 0;
      byte[] bytes = new byte[8192];
      try {
        while ((read = is.read(bytes)) != -1)
          outputStream.write(bytes, 0, read); 
      } catch (Exception ex) {
      
      } finally {
        outputStream.close();
        is.close();
      } 
    } catch (Exception ex) {}
  }
  
  public static File ExtractLibraryFromJar(String path, String FileName, String TempFolder, boolean isLoad) throws IOException {
    try {
      if (!path.startsWith("/"))
        throw new IllegalArgumentException("The path to be absolute (start with '/')."); 
      String tempFolderpath = System.getProperty("java.io.tmpdir");
      if (tempFolderpath == null || tempFolderpath.equals(""))
        tempFolderpath = System.getenv("TEMP"); 
      InputStream is = NativeUtils.class.getResourceAsStream(path);
      if (is == null)
        throw new FileNotFoundException("File " + path + " was not found inside JAR."); 
      String temppath = tempFolderpath + "/" + TempFolder;
      temppath = temppath + "/" + FileName;
      File file = new File(temppath);
      try {
        file.getParentFile().mkdirs();
      } catch (Exception fex) {}
      try {
        if (file.exists())
          file.delete(); 
      } catch (Exception e) {}
      if (!file.exists())
        file.createNewFile(); 
      OutputStream outputStream = new FileOutputStream(new File(temppath));
      int read = 0;
      byte[] bytes = new byte[8192];
      try {
        while ((read = is.read(bytes)) != -1)
          outputStream.write(bytes, 0, read); 
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      } finally {
        outputStream.close();
        is.close();
      } 
      if (isLoad)
        System.load(file.getAbsolutePath()); 
      return file;
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    } 
  }
  
  public static File ExtractLibraryFromLinuxJar(String path, String FileName, String bits, boolean isLoad, boolean idkit) throws IOException {
    try {
      if (!path.startsWith("/"))
        throw new IllegalArgumentException("The path to be absolute (start with '/')."); 
      InputStream is = NativeUtils.class.getResourceAsStream(path);
      if (is == null)
        throw new FileNotFoundException("File " + path + " was not found inside JAR."); 
      String temppath = "/usr/local/lib/MIDIris_Enroll/" + bits;
      String path2 = temppath;
      temppath = temppath + "/" + FileName;
      File file = new File(temppath);
      try {
        file.getParentFile().mkdirs();
      } catch (Exception fex) {}
      if (!file.exists())
        file.createNewFile(); 
      OutputStream outputStream = new FileOutputStream(new File(temppath));
      int read = 0;
      byte[] bytes = new byte[8192];
      try {
        while ((read = is.read(bytes)) != -1)
          outputStream.write(bytes, 0, read); 
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      } finally {
        outputStream.close();
        is.close();
      } 
      if (isLoad)
        System.load(file.getAbsolutePath()); 
      return file;
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    } 
  }
  
  static void ExtractLibraryFromJarAtApplicationPath(String path, String FileName) throws IOException {
    try {
      if (!path.startsWith("/"))
        throw new IllegalArgumentException("The path to be absolute (start with '/')."); 
      String AbsolutePath = (new File("")).getAbsolutePath();
      String tempFolderpath = AbsolutePath;
      System.out.println(tempFolderpath);
      InputStream is = NativeUtils.class.getResourceAsStream(path);
      if (is == null)
        throw new FileNotFoundException("File " + path + " was not found inside JAR."); 
      String temppath = tempFolderpath + "\\" + FileName;
      File file = new File(temppath);
      if (file.exists())
        file.delete(); 
      if (!file.exists())
        file.createNewFile(); 
      OutputStream outputStream = new FileOutputStream(new File(temppath));
      int read = 0;
      byte[] bytes = new byte[8192];
      try {
        while ((read = is.read(bytes)) != -1)
          outputStream.write(bytes, 0, read); 
      } catch (Exception ex) {
      
      } finally {
        outputStream.close();
        is.close();
      } 
    } catch (Exception ex) {}
  }
}