package com.example.jcblas.app_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movies;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = getAllMovies();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(movies, R.layout.recycler_view_item, new MyAdapter.OnJCItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                Log.i("MainActivity>>", "Hola mundo" + movie.getName());
                deleteMovie(position);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_name:
                this.addMovie(0);
                break;
            default:
                return super.onOptionsItemSelected(item);


        }
        return super.onOptionsItemSelected(item);
    }

    private void addMovie(int position) {
        Log.i("MainActivity>>addMovie", "position:"+position);
        movies.add(position,new Movie(R.drawable.images,"Default Movie"));
        mAdapter.notifyItemInserted(position);
        mLayoutManager.scrollToPosition(position);
    }

    private void deleteMovie(int position) {
        movies.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    private List<String> getAllNames() {
        return new ArrayList<>(Arrays.asList("Alejandro", "Miguel", "Sofia", "Gerardo"));
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<Movie>() {{
            add(new Movie(R.drawable.howl_poster3, "El castillo vagabundo"));
            add(new Movie(R.drawable.images, "El viaje de Chihiro"));
            add(new Movie(R.drawable.princesa_mononoke, "La Princesa Mononoke"));
            add(new Movie(R.drawable.totoro, "Mi vecino Totoro"));
        }};
    }
}
