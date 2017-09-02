package com.zf.myapplication.struct.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import static android.R.attr.tag;

/**
 * creater: zf
 * qq: 2033152950
 * time:2017/9/2 0002 上午 9:40
 */

public class VolleyImage implements IPictureBase {

    private RequestQueue queue;

    public VolleyImage(RequestQueue queue1) {
        queue = queue1;
    }

    @Override
    public <C extends Context> void loadImage(C c, String ImagePath, final ImageView view) {
        ImageRequest imageRequest = new ImageRequest(
                ImagePath, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                view.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {

            }
        });
        imageRequest.setTag(tag);
        queue.add(imageRequest);
    }
}
