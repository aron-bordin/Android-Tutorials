package com.rhesoft.androidprocessbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.dd.processbutton.ProcessButton;
import com.dd.processbutton.iml.ActionProcessButton;
import com.dd.processbutton.iml.GenerateProcessButton;
import com.dd.processbutton.iml.SubmitProcessButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // ################# ACTION PROCESS BUTTON #################################################
        // get the button view
        ActionProcessButton btnProcess = (ActionProcessButton) findViewById(R.id.btnProcess);

        //set the animation type. The PROGRESS display a bar with the percentage
//        btnProcess.setMode(ActionProcessButton.Mode.PROGRESS);
        //or ENDLESS, that indicate the it's loading
        btnProcess.setMode(ActionProcessButton.Mode.ENDLESS);

        //start with progress = 0
        btnProcess.setProgress(0);

        //to test the animations, when we touch the button it will start counting
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActionProcessButton btn = (ActionProcessButton) view;
                // we add 25 in the button progress each click
                if(btn.getProgress() < 100){
                    btn.setProgress(btn.getProgress() + 25);
                }
            }
        });

        // ####################### ACTION SUBMIT BUTTON ############################################

        // get the button view
        SubmitProcessButton btnSubmit = (SubmitProcessButton) findViewById(R.id.btnSubmit);

        //start with progress = 0
        btnSubmit.setProgress(0);

        //to test the animations, when we touch the button it will start counting
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitProcessButton btn = (SubmitProcessButton) view;
                // we add 25 in the button progress each click
                if(btn.getProgress() < 100){
                    btn.setProgress(btn.getProgress() + 25);
                }
            }
        });

        // ####################### ACTION GENERATE BUTTON ##########################################

        // get the button view
        GenerateProcessButton btnGenerate = (GenerateProcessButton) findViewById(R.id.btnGenerate);

        //start with progress = 0
        btnGenerate.setProgress(0);

        //to test the animations, when we touch the button it will start counting
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenerateProcessButton btn = (GenerateProcessButton) view;
                // we add 25 in the button progress each click
                if(btn.getProgress() < 100){
                    btn.setProgress(btn.getProgress() + 25);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
