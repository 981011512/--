package com.cf.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 此文件作为视频文件处理父类，提供：
 * 1、查看视频时长
 * 2、校验两个视频的时长是否相等
 *
 */
public class VideoUtil {

    String ffmpeg_path = "D:\\Program Files\\ffmpeg-20180227-fa0c9d6-win64-static\\bin\\ffmpeg.exe";//ffmpeg的安装位置

    public VideoUtil(String ffmpeg_path){
        this.ffmpeg_path = ffmpeg_path;
    }


    //检查视频时间是否一致
    public Boolean check_video_time(String source,String target) {
        String source_time = get_video_time(source);
        //取出时分秒
        source_time = source_time.substring(0,source_time.lastIndexOf("."));
        String target_time = get_video_time(target);
        //取出时分秒
        target_time = target_time.substring(0,target_time.lastIndexOf("."));
        if(source_time == null || target_time == null){
            return false;
        }
        if(source_time.equals(target_time)){
            return true;
        }
        return false;
    }

    //获取视频时间(时：分：秒：毫秒)
    public String get_video_time(String video_path) {
        /*
        ffmpeg -i  lucene.mp4
         */
        List<String> commend = new ArrayList<String>();
        commend.add(ffmpeg_path);
        commend.add("-i");
        commend.add(video_path);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            //将标准输入流和错误输入流合并，通过标准输入流程读取信息
            builder.redirectErrorStream(true);
            Process p = builder.start();
            String outstring = waitFor(p);
            System.out.println(outstring);
            int start = outstring.trim().indexOf("Duration: ");
            if(start>=0){
                int end = outstring.trim().indexOf(", start:");
                if(end>=0){
                    String time = outstring.substring(start+10,end);
                    if(time!=null && !time.equals("")){
                        return time.trim();
                    }
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return null;
    }

     public String waitFor(Process p) {
        InputStream in = null;
        InputStream error = null;
        String result = "error";
        int exitValue = -1;
        StringBuffer outputString = new StringBuffer();
        try {
            in = p.getInputStream();
            error = p.getErrorStream();
            boolean finished = false;
            int maxRetry = 600;//每次休眠1秒，最长执行时间10分种
            int retry = 0;
            while (!finished) {
                if (retry > maxRetry) {
                    return "error";
                }
                try {
                    while (in.available() > 0) {
                        Character c = new Character((char) in.read());
                        outputString.append(c);
                        System.out.print(c);
                    }
                    while (error.available() > 0) {
                        Character c = new Character((char) in.read());
                        outputString.append(c);
                        System.out.print(c);
                    }
                    //进程未结束时调用exitValue将抛出异常
                    exitValue = p.exitValue();
                    finished = true;

                } catch (IllegalThreadStateException e) {
                    Thread.currentThread().sleep(1000);//休眠1秒
                    retry++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
       return outputString.toString();

    }


    public static void main(String[] args) throws IOException {
        String ffmpeg_path = "D:\\Program Files\\ffmpeg-20180227-fa0c9d6-win64-static\\bin\\ffmpeg.exe";//ffmpeg的安装位置
        VideoUtil videoUtil = new VideoUtil(ffmpeg_path);
        String video_time = videoUtil.get_video_time("E:\\ffmpeg_test\\1.avi");
        System.out.println(video_time);
    }
}
