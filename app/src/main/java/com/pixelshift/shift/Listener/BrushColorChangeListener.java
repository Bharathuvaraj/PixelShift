package com.pixelshift.shift.Listener;

import com.pixelshift.shift.Editor.BrushDrawingView;

public interface BrushColorChangeListener {
    void onStartDrawing();

    void onStopDrawing();

    void onViewAdd(BrushDrawingView brushDrawingView);

    void onViewRemoved(BrushDrawingView brushDrawingView);
}
