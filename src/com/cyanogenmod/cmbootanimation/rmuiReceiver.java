package com.cyanogenmod.cmbootanimation;

import android.os.Bundle;
import android.os.Environment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.cyanogenmod.cmbootanimation.R;


public class rmuiReceiver extends BroadcastReceiver {

    public static final String rmUi = "com.cyanogenmod.cmbootanimation.RESET_DEFAULT";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(rmUi)) {
            String fileName = "bootanimation.zip";
            File rmFile = new File(context.getFilesDir(), fileName);
            if (rmFile.exists()) {
                try {
                    rmFile.delete();
                } catch (Exception e) { }
                Toast.makeText(context, R.string.remove_ui, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

