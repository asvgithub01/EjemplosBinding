package com.example.alberto.tallerbinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.alberto.tallerbinding.commands.Command;
import com.example.alberto.tallerbinding.commands.helloWorldCommand;
import com.squareup.okhttp.OkHttpClient;

import java.io.InputStream;

/**
 * Created by Alberto on 09/10/2015.
 */
public  class BindingAdapters {

    //region BindingAdapter para cargar imagenes
    @BindingAdapter("bind:onLoadImageUrlSimple")
    public static void setLoadImageUrlSimple(ImageView imageView, String este_parametro_sobra)//comprobado que el @null no chuta
    {
        imageView.setImageResource(R.drawable.magic);
    }


    @BindingAdapter("bind:loadImageUrl")
    public static void setLoadImageUrl(ImageView imageView, String url)//, final ImageView imageView)
    {
        //init
        Context context = imageView.getContext();
        Glide.get(context).register(GlideUrl.class, InputStream.class,
                new OkHttpUrlLoader.Factory(new OkHttpClient()));

        if (!TextUtils.isEmpty(url)) {
            GlideUrl glideUrl = new GlideUrl(url);

            //este contexto no sirve para agregar otre imageview     haga de placeholder
          /*  if (url.contains(".gif")) {
                ImageView imgAux = new ImageView(context);
                Glide.with(context).load(url).asBitmap().into(imgAux);
                Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(imgAux.getDrawable()).into(imageView);//asv a ver si con cache mejora el tiempo de mostrar imagen
            } else*/
            Glide.with(context).load(url).into(imageView);

        }

    }


    /* Este es un ejemplo de una funcion q necesita recibir varios argumentos,
    se le pasa cada tipo de argumento por una propiedad, q se llam -setloadImageWithPlaceholder*/
    /*IMPORTA, order de los parametros(el primero el View, y si recibe varios en orden de entrada,
    el nombre de la funcion no tiene nada q ver con como se invoca la misma
    el enganche se crea mediante el nombre de los parametros, noolvidarse ninguno*/
    @BindingAdapter({"bind:loadImageUrl", "bind:placeholder"})
    public static void setLoadImageWithPlaceholder(ImageView imageView, String url, Drawable placeholder) {
        //init
        Context context = imageView.getContext();
        Glide.get(context)
                .register(GlideUrl.class, InputStream.class,
                        new OkHttpUrlLoader.Factory(new OkHttpClient()));

        if (!TextUtils.isEmpty(url)) {
            GlideUrl glideUrl = new GlideUrl(url);

            Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(placeholder).into(imageView);


        }
    }
    //endregion

    //region (Bindings adapters), para introducir commands, o cutres listener ;P

    @BindingAdapter("bind:commandOnClick")
    public static void setCommandOnclick(View v, final Command command) {

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute(v);
            }
        });

    }

    @BindingAdapter({"bind:commandOnClick","bind:commandOnClickWithParam"})
    public static void setCommandOnclick(View v, final Command command, final Object o) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command.execute(v, o);
            }
        });
    }

    @BindingAdapter("bind:commandOnItemClick")
    public static void setCommandOnItemclick(View v, final Command command) {

    }
    //endregion

}
