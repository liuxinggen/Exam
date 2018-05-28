package com.ftwj.exam.utils;

/**
 * 类名：com.ftwj.exam.utils
 * 时间：2018/5/25 10:32
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class Constant {
    /**
     * IP地址
     */
    public static final String IP = "http://192.168.1.235";

//    /**
//     * IP地址
//     */
//    public static final String IP = "http://192.168.1.3";

    /**
     * 端口号
     */
    public static final String PORT = ":8888";

    /**
     * 项目地址
     */
    public static final String PROJECT = "/Online_Answer_Reception/";


    /**
     * 获取题目和选项
     */
    public static final String GET_CONTENT_URL = IP + PORT + PROJECT + "exam/getExamContent";
    /**
     * 获取科目
     */
    public static final String GET_SUBJECT_URL = IP + PORT + PROJECT + "exam/getSubject";

    /**
     * 提交答案
     */
    public static final String GET_AUBMIT_URL = IP + PORT + PROJECT + "exam/submit";


    public static final String text="http://www.wanandroid.com/tools/mockapi/2091/sss";



}
