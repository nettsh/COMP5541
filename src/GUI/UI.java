import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.DateFormatter;

import java.awt.*;
import java.awt.event.*;

import java.util.Date;

public class UI {

 public static void main(String[] args) {

  JFrame frame = new JFrame("Personal Diatery Manager Application");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.add(new MainPanel());


  frame.pack();

  frame.setLocationRelativeTo(null); // *** this will center your app ***

  frame.setVisible(true);

 }
}

class MainPanel extends JPanel {

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

 public MainPanel() {

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
    frame.add(new DietType(frame));
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
    JFrame frame = new JFrame("Out Dining");
    frame.add(new FoodSpecifications());
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
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

  inDining.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("In Dining");
    frame.add(new FoodSpecificationsInDining());
    frame.setVisible(true);
    frame.pack();
    frame.setLocationRelativeTo(null);
    dietTypeFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

   }

  });


  JButton outDining = new JButton("Out Dining");

  outDining.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Out Dining");
    frame.add(new FoodSpecificationsOutDining());
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    dietTypeFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
   }

  });

  JPanel ChoicePanel = new JPanel();
  ChoicePanel.add(inDining);
  ChoicePanel.add(outDining);

  this.add(ChoicePanel);

 }

}

class FoodSpecificationsInDining extends JPanel {


 public FoodSpecificationsInDining() {

  setBackground(Color.green);
  setLayout(new BorderLayout());


  JPanel foodMetadata = new JPanel();
  foodMetadata.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();

  // time selector        
  JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
  JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
  timeSpinner.setEditor(timeEditor);
  timeSpinner.setValue(new Date()); // will only show the current time

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 0;
  foodMetadata.add(timeSpinner, c);


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

  // name

  JTextField dietName = new JTextField("name");

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 1;
  foodMetadata.add(dietName, c);
  
  // type (assuming foodgroup)

  JTextField dietType = new JTextField("type");

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 2;
  foodMetadata.add(dietType, c);

  // confirm button

  JButton confirm = new JButton("Confirm");

  foodMetadata.add(confirm);

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 3;
  add(confirm, BorderLayout.SOUTH);

  add(foodMetadata, BorderLayout.WEST);

  }

}

 class FoodSpecificationsOutDining extends JPanel {


  public FoodSpecificationsOutDining() {


  setBackground(Color.green);
  setLayout(new BorderLayout());


  JPanel foodMetadata = new JPanel();
  foodMetadata.setLayout(new GridBagLayout());
  GridBagConstraints c = new GridBagConstraints();

  // time selector        
  JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
  JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
  timeSpinner.setEditor(timeEditor);
  timeSpinner.setValue(new Date()); // will only show the current time

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 0;
  foodMetadata.add(timeSpinner, c);


  // nutrition fact
  Object[] columnNames = new Object[] {
   "Nutrition Facts",
   "Value"
  };

  Object[][] rowData = new Object[][] {
   {
    "meal",
    "15"
   }
  };

  JTable itemTable = new JTable(rowData, columnNames);
  add(itemTable, BorderLayout.EAST);

  // retailer

  JTextField dietRetailer = new JTextField("retailer");

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 1;
  foodMetadata.add(dietRetailer, c);
  
  // type (assuming foodgroup)

  JTextField dietGroup = new JTextField("group");

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 2;
  foodMetadata.add(dietGroup, c);

  // confirm button

  JButton confirm = new JButton("Confirm");

  foodMetadata.add(confirm);

  c.fill = GridBagConstraints.HORIZONTAL;
  c.gridx = 0;
  c.gridy = 3;
  add(confirm, BorderLayout.SOUTH);

  add(foodMetadata, BorderLayout.WEST);

  }


 }

