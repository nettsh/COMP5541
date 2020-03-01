import javax.swing.*; // basic Swing stuffs.

import java.awt.event.*; // ActionListener

public class FoodContextMenu extends JPopupMenu {

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

}
