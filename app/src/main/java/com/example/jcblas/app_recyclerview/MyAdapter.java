package com.example.jcblas.app_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by jcblas on 1/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Movie> names;
    private int layout;
    private OnJCItemClickListener itemClickListener;

    public MyAdapter(List<Movie> names, int layout, OnJCItemClickListener itemClickListener) {
        this.names = names;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
        Log.i("MyAdapter>>","Constructor");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position),itemClickListener);
        Log.i("MyAdapter>>","holder.bind");
    }

    @Override
    public int getItemCount() {
        return names.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imgViewPoster;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        }

        public void bind(final Movie movie, final OnJCItemClickListener listener){
            this.textViewName.setText(movie.getName());

            //itemView es una variable de clarada en la clase padre.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(movie, getAdapterPosition());
                    Log.i("MyAdapter>>","bind.onClick");
                }
            });
        }


    }

    public interface OnJCItemClickListener{
        void onItemClick(Movie movie, int position);
    }
}
