package com.pixelshift.shift.Event;

import android.view.MotionEvent;

import com.pixelshift.shift.Sticker.StickerView;

public interface StickerIconEvent {
    void onActionDown(StickerView paramStickerView, MotionEvent paramMotionEvent);

    void onActionMove(StickerView paramStickerView, MotionEvent paramMotionEvent);

    void onActionUp(StickerView paramStickerView, MotionEvent paramMotionEvent);
}