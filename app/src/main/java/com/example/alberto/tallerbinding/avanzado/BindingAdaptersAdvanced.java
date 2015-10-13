package com.example.alberto.tallerbinding.avanzado;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Created by Alberto on 09/10/2015.
 */
public class BindingAdaptersAdvanced {

    @BindingAdapter("bind:loadCircleImageUrl")
    public static void setLoadImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.get(context).register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(new OkHttpClient()));

        Glide.with(context).load(url).transform(new imageHelper.CircleTransform(context)).into(imageView);
    }

    @BindingAdapter("bind:changeFontText")
    public static void setChangeFontText(TextView v, int pen) {
        {
           /*crear assets y pegar una fuente*/
            /*doStuff cargar fuente*/
        }

    }
}