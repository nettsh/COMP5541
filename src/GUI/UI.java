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

  frame.add(new PrimaryPanel());


  frame.pack();

  frame.setLocationRelativeTo(null); // *** this will center your app ***

  frame.setVisible(true);

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
    String[] metadata = new String[]{"Name","Serving","Type"};
    frame.add(new FoodSpecificationsPanel(metadata));
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
    String[] metadata = new String[]{"Retailer","Meal","Group"};
    frame.add(new FoodSpecificationsPanel(metadata));
    frame.setVisible(true);
    frame.pack();
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
