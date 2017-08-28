package com.zf.myapplication.struct.picture;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/8/28 0028 下午 2:35
 */

public class PicassoImage implements IPictureBase {

    @Override
    public <C extends Context> void loadImage(C c, String ImagePath, ImageView view) {
        ViewGroup.LayoutParams para = view.getLayoutParams();
        int width = para.width;
        int height = para.height;
        Log.d("PicassoImage", "loadImage: width = " + width + " --- height = " + height);
        int maxwidth = width > height ? height : width;
        Picasso.with(c)
                .load(ImagePath)
                .resize(width, height)
                .centerCrop()
                .into(view);
    }
}
