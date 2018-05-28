package com.ftwj.exam.bean;

import java.util.List;

/**
 * 类名：com.ftwj.exam.Bean
 * 时间：2018/5/25 10:38
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class ContentBean {


    /**
     * count : 0
     * code : 200
     * msg : 成功
     * data : [{"title":{"id":21,"op_id":29,"content":"古代科举考试最后在殿试中考取第二名别称为（）","sub_id":7,"status":1},"option":[{"id":26,"t_id":21,"iden":"A","content":"执牛耳","status":1},{"id":27,"t_id":21,"iden":"B","content":"状元","status":1},{"id":28,"t_id":21,"iden":"C","content":"探花","status":1},{"id":29,"t_id":21,"iden":"D","content":"榜眼","status":1}]},{"title":{"id":27,"op_id":32,"content":"文房四宝是谁发明的","sub_id":7,"status":1},"option":[{"id":30,"t_id":27,"iden":"A","content":"乐毅","status":1},{"id":31,"t_id":27,"iden":"B","content":"闻仲","status":1},{"id":32,"t_id":27,"iden":"C","content":"蒙恬","status":1},{"id":33,"t_id":27,"iden":"D","content":"刘伯温","status":1}]},{"title":{"id":19,"op_id":19,"content":"现在我们看到的万里长城是（ ）时期留下来的","sub_id":7,"status":1},"option":[{"id":18,"t_id":19,"iden":"A","content":"秦朝","status":1},{"id":19,"t_id":19,"iden":"B","content":"明朝","status":1},{"id":20,"t_id":19,"iden":"C","content":"清朝","status":1},{"id":21,"t_id":19,"iden":"D","content":"唐朝","status":1}]},{"title":{"id":20,"op_id":23,"content":"杜牧有诗句\u201c一骑红尘妃子笑\u201d，其中\u201c妃子\u201d是（）11","sub_id":7,"status":1},"option":[{"id":22,"t_id":20,"iden":"A","content":"武则天","status":1},{"id":23,"t_id":20,"iden":"B","content":"杨贵妃","status":1},{"id":24,"t_id":20,"iden":"C","content":"慈溪","status":1},{"id":25,"t_id":20,"iden":"D","content":"花木兰","status":1}]}]
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
         * title : {"id":21,"op_id":29,"content":"古代科举考试最后在殿试中考取第二名别称为（）","sub_id":7,"status":1}
         * option : [{"id":26,"t_id":21,"iden":"A","content":"执牛耳","status":1},{"id":27,"t_id":21,"iden":"B","content":"状元","status":1},{"id":28,"t_id":21,"iden":"C","content":"探花","status":1},{"id":29,"t_id":21,"iden":"D","content":"榜眼","status":1}]
         */

        private TitleBean title;
        private List<OptionBean> option;

        public TitleBean getTitle() {
            return title;
        }

        public void setTitle(TitleBean title) {
            this.title = title;
        }

        public List<OptionBean> getOption() {
            return option;
        }

        public void setOption(List<OptionBean> option) {
            this.option = option;
        }

        public static class TitleBean {
            /**
             * id : 21
             * op_id : 29
             * content : 古代科举考试最后在殿试中考取第二名别称为（）
             * sub_id : 7
             * status : 1
             */

            private int id;
            private int op_id;
            private String content;
            private int sub_id;
            private int status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOp_id() {
                return op_id;
            }

            public void setOp_id(int op_id) {
                this.op_id = op_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getSub_id() {
                return sub_id;
            }

            public void setSub_id(int sub_id) {
                this.sub_id = sub_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }

        public static class OptionBean {
            /**
             * id : 26
             * t_id : 21
             * iden : A
             * content : 执牛耳
             * status : 1
             */

            private int id;
            private int t_id;
            private String iden;
            private String content;
            private int status;
            private boolean checked;


            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getT_id() {
                return t_id;
            }

            public void setT_id(int t_id) {
                this.t_id = t_id;
            }

            public String getIden() {
                return iden;
            }

            public void setIden(String iden) {
                this.iden = iden;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
