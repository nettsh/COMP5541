import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

import java.util.Date;

public class FoodSpecificationsPanel extends JPanel {


 public FoodSpecificationsPanel(String[] metadata) {

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

  for(int i=0; i<metadata.length; i++) {
    JTextField field = new JTextField(metadata[i]);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = i+1;
    foodMetadata.add(field, c);
  }

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
  foodMetadata.add(confirm);
  
  add(confirm, BorderLayout.SOUTH);

  add(foodMetadata, BorderLayout.WEST);

  }

}