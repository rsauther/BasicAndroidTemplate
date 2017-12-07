package com.allie.templateapplication.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.allie.templateapplication.AdvertisementActivity;
import com.allie.templateapplication.MainActivity;
import com.allie.templateapplication.R;
import com.allie.templateapplication.constants.ActivityCodes;
import com.allie.templateapplication.model.Advertisement;

/**
 * Created by rsauther on 10/19/17.
 */

public class AdViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    private TextView adColorText;

    public AdViewHolder(View itemView) {

        super(itemView);
        mContext = itemView.getContext();
        adColorText = (TextView) itemView.findViewById(R.id.ad_text);

    }


    public void bind(Advertisement advertisement, View.OnClickListener adListener) {

        adColorText.setBackgroundColor(advertisement.getBackgroundColor());
        adColorText.setText(advertisement.getAdColorText());
        adColorText.setOnClickListener(adListener);

    }

}
