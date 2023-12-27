package com.example.task4;

import javafx.scene.image.Image;

public interface Iterator {
    public boolean hasNext();
    public boolean hasPrev();
    public Image next();
    public Image prev();
}
