package com.pixelshift.shift.Listener;

import com.pixelshift.shift.Editor.BrushDrawingView;

public interface BrushViewChangeListener {
    void onStartDrawing();

    void onStopDrawing();

    void onViewAdd(BrushDrawingView brushDrawingView);

    void onViewRemoved(BrushDrawingView brushDrawingView);
}
