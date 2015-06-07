package com.example.sharegame;

import android.graphics.Bitmap;

public class PlayCharacter {

    private Bitmap pCharImage;
    private int gravity;
    private int charX;
    private int charY;
    private boolean position;

    public PlayCharacter(Bitmap pCharImage, int gravity, int charX, int charY, boolean position) {
        this.pCharImage = pCharImage;
        this.gravity = gravity;
        this.charX = charX;
        this.charY = charY;
        this.position = position;
    }

    /**
     * @return pCharImage
     */
    public Bitmap getpCharImage() {
        return pCharImage;
    }

    /**
     * @param pCharImage
     *            セットする pCharImage
     */
    public void setpCharImage(Bitmap pCharImage) {
        this.pCharImage = pCharImage;
    }

    /**
     * @return gravity
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * @param gravity
     *            セットする gravity
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    /**
     * @return charX
     */
    public int getCharX() {
        return charX;
    }

    /**
     * @param charX
     *            セットする charX
     */
    public void setCharX(int charX) {
        this.charX = charX;
    }

    /**
     * @return charY
     */
    public int getCharY() {
        return charY;
    }

    /**
     * @param charY
     *            セットする charY
     */
    public void setCharY(int charY) {
        this.charY = charY;
    }

    /**
     * @return position
     */
    public boolean isPosition() {
        return position;
    }

    /**
     * @param position
     *            セットする position
     */
    public void setPosition(boolean position) {
        this.position = position;
    }

    /*
     * (非 Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlayCharacter [pCharImage=" + pCharImage + ", gravity="
                + gravity + ", charX=" + charX + ", charY=" + charY
                + ", position=" + position + "]";
    }

}
