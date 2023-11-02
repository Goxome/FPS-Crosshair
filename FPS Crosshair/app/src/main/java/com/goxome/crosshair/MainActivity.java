package com.goxome.crosshair;
 
import android.app.Activity;

//    Only Requried for Crosshair

//import android.os.Bundle;
//import android.view.View;

import android.annotation.SuppressLint;//Hide Navigation Bar at Login Screen Requried Api
import android.os.Build;
//      Only Requried for Uodater
import com.goxome.crosshair.AppUtils;
import com.goxome.crosshair.UpdateChecker;

// Requried for Button and Text
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// Public Class 
public class MainActivity extends Activity { 
//public class MainActivity extends AppCompatActivity {





  //  private static final boolean AUTO_HIDE = true;
    private int currentApiVersion;//Navigation Bar Hide at Login Screen








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//}







//              >>>>>>>>>>> Navigation Bar Hide <<<<<<<<<

    
  //  @Override
 //   protected void onCreate(Bundle savedInstanceState) {
  //      super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
        currentApiVersion = android.os.Build.VERSION.SDK_INT;
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
            View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        if (currentApiVersion >= Build.VERSION_CODES.N) {
            getWindow().getDecorView().setSystemUiVisibility(flags);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            decorView.setSystemUiVisibility(flags);
                        }
                    }
                });
        }
    }
    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
               
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
              | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_FULLSCREEN 
              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  //      }
    }



//             >>>>>>>>>>> Navigation Bar Hide <<<<<<<<<
   
   
       // System.loadLibrary("GoxomeAuth");





// Button for Updater
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateChecker.checkForDialog(MainActivity.this);
            }
        });
        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                UpdateChecker.checkForNotification(MainActivity.this);
            }
        });

// Text
        TextView textView = (TextView) findViewById(R.id.textView1);

        textView.setText("Updater Info: Version = " + AppUtils.getVersionName(this) + " VersionCode = " + AppUtils.getVersionCode(this));

    }

//}


   // ---------CROSSHAIR----------
    public void StartCheat(View Goxome) {
  // Start Updater Service in Notifications
        UpdateChecker.checkForNotification(MainActivity.this);
  // Start Updater Service in Dialogs
        UpdateChecker.checkForDialog(MainActivity.this);
  // Start Crosshair Service
        StartService.StartService(this);
        
    }
    public void StopService(View Goxome){
        
    //    StartService.StartService(this);
        StartService.StopService(this);
        
        
        
        
    }
    
} 



