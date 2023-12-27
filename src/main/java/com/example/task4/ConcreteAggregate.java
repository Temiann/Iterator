package com.example.task4;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class ConcreteAggregate implements Aggregate {
    private String filetopic;
    public ConcreteAggregate(String filetopic) {
        this.filetopic = filetopic;
    }

    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }

    public class ImageIterator implements Iterator {
        private int current = 0;

        private Image getImage(int iterator) {
            String filename = Paths.get("src/main/resources/img/" + filetopic + iterator + ".jpg").toUri().toString();
            return new Image(filename);
        }

        @Override
        public boolean hasNext() {
            return !getImage(current + 1).isError();
        }
        @Override
        public boolean hasPrev() {
            return !getImage(current - 1).isError();
        }
        @Override
        public Image next() {
            if(hasNext()){
                return getImage(++current);
            } else {
                current = 1;
                return getImage(current);
            }
        }
        @Override
        public Image prev() {
            if(hasPrev()){
                return getImage(--current);
            } else {
                current = 4;
                return getImage(current);
            }
        }
        /*
        @Override
        public Image preview() {
            this.current = 1;
            return getImage(1);
        }

        @Override
        public Image backview() {
            current = 4;
            return getImage(4);
        }
         */
    }
}