import javax.swing.*; // basic Swing stuffs.

import java.awt.*; // Layouts
import java.awt.event.*; // ActionListener

import javax.swing.table.*; // DefaultTableModel


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
  JTable itemTable = new JTable(new FoodTableModel(rowData, columnNames));

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

 FoodTableModel(Object[][] data, Object[] columnNames) {
  super(data, columnNames);
 }

 @Override
 public Class getColumnClass(int column) {
  return column == 3 ? Boolean.class : String.class;
 }
}

class FoodContextMenu extends JPopupMenu {

 public FoodContextMenu() {

  JMenuItem menuItemModify = new JMenuItem("Modify");
  JMenuItem menuItemRemove = new JMenuItem("Remove");

  menuItemModify.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Item Modification");
    String[] metadata = new String[]{"OutDining","Is","Cool"};
    frame.add(new FoodSpecificationsPanel(metadata));

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
   }

  });


  add(menuItemModify);
  add(menuItemRemove);
 }

}
