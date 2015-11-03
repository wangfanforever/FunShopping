package com.funguide.funshopping.bean;

import java.util.List;

/**
 * Created by yangshuai in the 13:05 of 2015.11.03 .
 */
public class TempBean extends BaseBean{

    /**
     * type : banner
     * title :
     * moreUrl :
     * moreTitle :
     * interval : 5000
     * content : [{"image":"http://140.206.112.228:8088/images/ClientFace/2015/10/26/663894201510261504310824.png","url":"cmblife://go?url=Home&tip=Menu&urlVersion=0","defaultText":"123","fluxId":"ET000000343","authId":"AT000001464"},{"image":"http://140.206.112.228:8088/images/ClientFace/2015/10/26/663894201510261504440148.png","url":"cmblife://go?url=Home&Tab=Mine&urlVersion=0","defaultText":"258","fluxId":"ET000000344","authId":"AT000001465"},{"image":"","url":"","defaultText":"21","fluxId":"ET000000353","authId":"AT000001477"},{"image":"http://140.206.112.228:8088/images/ClientFace/2015/09/22/663894201509220942425750.jpg","url":"cmblife://go?url=Home&Tab=Mine&urlVersion=0","defaultText":"1","fluxId":"ET000000354","authId":"AT000001478"}]
     * authId : AT000001118
     */

    private List<JsonEntity> json;

    public void setJson(List<JsonEntity> json) {
        this.json = json;
    }

    public List<JsonEntity> getJson() {
        return json;
    }

    public static class JsonEntity {
        private String type;
        private String title;
        private String moreUrl;
        private String moreTitle;
        private String interval;
        private String authId;
        /**
         * image : http://140.206.112.228:8088/images/ClientFace/2015/10/26/663894201510261504310824.png
         * url : cmblife://go?url=Home&tip=Menu&urlVersion=0
         * defaultText : 123
         * fluxId : ET000000343
         * authId : AT000001464
         */

        private List<ContentEntity> content;

        public void setType(String type) {
            this.type = type;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMoreUrl(String moreUrl) {
            this.moreUrl = moreUrl;
        }

        public void setMoreTitle(String moreTitle) {
            this.moreTitle = moreTitle;
        }

        public void setInterval(String interval) {
            this.interval = interval;
        }

        public void setAuthId(String authId) {
            this.authId = authId;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public String getType() {
            return type;
        }

        public String getTitle() {
            return title;
        }

        public String getMoreUrl() {
            return moreUrl;
        }

        public String getMoreTitle() {
            return moreTitle;
        }

        public String getInterval() {
            return interval;
        }

        public String getAuthId() {
            return authId;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public static class ContentEntity {
            private String image;
            private String url;
            private String defaultText;
            private String fluxId;
            private String authId;

            public void setImage(String image) {
                this.image = image;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setDefaultText(String defaultText) {
                this.defaultText = defaultText;
            }

            public void setFluxId(String fluxId) {
                this.fluxId = fluxId;
            }

            public void setAuthId(String authId) {
                this.authId = authId;
            }

            public String getImage() {
                return image;
            }

            public String getUrl() {
                return url;
            }

            public String getDefaultText() {
                return defaultText;
            }

            public String getFluxId() {
                return fluxId;
            }

            public String getAuthId() {
                return authId;
            }
        }
    }
}
