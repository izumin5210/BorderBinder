package info.izumin.android.borderbinder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;

/**
 * Created by izumin on 12/30/15.
 */
final class BorderBindingUtils {
    private BorderBindingUtils() {
        throw new AssertionError("constructor of the utility class should not be called");
    }

    static LayerDrawable addLayer(LayerDrawable layerDrawable, Drawable drawable) {
        final int n = layerDrawable.getNumberOfLayers() + 1;
        final Drawable[] drawables = new Drawable[n];
        for (int i = 0; i < n - 1; i++) {
            drawables[i] = layerDrawable.getDrawable(i);
        }
        drawables[n - 1] = drawable;
        final LayerDrawable newLayerDrawable = new LayerDrawable(drawables);
        for (int i = 0; i < n - 1; i++) {
            if (layerDrawable.getId(i) != View.NO_ID) {
                newLayerDrawable.setId(i, layerDrawable.getId(i));
            }
        }
        return newLayerDrawable;
    }

    static LayerDrawable addLayer(LayerDrawable layerDrawable, Drawable drawable, int id) {
        LayerDrawable newLayerDrawable = addLayer(layerDrawable, drawable);
        newLayerDrawable.setId(newLayerDrawable.getNumberOfLayers() - 1, id);
        return newLayerDrawable;
    }

    static LayerDrawable setBorderLeftDrawable(LayerDrawable layerDrawable, int color, float width) {
        return setBorder(layerDrawable, BorderType.LEFT, color, width);
    }

    static LayerDrawable setBorderTopDrawable(LayerDrawable layerDrawable, int color, float width) {
        return setBorder(layerDrawable, BorderType.TOP, color, width);
    }

    static LayerDrawable setBorderRightDrawable(LayerDrawable layerDrawable, int color, float width) {
        return setBorder(layerDrawable, BorderType.RIGHT, color, width);
    }

    static LayerDrawable setBorderBottomDrawable(LayerDrawable layerDrawable, int color, float width) {
        return setBorder(layerDrawable, BorderType.BOTTOM, color, width);
    }

    private static LayerDrawable setBorder(LayerDrawable layerDrawable, BorderType borderType, int color, float width) {
        final Drawable newBorderDrawable = getBorderDrawable(layerDrawable, borderType, color, width);
        final LayerDrawable newLayerDrawable = addLayer(layerDrawable, newBorderDrawable, borderType.getId());
        borderType.setInsetToLayer(newLayerDrawable, width);
        return newLayerDrawable;
    }

    private static Drawable getBorderDrawable(LayerDrawable layerDrawable, BorderType borderType, int color, float width) {
        GradientDrawable drawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(borderType.getId());
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        drawable.setStroke((int) width, color);
        return drawable;
    }

    static LayerDrawable getCurrentDrawable(View view) {
        final Drawable currentDrawable = view.getBackground();
        if (currentDrawable == null) {
            return new LayerDrawable(new Drawable[0]);
        } else if (currentDrawable instanceof LayerDrawable) {
            return (LayerDrawable) currentDrawable;
        } else {
            return new LayerDrawable(new Drawable[]{currentDrawable});
        }
    }

    static void setDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}