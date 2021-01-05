package com.wjc;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 禅道api工具类
 *
 * @author wjcIvan
 */
public class ZentaoUtils {

    /*====常量声明区====*/

    /**
     * http请求成功状态码，200
     */
    public static final int HTTP_SUCCESS_CODE = 200;

    /**
     * 禅道处理请求状态字符串
     */
    public static final String ZENTAO_SUCCESS = "success";

    /**
     * 禅道应用返回接口中标识状态的字段
     */
    public static final String ZENTAO_STATUS_NODE = "status";


    public static final String ZENTAO_RESULT_NODE = "result";

    /**
     * 禅道应用返回接口中数据的字段
     */
    public static final String ZENTAO_DATA_NODE = "data";

    /**
     * 禅道应用登录返回接口中用户的字段
     */
    public static final String ZENTAO_USER_NODE = "user";

    /**
     * 禅道地址
     */
    public String ZENTAO_ADDRESS = "http://192.168.0.186:8780/zentao";


    /**
     * 用户名字符串常量
     */
    public String ZENTAO_USERNAME = "yourUsername";

    /**
     * 密码字符串常量
     */
    public String ZENTAO_PASSWORD = "yourPassword";

    private static String session = "";

    /*====常量声明区====*/


    /**
     * 获取请求的session
     *
     * @return 请求禅道的session
     */
    private String getSession() {
        String getSessionIdUrl = "/api-getsessionid.json";
        return (String) get(getSessionIdUrl).get("sessionID");
    }

    /**
     * 使用用户名密码登录禅道
     *
     * @return 是否登录成功
     */
    public boolean login() {
        session = getSession();
        String loginUrl = "/user-login.json?zentaosid=" + session;

        Map<String, String> loginDataMap = new HashMap<>(2);
        loginDataMap.put("account", ZENTAO_USERNAME);
        loginDataMap.put("password", ZENTAO_PASSWORD);

        JSONObject loginReturnJsonData = post(loginUrl, loginDataMap, null, ZENTAO_USER_NODE);
        return !loginReturnJsonData.isEmpty() && loginReturnJsonData.getString("account").equals(ZENTAO_USERNAME);
    }

    /**
     * 提交bug
     *
     * @param url         url携带参数[productID]-[branch]-[extras] ps:"1-0-moduleID=0"
     * @param title       Bug标题 * 必填
     * @param filePath    文件路径
     * @param product     所属产品 * 必填
     * @param project     所属项目
     * @param deadline    截止日期 日期格式：YY - mm - dd，如：2019 - 01 - 01
     * @param assignedTo  指派给
     * @param type        Bug类型 取值范围： | codeerror | interface | config | install | security | performance | standard | automation | designchange | newfeature | designdefect | trackthings | codeimprovement | others
     * @param description 所属项目
     * @param severity    严重程度 取值范围：1 | 2 | 3 | 4
     * @param pri         优先级 取值范围：0 | 1 | 2 | 3 | 4
     * @return 是否提交成功
     */
    public String addBug(String url, String title, String filePath, String product, String project, String deadline,
                         String assignedTo, String type, String description, String severity, String pri) {

        String loginUrl = "/bug-create-" + url + ".json?zentaosid=" + session;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("title", title);
        paramMap.put("openedBuild", "trunk");
        paramMap.put("deadline", deadline);
        paramMap.put("assignedTo", assignedTo);
        paramMap.put("type", type);
        paramMap.put("severity", severity);
        paramMap.put("pri", pri);
        paramMap.put("steps", description);
        paramMap.put("project", project);
        paramMap.put("product", product);

        //文件参数，单个文件上传
        Map<String, File> files = new HashMap<>();
        files.put("files[]", new File(filePath));

        JSONObject returnJsonData = post(loginUrl, paramMap, files, "message");
        if ("success".equals(returnJsonData.get("result")) && "保存成功".equals(returnJsonData.get("message"))) {
            return "提交工单成功！";
        } else {
            return returnJsonData.get("message") + "";
        }

    }


    /**
     * 获取产品列表
     *
     * @return 产品列表
     */
    public Object getProducts() throws URISyntaxException {
        String url = String.format("/product-all.json?zentaosid=%s", session);
        URIBuilder uriBuilder = new URIBuilder(ZENTAO_ADDRESS + url);

        JSONObject returnJsonData = get(uriBuilder, ZENTAO_DATA_NODE);
        if (returnJsonData.has("products")) {
            return returnJsonData.get("products");
        }
        return null;
    }

    /**
     * 获取Branches列表
     *
     * @return 产品列表
     */
    public Object getBranches(String productId) throws URISyntaxException {
        String url = String.format("/branch-ajaxGetBranches-%s.json?zentaosid=%s", productId, session);
        URIBuilder uriBuilder = new URIBuilder(ZENTAO_ADDRESS + url);

        JSONObject returnJsonData = get(uriBuilder, ZENTAO_DATA_NODE);
        if (returnJsonData == null) {
            return null;
        }
        if (returnJsonData.has("products")) {
            return returnJsonData.get("products");
        }
        return null;
    }

