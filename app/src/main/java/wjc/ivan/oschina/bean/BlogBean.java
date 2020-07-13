package wjc.ivan.oschina.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by 龙心诚 on 2018/6/25 0025.
 */

public class BlogBean extends BasePageBean<BlogBean.ResultBean.ItemsBean>{
    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"Java架构资源分享","body":"1、什么是 Spring 框架？Spring 框架有哪些主要模块？ Spring 框架是一个...","commentCount":0,"href":"https://my.oschina.net/u/3779583/blog/1835233","id":1835233,"original":true,"pubDate":"2018-06-25 17:04:28","recommend":true,"title":"Spring面试底层原理的那些问题，你是不是真的懂Spring？","type":3,"viewCount":3},{"author":"美团技术团队","body":"\u201c道生一，一生二，二生三，三生万物。\u201d \u2014\u2014 《道德经》\n Picasso是大...","commentCount":1,"href":"https://my.oschina.net/meituantech/blog/1835230","id":1835230,"original":true,"pubDate":"2018-06-25 17:03:03","recommend":true,"title":"Picasso：开启大前端的未来","type":3,"viewCount":2},{"author":"gfjjfuy112","body":"在之前我已经写了一篇关于线性回归的文章,今天给大家带来另一个重要的回...","commentCount":0,"href":"https://my.oschina.net/u/3894256/blog/1835203","id":1835203,"original":true,"pubDate":"2018-06-25 16:15:36","recommend":false,"title":"Logistic回归","type":3,"viewCount":0},{"author":"James-","body":"1 基本概念和目的   架构设计的目的是为了解决系统复杂度带来的问题，并...","commentCount":1,"href":"https://my.oschina.net/u/3833719/blog/1835201","id":1835201,"original":true,"pubDate":"2018-06-25 16:13:52","recommend":true,"title":"架构设计之初体验，送给准备进阶架构的朋友（个人总结）","type":3,"viewCount":80},{"author":"JackJiang-","body":"本文由腾讯云技术团队原创，感谢作者的分享。 1、前言 微信小程序提供了...","commentCount":0,"href":"https://my.oschina.net/jb2011/blog/1835180","id":1835180,"original":true,"pubDate":"2018-06-25 15:46:12","recommend":true,"title":"微信小程序中如何使用WebSocket实现长连接(含完整源码)","type":3,"viewCount":2},{"author":"bodasisiter","body":"        一、准备工作     üTurnipBit 开发板 一块     ü下载...","commentCount":0,"href":"https://my.oschina.net/micropython/blog/1835159","id":1835159,"original":true,"pubDate":"2018-06-25 15:33:01","recommend":false,"title":"MicroPython开发实例之TurniBit开发板DIY自动窗帘模拟系统","type":3,"viewCount":0},{"author":"海岸线的曙光","body":"    Flume是一个分布式、可靠、和高可用的海量日志采集、聚合和传输的...","commentCount":0,"href":"https://my.oschina.net/u/3747963/blog/1834981","id":1834981,"original":true,"pubDate":"2018-06-25 10:41:35","recommend":false,"title":"Flume日志收集之Logger和HDFS数据传输方式","type":3,"viewCount":0},{"author":"三人行gogogo","body":"一、什么是eSIM     eSIM即Embedded-SIM,嵌入式SIM卡.即将传统通信中可...","commentCount":0,"href":"https://my.oschina.net/u/3893784/blog/1834974","id":1834974,"original":true,"pubDate":"2018-06-25 10:30:22","recommend":true,"title":"eSIM、RSP模式的证书体系","type":3,"viewCount":10},{"author":"喵了_个咪","body":"对一个公司来说安全也是最为重要的因为可能一旦出现安全问题可能这个公司...","commentCount":0,"href":"https://my.oschina.net/wenzhenxi/blog/1834958","id":1834958,"original":true,"pubDate":"2018-06-25 10:15:57","recommend":false,"title":"Kubernetes(六) - Secret和私有仓库认证","type":3,"viewCount":1},{"author":"冷冷gg","body":"背景 6.19号，spring团队发布了期待已久的 Spring Cloud Finchley.RELE...","commentCount":4,"href":"https://my.oschina.net/giegie/blog/1834899","id":1834899,"original":true,"pubDate":"2018-06-25 07:55:48","recommend":true,"title":"oAuth2 升级Spring Cloud Finchley.RELEASE踩坑分享 ","type":3,"viewCount":1376},{"author":"特拉仔","body":"偏移量由消费者管理 \u200bkafka Consumer Api还提供了自己存储offset的功能...","commentCount":0,"href":"https://my.oschina.net/u/3049601/blog/1834897","id":1834897,"original":true,"pubDate":"2018-06-25 07:21:24","recommend":true,"title":"Kafka1.0.X_消费者API详解2","type":3,"viewCount":39},{"author":"特拉仔","body":"kafka的消费者API提供从kafka服务端拉取消息的能力，kafka引入了消费者组...","commentCount":0,"href":"https://my.oschina.net/u/3049601/blog/1834896","id":1834896,"original":true,"pubDate":"2018-06-25 07:17:30","recommend":true,"title":"Kafka1.0.X_消费者API详解1","type":3,"viewCount":30},{"author":"特拉仔","body":"Producer是Kafka三大组件中的一个，用于发送消息到kafka集群中 Producer...","commentCount":1,"href":"https://my.oschina.net/u/3049601/blog/1834895","id":1834895,"original":true,"pubDate":"2018-06-25 06:43:23","recommend":true,"title":"Kafka1.0.X_生产者API详解","type":3,"viewCount":96},{"author":"雕刻零碎","body":"flux架构，是我理解错了吗？ 笔者原意是希望能通过阅读redux文档和其源码...","commentCount":2,"href":"https://my.oschina.net/reamd7/blog/1834892","id":1834892,"original":true,"pubDate":"2018-06-25 01:25:18","recommend":true,"title":"flux架构，是我理解错了吗？记一次用ts造flux轮子的经历。","type":3,"viewCount":46},{"author":"Ujued","body":"极客必玩 用Java写后台的都知道不论使用什么框架，都是遵守Servlet标准的...","commentCount":0,"href":"https://my.oschina.net/u/3343049/blog/1834860","id":1834860,"original":true,"pubDate":"2018-06-24 23:01:33","recommend":true,"title":"极客必玩的 Quick Server 是什么？","type":3,"viewCount":75},{"author":"NDweb","body":"webpack 最近升级到了 v4.5+版 01 官方不再支持 node4 以下版本 官方不再...","commentCount":0,"href":"https://my.oschina.net/ndweb/blog/1834794","id":1834794,"original":false,"pubDate":"2018-06-24 18:25:48","recommend":true,"title":"Webpack 4 api 了解与使用","type":3,"viewCount":95},{"author":"xpbob","body":"生产环境最多的几种事故之一就是程序执行慢，如果是web服务的话，表现就...","commentCount":0,"href":"https://my.oschina.net/xpbob/blog/1834764","id":1834764,"original":true,"pubDate":"2018-06-24 16:23:37","recommend":true,"title":"jvm程序执行慢诊断手册","type":3,"viewCount":189},{"author":"笔阁","body":"web3j简介 web3j是一个轻量级、高度模块化、响应式、类型安全的Java和A...","commentCount":0,"href":"https://my.oschina.net/u/2275217/blog/1834730","id":1834730,"original":true,"pubDate":"2018-06-24 14:18:02","recommend":true,"title":"web3j开发java或android以太坊智能合约快速入门","type":3,"viewCount":45},{"author":"申文波","body":"CyclicBarrier、CountDownLatch以及Semaphore是Java并发包中几个常用的并...","commentCount":0,"href":"https://my.oschina.net/wenbo123/blog/1834618","id":1834618,"original":true,"pubDate":"2018-06-23 22:34:36","recommend":true,"title":"CyclicBarrier、CountDownLatch以及Semaphore使用及其原理分析","type":3,"viewCount":108},{"author":"丛力夫","body":"先想说明一点，虽然有这样那样的不好的心态(比如中文技术书)，但总体来说...","commentCount":0,"href":"https://my.oschina.net/u/3227483/blog/1834571","id":1834571,"original":false,"pubDate":"2018-06-23 19:39:47","recommend":true,"title":"浅谈C#中闭包","type":3,"viewCount":125}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":1000}
     * time : 2018-06-25 23:00:05
     */

    private int code;
    private String message;
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

    public static class ResultBean {
        /**
         * items : [{"author":"Java架构资源分享","body":"1、什么是 Spring 框架？Spring 框架有哪些主要模块？ Spring 框架是一个...","commentCount":0,"href":"https://my.oschina.net/u/3779583/blog/1835233","id":1835233,"original":true,"pubDate":"2018-06-25 17:04:28","recommend":true,"title":"Spring面试底层原理的那些问题，你是不是真的懂Spring？","type":3,"viewCount":3},{"author":"美团技术团队","body":"\u201c道生一，一生二，二生三，三生万物。\u201d \u2014\u2014 《道德经》\n Picasso是大...","commentCount":1,"href":"https://my.oschina.net/meituantech/blog/1835230","id":1835230,"original":true,"pubDate":"2018-06-25 17:03:03","recommend":true,"title":"Picasso：开启大前端的未来","type":3,"viewCount":2},{"author":"gfjjfuy112","body":"在之前我已经写了一篇关于线性回归的文章,今天给大家带来另一个重要的回...","commentCount":0,"href":"https://my.oschina.net/u/3894256/blog/1835203","id":1835203,"original":true,"pubDate":"2018-06-25 16:15:36","recommend":false,"title":"Logistic回归","type":3,"viewCount":0},{"author":"James-","body":"1 基本概念和目的   架构设计的目的是为了解决系统复杂度带来的问题，并...","commentCount":1,"href":"https://my.oschina.net/u/3833719/blog/1835201","id":1835201,"original":true,"pubDate":"2018-06-25 16:13:52","recommend":true,"title":"架构设计之初体验，送给准备进阶架构的朋友（个人总结）","type":3,"viewCount":80},{"author":"JackJiang-","body":"本文由腾讯云技术团队原创，感谢作者的分享。 1、前言 微信小程序提供了...","commentCount":0,"href":"https://my.oschina.net/jb2011/blog/1835180","id":1835180,"original":true,"pubDate":"2018-06-25 15:46:12","recommend":true,"title":"微信小程序中如何使用WebSocket实现长连接(含完整源码)","type":3,"viewCount":2},{"author":"bodasisiter","body":"        一、准备工作     üTurnipBit 开发板 一块     ü下载...","commentCount":0,"href":"https://my.oschina.net/micropython/blog/1835159","id":1835159,"original":true,"pubDate":"2018-06-25 15:33:01","recommend":false,"title":"MicroPython开发实例之TurniBit开发板DIY自动窗帘模拟系统","type":3,"viewCount":0},{"author":"海岸线的曙光","body":"    Flume是一个分布式、可靠、和高可用的海量日志采集、聚合和传输的...","commentCount":0,"href":"https://my.oschina.net/u/3747963/blog/1834981","id":1834981,"original":true,"pubDate":"2018-06-25 10:41:35","recommend":false,"title":"Flume日志收集之Logger和HDFS数据传输方式","type":3,"viewCount":0},{"author":"三人行gogogo","body":"一、什么是eSIM     eSIM即Embedded-SIM,嵌入式SIM卡.即将传统通信中可...","commentCount":0,"href":"https://my.oschina.net/u/3893784/blog/1834974","id":1834974,"original":true,"pubDate":"2018-06-25 10:30:22","recommend":true,"title":"eSIM、RSP模式的证书体系","type":3,"viewCount":10},{"author":"喵了_个咪","body":"对一个公司来说安全也是最为重要的因为可能一旦出现安全问题可能这个公司...","commentCount":0,"href":"https://my.oschina.net/wenzhenxi/blog/1834958","id":1834958,"original":true,"pubDate":"2018-06-25 10:15:57","recommend":false,"title":"Kubernetes(六) - Secret和私有仓库认证","type":3,"viewCount":1},{"author":"冷冷gg","body":"背景 6.19号，spring团队发布了期待已久的 Spring Cloud Finchley.RELE...","commentCount":4,"href":"https://my.oschina.net/giegie/blog/1834899","id":1834899,"original":true,"pubDate":"2018-06-25 07:55:48","recommend":true,"title":"oAuth2 升级Spring Cloud Finchley.RELEASE踩坑分享 ","type":3,"viewCount":1376},{"author":"特拉仔","body":"偏移量由消费者管理 \u200bkafka Consumer Api还提供了自己存储offset的功能...","commentCount":0,"href":"https://my.oschina.net/u/3049601/blog/1834897","id":1834897,"original":true,"pubDate":"2018-06-25 07:21:24","recommend":true,"title":"Kafka1.0.X_消费者API详解2","type":3,"viewCount":39},{"author":"特拉仔","body":"kafka的消费者API提供从kafka服务端拉取消息的能力，kafka引入了消费者组...","commentCount":0,"href":"https://my.oschina.net/u/3049601/blog/1834896","id":1834896,"original":true,"pubDate":"2018-06-25 07:17:30","recommend":true,"title":"Kafka1.0.X_消费者API详解1","type":3,"viewCount":30},{"author":"特拉仔","body":"Producer是Kafka三大组件中的一个，用于发送消息到kafka集群中 Producer...","commentCount":1,"href":"https://my.oschina.net/u/3049601/blog/1834895","id":1834895,"original":true,"pubDate":"2018-06-25 06:43:23","recommend":true,"title":"Kafka1.0.X_生产者API详解","type":3,"viewCount":96},{"author":"雕刻零碎","body":"flux架构，是我理解错了吗？ 笔者原意是希望能通过阅读redux文档和其源码...","commentCount":2,"href":"https://my.oschina.net/reamd7/blog/1834892","id":1834892,"original":true,"pubDate":"2018-06-25 01:25:18","recommend":true,"title":"flux架构，是我理解错了吗？记一次用ts造flux轮子的经历。","type":3,"viewCount":46},{"author":"Ujued","body":"极客必玩 用Java写后台的都知道不论使用什么框架，都是遵守Servlet标准的...","commentCount":0,"href":"https://my.oschina.net/u/3343049/blog/1834860","id":1834860,"original":true,"pubDate":"2018-06-24 23:01:33","recommend":true,"title":"极客必玩的 Quick Server 是什么？","type":3,"viewCount":75},{"author":"NDweb","body":"webpack 最近升级到了 v4.5+版 01 官方不再支持 node4 以下版本 官方不再...","commentCount":0,"href":"https://my.oschina.net/ndweb/blog/1834794","id":1834794,"original":false,"pubDate":"2018-06-24 18:25:48","recommend":true,"title":"Webpack 4 api 了解与使用","type":3,"viewCount":95},{"author":"xpbob","body":"生产环境最多的几种事故之一就是程序执行慢，如果是web服务的话，表现就...","commentCount":0,"href":"https://my.oschina.net/xpbob/blog/1834764","id":1834764,"original":true,"pubDate":"2018-06-24 16:23:37","recommend":true,"title":"jvm程序执行慢诊断手册","type":3,"viewCount":189},{"author":"笔阁","body":"web3j简介 web3j是一个轻量级、高度模块化、响应式、类型安全的Java和A...","commentCount":0,"href":"https://my.oschina.net/u/2275217/blog/1834730","id":1834730,"original":true,"pubDate":"2018-06-24 14:18:02","recommend":true,"title":"web3j开发java或android以太坊智能合约快速入门","type":3,"viewCount":45},{"author":"申文波","body":"CyclicBarrier、CountDownLatch以及Semaphore是Java并发包中几个常用的并...","commentCount":0,"href":"https://my.oschina.net/wenbo123/blog/1834618","id":1834618,"original":true,"pubDate":"2018-06-23 22:34:36","recommend":true,"title":"CyclicBarrier、CountDownLatch以及Semaphore使用及其原理分析","type":3,"viewCount":108},{"author":"丛力夫","body":"先想说明一点，虽然有这样那样的不好的心态(比如中文技术书)，但总体来说...","commentCount":0,"href":"https://my.oschina.net/u/3227483/blog/1834571","id":1834571,"original":false,"pubDate":"2018-06-23 19:39:47","recommend":true,"title":"浅谈C#中闭包","type":3,"viewCount":125}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 1000
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
             * author : Java架构资源分享
             * body : 1、什么是 Spring 框架？Spring 框架有哪些主要模块？ Spring 框架是一个...
             * commentCount : 0
             * href : https://my.oschina.net/u/3779583/blog/1835233
             * id : 1835233
             * original : true
             * pubDate : 2018-06-25 17:04:28
             * recommend : true
             * title : Spring面试底层原理的那些问题，你是不是真的懂Spring？
             * type : 3
             * viewCount : 3
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
            private boolean original;
            private String pubDate;
            private boolean recommend;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
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

            public boolean isOriginal() {
                return original;
            }

            public void setOriginal(boolean original) {
                this.original = original;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
