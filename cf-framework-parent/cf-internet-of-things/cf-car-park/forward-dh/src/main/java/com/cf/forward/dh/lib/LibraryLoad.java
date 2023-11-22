package com.cf.forward.dh.lib;

import java.io.*;

/**
 * @author 47081
 * @version 1.0
 * @description 动态库加载
 * @date 2020/11/14
 */
public class LibraryLoad {
  private static final String ARCH_WINDOWS = "win";
  private static final String ARCH_LINUX = "linux";
  private static final String ARCH_MAC = "mac";
  private static final int PREFIX_64 = 64;
  private static final int PREFIX_32 = 32;
  private static final String PREFIX_ARM = "ARM";
  private static final String EXTERNAL_WIN = ".dll";
  private static final String EXTERNAL_LINUX = ".so";
  private static final String EXTERNAL_MAC = ".dylib";
  private static DynamicParseUtil dynamicParseUtil;
  /** 当前读取的目录 */
  private static String currentFold;
  /** 动态库需要写入的目录 */
  private static String EXTRACT_PATH = System.getProperty("java.io.tmpdir");

  private static boolean written = false;

  /**
   * 设置动态库写入的路径,适用于需要自定义加载路径的用户
   *
   * @param path 动态库写入的文件夹,从该文件夹下加载sdk的动态库
   */
  public static void setExtractPath(String path) {
    EXTRACT_PATH = path;
  }
  
  public static String  getExtractPath() {
	return EXTRACT_PATH;
	   
	  }
  /** 动态库路径 */
  private static String INNER_PATH;

  // private static final String EXTERNAL_MAC = ".so";

  private static String extractNetSDKLib(String libName) {
    return extractLibrary(libName);
  }

  public static String getLoadLibrary(String libraryName) {
    currentFold = getLibraryFold();
    if (dynamicParseUtil == null) {
      try {
        dynamicParseUtil =
            new DynamicParseUtil(
                LibraryLoad.class.getClassLoader().getResourceAsStream("dynamic-lib-load.xml"));
        if (!written) {
          for (String libName : dynamicParseUtil.getLibsSystem(currentFold)) {
            extractLibrary(libName);
          }
          written = true;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    String fullName = getLibraryName(libraryName);
    String path = EXTRACT_PATH;
    if (!(EXTRACT_PATH.endsWith("/") || EXTRACT_PATH.endsWith("\\"))) {
      path = EXTRACT_PATH + "/";
    }
    System.out.println("load library: " + path + fullName);
    return path + fullName;
  }

  /**
   * 将jar包里的动态库写入到系统缓存目录,使用绝对路径加载动态库
   *
   * @param libName
   * @return
   */
  private static String extractLibrary(String libName) {
    return extractLibrary("", libName);
  }

  /**
   * 相对路径文件夹
   *
   * @param relativePath 相对路径
   * @param libName 动态库路径
   * @return
   */
  private static String extractLibrary(String relativePath, String libName) {
    if (libName.trim().equals("")) {
      return "";
    }
    String libFullName = getLibraryName(libName);
    String dir = getLibraryFold();
    if (!(relativePath.endsWith("/") || relativePath.endsWith("\\"))) {
      relativePath = relativePath + "/";
    }
    String fileName = relativePath + dir + "/" + libFullName;
    InputStream in = LibraryLoad.class.getResourceAsStream(fileName);
    BufferedInputStream reader;
    FileOutputStream writer;
    File extractedLibFile = null;
    try {
      if (in == null) {
        in = new FileInputStream(fileName);
        if (in == null) {
          return "";
        }
      }
      String nativeTempDir = EXTRACT_PATH;
      if (!(nativeTempDir.endsWith("/") || nativeTempDir.endsWith("\\"))) {
        nativeTempDir = nativeTempDir + "/";
      }
      extractedLibFile = new File(nativeTempDir + libFullName);
      reader = new BufferedInputStream(in);
      writer = new FileOutputStream(extractedLibFile);
      byte[] buffer = new byte[1024];
      while (true) {
        int len = reader.read(buffer);
        if (len == 0 || len == -1) break;
        writer.write(buffer, 0, len);
      }
      reader.close();
      writer.close();
      in.close();
    } catch (Exception e) {
      System.out.println(
          "dynamic file[ "
              + fileName
              + " ] not found in project.please ensure you need this library.");
    }
    return extractedLibFile != null ? extractedLibFile.getAbsolutePath() : "";
  }

  /**
   * 获取动态库完整名称
   *
   * @param libName
   * @return
   */
  private static String getLibraryName(String libName) {
    String dir = currentFold;
    String libPrefix = "";
    String libExtension = EXTERNAL_WIN;

    if (!dir.contains("win")) {
      libPrefix = "lib";
      if (dir.contains("linux")) {
        libExtension = EXTERNAL_LINUX;
      } else {
        // libExtension=".dylib";
        libExtension = EXTERNAL_MAC;
      }
    }
    libName = dynamicParseUtil.compareLibName(currentFold, libName);
    // 动态库以lib开头，则不添加lib前缀
    // 以lib开头的库则不添加lib前缀
    return (libName.startsWith("lib") ? "" : libPrefix) + libName + libExtension;
  }

  // 获取系统对应的动态库文件夹
  private static String getLibraryFold() {
    String osType;
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().startsWith("linux")) {
      osType = ARCH_LINUX;
    } else if (osName.toLowerCase().startsWith("mac")
        || osName.toLowerCase().startsWith("darwin")) {
      osType = ARCH_MAC;
    } else if (osName.toLowerCase().startsWith("windows")) {
      osType = ARCH_WINDOWS;
    } else {
      osType = "";
    }
    String arch = System.getProperty("os.arch");
    arch = arch.toLowerCase().trim();
    if ("i386".equals(arch) || "i686".equals(arch)||"x86".equals(arch)) {
      arch = PREFIX_32 + "";
    } else if ("x86_64".equals(arch) || "amd64".equals(arch)) {
      arch = PREFIX_64 + "";
    } else if (arch.startsWith("arm")) {
      arch = PREFIX_ARM + "";
    }
    return osType + arch;
  }
}
