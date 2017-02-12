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

    private MyAdapter_SG myAdapter_sg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names=getAllNames();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        /*mAdapter = new MyAdapter(names, R.layout.recycler_view_item, new MyAdapter.OnJCItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Log.i("MainActivity>>","Hola mundo"+name);
            }
        });*/
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setAdapter(mAdapter);

        myAdapter_sg = new MyAdapter_SG(names);
        myAdapter_sg.setOnJCClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(mRecyclerView.getChildAdapterPosition(v));

            }
        });

        /*hola soy el voluemn de tu corazon*/
        /*MyAdapter_google adaptador = new MyAdapter_google(names);*/
        mRecyclerView.setAdapter(myAdapter_sg);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
        myAdapter_sg.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void delete(int position){
        names.remove(position);
        myAdapter_sg.notifyItemRemoved(position);
    }

    private List<String> getAllNames(){
        return new ArrayList<>(Arrays.asList("Alejandro","Miguel","Sofia","Gerardo"));
    }
}
