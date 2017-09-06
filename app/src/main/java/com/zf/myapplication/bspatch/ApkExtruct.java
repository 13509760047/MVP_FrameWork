package com.zf.myapplication.bspatch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;

import java.io.File;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/9/6 0006 下午 4:30
 */

public class ApkExtruct {
    public static String extract(Context context) {
        context = context.getApplicationContext();
        ApplicationInfo info = context.getApplicationInfo();
        String path = info.sourceDir;
        return path;
    }

    public static void install(Context context, String apkPath) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnp.android.package-archive");
        context.startActivity(i);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
