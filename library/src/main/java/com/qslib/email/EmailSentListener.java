package com.qslib.email;

public interface EmailSentListener {
    void onStarted();

    void onSuccess();

    void onFail();

    void onFinished();
}
