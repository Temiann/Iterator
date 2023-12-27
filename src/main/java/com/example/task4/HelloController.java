package com.example.task4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {
    public Button prevB;
    public Button nextB;
    public Button startB;
    public ImageView imageView;
    @FXML
    public TextField timer = new TextField();
    Timeline time = new Timeline();
    public ConcreteAggregate concreteAggregate = new ConcreteAggregate("");
    public Iterator iterator = concreteAggregate.getIterator();

    public void onPrevClick(ActionEvent actionEvent) {
        /*
        if (iterator.hasNext(-1)){
            imageView.setImage((Image) iterator.prev());
        } else {
            imageView.setImage((Image) iterator.backview());
        }
         */
        imageView.setImage(iterator.prev());
    }
    public void onNextClick(ActionEvent actionEvent) {
        /*
        if (iterator.hasNext(1)){
            imageView.setImage((Image)iterator.next());
        } else {
            imageView.setImage((Image) iterator.preview());
        }
         */
        imageView.setImage(iterator.next());
    }

    @FXML
    protected void onStartButton(ActionEvent event) {
        int speed = Integer.parseInt(timer.getText());

        if (startB.getText().equals("Start")) {
            startB.setText("Stop");

            time = new Timeline();
            time.setCycleCount(Timeline.INDEFINITE);
            time.getKeyFrames().add(new KeyFrame(Duration.seconds(speed), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /*
                    if (iterator.hasNext(1)){
                        imageView.setImage((Image) iterator.next());
                    }
                    else imageView.setImage((Image) iterator.preview());
                     */
                    imageView.setImage((Image) iterator.next());
                }
            }));
            time.play();
        } else if (startB.getText().equals("Stop")) {
            startB.setText("Start");
            time.stop();
        }
    }
}