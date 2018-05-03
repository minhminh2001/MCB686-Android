package com.mc.interactors.service;

import com.mc.models.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observer;

/**
 * Created by dangpp on 2/9/2018.
 */

public interface IApiService {
    Observer<User> getUsers();

    @GET("/json/get/bItCmtKbAO?indent=2")
    Observer<User> login();
}
