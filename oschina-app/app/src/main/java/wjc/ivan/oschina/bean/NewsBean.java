package wjc.ivan.oschina.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by 龙心诚 on 2018/6/25 0025.
 */

public class NewsBean extends BasePageBean<NewsBean.ResultBean.ItemsBean>{

    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"淡漠悠然","body":"DataTables 1.10.19 已发布，DataTables 是一个 jQuery 的表格插件。这是一个高度灵活的工具，依据的基础逐步增强，这将增加先进的互动控制，支持任...","commentCount":0,"href":"https://www.oschina.net/news/97409/datatables-11019-released","id":97409,"pubDate":"2018-06-25 17:20:27","recommend":true,"title":"DataTables 1.10.19 发布，jQuery 表格插件","type":6,"viewCount":302},{"author":"八一菜刀","body":"oss-server 1.1 正式发布了。oss-server 是针对项目开发时提供的小型对象存储系统，开发者在针对文件上传时业务剥离，同时方便文件迁移，为满足单个...","commentCount":5,"href":"https://www.oschina.net/news/97408/oss-server-1-1-released","id":97408,"pubDate":"2018-06-25 16:38:45","recommend":true,"title":"oss-server 1.1 版本发布，小型对象存储系统","type":6,"viewCount":242},{"author":"淡漠悠然","body":"Keepalived 2.0.4 已发布，Keepalived 是一款用 C 编写的路由软件。该项目的主要目标是为 Linux 系统和基于 Linux 的基础设备提供简单而强大的负载...","commentCount":3,"href":"https://www.oschina.net/news/97407/keepalived-2-0-4-released","id":97407,"pubDate":"2018-06-25 16:21:41","recommend":true,"title":"Keepalived 2.0.4 发布，C 语言编写的路由软件","type":6,"viewCount":304},{"author":"淡漠悠然","body":"ZXing 3.3.3 已发布，ZXing 是一个开源 Java 类库，可用于解析多种格式的 1D/2D 条形码。目标是能够对 QR 编码、Data Matrix、UPC 的 1D 条形码进行...","commentCount":2,"href":"https://www.oschina.net/news/97406/zxing-3-3-3-released","id":97406,"pubDate":"2018-06-25 15:50:02","recommend":true,"title":"条形码处理类库 ZXing 3.3.3 发布，支持 Java 9","type":6,"viewCount":277},{"author":"宇润","body":"更新内容 * 框架依赖更新：php >= 7.1 + swoole >= 4.0.0 （之前为 php 7.0 + swoole 2.2.0） * 新增 Redis 模型 * 新增双驼峰转换方法 * 新增文...","commentCount":4,"href":"https://www.oschina.net/news/97404/imi-0-0-2-released","id":97404,"pubDate":"2018-06-25 14:26:17","recommend":true,"title":"IMI v0.0.2 支持 PHP 7.0 + Swoole 4.0，引入 Redis 模型","type":6,"viewCount":400},{"author":"Newbe36524","body":"开篇一张图，功能全靠编。         QQ机器人平台意指那些支持通过QQ进行消息收发和群员软件平台。         使用该SDK开发可以实现一次开发...","commentCount":1,"href":"https://www.oschina.net/news/97402/newbe-mahua-1-10-released","id":97402,"pubDate":"2018-06-25 12:49:49","recommend":false,"title":"QQ 机器人平台 Newbe.Mahua 1.10，Amanda 新时代","type":6,"viewCount":752},{"author":"王练","body":"6月25日， LC3（LinuxCon + ContainerCon + CloudOpen）2018 大会在北京开幕，会上，Linux 基金会宣布腾讯成为基金会的最新白金会员，同时腾讯也宣...","commentCount":26,"href":"https://www.oschina.net/news/97401/tecent-and-linux-foundationlinux","id":97401,"pubDate":"2018-06-25 12:29:50","recommend":false,"title":"腾讯成为 Linux 基金会白金会员，贡献两大自研项目","type":6,"viewCount":2842},{"author":"GoodERP","body":"2018/06/18~ 2018/06/24 goods 模块 [优化] 商品上添加 不可采购 字段，如果为真，该商品将不可采购； [修复] 商品成本小数点位数BUG修复。 sell 模...","commentCount":0,"href":"https://www.oschina.net/news/97400/gooderp-18-26-released","id":97400,"pubDate":"2018-06-25 11:46:21","recommend":false,"title":"GoodERP 18.26 发布，开源企业管理软件","type":6,"viewCount":596},{"author":"ruki","body":"xmake-vscode插件深度集成了xmake和vscode，提供方便快速的跨平台c/c++构建。 最近xmake新版本新增了 Qt/WDK编译环境支持，因此对vscode的集成插件...","commentCount":3,"href":"https://www.oschina.net/news/97397/xmake-vscode-1-0-8-released","id":97397,"pubDate":"2018-06-25 09:35:30","recommend":false,"title":"xmake-vscode v1.0.8，在 VSCode 中构建 Qt/WDK 程序","type":6,"viewCount":868},{"author":"actionview","body":"ActionView 1.4.0 新版本已发布，新版本做了以下内容的更新： 支持基于LDAP用户的同步和认证； 用户列表的检索支持用户目录筛选； 用户组列表的检索...","commentCount":1,"href":"https://www.oschina.net/news/97396/actionview-1-4-0-released","id":97396,"pubDate":"2018-06-25 09:33:33","recommend":false,"title":"ActionView 1.4.0 发布，类 Jira 问题需求跟踪工具","type":6,"viewCount":558},{"author":"独孤求胜16","body":"renren-fast是一个轻量级的Spring Boot2.0快速开发平台，其设计目标是开发迅速、学习简单、轻量级、易扩展；使用Spring Boot、Shiro、MyBatis、Red...","commentCount":6,"href":"https://www.oschina.net/news/97395/renren-fast-2-1-released","id":97395,"pubDate":"2018-06-25 08:55:09","recommend":false,"title":"renren-fast 2.1 发布，前后端完全分离","type":6,"viewCount":1557},{"author":"三刀蜀黍","body":"smart-socket是一款国产开源的Java AIO框架，追求代码量、性能、稳定性、接口设计各方面都达到极致。如果smart-socket对您有一丝帮助，请Star一下我...","commentCount":1,"href":"https://www.oschina.net/news/97394/smart-socket-1-3-12-released","id":97394,"pubDate":"2018-06-25 08:47:59","recommend":false,"title":"smart-socket v1.3.12 发布，bug 修复版","type":6,"viewCount":382},{"author":"达尔文","body":"Spring 团队发布了期待已久的 Spring Cloud Finchley.RELEASE 版本。期间踩过几个坑，分享出来给大伙，主要是关于 Spring Cloud oAuth 部分...","commentCount":4,"href":"https://my.oschina.net/giegie/blog/1834899","id":1834899,"pubDate":"2018-06-25 08:14:03","recommend":false,"title":"每日一博 | oAuth2 升级 Spring Cloud Finchley 踩坑记","type":3,"viewCount":1375},{"author":"达尔文","body":"本文详细描述了被称为并发标记的垃圾回收技术。该优化允许 JavaScript 应用在垃圾回收器扫描其堆以查找和标记活动对象时可继续执行。","commentCount":0,"href":"https://www.oschina.net/translate/v8-javascript-engine","id":10004328,"pubDate":"2018-06-25 08:13:16","recommend":false,"title":"协作翻译 | 深入解读 V8 引擎的「并发标记」技术","type":4,"viewCount":1344},{"author":"达尔文","body":"Packt 发布了 2018 年技能提升报告的结果，旨在了解软件开发人员的工具使用情况和技能趋势。报告显示，Java 在编程语言中仍然占据主导地位，但 Ko...","commentCount":15,"href":"https://www.oschina.net/news/97390/2018-skill-up","id":97390,"pubDate":"2018-06-25 08:08:29","recommend":false,"title":"2018 年技能提升报告：Kotlin 已对 Java 构成威胁？","type":6,"viewCount":3640},{"author":"达尔文","body":"Google 希望在其即将推出的 Android P 中改进生物识别技术。该公司宣布开发人员可以开始使用 BiometricPrompt API 将生物识别身份验证集成到他们的...","commentCount":2,"href":"https://www.oschina.net/news/97389/google-introduces-new-api-for-android-p","id":97389,"pubDate":"2018-06-25 08:06:17","recommend":false,"title":"Google 为 Android P 引入新的生物识别身份验证 API","type":6,"viewCount":935},{"author":"达尔文","body":"Vue 写的一个小说应用（请用 Chrome 手机模式预览）","commentCount":0,"href":"https://gitee.com/hongjiapei/vue-novel","id":97388,"pubDate":"2018-06-25 08:02:17","recommend":false,"title":"码云推荐 | 用 Vue 编写的小说应用 vue-novel ","type":0,"viewCount":5},{"author":"达尔文","body":"基于 Google Flutter 的开源中国客户端，支持 Android 与 iOS。独创的动弹小黑屋功能，可屏蔽你不想看的人发的动弹。","commentCount":1,"href":"https://www.oschina.net/p/flutterosc","id":47430,"pubDate":"2018-06-25 08:02:07","recommend":false,"title":"FlutterOSC \u2014\u2014 基于 Flutter 开发的开源中国客户端","type":1,"viewCount":1712},{"author":"达尔文","body":"Salesforce研究院（Salesforce Research）创建的自然语言处理架构可以处理多种模型和任务。在通常情况下，自然语言处理（NLP）针对每种功能（如翻译...","commentCount":0,"href":"https://www.oschina.net/news/97386/salesforce-research-aims-to-capture-the-nuances","id":97386,"pubDate":"2018-06-25 07:55:54","recommend":false,"title":"Salesforce 开发了一个处理不同 NLP 任务的通用模型","type":6,"viewCount":537},{"author":"达尔文","body":"一个人吃饭才好啊 ，没人跟我抢菜啊","commentCount":21,"href":"https://my.oschina.net/xxiaobian/blog/1834898","id":1834898,"pubDate":"2018-06-25 07:55:05","recommend":false,"title":"OSChina 周一乱弹 \u2014\u2014 理发师小姐姐的魔法","type":3,"viewCount":2057}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":89535}
     * time : 2018-06-25 19:05:02
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
         * items : [{"author":"淡漠悠然","body":"DataTables 1.10.19 已发布，DataTables 是一个 jQuery 的表格插件。这是一个高度灵活的工具，依据的基础逐步增强，这将增加先进的互动控制，支持任...","commentCount":0,"href":"https://www.oschina.net/news/97409/datatables-11019-released","id":97409,"pubDate":"2018-06-25 17:20:27","recommend":true,"title":"DataTables 1.10.19 发布，jQuery 表格插件","type":6,"viewCount":302},{"author":"八一菜刀","body":"oss-server 1.1 正式发布了。oss-server 是针对项目开发时提供的小型对象存储系统，开发者在针对文件上传时业务剥离，同时方便文件迁移，为满足单个...","commentCount":5,"href":"https://www.oschina.net/news/97408/oss-server-1-1-released","id":97408,"pubDate":"2018-06-25 16:38:45","recommend":true,"title":"oss-server 1.1 版本发布，小型对象存储系统","type":6,"viewCount":242},{"author":"淡漠悠然","body":"Keepalived 2.0.4 已发布，Keepalived 是一款用 C 编写的路由软件。该项目的主要目标是为 Linux 系统和基于 Linux 的基础设备提供简单而强大的负载...","commentCount":3,"href":"https://www.oschina.net/news/97407/keepalived-2-0-4-released","id":97407,"pubDate":"2018-06-25 16:21:41","recommend":true,"title":"Keepalived 2.0.4 发布，C 语言编写的路由软件","type":6,"viewCount":304},{"author":"淡漠悠然","body":"ZXing 3.3.3 已发布，ZXing 是一个开源 Java 类库，可用于解析多种格式的 1D/2D 条形码。目标是能够对 QR 编码、Data Matrix、UPC 的 1D 条形码进行...","commentCount":2,"href":"https://www.oschina.net/news/97406/zxing-3-3-3-released","id":97406,"pubDate":"2018-06-25 15:50:02","recommend":true,"title":"条形码处理类库 ZXing 3.3.3 发布，支持 Java 9","type":6,"viewCount":277},{"author":"宇润","body":"更新内容 * 框架依赖更新：php >= 7.1 + swoole >= 4.0.0 （之前为 php 7.0 + swoole 2.2.0） * 新增 Redis 模型 * 新增双驼峰转换方法 * 新增文...","commentCount":4,"href":"https://www.oschina.net/news/97404/imi-0-0-2-released","id":97404,"pubDate":"2018-06-25 14:26:17","recommend":true,"title":"IMI v0.0.2 支持 PHP 7.0 + Swoole 4.0，引入 Redis 模型","type":6,"viewCount":400},{"author":"Newbe36524","body":"开篇一张图，功能全靠编。         QQ机器人平台意指那些支持通过QQ进行消息收发和群员软件平台。         使用该SDK开发可以实现一次开发...","commentCount":1,"href":"https://www.oschina.net/news/97402/newbe-mahua-1-10-released","id":97402,"pubDate":"2018-06-25 12:49:49","recommend":false,"title":"QQ 机器人平台 Newbe.Mahua 1.10，Amanda 新时代","type":6,"viewCount":752},{"author":"王练","body":"6月25日， LC3（LinuxCon + ContainerCon + CloudOpen）2018 大会在北京开幕，会上，Linux 基金会宣布腾讯成为基金会的最新白金会员，同时腾讯也宣...","commentCount":26,"href":"https://www.oschina.net/news/97401/tecent-and-linux-foundationlinux","id":97401,"pubDate":"2018-06-25 12:29:50","recommend":false,"title":"腾讯成为 Linux 基金会白金会员，贡献两大自研项目","type":6,"viewCount":2842},{"author":"GoodERP","body":"2018/06/18~ 2018/06/24 goods 模块 [优化] 商品上添加 不可采购 字段，如果为真，该商品将不可采购； [修复] 商品成本小数点位数BUG修复。 sell 模...","commentCount":0,"href":"https://www.oschina.net/news/97400/gooderp-18-26-released","id":97400,"pubDate":"2018-06-25 11:46:21","recommend":false,"title":"GoodERP 18.26 发布，开源企业管理软件","type":6,"viewCount":596},{"author":"ruki","body":"xmake-vscode插件深度集成了xmake和vscode，提供方便快速的跨平台c/c++构建。 最近xmake新版本新增了 Qt/WDK编译环境支持，因此对vscode的集成插件...","commentCount":3,"href":"https://www.oschina.net/news/97397/xmake-vscode-1-0-8-released","id":97397,"pubDate":"2018-06-25 09:35:30","recommend":false,"title":"xmake-vscode v1.0.8，在 VSCode 中构建 Qt/WDK 程序","type":6,"viewCount":868},{"author":"actionview","body":"ActionView 1.4.0 新版本已发布，新版本做了以下内容的更新： 支持基于LDAP用户的同步和认证； 用户列表的检索支持用户目录筛选； 用户组列表的检索...","commentCount":1,"href":"https://www.oschina.net/news/97396/actionview-1-4-0-released","id":97396,"pubDate":"2018-06-25 09:33:33","recommend":false,"title":"ActionView 1.4.0 发布，类 Jira 问题需求跟踪工具","type":6,"viewCount":558},{"author":"独孤求胜16","body":"renren-fast是一个轻量级的Spring Boot2.0快速开发平台，其设计目标是开发迅速、学习简单、轻量级、易扩展；使用Spring Boot、Shiro、MyBatis、Red...","commentCount":6,"href":"https://www.oschina.net/news/97395/renren-fast-2-1-released","id":97395,"pubDate":"2018-06-25 08:55:09","recommend":false,"title":"renren-fast 2.1 发布，前后端完全分离","type":6,"viewCount":1557},{"author":"三刀蜀黍","body":"smart-socket是一款国产开源的Java AIO框架，追求代码量、性能、稳定性、接口设计各方面都达到极致。如果smart-socket对您有一丝帮助，请Star一下我...","commentCount":1,"href":"https://www.oschina.net/news/97394/smart-socket-1-3-12-released","id":97394,"pubDate":"2018-06-25 08:47:59","recommend":false,"title":"smart-socket v1.3.12 发布，bug 修复版","type":6,"viewCount":382},{"author":"达尔文","body":"Spring 团队发布了期待已久的 Spring Cloud Finchley.RELEASE 版本。期间踩过几个坑，分享出来给大伙，主要是关于 Spring Cloud oAuth 部分...","commentCount":4,"href":"https://my.oschina.net/giegie/blog/1834899","id":1834899,"pubDate":"2018-06-25 08:14:03","recommend":false,"title":"每日一博 | oAuth2 升级 Spring Cloud Finchley 踩坑记","type":3,"viewCount":1375},{"author":"达尔文","body":"本文详细描述了被称为并发标记的垃圾回收技术。该优化允许 JavaScript 应用在垃圾回收器扫描其堆以查找和标记活动对象时可继续执行。","commentCount":0,"href":"https://www.oschina.net/translate/v8-javascript-engine","id":10004328,"pubDate":"2018-06-25 08:13:16","recommend":false,"title":"协作翻译 | 深入解读 V8 引擎的「并发标记」技术","type":4,"viewCount":1344},{"author":"达尔文","body":"Packt 发布了 2018 年技能提升报告的结果，旨在了解软件开发人员的工具使用情况和技能趋势。报告显示，Java 在编程语言中仍然占据主导地位，但 Ko...","commentCount":15,"href":"https://www.oschina.net/news/97390/2018-skill-up","id":97390,"pubDate":"2018-06-25 08:08:29","recommend":false,"title":"2018 年技能提升报告：Kotlin 已对 Java 构成威胁？","type":6,"viewCount":3640},{"author":"达尔文","body":"Google 希望在其即将推出的 Android P 中改进生物识别技术。该公司宣布开发人员可以开始使用 BiometricPrompt API 将生物识别身份验证集成到他们的...","commentCount":2,"href":"https://www.oschina.net/news/97389/google-introduces-new-api-for-android-p","id":97389,"pubDate":"2018-06-25 08:06:17","recommend":false,"title":"Google 为 Android P 引入新的生物识别身份验证 API","type":6,"viewCount":935},{"author":"达尔文","body":"Vue 写的一个小说应用（请用 Chrome 手机模式预览）","commentCount":0,"href":"https://gitee.com/hongjiapei/vue-novel","id":97388,"pubDate":"2018-06-25 08:02:17","recommend":false,"title":"码云推荐 | 用 Vue 编写的小说应用 vue-novel ","type":0,"viewCount":5},{"author":"达尔文","body":"基于 Google Flutter 的开源中国客户端，支持 Android 与 iOS。独创的动弹小黑屋功能，可屏蔽你不想看的人发的动弹。","commentCount":1,"href":"https://www.oschina.net/p/flutterosc","id":47430,"pubDate":"2018-06-25 08:02:07","recommend":false,"title":"FlutterOSC \u2014\u2014 基于 Flutter 开发的开源中国客户端","type":1,"viewCount":1712},{"author":"达尔文","body":"Salesforce研究院（Salesforce Research）创建的自然语言处理架构可以处理多种模型和任务。在通常情况下，自然语言处理（NLP）针对每种功能（如翻译...","commentCount":0,"href":"https://www.oschina.net/news/97386/salesforce-research-aims-to-capture-the-nuances","id":97386,"pubDate":"2018-06-25 07:55:54","recommend":false,"title":"Salesforce 开发了一个处理不同 NLP 任务的通用模型","type":6,"viewCount":537},{"author":"达尔文","body":"一个人吃饭才好啊 ，没人跟我抢菜啊","commentCount":21,"href":"https://my.oschina.net/xxiaobian/blog/1834898","id":1834898,"pubDate":"2018-06-25 07:55:05","recommend":false,"title":"OSChina 周一乱弹 \u2014\u2014 理发师小姐姐的魔法","type":3,"viewCount":2057}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 89535
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
             * author : 淡漠悠然
             * body : DataTables 1.10.19 已发布，DataTables 是一个 jQuery 的表格插件。这是一个高度灵活的工具，依据的基础逐步增强，这将增加先进的互动控制，支持任...
             * commentCount : 0
             * href : https://www.oschina.net/news/97409/datatables-11019-released
             * id : 97409
             * pubDate : 2018-06-25 17:20:27
             * recommend : true
             * title : DataTables 1.10.19 发布，jQuery 表格插件
             * type : 6
             * viewCount : 302
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
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
