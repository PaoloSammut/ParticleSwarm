package com.swarm.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.swarm.mathPhysicsEngine.ScreenPoint;
import com.swarm.mathPhysicsEngine.WorldPoint;

public class SphereEntity extends Entity {

	private double radius = 25;
	private double x, y, z; // Calculated vertex coordinates
	private double k, j; // Loop counters
			// private float[] rgbaColour = new float[4];

	public SphereEntity() {
		noOfVertices = 0;
		noOfLines = 12;
		objectType = "SPHERE";

		List<WorldPoint> spherePoints = new ArrayList<WorldPoint>();

		for (j = 0; j < Math.PI; j = j + 0.125) {

			for (k = 0; k < (Math.PI * 2); k = k + 0.125) {
				// for (k = 0; k < (Math.PI * 2); k = k + 0.5) {
				x = radius * Math.cos(k) * Math.sin(j);
				y = radius * Math.sin(k) * Math.sin(j);
				z = radius * Math.cos(j);
				spherePoints.add(new WorldPoint(x, y, z));
			}
		}

		// now bind these into the standard entity model
		noOfVertices = spherePoints.size();
		objectPoints = new WorldPoint[noOfVertices];
		screenPoints = new ScreenPoint[noOfVertices];

		int j = 0;
		for (WorldPoint points : spherePoints) {
			objectPoints[j] = new WorldPoint(points.getX(), points.getY(),
					points.getZ());
			j++;
		}

		regenerateObject();
	} // end of sphere entity

	public SphereEntity(double scaleFactor) {
		this();
		this.scaleEntity(scaleFactor);
	} // end of sphere entity

	@Override
	public void generateVectorLines() {
		// TODO Auto-generated method stub
	}

	@Override
	public void generateLineScreenCoordinates() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintEntity(Graphics g, int frameCentreX, int frameCentreY) {
		// TODO Auto-generated method stub
		int i = 0;
		Color colour = new Color((float) rgbaColour[0], (float) rgbaColour[1],
				(float) rgbaColour[2], (float) rgbaColour[3]);

		for (ScreenPoint points : screenPoints) {

			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(colour);

			g2d.drawLine((int) points.getX() + frameCentreX,
					(int) points.getY() + frameCentreY, (int) points.getX()
							+ frameCentreX, (int) points.getY() + frameCentreY);
			i++;
		}

	}

	// public float[] getRgbaColour() {
	// return rgbaColour;
	// }
	//
	// public void setRgbaColour(float[] rgbaArray) {
	// this.rgbaColour = rgbaArray;
	// }

	// for (j = 0; j < Math.PI; j=j+0.125) {
	// for (k = 0; k < (Math.PI * 2); k=k+0.125) {
	// x = radius * Math.cos(k) * Math.sin(j);
	// y = radius * Math.sin(k) * Math.sin(j);
	// z = radius * Math.cos(j);
	//
	// // screenPoints[i] = cubePoints[i].perspective(cubePoints[i], new
	// Camera(Camera.getX(), Camera.getY(), Camera.getZ()));
	//
	// Vector point = new Vector (x, y, z);
	// ScreenCoordinates sc = new ScreenCoordinates(point.perspective(point, new
	// Camera(Camera.getX(), Camera.getY(), Camera.getZ())));
	// g2d.drawLine ((int)sc.getX() + frameCentreX*2,(int)sc.getY() +
	// frameCentreY,(int)sc.getX() + frameCentreX*2,(int)sc.getY() +
	// frameCentreY);
	// }
	// }
	//

}
