package com.example.customer_registration;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class CustomAdapterSrvRequst extends RecyclerView.Adapter<CustomAdapterSrvRequst.MyViewHolder> {

    public static ArrayList<DatamodelSrvRequst> dssr;
    //private  ArrayList<DatamodelSrvRequst> dssr;

    private Context context;

    public CustomAdapterSrvRequst(Context context) {
        super();
        this.context = context;
    }


    public void updateList(ArrayList<DatamodelSrvRequst> list) {
        dssr = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {

        TextView tvsrvrqustcustj, tvsrvrqustdatej, tvsrvrqustcallj, tvsrvrqustInvonoj, tvsrvrqustserlnoj, tvsrvrqustserttypej, tvsrvrqustsertstatj;
        ExpandableTextView tvsrvrqustAddj;
        CardView cardviewsrvrqustj;
        ImageButton imageButton;
        Dialog dialog;
        MenuItem srvallj;
        private final Context context;
        String[] listalltechnician = {"Select a Technician", "Ramesh"};
        String[] listrealltechnician = {"Select a Technician", "Ramesh"};
        ImageView imgclose, imgclosereallo;
        Button btncancel, btnreallocancel, btaccept, btnreallosubmit, btnsrvrequstprtdtelj;
        Spinner spinneralltechnicianj, spinnerrealltechnicianj;
        //public Context getContext() {return itemView.getContext();}


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvsrvrqustcustj = (TextView) itemView.findViewById(R.id.tvsrvrqustcust);
            this.tvsrvrqustdatej = (TextView) itemView.findViewById(R.id.tvsrvrqustdate);
            this.tvsrvrqustcallj = (TextView) itemView.findViewById(R.id.tvsrvrqustcall);
            this.tvsrvrqustAddj = (ExpandableTextView) itemView.findViewById(R.id.tvsrvrqustAdd);
            this.tvsrvrqustInvonoj = (TextView) itemView.findViewById(R.id.tvsrvrqustInvono);
            this.tvsrvrqustserlnoj = (TextView) itemView.findViewById(R.id.tvsrvrqustserlno);
            this.tvsrvrqustserttypej = (TextView) itemView.findViewById(R.id.tvsrvrqustserttype);
            this.tvsrvrqustsertstatj = (TextView) itemView.findViewById(R.id.tvsrvrqustsertstat);
            this.cardviewsrvrqustj = (CardView) itemView.findViewById(R.id.cardviewsrvrqust);
            this.cardviewsrvrqustj = (CardView) itemView.findViewById(R.id.cardviewsrvrqust);
            this.btnsrvrequstprtdtelj = (Button) itemView.findViewById(R.id.btnsrvrequstprtdtel);

            imageButton = itemView.findViewById(R.id.imageButton);
            imageButton.setOnClickListener(this);
            context = itemView.getContext();
            dialog = new Dialog(context);
        }

        @Override
        public void onClick(View v) {
            showPopupMenu(v);
        }

        private void showPopupMenu(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.menusrvrqust);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.show();
        }


        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.srvall:
                    openallocate();
                    return true;
                case R.id.srvreall:
                    openreallocate();
                    return true;
                case R.id.srvsd:
                    openschedule();
                    return true;
                case R.id.srvresd:
                    openreschedule();
                    return true;
                case R.id.srvcomp:
                    opencomplete();
                    return true;
                default:
                    return false;
            }
        }

        private void openallocate() {
            dialog.setContentView(R.layout.activity_srv_allocate);
            //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            imgclose = dialog.findViewById(R.id.imgclose);
            spinneralltechnicianj = dialog.findViewById(R.id.spinneralltechnician);
            btncancel = dialog.findViewById(R.id.btnsrvallcancel);
            btaccept = dialog.findViewById(R.id.btnsrvallsubmit);

            spinneralltechnicianj.setOnItemSelectedListener(this);
            ArrayAdapter spinneralltech = new ArrayAdapter(context, R.layout.spinner_item2, listalltechnician);
            spinneralltech.setDropDownViewResource(R.layout.spinner_item);
            spinneralltechnicianj.setAdapter(spinneralltech);

            imgclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });

            btaccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (spinneralltechnicianj.getSelectedItem().equals("Select a Technician")) {
                        //may be you want to ignorecase using equalsIgnoreCase() method
                        //display message that you haven't selected anything
                        Toast.makeText(context, "please select a Technician", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.show();
        }

        private void openreallocate() {
            dialog.setContentView(R.layout.activity_srv_re_allocate);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            imgclosereallo = dialog.findViewById(R.id.imgvclosesrvreallo);
            spinnerrealltechnicianj = dialog.findViewById(R.id.spinnerrealltechnician);
            btnreallocancel = dialog.findViewById(R.id.btnsrvreallcancel);
            btnreallosubmit = dialog.findViewById(R.id.btnsrvreallsubmit);

            spinnerrealltechnicianj.setOnItemSelectedListener(this);
            ArrayAdapter spinnerrealltech = new ArrayAdapter(context, R.layout.spinner_item2, listrealltechnician);
            spinnerrealltech.setDropDownViewResource(R.layout.spinner_item);
            spinnerrealltechnicianj.setAdapter(spinnerrealltech);

            imgclosereallo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            btnreallocancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });

            btnreallosubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (spinnerrealltechnicianj.getSelectedItem().equals("Select a Technician")) {
                        //may be you want to ignorecase using equalsIgnoreCase() method
                        //display message that you haven't selected anything
                        Toast.makeText(context, "please select a Technician", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.show();
        }

        private void openschedule(){
            Intent intent = new Intent(context,ServiceSchedule.class);
            context.startActivity(intent);
        }

        private void openreschedule(){
            Intent intent = new Intent(context,ServiceReschedule.class);
            context.startActivity(intent);
        }

        private void opencomplete(){
            Intent intent = new Intent(context, ServiceCompletion.class);
            context.startActivity(intent);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        private void btnin(){
            Intent in = new Intent(context, ProductList.class);
            context.startActivity(in);
        }
    }

    public CustomAdapterSrvRequst(ArrayList<DatamodelSrvRequst> dmsr) {
        this.dssr = dmsr;
    }


    @NonNull
    @Override
    public CustomAdapterSrvRequst.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_service_request_item, parent, false);

        //View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_srv_allocate, parent, false);
        //context = parent.getContext();
