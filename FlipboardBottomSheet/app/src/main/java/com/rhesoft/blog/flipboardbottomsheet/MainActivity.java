package com.rhesoft.blog.flipboardbottomsheet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.flipboard.bottomsheet.commons.IntentPickerSheetView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    BottomSheetLayout bottomSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomSheetLayout = (BottomSheetLayout) findViewById(R.id.bottomsheet);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_custom_view:
                bottomSheetLayout.showWithSheetView(getLayoutInflater().inflate(R.layout.custom_view, bottomSheetLayout, false));
                break;
            case R.id.btn_expand_me:
                bottomSheetLayout.expandSheet();
                break;
            case R.id.btn_intent:
                final Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Rhesoft tutorial");
                shareIntent.setType("text/plain");

                IntentPickerSheetView intentPickerSheetView = new IntentPickerSheetView(MainActivity.this, shareIntent, "Share", new IntentPickerSheetView.OnIntentPickedListener() {
                    @Override
                    public void onIntentPicked(IntentPickerSheetView.ActivityInfo activityInfo) {
                        bottomSheetLayout.dismissSheet();
                        startActivity(activityInfo.getConcreteIntent(shareIntent));
                    }
                });

                bottomSheetLayout.showWithSheetView(intentPickerSheetView);
                break;
        }
    }
}
