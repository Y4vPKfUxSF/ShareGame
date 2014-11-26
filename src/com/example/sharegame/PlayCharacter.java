package com.example.sharegame;

import android.R.integer;
import android.graphics.Bitmap;


public class PlayCharacter {
	
	private Bitmap pCharImage;
	private integer gravity;
	private int charX;
	private int charY;
	private boolean position;
	
	/**
	 * �R���X�g���N�^
	 */
	public PlayCharacter(Bitmap pCharImage, int charX, int charY, boolean position){
		this.pCharImage = pCharImage;
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
	 * @param pCharImage �Z�b�g���� pCharImage
	 */
	public void setpCharImage(Bitmap pCharImage) {
		this.pCharImage = pCharImage;
	}
	/**
	 * @return gravity
	 */
	public integer getGravity() {
		return gravity;
	}
	/**
	 * @param gravity �Z�b�g���� gravity
	 */
	public void setGravity(integer gravity) {
		this.gravity = gravity;
	}
	/**
	 * @return charX
	 */
	public int getCharX() {
		return charX;
	}
	/**
	 * @param charX �Z�b�g���� charX
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
	 * @param charY �Z�b�g���� charY
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
	 * @param position �Z�b�g���� position
	 */
	public void setPosition(boolean position) {
		this.position = position;
	}
	
	/* (�� Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayCharacter [pCharImage=" + pCharImage + ", gravity="
				+ gravity + ", charX=" + charX + ", charY=" + charY
				+ ", position=" + position + "]";
	}
	
}
