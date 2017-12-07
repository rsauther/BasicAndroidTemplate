package com.allie.templateapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Employee;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rsauther on 9/22/17.
 */

public class CreateEmployeeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee_item);
        ImageButton addEmployeeButton = (ImageButton)findViewById(R.id.add_button);
        EditText nameField = (EditText)findViewById(R.id.name_edit_text);
        EditText titleField = (EditText)findViewById(R.id.title_edit_text);
        EditText roleField = (EditText)findViewById(R.id.role_edit_text);
        EditText tasksField = (EditText)findViewById(R.id.tasks_edit_text);
        ImageButton cancelAddingEmployeeButton = (ImageButton)findViewById(R.id.cancel_button);

        addEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee e = new Employee();
                e.setName(nameField.getText().toString());
                e.setTitle(titleField.getText().toString());
                e.setRole(roleField.getText().toString());
                e.setTasks(tasksField.getText().toString());
                e.setDate(String.valueOf(new Date()));
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("employee", e);
                setResult(ActivityCodes.CREATE_EMPLOYEE_RESPONSE, intent);
                finish();
            }
        });

        cancelAddingEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast tRich =
                //Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_LONG)//.show();
                //Toast.makeText(getApplicationContext(),"Canceled" ,Toast.LENGTH_LONG).show();
                //tRich.show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                setResult(ActivityCodes.CANCEL_EMPLOYEE_RESPONSE, intent);
                finish();
            }
        });
    }
}
