package com.lovers.common.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangzefeng on 2019/11/29 0029.
 */
public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间

    public static String webUrl2 = "http://www.taobao.com";//淘宝
    public static String webUrl3 = "http://www.baidu.com";//百度
    public static String webUrl4 = "http://www.ntsc.ac.cn";//中国科学院国家授时中心
    public static String webUrl5 = "http://www.360.cn";//360
    public static String webUrl6 = "http://www.beijing-time.org";
    /**
     * 获取指定网站的日期时间
     * @return
     * @auther wangzefeng
     * @date 2019年11月29日
     */
    public static Date getWebDate(){
        Date websiteDatetime = getWebsiteDatetime(webUrl2);
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl3);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl4);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl5);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl6);
        }
        return websiteDatetime;
    }
    /**
     * 获取指定网站的日期时间
     * @return
     * @auther wangzefeng
     * @date 2019年11月29日
     */
    public static String getWebDateToString(){
        Date websiteDatetime = getWebsiteDatetime(webUrl2);
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl3);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl4);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl5);
        }
        if(websiteDatetime==null){
            websiteDatetime=getWebsiteDatetime(webUrl6);
        }
        return sdf.format(websiteDatetime);
    }

    /**
     * 获取指定网站的日期时间
     * @param webUrl
     */
    public static Date getWebsiteDatetime(String webUrl){
        try {
            URL url = new URL(webUrl);// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            long ld = uc.getDate();// 读取网站日期时间
            Date date = new Date(ld);// 转换为标准时间对象
            return date;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
