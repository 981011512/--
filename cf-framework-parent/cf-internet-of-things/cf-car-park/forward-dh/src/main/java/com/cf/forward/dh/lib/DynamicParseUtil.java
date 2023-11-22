package com.cf.forward.dh.lib;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 47081
 * @version 1.0
 * @description
 * @date 2021/3/10
 */
public class DynamicParseUtil {
  private DynamicLibParseHandler handler;
  private SAXParserFactory saxParserFactory;
  private SAXParser saxParser;

  /**
   * 适配各系统动态库名称大小写不同,以及lib前缀造成的找不到库的问题
   *
   * @param currentSystem 当前系统:win64,win32,linux64,linux32,mac64
   * @param libName 动态库名称
   * @return
   */
  public String compareLibName(String currentSystem, String libName) {
    String dynamicLibName = libName;
    List<String> libs = handler.getLibsBySystem(currentSystem);
    if (currentSystem.toLowerCase().contains("win")) {
      return findLibs(libs, libName);
    }
    if (libName.startsWith("lib")) {
      dynamicLibName = libName.substring(3);
    }
    return findLibs(libs, dynamicLibName);
  }

  private String findLibs(List<String> libs, String libName) {
    for (String lib : libs) {
      if (libName.equalsIgnoreCase(lib)) {
        return lib;
      }
    }
    return "";
  }

  public List<String> getLibsSystem(String system) {
    return handler.getLibsBySystem(system);
  }

  private DynamicParseUtil() throws ParserConfigurationException {
    // 获取SAX分析器的工厂实例，专门负责创建SAXParser分析器
    saxParserFactory = SAXParserFactory.newInstance();
    // 获取SAXParser分析器的实例
    try {
      saxParser = saxParserFactory.newSAXParser();
      handler = new DynamicLibParseHandler();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public DynamicParseUtil(InputStream inputSteam)
      throws ParserConfigurationException, IOException, SAXException {
    this();
    saxParser.parse(inputSteam, handler);
  }

  /** xml解析handler */
  private class DynamicLibParseHandler extends DefaultHandler {
    private HashMap<String, List<String>> dynamics = new HashMap<String, List<String>>();
    private List<String> systems =
        Arrays.asList("win64", "win32", "linux64", "linux32", "mac64", "linuxARM");
    private String currentDynamicSystem;
    private List<String> libs;

    public List<String> getLibsBySystem(String system) {
      return dynamics.get(system);
    }

    @Override
    public void startDocument() throws SAXException {
      super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
      super.startElement(uri, localName, qName, attributes);
      if (systems.contains(qName)) {
        currentDynamicSystem = qName;
        if (libs == null) {
          libs = new ArrayList<String>();
        }
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      super.endElement(uri, localName, qName);
      if (systems.contains(qName)) {
        // 保存到hashmap中
        dynamics.put(currentDynamicSystem, libs);
        // 清除libs
        libs = null;
      }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      super.characters(ch, start, length);
      String lib = new String(ch, start, length);
      if (!lib.trim().isEmpty()) {
        libs.add(lib);
      }
    }
  }
}
