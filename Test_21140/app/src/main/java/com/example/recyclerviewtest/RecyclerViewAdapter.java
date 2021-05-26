package com.example.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<BaseDataClass> dataList;
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        this.dataList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaseDataClass data = this.dataList.get(position);
        holder.getTextView().setText(data.getName());

       /* if (data instanceof Company) {
            Company company = (Company) data;
            company.getName();
            company.getAddress();
            company.getLocal();
            company.getPhoneNum();
        }else if(data instanceof Family){
            Family family = (Family) data;
            family.getName();
            family.getAddress();
            family.getLocal();
            family.getPhoneNum();
        }
*/


        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sempre que clicar no parent layout, este código é executado
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", data.getName(), position));

                DetailsActivity.startActivity(RecyclerViewAdapter.this.context, data.getId(), data.getType());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public void updateList(ArrayList<BaseDataClass> newList) {
        this.dataList = newList;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View parentLayout;
        private final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.parentLayout = itemView.findViewById(R.id.parentLayout);
        }

        public TextView getTextView() {
            return textView;
        }


        public View getParentLayout() { return parentLayout; }
    }
}
