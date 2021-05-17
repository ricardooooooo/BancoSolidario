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

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Company> companyList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Company> countryList) {
        this.context = context;
        this.companyList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Company company = this.companyList.get(position);
        holder.getTextView().setText(company.getName());
        // ImageView carregada através da biblioteca Glide

        holder.getParentLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sempre que clicar no parent layout, este código é executado
                Log.i("RecyclerViewAdapter", String.format("Clicked on: %s (position %d)", company.getName(), position));
//                Intent intent = new Intent(RecyclerViewAdapter.this.context, DetailsActivity.class);
//                intent.putExtra(DetailsActivity.KEY_COMPANYPOSITION, position);
//                RecyclerViewAdapter.this.context.startActivity(intent);

                DetailsActivity.startActivity(RecyclerViewAdapter.this.context, company.getCodCompany());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.companyList.size();
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
