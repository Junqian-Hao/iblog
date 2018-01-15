package com.nuc.iblog.service;

import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/15 11:17
 * @Description : 后台管理系统敏感词设置
 */
public interface MSSensitiveWordService {
    /**
     * 更新敏感词库
     * @param word
     * @return
     */
    Map<String, String> updateSensitiveWord(String word);

    /**
     * 读取敏感词库
     * @return
     */
    String readSensitive();
}
