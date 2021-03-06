// IDataServiceCallback.aidl
package com.fxp.secondapp.api;

// Declare any non-default types here with import statements

interface IDataServiceCallback {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onSuccess(String result);

    void onFailure(String error);
}