    /**
     * 获取项目列表
     *
     * @return 项目列表
     */
    public Object getProjects(String productId) throws URISyntaxException {
        String url = String.format("/product-ajaxGetProjects-%s-0-0.json?zentaosid=%s", productId, session);
        URIBuilder uriBuilder = new URIBuilder(ZENTAO_ADDRESS + url);

        JSONObject returnJsonData = get(uriBuilder, ZENTAO_DATA_NODE);
        return returnJsonData;
    }

    /**
     * 获取版本列表
     *
     * @return 版本列表
     */
    public Object getProductBuilds(String productID) throws URISyntaxException {
        String url = String.format("/build-ajaxGetProductBuilds-%s-openedBuild-.json?zentaosid=%s", productID, session);
        URIBuilder uriBuilder = new URIBuilder(ZENTAO_ADDRESS + url);

        JSONObject returnJsonData = get(uriBuilder, ZENTAO_DATA_NODE);
        if (returnJsonData == null) {
            return null;
        }
        if (returnJsonData.has("products")) {
            return returnJsonData.get("products");
        }
        return null;
    }

    public static void main(String[] args) throws URISyntaxException {
        ZentaoUtils zentaoUtils = new ZentaoUtils();
        System.out.println(zentaoUtils.login());
//        zentaoUtils.viewBug();
//        zentaoUtils.addBug("1-0-moduleId=0","");
//        zentaoUtils.getProducts();
//        zentaoUtils.getBranches("1");
    }

    /**
     * 执行http请求并返回JSONObject
     *
     * @param httpUriRequest {HttpGet|HttpPost}
     * @return JSONObject
     */
    private static JSONObject httpExecute(final HttpUriRequest httpUriRequest, final String dataNodeKey) {
        //创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            //执行请求
            final CloseableHttpResponse response = httpclient.execute(httpUriRequest);
            //判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == HTTP_SUCCESS_CODE) {
                //解析响应数据
                String content = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                if (content == null || "".equals(content)) {
                    return null;
                }
                JSONObject zentaoReturnObject = JSONObject.fromObject(content);
                if (ZENTAO_SUCCESS.equals(zentaoReturnObject.get(ZENTAO_STATUS_NODE))) {
                    String dataNode = zentaoReturnObject.getString(dataNodeKey);
                    return JSONObject.fromObject(dataNode);
                }
                if (ZENTAO_SUCCESS.equals(zentaoReturnObject.get(ZENTAO_RESULT_NODE))) {
                    return zentaoReturnObject;
                }
                return zentaoReturnObject;
            }
        } catch (IOException ioe) {
//            LOGGER.error("禅道请求出错,{}", ioe.getMessage());
        }
        return new JSONObject();
    }

    /**
     * 无参数get请求
     *
     * @param url 请求地址
     * @return 请求响应JSONObject
     */
    public JSONObject get(final String url) {
        try {
            URIBuilder uriBuilder = new URIBuilder(ZENTAO_ADDRESS + url);
            return get(uriBuilder, ZENTAO_DATA_NODE);
        } catch (URISyntaxException e) {
//            LOGGER.error("url格式错误,{}", e.getMessage());
        }
        return new JSONObject();
    }

    /**
     * 私有get请求,URIBuilder已经包含请求参数
     *
     * @param uriBuilder URIBuilder
     * @return JSONObject 请求返回的json数据
     * @throws URISyntaxException URL格式异常
     */
    private JSONObject get(final URIBuilder uriBuilder, final String dataNodeKey) throws URISyntaxException {
        URI uri = uriBuilder.build();
        //创建http GET请求
        return httpExecute(new HttpGet(uri), dataNodeKey);
    }

    /**
     * 向禅道的post请求
     *
     * @param url         请求地址
     * @param paramMap    请求参数
     * @param dataNodeKey 数据节点
     * @return 请求响应JSONObject
     */
    public JSONObject post(final String url, final Map<String, String> paramMap, final Map<String, File> files, final String dataNodeKey) {
        ContentType contentType = ContentType.create("text/plain", StandardCharsets.UTF_8);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        for (Map.Entry<String, String> dataEntry : paramMap.entrySet()) {
            multipartEntityBuilder.addTextBody(dataEntry.getKey(), dataEntry.getValue(), contentType);
        }
        if (files != null) {
            for (Map.Entry<String, File> dataEntry : files.entrySet()) {
                multipartEntityBuilder.addBinaryBody(dataEntry.getKey(), dataEntry.getValue());
            }
        }
        HttpEntity httpEntity = multipartEntityBuilder.build();
        try {
            final URI uri = new URIBuilder(ZENTAO_ADDRESS + url).build();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(httpEntity);
            return httpExecute(httpPost, dataNodeKey);
        } catch (URISyntaxException e) {
//            LOGGER.error("url格式错误,{}", e.getMessage());
        }

        return new JSONObject();
    }
}

