package com.allie.templateapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.allie.templateapplication.model.Advertisement;
import com.allie.templateapplication.model.Employee;
import com.allie.templateapplication.viewholders.AdViewHolder;
import com.allie.templateapplication.viewholders.EmployeeViewHolder;
import com.allie.templateapplication.viewholders.EmptyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acaldwell on 9/14/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_EMPLOYEE = 0;
    private static final int VIEW_TYPE_ADVERTISEMENT = 1;
    private static final int VIEW_TYPE_EMPTY = 2;
    private List<Object> mItems = new ArrayList<>();
    private Context mContext;
    private IListener mListener;
//TODO:ask a question here
    public RecyclerAdapter(Context context, IListener listener) {
        //this.mEmployeeList = list;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
        if (viewType == VIEW_TYPE_EMPLOYEE) {
           v = inflater.inflate(R.layout.recyclerview_item, parent, false);
            EmployeeViewHolder holder = new EmployeeViewHolder(v);
            return holder;
        }
        else if (viewType == VIEW_TYPE_ADVERTISEMENT) {
            v = inflater.inflate(R.layout.viewholder_ad, parent, false);
            AdViewHolder holder = new AdViewHolder(v);
            return holder;
        }else {
            v = inflater.inflate(R.layout.viewholder_empty, parent, false);
            EmptyViewHolder holder = new EmptyViewHolder(v);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == VIEW_TYPE_EMPLOYEE) {
            ((EmployeeViewHolder)holder).bind((Employee)mItems.get(position), new View.OnClickListener() {
                     @Override
                      public void onClick(View view) {
                         mItems.remove(position);
                          notifyDataSetChanged();
                      }
                  },mListener);
        }else if (getItemViewType(position) == VIEW_TYPE_ADVERTISEMENT) {
            ((AdViewHolder)holder).bind((Advertisement)mItems.get(position), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onListener(mItems.get(position));
                 //   Toast.makeText(mContext,"Ad Click" ,Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(mContext, AdvertisementActivity.class);
//                    Bundle b = new Bundle();
//                    b.putParcelable("advertisement", (Advertisement)o);
//                    intent.putExtras(b);
//                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof Employee){
            return VIEW_TYPE_EMPLOYEE;
        }else if (mItems.get(position) instanceof Advertisement){
            return VIEW_TYPE_ADVERTISEMENT;
        }else{
            return VIEW_TYPE_EMPTY;
        }
    }

    public void updateAdapter(List<Object> list) {
        mItems.clear();
        mItems.addAll(list);
        notifyDataSetChanged();
    }

    public void appendAdapter(Object o){
        mItems.add(o);
        notifyDataSetChanged();
    }

    public void addItem(Object o){
        mItems.add(o);
        //mEmployeeList.add(o);
        //mList.add(o);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }




}
