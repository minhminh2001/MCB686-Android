package com.qslib.application;

import android.support.multidex.MultiDexApplication;

import com.qslib.image.ImageLoaderUtils;
import com.qslib.logger.Logger;
import com.qslib.util.FileUtils;
import com.qslib.util.ExtUtils;

import java.io.File;

/**
 * Created by Administrator on 24/01/2017.
 */

public class ExtApplication extends MultiDexApplication {
    protected static File pathProject;
    protected static ExtApplication extApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            ExtUtils.init(this);

            // set instance application
            ExtApplication.extApplication = this;

            // setup path project
            ExtApplication.getPathProject();

            // init image loader
            ImageLoaderUtils.initImageLoader(this, 50, 100);

            // setup Logger
            Logger.setEnableLog(true);
            if (ExtApplication.getPathProject() != null) {
                Logger.setPathSaveLog(ExtApplication.getPathProject().getAbsolutePath(), getPackageName(), "log");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get instance of base application
     *
     * @return
     */
    public static ExtApplication getInstance() {
        return ExtApplication.extApplication;
    }

    /**
     * get path root project
     *
     * @return
     */
    public static File getPathProject() {
        if (ExtApplication.pathProject == null) {
            ExtApplication.pathProject = FileUtils.getRootFolderPath(ExtApplication.getInstance(),
                    ExtApplication.getInstance().getPackageName());
        }

        return ExtApplication.pathProject;
    }
}
