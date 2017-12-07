package com.allie.templateapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Advertisement;
import com.allie.templateapplication.model.Employee;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBar mActionBar;
    private Toolbar mToolbar;
    //private  List<Employee> list = new ArrayList<>();
    //private  List<Object> list = new ArrayList<>();
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        toolbarSetup();
        Button newEmployeeScreenButton = (Button) findViewById(R.id.new_employee) ;

        newEmployeeScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CreateEmployeeActivity.class);
               // intent.putExtra("name","rich");
                //startActivity(intent);
                startActivityForResult(intent, ActivityCodes.CREATE_EMPLOYEE_REQUEST);
                //list.add(intent.getStringExtra("name"));
            }
        });
        //this is an example list - create your own from your json file to populate the recyclerview
        recyclerViewSetup();
        Employee e = new Employee();
        e.setName("Ronald");
        e.setTitle("Spokesperson");
        e.setRole("Clown");
        e.setTasks("Selling hamburgers");
        e.setDate(String.valueOf(new Date()));
        mAdapter.addItem(e);
        Employee e1 = new Employee();
        e1.setName("Hamburgalar");
        e1.setTitle("Spokesperson");
        e1.setRole("Thief");
        e1.setTasks("Stealing hamburgers");
        e1.setDate(String.valueOf(new Date()));
        mAdapter.addItem(e1);
        Advertisement a = new Advertisement();
        a.setBackgroundColor(getResources().getColor(R.color.red));
        a.setAdColorText("RED");
        mAdapter.addItem(a);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ActivityCodes.CREATE_EMPLOYEE_REQUEST){
            if (resultCode == ActivityCodes.CREATE_EMPLOYEE_RESPONSE){
                Employee e = data.getParcelableExtra("employee");
                mAdapter.appendAdapter(e);
                int count = mAdapter.getItemCount()+3;
               // Toast.makeText(getApplicationContext(),""+count,Toast.LENGTH_LONG).show();
               // Log.d("mainActivity", "we clicked on position:"+pos);
                if ((count>4)&(count % 3 == 2)) { //(count % 3 == 0)||
                    Advertisement a = new Advertisement();
                    if(mAdapter.getItemCount() % 2 == 0){
                        a.setBackgroundColor(getResources().getColor(R.color.red));
                        a.setAdColorText("RED");
                    }
                    if(mAdapter.getItemCount() % 2 == 1){
                        a.setBackgroundColor(getResources().getColor(R.color.yellow));
                        a.setAdColorText("YELLOW");
                    }
                    mAdapter.addItem(a);
                }
            }
            else if (resultCode == ActivityCodes.CANCEL_EMPLOYEE_RESPONSE){
                Toast.makeText(getApplicationContext(),"Canceled" ,Toast.LENGTH_LONG).show();
            }
        }
    }

    private void recyclerViewSetup() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerAdapter(getApplicationContext(), new IListener() {
            @Override
            public void onListener(Object o)
            {
                if (o instanceof Employee)
                {
                    Intent intent = new Intent(getApplicationContext(), EmployeeInfoActivity.class);
                    Bundle b = new Bundle();
                    b.putParcelable("employee", (Employee)o);
                    intent.putExtras(b);
                    startActivity(intent);
                }
                else if (o instanceof Advertisement)
                {
                    Intent intent = new Intent(getApplicationContext(), AdvertisementActivity.class);
                    Bundle b = new Bundle();
                    b.putParcelable("advertisement", (Advertisement)o);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            }

        }) ;
        mRecyclerView.setAdapter(mAdapter);
    }

    private void toolbarSetup() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(R.string.app_name);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

    //example of how to get items from your json file
//    private List<Employee> getJsonObject() {
//            if (mJsonList == null) {
//                String json = null;
//                try {
//                    InputStream is = MainActivity.this.getAssets().open("Employee.json");
//                    int size = is.available();
//                    byte[] buffer = new byte[size];
//                    is.read(buffer);
//                    is.close();
//                    json = new String(buffer, "UTF-8");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    return null;
//                }
//                Gson gson = new Gson();
//                Type type = new TypeToken<List<Employee>>() {
//                }.getType();
//                mJsonList = gson.fromJson(json, type);
//
//                for (Employee employee : mJsonList) {
//                }
//            }
//            return mJsonList;
//        }
}
