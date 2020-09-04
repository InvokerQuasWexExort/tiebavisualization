package org.cp.tiebavisualization.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description
 * @Author chenpeng
 * @Date 2020/9/3 15:24
 */
public class DateUtil {

    private final static SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static volatile DateUtil ins;

    private DateUtil() {
    }

    public static synchronized DateUtil getIns() {
        if (ins == null) {
            ins = new DateUtil();
        }
        return ins;
    }

    private Date excuteCreateTime(String str) {
        Date date = new Date();
        try {
            date = df.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
