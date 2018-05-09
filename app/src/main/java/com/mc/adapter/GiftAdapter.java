package com.mc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mc.books.R;
import com.mc.common.adapters.BaseRecycleAdapter;
import com.mc.customize.ExpandableCardView;
import com.mc.models.gift.GiftResponse;
import com.mc.models.home.Author;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GiftAdapter extends BaseRecycleAdapter<GiftResponse, GiftAdapter.GiftViewHolder> {

    private Context context;

    public GiftAdapter(Context context) {
        this.context = context;
    }

    @Override
    public GiftViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gift, parent, false);
        return new GiftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GiftViewHolder holder, int position) {
        GiftResponse giftResponse = listItems.get(position);
        holder.ecvGift.setTitle(giftResponse.getName());
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    class GiftViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ecvGift)
        ExpandableCardView ecvGift;

        public GiftViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
