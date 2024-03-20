package com.pixelshift.shift.Event;

import android.view.MotionEvent;

import com.pixelshift.shift.Sticker.StickerView;

public abstract class AbstractFlipEvent implements StickerIconEvent {
    protected abstract int getFlipDirection();

    public void onActionDown(StickerView paramStickerView, MotionEvent paramMotionEvent) {
    }

    public void onActionMove(StickerView paramStickerView, MotionEvent paramMotionEvent) {
    }

    public void onActionUp(StickerView paramStickerView, MotionEvent paramMotionEvent) {
        paramStickerView.flipCurrentSticker(getFlipDirection());
    }
}
