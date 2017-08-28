package com.zf.myapplication.struct.picture;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/28 0028 下午 2:45
 */

public class GlideImage implements IPictureBase {

    @Override
    public <C extends Context> void loadImage(C c, String ImagePath, ImageView view) {
        Glide.with(c)
                .load(ImagePath)
                .into(view);
    }
}
