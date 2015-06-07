package com.example.sharegame;

import android.graphics.Bitmap;


public class PlayCharacter {
	
	private Bitmap pCharImage;
	private int gravity;
	private float charX;
	private float charY;
	private int position;
	
	public PlayCharacter(Bitmap pcharimage, int g, float x, float y, int p) {
		pCharImage = pcharimage;
		gravity = g;
		charX = x;
		charY = y;
		position = p;
	}
	
	/**
	 * @return pCharImage
	 */
	public Bitmap getpCharImage() {
		return pCharImage;
	}
	/**
	 * @param pCharImage セットする pCharImage
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
	 * @param gravity セットする gravity
	 */
	public void setGravity(int gravity) {
		this.gravity = gravity;
	}
	/**
	 * @return charX
	 */
	public float getCharX() {
		return charX;
	}
	/**
	 * @param charX セットする charX
	 */
	public void setCharX(float charX) {
		this.charX = charX;
	}
	/**
	 * @return charY
	 */
	public float getCharY() {
		return charY;
	}
	/**
	 * @param charY セットする charY
	 */
	public void setCharY(float charY) {
		this.charY = charY;
	}
	/**
	 * @return position
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @param position セットする position
	 */
	public void setPosition(int position) {
		this.position = position;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayCharacter [pCharImage=" + pCharImage + ", gravity="
				+ gravity + ", charX=" + charX + ", charY=" + charY
				+ ", position=" + position + "]";
	}
	
}
