package com.swarm.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.swarm.mathPhysicsEngine.Camera;

@SuppressWarnings("serial")
public class VisualDisplayControlPanel extends JPanel {

	// private World worldObjects;
	private JButton quitButton = new JButton("Quit");
	private JButton playButton = new JButton("Play");
	private JSlider thetaSlider;
	private JSlider phiSlider;
	private JSlider rhoSlider;

	public VisualDisplayControlPanel(final VisualDisplay visualDisplay,
			final VisualDisplayPanel visualDisplayPanel) {

		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				visualDisplay.setVisible(false);

				// reset sliders so that if page is reopened the initial camera
				// frame is not broken
				thetaSlider.setValue(240);
				phiSlider.setValue(240);
				rhoSlider.setValue(100);
			}
		});

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				visualDisplayPanel.animate();

			}
		});

		this.add(Box.createHorizontalGlue());
		thetaSlider = new JSlider(0, 360, 240);
		thetaSlider.setPreferredSize(new Dimension(150, 30));
		phiSlider = new JSlider(0, 360, 240);
		phiSlider.setPreferredSize(new Dimension(150, 30));
		rhoSlider = new JSlider(80, 2360, 100);
		rhoSlider.setPreferredSize(new Dimension(150, 30));

		thetaSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				int thetaValue = thetaSlider.getValue();
				Camera.setX((double) thetaValue);
				visualDisplay.repaint();
			}
		});

		phiSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				int phiValue = phiSlider.getValue();
				Camera.setY((double) phiValue);
				visualDisplay.repaint();
			}
		});

		rhoSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				int rhoValue = rhoSlider.getValue();
				Camera.setZ((double) rhoValue);
				visualDisplay.repaint();
			}
		});

		this.add(thetaSlider);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(phiSlider);
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		this.add(rhoSlider);
		this.add(Box.createRigidArea(new Dimension(5, 0)));

		add(playButton);
		add(quitButton);

		quitButton.setVisible(true);
	}

}
