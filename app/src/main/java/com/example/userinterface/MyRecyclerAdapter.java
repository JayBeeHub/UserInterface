package com.example.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

    String data1[], data2[], data3[];
    Context context;


    public MyRecyclerAdapter(Context ct, String s1[], String s2[], String s3[]){

        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position >= data1.length){
            return;
        }else{
            holder.myText1.setText(data1[position]);
            holder.myText2.setText(data2[position]);
            holder.myText3.setText(data3[position]);
        }
    }

    @Override
    public int getItemCount() {
        return data1.length ;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2, myText3;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            myText1 = itemView.findViewById(R.id.standard);
            myText2 = itemView.findViewById(R.id.button);
            myText3 = itemView.findViewById(R.id.time);
        }
    }

}
