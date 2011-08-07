package com.swarm.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.swarm.world.ObjectList;


@SuppressWarnings("serial")
public class Swarm extends JFrame {

	// window sizes and positions
	private int xSize = 700;
	private int ySize = 600;
	private int buttonWidth = 70;
	private int buttonHeight = 30;
	private int quitButtonStartX = xSize - (buttonWidth + 20);
	private int quitButtonEndX = buttonWidth;
	private int quitButtonStartY = ySize - (buttonWidth + 20);
	private int quitButtonEndY = buttonHeight;

	private int playButtonStartX = xSize - ((buttonWidth + 20) * 2);
	private int playButtonEndX = buttonWidth;
	private int playButtonStartY = ySize - (buttonWidth + 20);
	private int playButtonEndY = buttonHeight;
	
	private JFormattedTextField numberOfEntities = new JFormattedTextField();
	private JTextArea textPane = new JTextArea();
	private JButton quitButton = new JButton("Quit");
	private JButton openVisualDisplayButton = new JButton("View");
	private String[] entities = getEntityList();
	private String[] colours = getColourList();
	private JList entityList = new JList(entities);
	private JList colourList = new JList(colours);
	private JScrollPane entityListPane = new JScrollPane();
	private JScrollPane colourListPane = new JScrollPane();
	private JScrollPane logPane = new JScrollPane();
	private JButton addButton = new JButton("Add");
	private JButton clearButton = new JButton("Clear");
	private List<ObjectList> objectList = new ArrayList<ObjectList>();
	
	public Swarm() {
		initUI();
	}

	public final void initUI() {

		JPanel panel = new JPanel();
		panel.setLayout(null);

		// exit button
		quitButton.setBounds(quitButtonStartX, quitButtonStartY,quitButtonEndX, quitButtonEndY);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// open visualDisplay panel
		openVisualDisplayButton.setBounds(playButtonStartX, playButtonStartY, playButtonEndX, playButtonEndY);
		openVisualDisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						VisualDisplay visualDisplay = new VisualDisplay(objectList);
						visualDisplay.setVisible(true);
					}
				});
			}
		});
		
		// Set up entity list and create a scrollPane to display ut 
		entityList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				}
			}
		});

		entityList.setSelectedIndex(0);  // 2 should be the default
		entityListPane.getViewport().add(entityList);
		entityListPane.setBounds(20, 20, 200, 60);

		// Set up colour list and create a scrollPane to display ut 
		colourList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					System.out.println("New Colour change");
				}
			}
		});
		
		colourList.setSelectedIndex(0);
		colourListPane.getViewport().add(colourList);
		colourListPane.setBounds(220, 20, 200, 60);
		
		// Now set up text box to add number of entities (Integer only)
		//JFormattedTextField numberOfEntities = new JFormattedTextField();
		numberOfEntities.setValue(new Integer(1));  // 5 should be default
		numberOfEntities.setColumns(10);
		numberOfEntities.setBounds(420, 20, 60, 30);

		// Log pane lists what to create (contains textPane)
		logPane.setBounds(20, 90, 250, 80);
		logPane.getViewport().add(textPane);
		textPane.setEditable(false);
		textPane.setText("Objects being created in World");
        textPane.setBounds(20, 90, 250, 80);
       
		// Add entity button
		addButton.setBounds(482, 20,80, 30);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textPane.setText(textPane.getText() + "\n\r "  + entityList.getSelectedValue() + " " + colourList.getSelectedValue() + " " + numberOfEntities.getValue() + " ");
				// TODO need to add data to collection and then pass to panel to draw;
				// TODO probably should have an option here to open up a greater details page
				ObjectList oL = new ObjectList(entityList.getSelectedValue().toString(), (Integer) numberOfEntities.getValue(), colourList.getSelectedValue().toString() );
				objectList.add(oL);
			}
		});
        
        
		// Clear list button
		clearButton.setBounds(565, 20,80, 30);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//textPane.setText(textPane.getText() + "\n\r "  + entityList.getSelectedValue() + " " + colourList.getSelectedValue() + " " + numberOfEntities.getValue() + " ");
				textPane.setText("wibble");
				// TODO need to add data to collection and then pass to panel to draw;
				// TODO probably should have an option here to open up a greater details page
//				objectList.removeAll(objectList);
				};
		});
		
		
        
        // display everything on panel
		pack();
		add(panel);
		panel.add(entityListPane);
		panel.add(colourListPane);
		panel.add(logPane);
		panel.add(numberOfEntities);
		panel.add(quitButton);
		panel.add(addButton);
		panel.add(clearButton);
		panel.add(openVisualDisplayButton);

		setTitle("Spectra Main Console");
		setSize(xSize, ySize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private String[] getEntityList() {
		String[] entities = new String[10];

		entities[0] = "Cube";
		entities[1] = "Pyramid";
		entities[2] = "Sphere";
		entities[3] = "SphereGun";
		entities[4] = "Four";
		entities[5] = "Five";
		entities[6] = "Six";
		entities[7] = "Seven";
		entities[8] = "Eight";
		entities[9] = "Nine";

		return entities;
	}

	private String[] getColourList() {
		String[] colours = new String[14];
		colours[0] = "RANDOM";
		colours[1] = "WHITE";
		colours[2] = "YELLOW";
		colours[3] = "RED";
		colours[4] = "BLUE";
		colours[5] = "GREEN";
		colours[6] = "CYAN";
		colours[7] = "GRAY";
		colours[8] = "ORANGE";
		colours[9] = "MAGENTA";
		colours[10] = "PINK";
		colours[11] = "LIGHT_GRAY";
		colours[12] = "DARK_GRAY ";
		colours[13] = "BLACK";
		return colours;
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Swarm swarm = new Swarm();
				swarm.setVisible(true);
			}
		});
	}

}
