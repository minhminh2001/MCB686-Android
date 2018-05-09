package com.mc.customizes.bottombars;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mc.books.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemBottomBar extends LinearLayout {
    private static final String TAG = ItemBottomBar.class.getSimpleName();

    @BindView(R.id.ivImage)
    AppCompatImageView ivImage;
    @BindView(R.id.vLine)
    View vLine;

    // drawable
    Drawable drawableIconNormal, drawableIconActive;

    public ItemBottomBar(Context context) {
        super(context);
        initView(context, null);
    }

    public ItemBottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ItemBottomBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ItemBottomBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_bar_item, this);
        ButterKnife.bind(this, view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemBottomBar);

        // active
        boolean isActive = typedArray.getBoolean(R.styleable.ItemBottomBar_bottomBarActive, false);

        // icon
        drawableIconNormal = typedArray.getDrawable(R.styleable.ItemBottomBar_bottomBarIconNormal);
        drawableIconActive = typedArray.getDrawable(R.styleable.ItemBottomBar_bottomBarIconActive);

        // set active mode
        setActiveMode(isActive);

        // recycle
        typedArray.recycle();
    }

    public View getImageView() {
        return ivImage;
    }

    /**
     * @param isActive
     */
    public void setActiveMode(boolean isActive) {
        vLine.setVisibility(isActive ? VISIBLE : INVISIBLE);
        ivImage.setImageDrawable(isActive ? drawableIconActive : drawableIconNormal);
    }
}
