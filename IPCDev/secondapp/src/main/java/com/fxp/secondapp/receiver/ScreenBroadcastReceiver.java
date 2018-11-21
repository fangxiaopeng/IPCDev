package com.fxp.secondapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Title:       ScreenBroadcastReceiver
 * <p>
 * Package:     com.fxp.secondapp.receiver
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/15 11:41 AM
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
public class ScreenBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("fxp", "onReceive action-" + action);
        if (Intent.ACTION_SCREEN_ON.equals(action)) { // 开屏

        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // 锁屏

        } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // 解锁

        } else if (Intent.ACTION_PACKAGE_REPLACED.equals(action)) { // 监听程序更新

        } else {}
    }
}
