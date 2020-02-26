import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.awt.event.*;

import java.util.Date;

public class UI {

	public static void main (String[] args) {

	      JFrame frame = new JFrame ("Personal Diatery Manager Application");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      
	      frame.add(new MainPanel());
	     
			
	      frame.pack();
	      
	      frame.setLocationRelativeTo(null);  // *** this will center your app ***
	      
	      frame.setVisible(true);
	 
	}
}

class MainPanel extends JPanel {
	
    Object[] columnNames = new Object[] { "Name" ,"Food group", "Time", "Eaten" };

    Object[][] rowData = new Object[][]{
  	  {"Apple","Fruits1","12PM", false},
  	  {"Apple","Fruits2","11PM", false},
  	  {"Apple","Fruits3","13PM", false},
  	  {"Apple","Fruits4","17PM", false},
  	  {"Apple","Fruits5","16PM", false},
  	  {"Apple","Fruits6","10PM", false},
  	  {"Apple","Fruits7","5PM", false},
  	  {"Apple","Fruits8","2PM", false},
  	  {"Apple","Fruits9","2PM", false}
    };
    
    public MainPanel () {
    	
    	// create food list (table)
        JTable itemTable = new JTable(new FoodTableModel(rowData, columnNames)); 
        
    	//configure table
        itemTable.setComponentPopupMenu(new FoodContextMenu());
        itemTable.setAutoCreateRowSorter(true); //a generic sorter
        itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroller = new JScrollPane( itemTable );
        
        // create food button
        JButton add = new JButton("Add");
        
        add.addActionListener( new ActionListener() {
        	
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame ("Diet Type");
                frame.add(new DietType(frame));
                frame.pack();
                frame.setVisible (true);
        		frame.setLocationRelativeTo(null);
            }
            
        });
            
        // configure panel
        setLayout(new BorderLayout());
        
        add(scroller, BorderLayout.CENTER);
        add(add, BorderLayout.SOUTH);
        
    }

}

class FoodTableModel extends DefaultTableModel {

	FoodTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}
	
    @Override
    public Class getColumnClass(int column)
    {
        return column == 3 ? Boolean.class : String.class;
    }
}

class FoodContextMenu extends JPopupMenu {
	
	public FoodContextMenu() {
		
		JMenuItem menuItemModify = new JMenuItem("Modify");
		JMenuItem menuItemRemove = new JMenuItem("Remove");
		
		menuItemModify.addActionListener( new ActionListener() {
        	
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame ("Out Dining");
                frame.add(new FoodSpecifications());
        		frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible (true);
            }
            
        });
        
        
		add(menuItemModify);
		add(menuItemRemove);
	}

}

class DietType extends JPanel {
	
	JFrame dietTypeFrame;
	
	DietType(JFrame frame) {
		
		this.dietTypeFrame = frame;
		
		setLayout(new BorderLayout());
		
		JButton inDining = new JButton("In Dining");
		
        inDining.addActionListener( new ActionListener() {
        	
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame ("In Dining");
                frame.add(new FoodSpecifications());
                frame.setVisible (true);
                frame.pack();
        		frame.setLocationRelativeTo(null);
        		dietTypeFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
            
        });
        
        
		JButton outDining = new JButton("Out Dining");
		
        outDining.addActionListener( new ActionListener() {
        	
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame ("Out Dining");
                frame.add(new FoodSpecifications());
        		frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible (true);
        		dietTypeFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
            
        });
		
        JPanel ChoicePanel = new JPanel();
        ChoicePanel.add(inDining);
        ChoicePanel.add(outDining);    
        
		this.add(ChoicePanel);
		
		}
	
}

class FoodSpecifications extends JPanel {
	

	public FoodSpecifications() {

		setBackground (Color.green);
        setLayout(new BorderLayout());

		// time selector        
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date()); // will only show the current time
		
        JPanel foodSpecificationsPanel = new JPanel();
        add(timeSpinner, BorderLayout.WEST);
			
	    Object[] columnNames = new Object[] { "Nutrition Facts" ,"Value" };

	    Object[][] rowData = new Object[][]{
	  	  {"Calories","20"},
	  	  {"Fat","Fruits2","15"},
	  	  {"Proteins","15"},
	  	  {"Carbohydrates","5"}
	    };
	    
        JTable itemTable = new JTable(rowData, columnNames); 

        add(itemTable, BorderLayout.EAST);
        
        JButton confirm = new JButton("Confirm");
        
        add(confirm, BorderLayout.SOUTH );
        
		add(foodSpecificationsPanel);
		
	}

}
