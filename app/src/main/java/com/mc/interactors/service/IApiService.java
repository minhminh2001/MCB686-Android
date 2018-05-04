package com.mc.interactors.service;

import com.mc.models.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by dangpp on 2/9/2018.
 */

public interface IApiService {
    @GET("/json/get/bItCmtKbAO?indent=2")
    Observable<User> login();

    @POST()
    @FormUrlEncoded()
    Observable<String> getKeyCloarkInfo(@Url String url, @Field("grant_type") String grantType, @Field("code") String code,
                                                @Field("client_id") String clientId, @Field("redirect_uri") String redirectUri);

    @GET
    Observable<String> getDemo(@Url String url);
}
