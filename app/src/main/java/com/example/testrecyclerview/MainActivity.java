package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler {
    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager=new GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ((GridLayoutManager)mLayoutManager).setSpanSizeLookup(
            new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int arg0) {
                    return (arg0 % 3) == 0 ? 2 : 1;
                }
            });
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);

//        RecyclerView.ItemDecoration itemDecoration =
//                new DividerItemDecoration(this, R.drawable.divider);
//        mRecyclerView.addItemDecoration(itemDecoration);
    }

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < 20; index++) {
            int image = R.drawable.spring;
            switch (index % 4) {
                case 0:
                    image = R.drawable.spring;
                    break;
                case 1:
                    image = R.drawable.summer;
                    break;
                case 2:
                    image = R.drawable.autumn;
                    break;
                case 3:
                    image = R.drawable.winter;
                    break;
            }
            Donnee obj = new Donnee("Texte principal " + index,"Texte auxiliaire ", image);
            results.add(index, obj);
        }
        return results;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int position, View v) {
        CoordinatorLayout mcoordinatorLayout;
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }
}