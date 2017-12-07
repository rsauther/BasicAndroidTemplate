package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Employee;

import java.util.Date;

/**
 * Created by rsauther on 10/8/17.
 */

public class EmployeeInfoActivity extends Activity {

    public TextView name;
    public TextView title;
    public TextView role;
    public TextView tasks;
    public TextView hireDate;
    public TextView position;
    public ImageButton deleteButton;
    public ImageView infoButton;
    public ImageButton cancelAddingEmployeeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_info);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Employee e = b.getParcelable("employee");

        name = (TextView)findViewById(R.id.name_edit_text);
        name.setText(e.getName());
        title = (TextView)findViewById(R.id.title_edit_text);
        title.setText(e.getTitle());
        role = (TextView)findViewById(R.id.role_edit_text);
        role.setText(e.getRole());
        tasks = (TextView)findViewById(R.id.tasks_edit_text);
        tasks.setText(e.getTasks());
        position = (TextView)findViewById(R.id.position_edit_text);
        position.setText(e.getPosition());
        hireDate = (TextView)findViewById(R.id.hire_edit_text);
        hireDate.setText(e.getDate());
        deleteButton = (ImageButton)findViewById(R.id.delete_button);
        infoButton = (ImageView)findViewById(R.id.user_icon);

        cancelAddingEmployeeButton = (ImageButton)findViewById(R.id.cancel_button);

        cancelAddingEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                setResult(ActivityCodes.CANCEL_EMPLOYEE_RESPONSE, intent);
                finish();

            }
        });

    }
}
