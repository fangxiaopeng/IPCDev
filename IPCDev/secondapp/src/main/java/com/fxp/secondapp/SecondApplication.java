package com.fxp.secondapp;

import android.app.Application;

/**
 * Title:       SecondApplication
 * <p>
 * Package:     com.fxp.secondapp
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/11/13 3:20 PM
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/11/13    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class SecondApplication extends Application {

    private SecondApplication instance;

    public SecondApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

    }

}
