package info.izumin.android.borderbinder;

import android.databinding.BindingAdapter;
import android.graphics.drawable.LayerDrawable;
import android.view.View;

import static info.izumin.android.borderbinder.BorderBindingUtils.getCurrentDrawable;
import static info.izumin.android.borderbinder.BorderBindingUtils.setBorderBottomDrawable;
import static info.izumin.android.borderbinder.BorderBindingUtils.setBorderLeftDrawable;
import static info.izumin.android.borderbinder.BorderBindingUtils.setBorderRightDrawable;
import static info.izumin.android.borderbinder.BorderBindingUtils.setBorderTopDrawable;
import static info.izumin.android.borderbinder.BorderBindingUtils.setDrawable;

/**
 * Created by izumin on 12/29/15.
 */
public class BorderBindingAdapter {
    public static final String TAG = BorderBindingAdapter.class.getSimpleName();

    private static final String ATTR_NAME_NAMESPACE = "android";
    private static final String ATTR_NAME_PREFIX = ATTR_NAME_NAMESPACE + ":" + "border";

    private static final String ATTR_COLOR            = ATTR_NAME_PREFIX + "Color";
    private static final String ATTR_LEFT_COLOR       = ATTR_NAME_PREFIX + "LeftColor";
    private static final String ATTR_TOP_COLOR        = ATTR_NAME_PREFIX + "TopColor";
    private static final String ATTR_RIGHT_COLOR      = ATTR_NAME_PREFIX + "RightColor";
    private static final String ATTR_BOTTOM_COLOR     = ATTR_NAME_PREFIX + "BottomColor";

    private static final String ATTR_WIDTH            = ATTR_NAME_PREFIX + "Width";
    private static final String ATTR_LEFT_WIDTH       = ATTR_NAME_PREFIX + "LeftWidth";
    private static final String ATTR_TOP_WIDTH        = ATTR_NAME_PREFIX + "TopWidth";
    private static final String ATTR_RIGHT_WIDTH      = ATTR_NAME_PREFIX + "RightWidth";
    private static final String ATTR_BOTTOM_WIDTH     = ATTR_NAME_PREFIX + "BottomWidth";

    @BindingAdapter({ATTR_COLOR, ATTR_WIDTH})
    public static void setBorder(View view, int color, float width) {
        LayerDrawable layerDrawable = getCurrentDrawable(view);
        layerDrawable = setBorderLeftDrawable(layerDrawable, color, width);
        layerDrawable = setBorderTopDrawable(layerDrawable, color, width);
        layerDrawable = setBorderRightDrawable(layerDrawable, color, width);
        layerDrawable = setBorderBottomDrawable(layerDrawable, color, width);
        setDrawable(view, layerDrawable);
    }

    @BindingAdapter({ATTR_COLOR, ATTR_LEFT_WIDTH})
    public static void setBorderColorAndBorderLeftWidth(View view, int color, float width) {
        setBorderLeft(view, color, width);
    }

    @BindingAdapter({ATTR_LEFT_COLOR, ATTR_WIDTH})
    public static void setBorderColorLeftAndBorderWidth(View view, int color, float width) {
        setBorderLeft(view, color, width);
    }

    @BindingAdapter({ATTR_LEFT_COLOR, ATTR_LEFT_WIDTH})
    public static void setBorderLeft(View view, int color, float width) {
        LayerDrawable layerDrawable = getCurrentDrawable(view);
        layerDrawable = setBorderLeftDrawable(layerDrawable, color, width);
        setDrawable(view, layerDrawable);
    }

    @BindingAdapter({ATTR_COLOR, ATTR_TOP_WIDTH})
    public static void setBorderColorAndBorderTopWidth(View view, int color, float width) {
        setBorderTop(view, color, width);
    }

    @BindingAdapter({ATTR_TOP_COLOR, ATTR_WIDTH})
    public static void setBorderColorTopAndBorderWidth(View view, int color, float width) {
        setBorderTop(view, color, width);
    }

    @BindingAdapter({ATTR_TOP_COLOR, ATTR_TOP_WIDTH})
    public static void setBorderTop(View view, int color, float width) {
        LayerDrawable layerDrawable = getCurrentDrawable(view);
        layerDrawable = setBorderTopDrawable(layerDrawable, color, width);
        setDrawable(view, layerDrawable);
    }

    @BindingAdapter({ATTR_COLOR, ATTR_RIGHT_WIDTH})
    public static void setBorderColorAndBorderRightWidth(View view, int color, float width) {
        setBorderRight(view, color, width);
    }

    @BindingAdapter({ATTR_RIGHT_COLOR, ATTR_WIDTH})
    public static void setBorderColorRightAndBorderWidth(View view, int color, float width) {
        setBorderRight(view, color, width);
    }

    @BindingAdapter({ATTR_RIGHT_COLOR, ATTR_RIGHT_WIDTH})
    public static void setBorderRight(View view, int color, float width) {
        LayerDrawable layerDrawable = getCurrentDrawable(view);
        layerDrawable = setBorderRightDrawable(layerDrawable, color, width);
        setDrawable(view, layerDrawable);
    }

    @BindingAdapter({ATTR_COLOR, ATTR_BOTTOM_WIDTH})
    public static void setBorderColorAndBorderBottomWidth(View view, int color, float width) {
        setBorderBottom(view, color, width);
    }

    @BindingAdapter({ATTR_BOTTOM_COLOR, ATTR_WIDTH})
    public static void setBorderColorBottomAndBorderWidth(View view, int color, float width) {
        setBorderBottom(view, color, width);
    }

    @BindingAdapter({ATTR_BOTTOM_COLOR, ATTR_BOTTOM_WIDTH})
    public static void setBorderBottom(View view, int color, float width) {
        LayerDrawable layerDrawable = getCurrentDrawable(view);
        layerDrawable = setBorderBottomDrawable(layerDrawable, color, width);
        setDrawable(view, layerDrawable);
    }
}
