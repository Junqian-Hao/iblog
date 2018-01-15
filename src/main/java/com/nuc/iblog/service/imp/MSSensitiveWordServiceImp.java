package com.nuc.iblog.service.imp;

import com.nuc.iblog.service.MSSensitiveWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/15 11:17
 * @Description :
 */
@Service
public class MSSensitiveWordServiceImp implements MSSensitiveWordService {
    Logger log = LoggerFactory.getLogger(MSSensitiveWordServiceImp.class);

    @Override
    public Map<String, String> updateSensitiveWord(String word) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            URL resource = MSSensitiveWordServiceImp.class.getResource("/baidumingganci.txt");

            File file = new File(resource.getFile());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(word.getBytes("UTF-8"));
            fileOutputStream.close();
            map.put("code", "1");
            return map;
        } catch (Exception e) {
            map.put("code", "0");
            log.error("敏感词设置业务逻辑出错", e);
        }
        return map;
    }

    @Override
    public String readSensitive() {
        try {
            StringBuffer sb = new StringBuffer();
            InputStream resourceAsStream = MSSensitiveWordServiceImp.class.getClassLoader().getResourceAsStream("baidumingganci.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String a = null;
            while ((a = bufferedReader.readLine())!=null) {
                sb.append(a);
            }
            bufferedReader.close();
            String s = sb.toString();
            log.info("读取到的内容：" + s);
            return s;
        } catch (Exception e) {
            log.error("读取文件错误",e);
        }

        return null;
    }

    public static void main(String[] args) {
        MSSensitiveWordServiceImp msSensitiveWordServiceImp = new MSSensitiveWordServiceImp();
        String s = msSensitiveWordServiceImp.readSensitive();
        String[] split = s.split("\\|");
        System.out.println(s);
        Map<String, String> map = msSensitiveWordServiceImp.updateSensitiveWord(s);
        System.out.println(map);
    }
}
