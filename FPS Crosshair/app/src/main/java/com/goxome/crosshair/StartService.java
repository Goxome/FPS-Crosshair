package com.goxome.crosshair;


/**
 * @author Goxome (GoxomeOfficial@gmail.com)
YouTube Goxome
 */

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.util.TypedValue;
import android.view.View;
import android.content.Context;
import android.provider.Settings;
import android.net.Uri;
import android.os.Process;
import android.widget.Toast;

public class StartService extends Service {
    
    private WindowManager mWindowManager;
    private static LinearLayout cross;



// This for Ediots
 //   private static final String TAG = "Developed by Goxome ";
 //   private static final String TAG2 = "Developed by Goxome ";
 //   private static final String TAG3 = "Developed by Goxome ";
    private  String Server = "https://101.33.11.00";
    private  String Text = "Developed By Goxome";
    private  String Security = "By Goxome";
// ----------------


    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @Override
    public void onCreate() {
        super.onCreate();


// Toast Make

       Toast.makeText(this, "Developed by Goxome", Toast.LENGTH_LONG).show();

//Start Crosshair Drawable

        SplashCrosshair();
    }

    
    private void SplashCrosshair() {
        cross = new LinearLayout(this);
        FrameLayout.LayoutParams fraLayoutParamsx = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        cross.setLayoutParams(fraLayoutParamsx);

        RelativeLayout hair = new RelativeLayout(this);
        RelativeLayout.LayoutParams hairr = new RelativeLayout.LayoutParams(dp(50), dp(50));
        hair.setBackgroundResource(R.drawable.aimcross);
        hair.setLayoutParams(hairr);

        cross.addView(hair);



        int flag;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1){
            flag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        else {
            flag = WindowManager.LayoutParams.TYPE_PHONE;
        }
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                                                                                 WindowManager.LayoutParams.WRAP_CONTENT,flag, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                                                                                 PixelFormat.TRANSLUCENT);
 
                                                                                 
                                                                                 
                                                                                 
                                                                                 params.layoutInDisplayCutoutMode = 1;
    
        params.gravity = Gravity.CENTER | Gravity.CENTER;
        params.x = 0;
        params.y = 0;
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(cross, params);
        // cross.setVisibility(View.GONE);
    }




    public static void StartService(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context)) {
            context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION",
                                             Uri.parse("package:" + context.getPackageName())));
            Process.killProcess(Process.myPid());
        } else {
            context.startService(new Intent(context, StartService.class));
        }
    }
    public static void StopService(Context context){
    //    Toast.makeText(context, "AAAAAAAAAA!", Toast.LENGTH_SHORT).show();
        context.stopService(new Intent(context, StartService.class));
        StartService.cross.setVisibility(View.GONE);
    }
    private int dp(int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }
}
 
