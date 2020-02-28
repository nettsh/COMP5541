import javax.swing.*; // basic Swing stuffs

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

