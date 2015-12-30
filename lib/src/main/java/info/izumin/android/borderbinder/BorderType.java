package info.izumin.android.borderbinder;

import android.graphics.drawable.LayerDrawable;
import android.view.View;

/**
 * Created by izumin on 12/30/15.
 */
public enum BorderType {
    LEFT(25435) {
        @Override
        void setInsetToLayer(LayerDrawable layerDrawable, float width) {
            layerDrawable.setLayerInset(findIndexByLayerId(layerDrawable), 0, -(int) width, -(int) width, -(int) width);
        }
    },
    TOP(25436) {
        @Override
        void setInsetToLayer(LayerDrawable layerDrawable, float width) {
            layerDrawable.setLayerInset(findIndexByLayerId(layerDrawable), -(int) width, 0, -(int) width, -(int) width);
        }
    },
    RIGHT(25437) {
        @Override
        void setInsetToLayer(LayerDrawable layerDrawable, float width) {
            layerDrawable.setLayerInset(findIndexByLayerId(layerDrawable), -(int) width, -(int) width, 0, -(int) width);
        }
    },
    BOTTOM(25438) {
        @Override
        void setInsetToLayer(LayerDrawable layerDrawable, float width) {
            layerDrawable.setLayerInset(findIndexByLayerId(layerDrawable), -(int) width, -(int) width, -(int) width, 0);
        }
    };

    private final int id;

    BorderType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    int findIndexByLayerId(LayerDrawable layerDrawable) {
        for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
            if (layerDrawable.getId(i) == getId()) {
                return i;
            }
        }
        return View.NO_ID;
    }

    abstract void setInsetToLayer(LayerDrawable layerDrawable, float width);
}
