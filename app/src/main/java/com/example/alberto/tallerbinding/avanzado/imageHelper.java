package com.example.alberto.tallerbinding.avanzado;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Alberto on 09/10/2015.
 */
public class imageHelper {
    public static class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
//todo falta hacerle un blur al borde
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
           /*  paint.setFilterBitmap(true);
            paint.setDither(true);*/
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }

//    https://github.com/wasabeef/glide-transformations/

    public static class BlurTransformation implements Transformation<Bitmap> {

        private static int MAX_RADIUS = 25;
        private static int DEFAULT_DOWN_SAMPLING = 1;

        private Context mContext;
        private BitmapPool mBitmapPool;

        private int mRadius;
        private int mSampling;

        public BlurTransformation(Context context) {
            this(context, Glide.get(context).getBitmapPool(), MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
        }

        public BlurTransformation(Context context, BitmapPool pool) {
            this(context, pool, MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
        }

        public BlurTransformation(Context context, BitmapPool pool, int radius) {
            this(context, pool, radius, DEFAULT_DOWN_SAMPLING);
        }

        public BlurTransformation(Context context, int radius) {
            this(context, Glide.get(context).getBitmapPool(), radius, DEFAULT_DOWN_SAMPLING);
        }

        public BlurTransformation(Context context, BitmapPool pool, int radius, int sampling) {
            mContext = context;
            mBitmapPool = pool;
            mRadius = radius;
            mSampling = sampling;
        }

        public BlurTransformation(Context context, int radius, int sampling) {
            mContext = context;
            mBitmapPool = Glide.get(context).getBitmapPool();
            mRadius = radius;
            mSampling = sampling;
        }

        @Override
        public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
            Bitmap source = resource.get();

            int width = source.getWidth();
            int height = source.getHeight();
            int scaledWidth = width / mSampling;
            int scaledHeight = height / mSampling;

            Bitmap bitmap = mBitmapPool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(bitmap);
            canvas.scale(1 / (float) mSampling, 1 / (float) mSampling);
            Paint paint = new Paint();
            paint.setFlags(Paint.FILTER_BITMAP_FLAG);
            canvas.drawBitmap(source, 0, 0, paint);

            RenderScript rs = RenderScript.create(mContext);
            Allocation input = Allocation.createFromBitmap(rs, bitmap, Allocation.MipmapControl.MIPMAP_NONE,
                    Allocation.USAGE_SCRIPT);
            Allocation output = Allocation.createTyped(rs, input.getType());
            ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

            blur.setInput(input);
            blur.setRadius(mRadius);
            blur.forEach(output);
            output.copyTo(bitmap);

            rs.destroy();

            return BitmapResource.obtain(bitmap, mBitmapPool);
        }



        @Override public String getId() {
            return "BlurTransformation(radius=" + mRadius + ", sampling=" + mSampling + ")";
        }
    }

}
