package com.example.jcblas.app_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jcblas on 1/16/2017.
 */

public class MyAdapter_SG extends RecyclerView.Adapter<MyAdapter_SG.ViewHolder> implements View.OnClickListener{
    private List<String> names;
    private View.OnClickListener mListener;

    public MyAdapter_SG(List<String> names) {
        this.names = names;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        itemView.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindTitular(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    @Override
    public void onClick(View v) {
        Log.i("DemoRecView>>", "MyAdapter_SG.onClick Inicia" );
        if(mListener != null)
            mListener.onClick(v);

        Log.i("DemoRecView>>", "MyAdapter_SG.onClick Fin" );
    }

    public void setOnJCClickListener(View.OnClickListener listener) {
        this.mListener = listener;
        Log.i("DemoRecView>>", "MyAdapter_SG.setOnJCClickListener " );
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewName;

        public ViewHolder(View itemView) {
            super(itemView);
            //this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
        }

        public void bindTitular(String name) {
            textViewName.setText(name);
        }
    }
}
