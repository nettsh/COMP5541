import javax.swing.table.DefaultTableModel;

public class FoodTableModel extends DefaultTableModel {

    int headerLength ;

    FoodTableModel(Object[] columnNames, Object[][] data) {

    
        super(data, columnNames);

    this.addColumn("Eaten");
 }

 FoodTableModel(Object[] columnNames) {
     super(columnNames, 0);
     
     headerLength = this.getColumnCount();

 }

    
 @Override
 public Class getColumnClass(int column) {
     return column == 3 ? Boolean.class : String.class;
 }

}