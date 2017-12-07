package com.allie.templateapplication.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.allie.templateapplication.IListener;
import com.allie.templateapplication.R;
import com.allie.templateapplication.model.Employee;

/**
 * Created by rsauther on 10/17/17.
 */

public class EmployeeViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView title;
    private TextView role;
    private TextView tasks;
    private ImageButton deleteButton;
    private ImageButton infoButton;
    private String date;
        // public String position;
        public EmployeeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.text_view_header_item);
            title = (TextView) itemView.findViewById(R.id.text_view_subheader1_item);
            role = (TextView) itemView.findViewById(R.id.text_view_subheader2_item);
            tasks = (TextView) itemView.findViewById(R.id.text_view_subheader3_item);
            deleteButton = (ImageButton) itemView.findViewById(R.id.delete_button);
            infoButton = (ImageButton) itemView.findViewById(R.id.user_icon);
            //date = "";
            // position = "";


            //infoButton.setOnClickListener(mListener);
        }

       public void bind(Employee employee, View.OnClickListener deleteListener, IListener infoListener) {
       //public void bind(Object employee, View.OnClickListener deleteListener, IListener infoListener) {
            name.setText(employee.getName());
            role.setText(employee.getRole());
            title.setText(employee.getTitle());
            tasks.setText(employee.getTasks());
            // holder.position = ""+position;
            // Toast.makeText(mContext,"onBindViewHolder Position = "+ mEmployeeList.get(position).getPosition() ,Toast.LENGTH_LONG).show();
            //holder.date = mEmployeeList.get(position).getPosition();
            //  holder.date = ""+ mEmployeeList.get(position);
            infoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   infoListener.onListener(employee);

                }
            });
            deleteButton.setOnClickListener(deleteListener);
        }
    }

