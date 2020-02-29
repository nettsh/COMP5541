import javax.swing.*; // basic Swing stuffs.

import java.awt.*; // Layouts
import java.awt.event.*; // ActionListener

import javax.swing.table.*; // DefaultTableModel

import java.util.ArrayList; // arraylist
import java.util.Arrays; // debugging

import java.util.Map;
import java.util.Vector;

public class PrimaryPanel extends JPanel {

 Object[] columnNames = new Object[] {
  "Name",
  "Food group",
  "Time",
  "Eaten"
 };

 Object[][] rowData = new Object[][] {
  {
   "Apple",
   "Fruits1",
   "12PM",
   false
  }, {
   "Apple",
   "Fruits2",
   "11PM",
   false
  }
 };

 public PrimaryPanel() {

  // create food list (table)
     JTable itemTable = new JTable(new FoodTableModel(columnNames, rowData));

  //configure table
  itemTable.setComponentPopupMenu(new FoodContextMenu());
  itemTable.setAutoCreateRowSorter(true); //a generic sorter
  itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  JScrollPane scroller = new JScrollPane(itemTable);

  // create food button
  JButton add = new JButton("Add");

  add.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Diet Type");
    frame.add(new DietTypePanel(frame));
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
   }

  });

  // configure panel
  setLayout(new BorderLayout());

  add(scroller, BorderLayout.CENTER);
  add(add, BorderLayout.SOUTH);

 }

  public PrimaryPanel(String[] header, ArrayList<FoodItem> foodItems ) {

    FoodTableModel model = new FoodTableModel(header);
	
    JTable itemTable = new JTable(model);

    for( FoodItem foodItem : foodItems) {

	Vector<String> row = new Vector<>();
	
	for ( String element : header ) {

	    String tmp = foodItem.getAll().containsKey(element) ? foodItem.getAll().get(element) : "" ;
		
	    row.add(tmp);
	    
	    //	    System.out.println("iterating through " +

	 }

	model.addRow(row);

	/*
	    if ( foodItem.class.getField(element) ) {

		System.out.println( foodItem.getId() + " has property " + element );
		
		}
	    */
    }
	//System.out.println(foodItem);
    
    //configure table
    itemTable.setComponentPopupMenu(new FoodContextMenu());
    itemTable.setAutoCreateRowSorter(true); //a generic sorter
    itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scroller = new JScrollPane(itemTable);

    // create food button
    JButton add = new JButton("Add");

    
  add.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Diet Type");
    frame.add(new DietTypePanel(frame));
    frame.pack();
    frame.setVisible(true);
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

    int headerLength ;

    FoodTableModel(Object[] columnNames, Object[][] data) {

	
        super(data, columnNames);

	this.addColumn("Eaten");
 }

 FoodTableModel(Object[] columnNames) {
     super(columnNames, 0);
     
     this.addColumn("Eaten");

     headerLength = this.getColumnCount();

     System.out.println(headerLength);

 }

    
 @Override
 public Class getColumnClass(int column) {
     return column == headerLength-1 ? Boolean.class : String.class;
 }

}
