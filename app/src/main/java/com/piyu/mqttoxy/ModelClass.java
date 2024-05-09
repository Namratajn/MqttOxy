package com.piyu.mqttoxy;

public class ModelClass {
    String name;
    String onOff;
    int image ;

    public ModelClass(String name, String onOff, int image) {
        this.name = name;
        this.onOff = onOff;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnOff() {
        return onOff;
    }

    public void setOnOff(String onOff) {
        this.onOff = onOff;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
