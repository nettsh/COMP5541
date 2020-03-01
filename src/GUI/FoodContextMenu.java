import javax.swing.*; // basic Swing stuffs.

import java.awt.event.*; // ActionListener

public class FoodContextMenu extends JPopupMenu {

  private JTable itemTable;
  private FoodTableModel itemTableModel;
  private JMenuItem menuItemModify;
  private JMenuItem menuItemRemove;
  private JMenuItem menuItemSetEatenFlag;

 public FoodContextMenu(FoodTableModel itemTableModel, JTable itemTable, ApplicationController ctl) {
        this.itemTableModel = itemTableModel;
        this.itemTable = itemTable;

        JMenuItem menuItemModify = new JMenuItem("Modify(Increment2)");
        JMenuItem menuItemRemove = new JMenuItem("Remove");
        JMenuItem menuItemSetEatenFlag = new JMenuItem("Mark/UnMark Eaten");

        menuItemModify.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Item Modification");
                String[] metadata = new String[]{"OutDining","Is","Cool"};
                frame.add(new FoodSpecificationsPanel(frame, metadata, ctl.itemsHeader, itemTableModel));

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });

        menuItemRemove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ctl.removeById(String.valueOf(itemTableModel.getValueAt(itemTable.getSelectedRow(), 0)));
                ctl.saveFoodItems("FoodItemsToRead.txt");
                itemTableModel.removeRow(itemTable.getSelectedRow());
            }
        });

        menuItemSetEatenFlag.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String id = String.valueOf(itemTableModel.getValueAt(itemTable.getSelectedRow(), 0));
                Boolean eatenFlag = true;
                if ((Boolean)(itemTableModel.getValueAt(itemTable.getSelectedRow(), 3)) == true) {
                    eatenFlag = false;
                    itemTableModel.setValueAt(eatenFlag, itemTable.getSelectedRow(), 3);
                } else {
                    itemTableModel.setValueAt(eatenFlag, itemTable.getSelectedRow(), 3);
                }
                ctl.setEatenFlagById(id, eatenFlag);
                ctl.saveFoodItems("FoodItemsToRead.txt");
            }
        });
        add(menuItemSetEatenFlag);
        add(menuItemRemove);
        add(menuItemModify);
    }

}
