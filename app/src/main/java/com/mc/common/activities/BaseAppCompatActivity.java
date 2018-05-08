package com.mc.common.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.MenuItem;

import com.bon.eventbus.IEvent;
import com.bon.eventbus.RxBus;
import com.bon.util.KeyboardUtils;
import com.mc.application.AppContext;
import com.mc.common.actions.IToolbarAction;
import com.mc.interactors.IDataModule;
import com.mc.interactors.database.IDbModule;
import com.mc.interactors.service.IApiService;

import javax.inject.Inject;

/**
 * Created by dangpp on 2/21/2018.
 */

public abstract class BaseAppCompatActivity extends ExtBaseActivity implements IToolbarAction {
    private static final String TAG = BaseAppCompatActivity.class.getSimpleName();

    @Inject
    protected RxBus<IEvent> bus;

    @Inject
    protected IDataModule dataModule;

    @Inject
    protected IDbModule dbModule;

    @Inject
    protected IApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppContext().getComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftKeyboard(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        switch (item.getItemId()) {
            case android.R.id.home:
                result = onHomeClicked(item);
                break;
        }

        return result || super.onOptionsItemSelected(item);
    }

    @Override
    public void initFragmentDefault() {

    }

    /**
     * get application context
     *
     * @return
     */
    public AppContext getAppContext() {
        return (AppContext) getApplicationContext();
    }

    /**
     * Override this method to return just {@code false} within Activity, if you need to override
     * home click in fragment.
     *
     * @param item The menu item that was selected.
     * @return Return {@code false} to allow normal menu processing to proceed, {@code true} to consume it here.
     */
    protected boolean onHomeClicked(MenuItem item) {
        onBackPressed();
        return true;
    }
}
