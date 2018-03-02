package com.mc.interactors.service;

import java.util.List;

import retrofit2.http.Url;
import rx.Observer;

/**
 * Created by dangpp on 2/9/2018.
 */

public interface IApiService {

    Observer<List<String>> getUsers();
}
