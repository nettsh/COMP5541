import javax.swing.*; // basic Swing stuffs.

import java.awt.*; // Layouts
import java.awt.event.*; // ActionListener

import javax.swing.table.*; // DefaultTableModel

import java.util.ArrayList; // arraylist
import java.util.Arrays; // debugging

import java.util.Map;
import java.util.Vector;
import java.util.List;

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

	List<Object> row = new ArrayList <Object>();

	//	System.out.println(foodItem.getAll());
		    
	for ( String element : header ) {
	    /*
	    if ( element.equals("Eaten") )
		 continue;
	    */


	    Object tmp = foodItem.getAll().containsKey(element) ? foodItem.getAll().get(element) : "" ;

	    row.add(tmp);

	    //	    System.out.println(row);
	 }

	System.out.println(row);
	model.addRow(row.toArray());

    }
    
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
     
     headerLength = this.getColumnCount();

 }

    
 @Override
 public Class getColumnClass(int column) {
     return column == 3 ? Boolean.class : String.class;
 }

}
