package com.example.sharegame;

import android.graphics.Bitmap;

public class Enemy {

    private int id;
    private Bitmap eCharImage;
    private int charX;
    private int charY;
    private int color;

    //
    public Enemy(int id, Bitmap eCharImage, int charX, int charY, int color) {
        this.id = id;
        this.eCharImage = eCharImage;
        this.charX = charX;
        this.charY = charY;
        this.color = color;
    }

    /**
     * @return the index
     */
    public int getId() {
        return id;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the eCharImage
     */
    public Bitmap geteCharImage() {
        return eCharImage;
    }

    /**
     * @param eCharImage
     *            the eCharImage to set
     */
    public void seteCharImage(Bitmap eCharImage) {
        this.eCharImage = eCharImage;
    }

    /**
     * @return the charX
     */
    public float getCharX() {
        return charX;
    }

    /**
     * @param charX
     *            the charX to set
     */
    public void setCharX(int charX) {
        this.charX = charX;
    }

    /**
     * @return the charY
     */
    public float getCharY() {
        return charY;
    }

    /**
     * @param charY
     *            the charY to set
     */
    public void setCharY(int charY) {
        this.charY = charY;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Enemy [id=" + id + ", eCharImage=" + eCharImage + ", charX="
                + charX + ", charY=" + charY + ", color=" + color + "]";
    }
}