package com.maiajam.backservice;

import android.support.annotation.NonNull;
import android.widget.Toast;

import androidx.work.Worker;

public class backJobWorker extends Worker {
    @NonNull
    @Override
    public WorkerResult doWork() {

        Toast.makeText(getApplicationContext(),"back service working now",Toast.LENGTH_LONG).show();
        return WorkerResult.RETRY;
    }
}