//        dialog = new Dialog(this)

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        TextView tvsrvrqustcustj = holder.tvsrvrqustcustj;
        TextView tvsrvrqustdatej = holder.tvsrvrqustdatej;
        TextView tvsrvrqustcallj = holder.tvsrvrqustcallj;
        //TextView tvsrvrqustAddj = holder.tvsrvrqustAddj;
        TextView tvsrvrqustInvonoj = holder.tvsrvrqustInvonoj;
        TextView tvsrvrqustserlnoj = holder.tvsrvrqustserlnoj;
        TextView tvsrvrqustserttypej = holder.tvsrvrqustserttypej;
        TextView tvsrvrqustsertstatj = holder.tvsrvrqustsertstatj;
        holder.tvsrvrqustAddj.setText(dssr.get(position).getsrvrqustAdd());
        holder.tvsrvrqustAddj.setOnStateChangeListener(new ExpandableTextView.OnStateChangeListener() {
            @Override
            public void onStateChange(boolean isShrink) {
                DatamodelSrvRequst contentItem = dssr.get(position);
                contentItem.setShrink(isShrink);
                dssr.set(position, contentItem);
            }
        });
        holder.tvsrvrqustAddj.setText(dssr.get(position).getsrvrqustAdd());
        holder.tvsrvrqustAddj.resetState(dssr.get(position).isShrink());

        holder.btnsrvrequstprtdtelj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnin();
            }
        });


        tvsrvrqustcustj.setText(dssr.get(position).getsrvrqustcust());
        tvsrvrqustdatej.setText(dssr.get(position).getsrvrqustdate());
        tvsrvrqustcallj.setText(dssr.get(position).getsrvrqustcall());
        //tvsrvrqustAddj.setText(dssr.get(position).getsrvrqustAdd());
        tvsrvrqustInvonoj.setText(dssr.get(position).getsrvrqustInvono());
        tvsrvrqustserlnoj.setText(dssr.get(position).getsrvrqustserlno());
        tvsrvrqustserttypej.setText(dssr.get(position).getsrvrqustserttype());
        tvsrvrqustsertstatj.setText(dssr.get(position).getsrvrqustsertstat());


    }

    @Override
    public int getItemCount() {
        return dssr.size();
    }
}

