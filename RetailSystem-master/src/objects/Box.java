/*
 * Class Name: Box.java
 * Class Description: This class creates a box item that stores the box dimensions and weight limit.
 * Created By: Tami Adeduntan (C18327556)
 */

package objects;

public class Box {

	int length;
	int width;
	int height;
	int weight;

	public Box(int length, int width, int height, int weight) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
