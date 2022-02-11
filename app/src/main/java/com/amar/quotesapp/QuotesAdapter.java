package com.amar.quotesapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {
    Context context;
    List<String> quotes = null;

    public QuotesAdapter(Context context, List<String> quotes )
    {
        this.context = context;
        this.quotes = quotes;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quotelist,parent,false);

        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder, int position) {
        String [] colors = {"#448AFF","#FFC107","#009688","#E91E63","#FF5722"};
        String textquote = quotes.get(position);
        holder.text.setText(textquote);
        int color = position % colors.length;
        int intColor = Color.parseColor(colors[color]);
        holder.quoteContain.setBackgroundColor(intColor);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        ImageView image;
        LinearLayout quoteContain;
        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.txtlist);
            image = itemView.findViewById(R.id.imageicon);
            quoteContain = itemView.findViewById(R.id.quoateContainer);
        }
    }
}
