package com.fxp.secondapp.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Title:       OnePxActivity
 * <p>
 * Package:     com.fxp.secondapp.activity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 11:21 AM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class OnePxActivity extends Activity {

    private final String TAG = OnePxActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("fxp-OnePxActivity", "onCreate");

        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);

        startDaemonService();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fxp-OnePxActivity", "onResume");

        finish();
    }

    private void startDaemonService(){
        Log.e("fxp-OnePxActivity", "startDaemonService");

        try {
            Intent intent = new Intent("com.fxp.ipcdev.activity.OnePxActivity");
            startActivity(intent);

            handleMessage(handler, 0, "startDaemonService");
        } catch (Exception e) {
            e.printStackTrace();
            handleMessage(handler, 0, e.getMessage().toString());
        }
    }

    private void handleMessage(Handler h, int msgID, String data)
    {
        Message msg = new Message();
        msg.what = msgID;
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            String data = msg.getData().getString("data");
            switch (msg.what){
                case 0:
                    Toast.makeText(OnePxActivity.this, data, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

}
