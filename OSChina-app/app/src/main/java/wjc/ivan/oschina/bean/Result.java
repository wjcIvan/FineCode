package wjc.ivan.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by 龙心诚 on 2018/6/27 0027.
 */

public class Result {
    @XStreamAlias("errorCode")
    public String errorCode;
    @XStreamAlias("errorMessage")
    public String errorMessage;

}
