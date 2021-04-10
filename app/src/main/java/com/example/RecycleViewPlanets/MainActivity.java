package com.example.RecycleViewPlanets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(this, getDataSource());
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Data> getDataSource() {
        ArrayList results = new ArrayList<Data>();
        String[] names = {getString(R.string.mercury), getString(R.string.venus), getString(R.string.earth), getString(R.string.mars), getString(R.string.jupiter), getString(R.string.saturn), getString(R.string.uranus), getString(R.string.neptune), getString(R.string.pluto)};
        int[] sizes = {4900, 12000, 12800, 6800, 144000, 120000, 52000, 50000, 2300};
        int[] images = {R.drawable.ic_mercury, R.drawable.ic_venus, R.drawable.ic_earth, R.drawable.ic_mars, R.drawable.ic_jupiter, R.drawable.ic_saturn, R.drawable.ic_uranus, R.drawable.ic_neptune, R.drawable.ic_pluto};
        for(int i = 0; i < names.length; i++){
            results.add(new Data(names[i], sizes[i], images[i]));
        }
        return results;
    }
}