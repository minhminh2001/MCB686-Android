package com.mc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bon.customview.textview.ExtTextView;
import com.bumptech.glide.Glide;
import com.mc.books.R;
import com.mc.common.adapters.BaseRecycleAdapter;
import com.mc.models.home.Author;
import com.mc.models.home.ProgramStudy;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import java8.util.function.Consumer;

public class ProgramStudyAdapter extends BaseRecycleAdapter<ProgramStudy, ProgramStudyAdapter.ProgramStudyViewHolder> {
    private Context context;
    private Consumer<ProgramStudy> programStudyConsumer;

    public ProgramStudyAdapter(Context context, Consumer<ProgramStudy> programStudyConsumer) {
        this.context = context;
        this.programStudyConsumer = programStudyConsumer;
    }

    @Override
    public ProgramStudyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_program_study, parent, false);
        return new ProgramStudyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramStudyViewHolder holder, int position) {
        ProgramStudy programStudy = listItems.get(position);
        holder.txtProgramStudyName.setText(programStudy.getName());
        programStudyConsumer.accept(programStudy);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    class ProgramStudyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtProgramStudyName)
        ExtTextView txtProgramStudyName;

        public ProgramStudyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
