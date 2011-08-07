package com.swarm.ui;

import java.awt.Color;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.swarm.entities.Entity;
import com.swarm.world.ObjectList;


// This is the main graphical view onto the world
@SuppressWarnings("serial")
public class VisualDisplay extends JFrame {

	// attributes
	private int frameSizeX = 1000;
	private int frameSizeY = 550;
	private int buttonHeightAndBorder = 50;
	private List<ObjectList> objectList = new ArrayList<ObjectList>();

	public VisualDisplay(List<ObjectList> objectList) {
		this.objectList = objectList;
		initVisualDisplay();
	}

	public final void initVisualDisplay() {

		setFrameSizeXY(frameSizeX, frameSizeY);
		setTitle("Spectra World Painter View");
		setBounds(0, 0, frameSizeX, frameSizeY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		VisualDisplayPanel visualPanel = new VisualDisplayPanel(this, objectList, frameSizeX, frameSizeY);
		getContentPane().add(visualPanel);
		visualPanel.setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel controlPanel = new VisualDisplayControlPanel(this, visualPanel);
		getContentPane().add(controlPanel);
		controlPanel.setBackground(Color.GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		controlPanel.setMinimumSize(new Dimension(frameSizeX, buttonHeightAndBorder));
		controlPanel.setPreferredSize(new Dimension(frameSizeX, buttonHeightAndBorder));
		controlPanel.setMaximumSize(new Dimension(1000000, buttonHeightAndBorder));
		controlPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				controlPanel.getBorder()));
		visualPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.gray),
				controlPanel.getBorder()));

		getContentPane().setLayout(
				new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


	}

	public void repaintPanel() {
		repaint();
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

	public void setFrameSizeXY(int frameSizeX, int frameSizeY) {
		this.frameSizeX = frameSizeX;
		this.frameSizeY = frameSizeY;
	}

//	public void animate() {
//
//		int x;
//
//		for (x = 0; x < 180; x++) {
//
//			for (Entity entity : .getEntities()) {
//				// entity.regenerateObject();
//				entity.rotateXAxis(1);
//				entity.paintEntity(g, frameCentreX, frameCentreY);
//				this.repaint();
//				visualDisplay.repaint();
//
//			}
//		}
//	}

}
