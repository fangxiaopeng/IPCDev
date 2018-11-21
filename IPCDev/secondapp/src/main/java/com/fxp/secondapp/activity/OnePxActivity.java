package com.fxp.secondapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

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

        initWindow();

        doSomeThing();
    }

    private void initWindow(){
        Window window = getWindow();
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);
    }

    private void doSomeThing(){
        // todo

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e("fxp-OnePxActivity", "onResume");

        finish();
    }
}
