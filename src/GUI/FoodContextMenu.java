import javax.swing.*; // basic Swing stuffs.

import java.awt.event.*; // ActionListener

public class FoodContextMenu extends JPopupMenu {

  private JTable itemTable;
  private FoodTableModel itemTableModel;
  private JMenuItem menuItemModify;
  private JMenuItem menuItemRemove;

 public FoodContextMenu() {

  JMenuItem menuItemModify = new JMenuItem("Modify");
  JMenuItem menuItemRemove = new JMenuItem("Remove");

  menuItemModify.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Item Modification");
    String[] metadata = new String[]{"OutDining","Is","Cool"};
    frame.add(new FoodSpecificationsPanel(frame, metadata));

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
   }

  });


  add(menuItemModify);
  add(menuItemRemove);
 }

 public FoodContextMenu(FoodTableModel itemTableModel, JTable itemTable, ApplicationController ctl) {
        this.itemTableModel = itemTableModel;
        this.itemTable = itemTable;

        JMenuItem menuItemModify = new JMenuItem("Modify");
        JMenuItem menuItemRemove = new JMenuItem("Remove");

        menuItemModify.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Item Modification");
                String[] metadata = new String[]{"OutDining","Is","Cool"};
                frame.add(new FoodSpecificationsPanel(frame, metadata));

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

        menuItemModify.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Listener for modify button"+ itemTable.getSelectedRow());
            }
        });
        add(menuItemModify);
        add(menuItemRemove);
    }

}
