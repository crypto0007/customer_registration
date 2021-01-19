package com.example.customer_registration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataMaodel> ds;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvcustnam, tvcustype, tvcity, tvcontact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvcustnam = (TextView) itemView.findViewById(R.id.etcutnam);
            this.tvcustype = (TextView) itemView.findViewById(R.id.etcuttype);
            this.tvcity = (TextView) itemView.findViewById(R.id.etcity);
            this.tvcontact = (TextView) itemView.findViewById(R.id.etcontact);
        }
    }

    public CustomAdapter(ArrayList<DataMaodel> dm) {
        this.ds = dm;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_list_item, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position){
    TextView tvcustnam = holder.tvcustnam;
    TextView tvcustype = holder.tvcustype;
    TextView tvcity = holder.tvcity;
    TextView tvcontact = holder.tvcontact;

        tvcustnam.setText(ds.get(position).getcustnam());
        tvcustype.setText(ds.get(position).getcusttype());
        tvcity.setText(ds.get(position).getcity());
        tvcontact.setText(ds.get(position).getcontact());
    }

    @Override
    public int getItemCount() {
        return ds.size();
    }
}
