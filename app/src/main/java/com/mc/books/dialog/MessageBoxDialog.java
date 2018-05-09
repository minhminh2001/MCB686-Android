package com.mc.books.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.bon.customview.textview.ExtTextView;
import com.mc.books.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageBoxDialog extends Dialog {
    @BindView(R.id.txtMessage)
    ExtTextView txtMessage;
    @BindView(R.id.rvGift)
    RecyclerView rvGift;
    @BindView(R.id.llMesssageDialog)
    LinearLayout llMesssageDialog;
    private Context context;
    private List<String> giftList = null;
    private String message;


    public MessageBoxDialog(@NonNull Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;
    }

    public MessageBoxDialog(@NonNull Context context, String message, List<String> giftList) {
        super(context);
        this.context = context;
        this.giftList = giftList;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_message_box);
        ButterKnife.bind(this);
        txtMessage.setText(message);
        if (giftList != null) {
            rvGift.setVisibility(View.VISIBLE);
            //set adapter ...
        }
    }

    @OnClick(R.id.llMesssageDialog)
    public void onViewClicked() {
        dismiss();
    }
}
