package picture.model;

import java.awt.Color;
import java.awt.Graphics;

public class Figure {
	private double x;
	private double y;
	private double z;
	private double r;
	private int shape;
	private Color color;
    public static final int ROUND = 0;
    public static final int DIAMOND = 1;
    
	public Figure(double x, double y, double z, double r, int shape, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
		this.shape = shape;
		this.color = color;
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return z;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getR() {
		return r;
	}
	
	public void setR(double r) {
		this.r = r;
	}
	
	public Color getColors() {
		return color;
	}

	public void setColors(Color color) {
		this.color = color;
	}
	
	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}
	
	public void draw(Graphics g, int size){
		// 一点透視図法による描画
        final double CENTER = size / 2.0;
        double dd = CENTER / (z + CENTER);
        double rr = r * dd;
        double xx = x * dd - rr + CENTER;
        double yy = y * dd - rr + CENTER;
        g.setColor(color);
        
        if (shape == ROUND) {
            g.fillOval((int) xx, (int) yy, (int) rr * 2, (int) rr * 2);
        } else if (shape == DIAMOND) {
            g.fillRect((int) xx, (int) yy, (int) rr * 2, (int) rr * 2);
        }
	}
	
	public void move(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
}
