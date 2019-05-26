package com.maiajam.backservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import androidx.work.BackoffPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    private OneTimeWorkRequest Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_b = (Button)findViewById(R.id.start_b);

        start_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Req = new OneTimeWorkRequest.Builder(backJobWorker.class)
                        .setBackoffCriteria(
                                BackoffPolicy.EXPONENTIAL,
                                3*1000,//every 3 sec
                                TimeUnit.MILLISECONDS)
                        .build();
                WorkManager.getInstance().enqueue(Req);
            }
        });
    }
}
