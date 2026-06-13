package com.hoseo.user;

public class Member {
    private String userId;
    private String password;
    private String userName;
    private String sex;
    private String [] hobby;
    private String department;
    private String strHobby;

    public  String getStrHobby() {
        strHobby = "";
        for (String s : hobby) {
            strHobby += s + " ";
        }
        return strHobby;
    }
    private String getUserId() {
        return userId;
    }
    private void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String[] getHobby() {
        return hobby;
    }
    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
