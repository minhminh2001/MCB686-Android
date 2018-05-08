package com.mc.books.fragments.more.tabmore;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;
import com.mc.events.SignInEvent;


public class MorePresenter<V extends IMoreView> extends BaseDataPresenter<V> implements IMorePresenter<V> {

    protected MorePresenter(AppComponent appComponent) {
        super(appComponent);
        bus.subscribe(this, SignInEvent.class, signInEvent -> {
        });
    }

}
