import javax.swing.*; // Basic Swing stuff
import java.awt.event.*; // ActionListener
import java.awt.*; // Layouts

import javax.swing.table.*;

import java.text.SimpleDateFormat; // format date into Text
import java.util.Date; // feature in TimeSpinner

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import java.util.UUID;

import java.util.Arrays; // debugging

public class FoodSpecificationsPanel extends JPanel {
    
    public FoodSpecificationsPanel(JFrame parentFrame, String[] metadata, String[] header, FoodTableModel itemTableModel) {
	
	setBackground(Color.green);
	setLayout(new BorderLayout());

	JPanel foodMetadataPanel = new JPanel();
	foodMetadataPanel.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();

	// time selector
	JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
	JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "yyyy-MM-dd HH:mm:ss");
	timeSpinner.setEditor(timeEditor);
	timeSpinner.setValue(new Date()); // will only show the current time

	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	foodMetadataPanel.add(timeSpinner, c);

	Map<String,JTextField> textFields = new HashMap<>();

	for(int j=0; j<metadata.length; j++) {

	    if ( Arrays.stream(header).anyMatch(metadata[j]::equals) ) {

		JTextField field = new JTextField(metadata[j]);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = j+1;
		foodMetadataPanel.add(field, c);

		textFields.put(metadata[j], field);

	    }

	}

	add(foodMetadataPanel, BorderLayout.WEST);

	// nutrition fact
	Object[] columnNames = new Object[] {
	    "Nutrition Facts",
	    "Value"
	};

	Object[][] rowData = new Object[][] {
	    {
		"serving size",
		"15"
	    }
	};

	JTable itemTable = new JTable(rowData, columnNames);
	add(itemTable, BorderLayout.EAST);

	// confirm button

	JButton confirm = new JButton("Confirm");

	confirm.addActionListener( new ActionListener() {

		public void actionPerformed (ActionEvent e) {


		    // Text Fields
		    Map<String,Object> metadata = new HashMap<>();
			
		    for ( Map.Entry<String,JTextField> textField : textFields.entrySet() ) {
			metadata.put(textField.getKey(), textField.getValue().getText());
		    }

		    // ID
		    
		    UUID uuid = UUID.randomUUID();

		    metadata.put("Id", uuid.toString());


		    // Eaten
		    
		    metadata.put("Eaten", Boolean.TRUE );

		    // Date
		    
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					    
		    metadata.put("Time", format.format(timeSpinner.getValue()) ) ;

		    // create object now

		    List<Object> row = new ArrayList <Object>();
				    
		    FoodItem foodItem ;
		    
		    foodItem = parentFrame.getTitle().equals("Out Dining") ? new OutDining ( metadata ) : new InDining ( metadata );

		    for ( String element : header ) {

			Object tmp = foodItem.getAll().containsKey(element) ? foodItem.getAll().get(element) : "" ;

			row.add(tmp);
		    
		    }

		    itemTableModel.addRow(row.toArray());

		    ApplicationController.add(foodItem);
		    ApplicationController.saveFoodItems("FoodItemsToRead.txt");
		}


	    });

	    add(confirm, BorderLayout.SOUTH);


	    }

    }
