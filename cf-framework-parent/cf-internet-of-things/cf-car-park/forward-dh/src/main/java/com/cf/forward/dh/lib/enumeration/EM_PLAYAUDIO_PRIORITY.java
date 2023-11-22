package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 语音播报优先级
 * @date 2021/2/20
 */
public enum EM_PLAYAUDIO_PRIORITY {
    /**
     * 未知
     */
    EM_PLAYAUDIO_PRIORITY_UNKNOWN,
    /**
     * 插入播放队列最前端，播放完该文件后播放原来的文件
     */
    EM_PLAYAUDIO_PRIORITY_FRONT,
    /**
     * 插入播放队列最后，等待其它文件播放完再播放该文件
     */
    EM_PLAYAUDIO_PRIORITY_BACK,
    /**
     * 优先级同 EM_PLAYAUDIO_PRIORITY_FRONT，但取消队列中正在播放文件
     */
    EM_PLAYAUDIO_PRIORITY_EMERGENCY;
}
