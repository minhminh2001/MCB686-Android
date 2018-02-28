package com.mc.di;

import android.os.Handler;

import com.mc.interactors.IDataModule;
import com.qslib.eventbus.IEvent;
import com.qslib.eventbus.RxBus;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by dangpp on 2/9/2018.
 */
@Module
public class DataModule implements IDataModule {
    private static final String TAG = DataModule.class.getSimpleName();

    private final AppComponent component;
    private final Handler handler = new Handler();

    @Inject
    RxBus<IEvent> bus;

    public DataModule(AppComponent component) {
        this.component = component;
        component.inject(this);
    }

    @Override
    public Handler getHandler() {
        return handler;
    }
}
