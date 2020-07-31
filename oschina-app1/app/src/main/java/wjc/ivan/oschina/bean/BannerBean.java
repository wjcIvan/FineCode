package wjc.ivan.oschina.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by 龙心诚 on 2018/6/25 0025.
 */

public class BannerBean extends BasePageBean<BannerBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * notice : {"newsCount":32}
     * result : {"items":[{"detail":"","href":"https://www.oschina.net/news/97344/app-20180623","id":97344,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_981a37bd-ac6b-44d4-89f0-f5f7f86a943e.jpg","name":"嘿哥们，全国最大的\u201c同性交友\u201dAPP了解一下？","pubDate":"2018-06-25 10:51:57","type":6},{"detail":"","href":"https://zb.oschina.net/activity/world-cup/index.html?from=osc&b=3&c=app","id":96769,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_d17b991f-b320-4264-bd9c-74e7c0b6670e.jpg","name":"众人看世界杯，我来送大红包","pubDate":"2018-06-13 21:01:45","type":0},{"detail":"","href":"https://blog.gitee.com/2018/06/19/gitee_education/","id":96979,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_7c7980f0-8692-4c4f-b20e-90a9287724eb.png","name":"码云高校版全新上线","pubDate":"2018-06-22 10:56:48","type":0},{"detail":"","href":"https://www.oschina.net/question/2720166_2281819","id":2281819,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_b5158e2e-5f3d-4717-867a-c8cb9e7198d7.jpg","name":"从 Python 网络爬虫开始玩转 Python","pubDate":"2018-06-20 14:35:49","type":2},{"detail":"","href":"https://www.oschina.net/news/97369/new-java-se-subscription","id":97369,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_3c4e5d08-da18-48c6-9fb6-286c52d8f887.jpg","name":"新Java SE订阅模式，为企业提供更广泛支持","pubDate":"2018-06-25 11:12:59","type":6}],"nextPageToken":"61AF0C190D6BD629","prevPageToken":"3EA621243546C8A5","requestCount":5,"responseCount":5,"totalResults":5}
     * time : 2018-06-25 21:42:50
     */

    private int code;
    private String message;
    private NoticeBean notice;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoticeBean getNotice() {
        return notice;
    }

    public void setNotice(NoticeBean notice) {
        this.notice = notice;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List getItemDatas() {
        return result.items;
    }

    public static class NoticeBean {
        /**
         * newsCount : 32
         */

        private int newsCount;

        public int getNewsCount() {
            return newsCount;
        }

        public void setNewsCount(int newsCount) {
            this.newsCount = newsCount;
        }
    }

    public static class ResultBean {
        /**
         * items : [{"detail":"","href":"https://www.oschina.net/news/97344/app-20180623","id":97344,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_981a37bd-ac6b-44d4-89f0-f5f7f86a943e.jpg","name":"嘿哥们，全国最大的\u201c同性交友\u201dAPP了解一下？","pubDate":"2018-06-25 10:51:57","type":6},{"detail":"","href":"https://zb.oschina.net/activity/world-cup/index.html?from=osc&b=3&c=app","id":96769,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_d17b991f-b320-4264-bd9c-74e7c0b6670e.jpg","name":"众人看世界杯，我来送大红包","pubDate":"2018-06-13 21:01:45","type":0},{"detail":"","href":"https://blog.gitee.com/2018/06/19/gitee_education/","id":96979,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_7c7980f0-8692-4c4f-b20e-90a9287724eb.png","name":"码云高校版全新上线","pubDate":"2018-06-22 10:56:48","type":0},{"detail":"","href":"https://www.oschina.net/question/2720166_2281819","id":2281819,"img":"https://static.oschina.net/uploads/cooperation/77929/top-income-programming-languages-2016_b5158e2e-5f3d-4717-867a-c8cb9e7198d7.jpg","name":"从 Python 网络爬虫开始玩转 Python","pubDate":"2018-06-20 14:35:49","type":2},{"detail":"","href":"https://www.oschina.net/news/97369/new-java-se-subscription","id":97369,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_3c4e5d08-da18-48c6-9fb6-286c52d8f887.jpg","name":"新Java SE订阅模式，为企业提供更广泛支持","pubDate":"2018-06-25 11:12:59","type":6}]
         * nextPageToken : 61AF0C190D6BD629
         * prevPageToken : 3EA621243546C8A5
         * requestCount : 5
         * responseCount : 5
         * totalResults : 5
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * detail :
             * href : https://www.oschina.net/news/97344/app-20180623
             * id : 97344
             * img : https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_981a37bd-ac6b-44d4-89f0-f5f7f86a943e.jpg
             * name : 嘿哥们，全国最大的“同性交友”APP了解一下？
             * pubDate : 2018-06-25 10:51:57
             * type : 6
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
