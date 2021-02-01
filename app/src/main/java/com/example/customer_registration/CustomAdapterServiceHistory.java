package com.example.customer_registration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterServiceHistory extends RecyclerView.Adapter<CustomAdapterServiceHistory.MyViewHolder>{

    public static ArrayList<Datamodelsrvhistory> dssh;

    //private  ArrayList<DatamodelSrvRequst> dssr;

    private Context context;

    public CustomAdapterServiceHistory(Context context) {
        super();
        this.context = context;
    }


    public void updateList(ArrayList<Datamodelsrvhistory> list) {
        dssh = list;
        notifyDataSetChanged();
    }

    public CustomAdapterServiceHistory(ArrayList<Datamodelsrvhistory> dmsr) {
        this.dssh = dmsr;
    }
    @NonNull
    @Override
    public CustomAdapterServiceHistory.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_service_history_item, parent, false);

       MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterServiceHistory.MyViewHolder holder, int position) {
        TextView tvsrvhiscustj = holder.tvsrvhiscustj;
        TextView tvsrvhisdatej = holder.tvsrvhisdatej;
        TextView tvsrvhisprtnamej = holder.tvsrvhisprtnamej;
        TextView tvsrvhissrvtypej = holder.tvsrvhissrvtypej;
        TextView tvsrvhisreqrmtj = holder.tvsrvhisreqrmtj;
        TextView tvsrvhiscompdatetimej = holder.tvsrvhiscompdatetimej;
        TextView tvsrvhistechnamej = holder.tvsrvhistechnamej;
        TextView tvsrvhicahrgej = holder.tvsrvhicahrgej;
        TextView tvsrvhisremrkj = holder.tvsrvhisremrkj;

        tvsrvhiscustj.setText(dssh.get(position).getsrvhiscustj());
        tvsrvhisdatej.setText(dssh.get(position).getsrvhisdatej());
        tvsrvhisprtnamej.setText(dssh.get(position).getsrvhisprtnamej());
        tvsrvhissrvtypej.setText(dssh.get(position).getsrvhissrvtypej());
        tvsrvhisreqrmtj.setText(dssh.get(position).getsrvhisreqrmtj());
        tvsrvhiscompdatetimej.setText(dssh.get(position).getsrvhiscompdatetimej());
        tvsrvhistechnamej.setText(dssh.get(position).getsrvhistechnamej());
        tvsrvhicahrgej.setText(dssh.get(position).getsrvhicahrgej());
        tvsrvhisremrkj.setText(dssh.get(position).getsrvhisremrkj());

        holder.btnsrvhisprtdtelj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnin();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dssh.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvsrvhiscustj, tvsrvhisdatej, tvsrvhisprtnamej, tvsrvhissrvtypej, tvsrvhisreqrmtj,
                tvsrvhiscompdatetimej, tvsrvhistechnamej,tvsrvhicahrgej, tvsrvhisremrkj;
//        CardView cardviewsrvrqustj;
//        ImageButton imageButton;
        private final Context context;
//        String[] listalltechnician = {"Select a Technician", "Ramesh"};
//        String[] listrealltechnician = {"Select a Technician", "Ramesh"};
        Button btnsrvhisprtdtelj;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvsrvhiscustj = (TextView) itemView.findViewById(R.id.tvsrvhiscust);
            this.tvsrvhisdatej = (TextView) itemView.findViewById(R.id.tvsrvhisdate);
            this.tvsrvhisprtnamej = (TextView) itemView.findViewById(R.id.tvsrvhisprtname);
            this.tvsrvhissrvtypej = (TextView) itemView.findViewById(R.id.tvsrvhissrvtype);
            this.tvsrvhisreqrmtj = (TextView) itemView.findViewById(R.id.tvsrvhisreqrmt);
            this.tvsrvhiscompdatetimej = (TextView) itemView.findViewById(R.id.tvsrvhiscompdatetime);
            this.tvsrvhistechnamej = (TextView) itemView.findViewById(R.id.tvsrvhistechname);
            this.tvsrvhicahrgej =  (TextView) itemView.findViewById(R.id.tvsrvhicahrge);
            this.tvsrvhisremrkj   = (TextView) itemView.findViewById(R.id.tvsrvhisremrk);
            this.btnsrvhisprtdtelj = (Button) itemView.findViewById(R.id.btnsrvhisprtdtel);

            context = itemView.getContext();
        }

        @Override
        public void onClick(View v) {

        }

        private void btnin(){
            Intent in = new Intent(context, ProductList.class);
            context.startActivity(in);
        }
    }
}
