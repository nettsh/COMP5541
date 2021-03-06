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

  public PrimaryPanel(ApplicationController ctl) {

    String[] header = ctl.itemsHeader;
    ArrayList<FoodItem> foodItems = ctl.items;
      
    FoodTableModel itemTableModel = new FoodTableModel(header);
	
    JTable itemTable = new JTable(itemTableModel);

    System.out.println(Arrays.toString(header));
    
    for ( FoodItem foodItem : foodItems) {

	List<Object> row = new ArrayList <Object>();

	for ( String element : header ) {

	    Object tmp = foodItem.getAll().containsKey(element) ? foodItem.getAll().get(element) : "" ;

	    row.add(tmp);

	}

	itemTableModel.addRow(row.toArray());

	System.out.println(row);
	
    }
  
    //configure table
    itemTable.setComponentPopupMenu(new FoodContextMenu(itemTableModel, itemTable, ctl));
    itemTable.setAutoCreateRowSorter(true); //a generic sorter
    itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scroller = new JScrollPane(itemTable);

    // create food button
    JButton add = new JButton("Add");

    
  add.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Diet Type");
    frame.add(new DietTypePanel(frame, header, itemTableModel));
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
