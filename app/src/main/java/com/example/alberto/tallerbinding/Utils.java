package com.example.alberto.tallerbinding;

import android.app.Application;
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
import java.util.Random;

/**
 * Created by Alberto on 28/09/2015.
 */
public class Utils {

    //esto es un sacrilegio y el mcontext static aun mas, habria que trasladarlo al Activity
    public static Command getHelloWorldCommand() {
        return new helloWorldCommand(MainActivity.mContext);
    }

    //Uso de funciones desde UX para reflejo visual
    public static String MayusQlizar(String txt) {
        String str = "";
        if (txt != null && txt != "")
            str = txt.toUpperCase();
        return str;
    }

    //region funciones generar datos fake
    public static String getRandomTitle() {
        String[] titles = {
                "Mr",
                "Miss",
                "Mister",
                "Doc",
                "Conde",
                "Duque",
                "Generalisimo",
                "Conde Duque de Olivares"
        };

        return getRandomValueFromArray(titles);
    }

    public static String getRandomName() {
        String[] names = {
                "Grijander",
                "Carlos Jesús",
                "Jesulin",
                "Paquito",
                "Pepito",
                "Dimitri"
        };

        return getRandomValueFromArray(names);
    }

    public static String getRandomSurName() {
        String[] surnames = {
                "Gonzalez",
                "Garcia",
                "Dominguez",
                "Monder",
                "Fernandez"
        };

        return getRandomValueFromArray(surnames);
    }

    public static String getRandomPhone() {
        String[] phones = {
                "679369962",
                "679368596",
                "626901020",
                "696234726",
                "656464587"
        };

        return getRandomValueFromArray(phones);
    }

    public static String getRandomEmail() {

        String[] emails = {
                "mentira@jeje.lie",
                "example-guion@flinger.com",
                "fuck@fock.fack",
                "whatever@uwant.com",
                "pepe@paca.com"
        };

        return getRandomValueFromArray(emails);
    }

    public static String getRandomPicture() {
        String[] pictures = {
                "http://ep00.epimg.net/cultura/imagenes/2013/02/17/actualidad/1361125096_165058_1361125223_noticia_normal.jpg",
                "http://i.gifs.com/1Yr.gif",
                "http://i.gifs.com/1YN.gif",
                "http://i.gifs.com/1ym.gif",
                "http://i.gifs.com/1YA.gif",
                "http://i.gifs.com/1aC.gif",
                "http://estaticos01.marca.com/imagenes/2015/05/11/futbol/equipos/real_madrid/1431296590_extras_portada_0.jpg",
                "http://estaticos.marca.com/imagenes/2015/05/11/motor/formula1/gp-espana/1431332444_extras_portada_0.jpg"

        };
        return getRandomValueFromArray(pictures);
    }

    public static String getRandomValueFromArray(String[] myRandomArr) {
        int max = myRandomArr.length - 1;

        Random rnd = new Random();
        int idx = rnd.nextInt(max);
        return myRandomArr[idx];
    }

    //endregion
}
