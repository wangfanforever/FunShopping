package com.funguide.funshopping.bean;

import java.util.List;

public class CommonBillsBean {
    private String respCode;
    private String respMsg;
    private List<UserPaymentItemBean> userPaymentItemRecordsModelList;




    public class UserPaymentItemBean {
        private String recordsId;
        private String uid;
        private String paymentItemId;
        private String urlParams;
        private String status;
        private String paymentItemName;
        private String billKey;
        private String isComplete;
        private String cityCode;
        private String cityName;
        private String categoryType;
        private String tipStatus;
        private String remark;
        private String paymentTipStatus;
        @Override
        public String toString() {
            return "UserPaymentItemBean [recordsId=" + recordsId + ", uid="
                    + uid + ", paymentItemId=" + paymentItemId + ", urlParams="
                    + urlParams + ", status=" + status + ", paymentItemName="
                    + paymentItemName + ", billKey=" + billKey
                    + ", isComplete=" + isComplete + ", cityCode=" + cityCode
                    + ", cityName=" + cityName + ", categoryType="
                    + categoryType + ", tipStatus=" + tipStatus + ", remark="
                    + remark + ", paymentTipStatus=" + paymentTipStatus + "]";
        }
        public String getRecordsId() {
            return recordsId;
        }
        public void setRecordsId(String recordsId) {
            this.recordsId = recordsId;
        }
        public String getUid() {
            return uid;
        }
        public void setUid(String uid) {
            this.uid = uid;
        }
        public String getPaymentItemId() {
            return paymentItemId;
        }
        public void setPaymentItemId(String paymentItemId) {
            this.paymentItemId = paymentItemId;
        }
        public String getUrlParams() {
            return urlParams;
        }
        public void setUrlParams(String urlParams) {
            this.urlParams = urlParams;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public String getPaymentItemName() {
            return paymentItemName;
        }
        public void setPaymentItemName(String paymentItemName) {
            this.paymentItemName = paymentItemName;
        }
        public String getBillKey() {
            return billKey;
        }
        public void setBillKey(String billKey) {
            this.billKey = billKey;
        }
        public String getIsComplete() {
            return isComplete;
        }
        public void setIsComplete(String isComplete) {
            this.isComplete = isComplete;
        }
        public String getCityCode() {
            return cityCode;
        }
        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }
        public String getCityName() {
            return cityName;
        }
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
        public String getCategoryType() {
            return categoryType;
        }
        public void setCategoryType(String categoryType) {
            this.categoryType = categoryType;
        }
        public String getTipStatus() {
            return tipStatus;
        }
        public void setTipStatus(String tipStatus) {
            this.tipStatus = tipStatus;
        }
        public String getRemark() {
            return remark;
        }
        public void setRemark(String remark) {
            this.remark = remark;
        }
        public String getPaymentTipStatus() {
            return paymentTipStatus;
        }
        public void setPaymentTipStatus(String paymentTipStatus) {
            this.paymentTipStatus = paymentTipStatus;
        }


    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public List<UserPaymentItemBean> getUserPaymentItemRecordsModelList() {
        return userPaymentItemRecordsModelList;
    }

    public void setUserPaymentItemRecordsModelList(
            List<UserPaymentItemBean> userPaymentItemRecordsModelList) {
        this.userPaymentItemRecordsModelList = userPaymentItemRecordsModelList;
    }


}
