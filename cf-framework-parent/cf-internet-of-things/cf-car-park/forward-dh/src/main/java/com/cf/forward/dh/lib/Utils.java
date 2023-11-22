package com.cf.forward.dh.lib;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public Utils() {

    }

    /**
     * 获取系统对应的编码
     *
     */
    public static String getPlatformEncode() {
        String encode = "";
        String osPrefix = getOsPrefix();
        if (osPrefix.toLowerCase().startsWith("win32")) {
            encode = "GBK";
        } else if (osPrefix.toLowerCase().startsWith("linux")) {
            encode = "UTF-8";
        }else if(osPrefix.toLowerCase().startsWith("mac")){
            encode="UTF-8";
        }
        if(encode.isEmpty()){
            encode="UTF-8";
        }
        return encode;
    }

    // 获取操作平台信息
    public static String getOsPrefix() {
        String arch = System.getProperty("os.arch").toLowerCase();
        final String name = System.getProperty("os.name");
        String osPrefix;
        switch (Platform.getOSType()) {
            case Platform.WINDOWS: {
                if ("i386".equals(arch))
                    arch = "x86";
                osPrefix = "win32-" + arch;
            }
            break;
            case Platform.LINUX: {
                if ("x86".equals(arch)) {
                    arch = "i386";
                } else if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                osPrefix = "linux-" + arch;
            }
            break;
            case Platform.MAC: {
                //mac系统的os.arch都是ppc(老版本的mac是powerpc，已经基本不用)看不出系统位数，使用下面的参数表示
                arch = System.getProperty("sun.arch.data.model");
                osPrefix = "mac-" + arch;
            }
            break;
            default: {
                osPrefix = name.toLowerCase();
                if ("x86".equals(arch)) {
                    arch = "i386";
                }
                if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                int space = osPrefix.indexOf(" ");
                if (space != -1) {
                    osPrefix = osPrefix.substring(0, space);
                }
                osPrefix += "-" + arch;
            }
            break;

        }

        return osPrefix;
    }

    public static String getOsName() {
        String osName = "";
        String osPrefix = getOsPrefix();
        if (osPrefix.toLowerCase().startsWith("win32-x86")
                || osPrefix.toLowerCase().startsWith("win32-amd64")) {
            osName = "win";
        } else if (osPrefix.toLowerCase().startsWith("linux-i386")
                || osPrefix.toLowerCase().startsWith("linux-amd64")) {
            osName = "linux";
        } else if (osPrefix.toLowerCase().startsWith("mac-64")
                || osPrefix.toLowerCase().startsWith("mac-32")) {
            osName = "mac";
        }

        return osName;
    }

    // 获取加载库
    public static String getLoadLibrary(String library) {
        if (isChecking()) {
            return null;
        }

        String loadLibrary = "";
        String osPrefix = getOsPrefix();
        if (osPrefix.toLowerCase().startsWith("win32-x86")) {
            loadLibrary = "./libs/win32/";
        } else if (osPrefix.toLowerCase().startsWith("win32-amd64")) {
            loadLibrary = "./libs/win64/";
        } else if (osPrefix.toLowerCase().startsWith("linux-i386")) {
            loadLibrary = "";
        } else if (osPrefix.toLowerCase().startsWith("linux-amd64")) {
            loadLibrary = "";
        } else if (osPrefix.toLowerCase().startsWith("mac-64")) {
            loadLibrary = "";
        }
//		else if(osPrefix.toLowerCase().startsWith("mac-32")) {
//			loadLibrary = "";
//		}  32位mac版本基本没人用了，暂时不用

        System.out.printf("加载库[%s]\n", loadLibrary + library);
        return loadLibrary + library;
    }

    private static boolean checking = false;

    public static void setChecking() {
        checking = true;
    }

    public static void clearChecking() {
        checking = false;
    }

    public static boolean isChecking() {
        return checking;
    }

    public static class LLong extends IntegerType {
        private static final long serialVersionUID = 1L;

        /**
         * Size of a native long, in bytes.
         */
        public static int size;

        static {
            size = Native.LONG_SIZE;
            if (Utils.getOsPrefix().toLowerCase().equals("linux-amd64")
                    || Utils.getOsPrefix().toLowerCase().equals("win32-amd64")
                    || Utils.getOsPrefix().toLowerCase().equals("mac-64")) {
                size = 8;
            } else if (Utils.getOsPrefix().toLowerCase().equals("linux-i386")
                    || Utils.getOsPrefix().toLowerCase().equals("win32-x86")) {
                size = 4;
            }
        }

        /**
         * Create a zero-valued LLong.
         */
        public LLong() {
            this(0);
        }

        /**
         * Create a LLong with the given value.
         */
        public LLong(long value) {
            super(size, value);
        }
    }

    public static class SdkStructure extends Structure {
        @Override
        protected List<String> getFieldOrder() {
            List<String> fieldOrderList = new ArrayList<String>();
            for (Class<?> cls = getClass();
                 !cls.equals(NetSDKLib.SdkStructure.class);
                 cls = cls.getSuperclass()) {
                Field[] fields = cls.getDeclaredFields();
                int modifiers;
                for (Field field : fields) {
                    modifiers = field.getModifiers();
                    if (Modifier.isStatic(modifiers) || !Modifier.isPublic(modifiers)) {
                        continue;
                    }
                    fieldOrderList.add(field.getName());
                }
            }
            //            System.out.println(fieldOrderList);

            return fieldOrderList;
        }
    }

    // 获取当前时间
    public static String getDate() {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDate.format(new java.util.Date())
                .replace(" ", "_").replace(":", "-");
    }

}
