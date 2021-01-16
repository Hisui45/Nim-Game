package player;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javafx.scene.shape.Line;

public class Stick extends Line2D {
	
	private double baseSize = 5; 
	
	public Stick() {
//		this.setStartX(baseSize);
//		this.setEndX(-baseSize);
//		this.setStartY(-10);
//		this.setEndY((baseSize*2)+50);
//		this.setStrokeWidth(4);
		this.setLine(30,60,75,75);
	   // Line2D.Double arm1 =new Line2D.Double(30,60,75,75);
	
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point2D getP2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getX2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getY2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub
		
	}
}
