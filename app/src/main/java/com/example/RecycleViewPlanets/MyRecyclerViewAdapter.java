package com.example.RecycleViewPlanets;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataContainer> {
    private Context context;
    private final ArrayList<Data> data;

    public MyRecyclerViewAdapter(Context context, ArrayList<Data> data)
    {
        this.context = context;
        this.data = data;
    }

    @Override
    public DataContainer onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new DataContainer(view);
    }

    @Override
    public void onBindViewHolder(DataContainer conteneur, int position) {
        String name = context.getString(R.string.name) + " : " + data.get(position).getName();
        conteneur.name.setText(name);
        String size = context.getString(R.string.size) + " : " + data.get(position).getSize() + "km";
        conteneur.size.setText(size);
        conteneur.image.setImageResource(data.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class DataContainer extends RecyclerView.ViewHolder {
        TextView name;
        TextView size;
        ImageView image;

        public DataContainer(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            size = (TextView) itemView.findViewById(R.id.size);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}




