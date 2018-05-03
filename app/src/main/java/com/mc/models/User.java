package com.mc.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("account_id")
    @Expose
    private Integer accountId;
    @SerializedName("fullname")
    @Expose
    private String fullName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("accountAvatar")
    @Expose
    private String accountAvatar;
    @SerializedName("accountIsUpdate")
    @Expose
    private Boolean accountIsUpdate;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountAvatar() {
        return accountAvatar;
    }

    public void setAccountAvatar(String accountAvatar) {
        this.accountAvatar = accountAvatar;
    }

    public Boolean getAccountIsUpdate() {
        return accountIsUpdate;
    }

    public void setAccountIsUpdate(Boolean accountIsUpdate) {
        this.accountIsUpdate = accountIsUpdate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountId=" + accountId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", accountAvatar='" + accountAvatar + '\'' +
                ", accountIsUpdate=" + accountIsUpdate +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
