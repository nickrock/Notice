package com.example.srk.noice;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class Food {
    private int id;
    private String name;
    private String price;
    private byte[] image;

    public Food( byte[] image, int id) {

        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
