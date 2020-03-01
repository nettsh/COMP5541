import javax.swing.*; // basic Swing stuffs
import java.awt.event.*; // ActionListener
import java.awt.*; // Layouts

public class DietTypePanel extends JPanel {

 JFrame dietTypeFrame;

 DietTypePanel(JFrame frame) {

  this.dietTypeFrame = frame;

  setLayout(new BorderLayout());

  JButton inDining = new JButton("In Dining");

  inDining.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("In Dining");
    String[] metadata = new String[]{"Name","Serving","Type"};
    frame.add(new FoodSpecificationsPanel(frame, metadata));
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
    frame.add(new FoodSpecificationsPanel(frame, metadata));
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
