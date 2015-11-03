package com.funguide.funshopping.bean;

/**
 * Created by yangshuai in the 12:56 of 2015.11.03 .
 */
public class BaseBean {
    /**
     * respCode : 1000
     * respMsg : 成功
     */

    protected String respCode;
    protected String respMsg;

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }
}
