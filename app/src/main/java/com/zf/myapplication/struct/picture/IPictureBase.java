package com.zf.myapplication.struct.picture;

import android.content.Context;
import android.widget.ImageView;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/26 0026 下午 5:26
 */

public interface IPictureBase {
    public <C extends Context> void loadImage(C c, String ImagePath, ImageView view);
}
