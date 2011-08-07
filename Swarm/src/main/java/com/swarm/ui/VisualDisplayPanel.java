package com.swarm.ui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.swarm.entities.Entity;
import com.swarm.world.ObjectList;
import com.swarm.world.World;

@SuppressWarnings("serial")
public class VisualDisplayPanel extends JPanel implements Runnable {

	private int frameSizeX;
	private int frameSizeY;
	private int frameCentreX; // These are used to "displace" the centre of the
								// world (0,0,0) to the centre of the screen
	private int frameCentreY;
	protected List<ObjectList> objectList = new ArrayList<ObjectList>();
	private World world;
	private boolean worldCreator = false;
	private Graphics g;
	private VisualDisplay visualDisplay;

	public VisualDisplayPanel (final VisualDisplay visualDisplay,
			List<ObjectList> objectList, int frameSizeX, int frameSizeY) {
		this.objectList = objectList;
		this.visualDisplay = visualDisplay;

		this.setFrameSizeX(frameSizeX);
		this.setFrameSizeY(frameSizeY);

		this.setFrameCentreX((int) (frameSizeX / 2));
		this.setFrameCentreY((int) (frameSizeY / 2));

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.g = g;

		// initalise the world
		if (!worldCreator) {
			world = new World(this.objectList);
			worldCreator = true;
		}

		for (Entity entity : world.getEntities()) {
			entity.regenerateObject();
			entity.paintEntity(g, frameCentreX, frameCentreY);
		}
	}

	public void animate() {

		Thread thread = new Thread(this);
		thread.start();
		
	}

	public void run() {

			for (int x = 0; x < 1000; x++) {
				for (Entity entity : world.getEntities()) {
					entity.rotateXAxis(1);
					entity.rotateYAxis(1);
					entity.rotateZAxis(1);
					entity.regenerateObject();
					entity.paintEntity(g, frameCentreX, frameCentreY);
				}
				this.repaint();
				visualDisplay.repaint();
			}
			
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {}
	}
	
	public int getFrameSizeX() {
		return frameSizeX;
	}

	public int getFrameSizeY() {
		return frameSizeY;
	}

	public void setFrameSizeX(int frameSizeX) {
		this.frameSizeX = frameSizeX;
	}

	public void setFrameSizeY(int frameSizeY) {
		this.frameSizeY = frameSizeY;
	}

	public int getFrameCentreX() {
		return frameCentreX;
	}

	public int getFramecentreY() {
		return frameCentreY;
	}

	public void setFrameCentreX(int frameCentreX) {
		this.frameCentreX = frameCentreX;
	}

	public void setFrameCentreY(int frameCentreY) {
		this.frameCentreY = frameCentreY;
	}

}