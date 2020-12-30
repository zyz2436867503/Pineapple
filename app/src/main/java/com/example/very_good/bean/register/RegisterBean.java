package com.example.very_good.bean.register;

public class RegisterBean {


    @Override
    public String toString() {
        return "RegisterBean{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * errno : 0
     * errmsg :
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMGE2MzE4ZDQtY2Q0OC00OTMzLTg5MjgtMWI2Y2MyM2E5ODhiIiwiaWF0IjoxNjA4Nzc5MTMwfQ.ZrTkBwafczFAeT5MNew5rOyDE65LGG_aI2LQXpcNZ0s","userInfo":{"uid":"0a6318d4-cd48-4933-8928-1b6cc23a988b","username":"zhang","nickname":null,"gender":0,"avatar":"","birthday":0}}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "token='" + token + '\'' +
                    ", userInfo=" + userInfo +
                    '}';
        }

        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMGE2MzE4ZDQtY2Q0OC00OTMzLTg5MjgtMWI2Y2MyM2E5ODhiIiwiaWF0IjoxNjA4Nzc5MTMwfQ.ZrTkBwafczFAeT5MNew5rOyDE65LGG_aI2LQXpcNZ0s
         * userInfo : {"uid":"0a6318d4-cd48-4933-8928-1b6cc23a988b","username":"zhang","nickname":null,"gender":0,"avatar":"","birthday":0}
         */

        private String token;
        private UserInfoBean userInfo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * uid : 0a6318d4-cd48-4933-8928-1b6cc23a988b
             * username : zhang
             * nickname : null
             * gender : 0
             * avatar :
             * birthday : 0
             */

            private String uid;
            private String username;
            private Object nickname;
            private int gender;
            private String avatar;
            private int birthday;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getBirthday() {
                return birthday;
            }

            public void setBirthday(int birthday) {
                this.birthday = birthday;
            }
        }
    }
}
