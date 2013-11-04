package picture.model;

import java.awt.Graphics;

import picture.util.PictureError;

public class Panel {
	/** 画面の一辺の長さ */
    public static final int SIZE = 600;
    /** 図形の最大個数 */
    public static final int MAX_FIGURES = 10;
    /** 発行された図形の個数 */
    public int figureCount;

    private Figure[] elements;

    public Figure[] getElements() {
		return elements;
	}

	public void setElements(Figure[] elements) {
		this.elements = elements;
	}

	public Panel() {
		super();
	}

	public void create(Figure[] elements) throws PictureError {
    	this.figureCount = elements.length;
    	System.out.print(this.figureCount);
    	if(figureCount > MAX_FIGURES) {
				throw new PictureError("the numbers of figure is larger than the max of figures!");
    	}
    	this.elements = elements;
    }
    
    public void draw(Graphics g) {
        for (int i = 0; i < figureCount; ++i) {
        	elements[i].draw(g, SIZE);
        }
    }

	public void lateralMove(Figure element, double theta) {
		element.move(300.0 * Math.cos(theta + 1.0), 10, 300.0 * Math.sin(theta + 1.0) + 300);
	}
	
	public void verticalMove(Figure element, double theta) {
		element.move(30, 300.0 * Math.cos(theta), 250.0 * Math.sin(theta) + 250);
	}
}
