package com.oldgoat5.bmstacticalreference.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

/*********************************************************************
 * @author Michael Evans
 * @since 1/19/17
 *********************************************************************/
public class ImageUtil
{
    /*****************************************************************
     * Resize a bitmap to be the width of the device screen
     * preserving the original aspect ratio.
     *
     * @return Returns int[width, height].
     *****************************************************************/
    public static int[] getImagePxByScreenDensity(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }

        int originalHeight = bitmap.getHeight();
        int originalWidth = bitmap.getWidth();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int screenWidthPx = displayMetrics.widthPixels;

        int newWidth = originalWidth;
        int newHeight = originalHeight;

        if (originalWidth > screenWidthPx) {
            newWidth = screenWidthPx;
            newHeight = (newWidth * originalHeight) / originalWidth;
        }

        return new int[]{newWidth, newHeight};
    }

    /*****************************************************************
     * Resize a bitmap to be the width of the device screen
     * preserving the original aspect ratio.
     *
     * @return Returns int[width, height].
     *****************************************************************/
    public static int[] getImagePxByWidth(Context context, Bitmap bitmap, int screenWidthPx) {
        if (bitmap == null) {
            return null;
        }

        int originalHeight = bitmap.getHeight();
        int originalWidth = bitmap.getWidth();

        int newWidth = originalWidth;
        int newHeight = originalHeight;

        if (originalWidth > screenWidthPx) {
            newWidth = screenWidthPx;
            newHeight = (newWidth * originalHeight) / originalWidth;
        }

        return new int[]{newWidth, newHeight};
    }
}
