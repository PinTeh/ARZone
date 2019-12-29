/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package cn.imhtb.zone.view;

import android.content.Context;

import com.baidu.ar.ARController;

/**
 * ARController manager
 */
public class ARControllerManager {

    private static ARControllerManager arControllerManager;

    /**
     * 设置单例 只能有一个arController实例
     */
    private ARController arController;

    private ARControllerManager(Context context) {
        arController = new ARController(context);
    }

    public static ARControllerManager getInstance(Context context) {
        if (arControllerManager == null) {
            arControllerManager = new ARControllerManager(context);
        }
        return arControllerManager;
    }

    public ARController getArController() {
        return arController;
    }

    public void release() {
        arController.release();
        arControllerManager = null;
    }
}
