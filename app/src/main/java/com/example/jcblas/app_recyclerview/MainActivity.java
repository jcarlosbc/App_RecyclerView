package com.example.jcblas.app_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> names;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names=getAllNames();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
         mRecyclerView.setHasFixedSize(true);
         mRecyclerView.setItemAnimator(new DefaultItemAnimator());
         mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(names, R.layout.recycler_view_item, new MyAdapter.OnJCItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Log.i("MainActivity>>","Hola mundo"+name);
                delete(position);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_name:
                this.addName(0);
                break;
            default:
                return  super.onOptionsItemSelected(item);


        }
        return super.onOptionsItemSelected(item);
    }

    private void addName(int position) {
        names.add(position,"New Name");
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void delete(int position){
        names.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    private List<String> getAllNames(){
        return new ArrayList<>(Arrays.asList("Alejandro","Miguel","Sofia","Gerardo"));
    }
}
