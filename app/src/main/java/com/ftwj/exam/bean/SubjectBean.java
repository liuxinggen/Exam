package com.ftwj.exam.bean;

import java.util.List;

/**
 * 类名：com.ftwj.exam.bean
 * 时间：2018/5/25 15:11
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class SubjectBean {


    /**
     * count : 0
     * code : 200
     * msg : 成功
     * data : [{"id":1,"name":"国学","status":1},{"id":2,"name":"数学","status":1},{"id":3,"name":"英语","status":1},{"id":4,"name":"生物","status":1},{"id":5,"name":"物理","status":1},{"id":6,"name":"化学","status":1},{"id":7,"name":"历史","status":1},{"id":8,"name":"心理","status":1},{"id":9,"name":"军事","status":1},{"id":10,"name":"舞蹈","status":1},{"id":11,"name":"体育1","status":1},{"id":12,"name":"医学","status":1},{"id":13,"name":"政治","status":1},{"id":14,"name":"地理","status":1},{"id":15,"name":"国防","status":1},{"id":16,"name":"厨艺","status":1},{"id":17,"name":"科技","status":1},{"id":18,"name":"外事","status":1}]
     */

    private int count;
    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 国学
         * status : 1
         */

        private int id;
        private String name;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
