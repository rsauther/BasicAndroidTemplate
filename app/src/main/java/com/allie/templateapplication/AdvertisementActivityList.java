package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Advertisement;

/**
 * Created by rsauther on 10/28/17.
 */

public class AdvertisementActivityList extends Activity {

    public ImageButton AdButton;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertisement);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Advertisement a = b.getParcelable("advertisement");
        int color = a.getBackgroundColor();
        getWindow().getDecorView().setBackgroundColor(color);
        AdButton = (ImageButton)findViewById(R.id.cancel_button);

        AdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                setResult(ActivityCodes.CANCEL_EMPLOYEE_RESPONSE, intent);
                finish();

            }
        });

    }

}
