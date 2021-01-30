package com.example.customer_registration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterProductList extends RecyclerView.Adapter<CustomAdapterProductList.MyViewHolder> {

    public static ArrayList<DataModelProductList> dspl;

    private Context context;

    public CustomAdapterProductList(Context context) {
        super();
        this.context = context;
    }

    public void updateList(ArrayList<DataModelProductList> list) {
        dspl = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvprtlitdatej, tvprtlitnamej, prtlitmodelj, prtlitinnoj, prtlitsrlnoj;
        CardView cardviewprtlitj;
        Button btnprtlifrsrvrqustj;
        private Context context;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvprtlitdatej = (TextView) itemView.findViewById(R.id.tvprtlitdate);
            this.tvprtlitnamej = (TextView) itemView.findViewById(R.id.tvprtlitname);
            this.prtlitmodelj = (TextView) itemView.findViewById(R.id.prtlitmodel);
            this.prtlitinnoj = (TextView) itemView.findViewById(R.id.prtlitinno);
            this.prtlitsrlnoj = (TextView) itemView.findViewById(R.id.prtlitsrlno);
            this.cardviewprtlitj = (CardView) itemView.findViewById(R.id.cardviewprtlit);
            this.btnprtlifrsrvrqustj = (Button) itemView.findViewById(R.id.btnprtlifrsrvrqust);

            context = itemView.getContext();
        }

        @Override
        public void onClick(View v) {
        }

        private void btnin(){
            Intent in = new Intent(context, ServiceRequest.class);
            context.startActivity(in);
        }
    }




    public CustomAdapterProductList(ArrayList<DataModelProductList> dmpl) {
        this.dspl = dmpl;
    }

    @NonNull
    @Override
    public CustomAdapterProductList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_product_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterProductList.MyViewHolder holder, int position) {
        TextView tvprtlitnamej = holder.tvprtlitnamej;
        TextView tvprtlitdatej = holder.tvprtlitdatej;
        TextView prtlitmodelj = holder.prtlitmodelj;
        TextView prtlitinnoj = holder.prtlitinnoj;
        TextView prtlitsrlnoj = holder.prtlitsrlnoj;

        holder.btnprtlifrsrvrqustj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnin();
            }
        });

        tvprtlitnamej.setText(dspl.get(position).getprtlitname());
        tvprtlitdatej.setText(dspl.get(position).getprtlitdate());
        prtlitmodelj.setText(dspl.get(position).getprtlitmodel());
        prtlitinnoj.setText(dspl.get(position).getprtlitinno());
        prtlitsrlnoj.setText(dspl.get(position).getprtlitsrlno());

    }

    @Override
    public int getItemCount() {
        return dspl.size();
    }
}
