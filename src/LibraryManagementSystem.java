import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;

public class LibraryManagementSystem extends javax.swing.JFrame {
 private static final String username = "root";
   private static final String password = "1234";
    private static final String dataConn = "jdbc:mysql://localhost:3306/library";
    
    public LibraryManagementSystem() {
        initComponents();
        Connect();
        LoadLibraryNo();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dataConn,username,password);
        }catch(ClassNotFoundException ex){
            
            Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadLibraryNo(){
        
     try {
         pst = con.prepareStatement("SELECT id FROM library");
         rs = pst.executeQuery();
         
         bookId.removeAllItems();
         
         while(rs.next()){
             
             bookId.addItem(rs.getString(1));
         }
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    private void Fetch(){
        
     try {
         int q;
         pst = con.prepareStatement("SELECT * FROM library");
         rs = pst.executeQuery();
         
        ResultSetMetaData rss = rs.getMetaData();
        
        q = rss.getColumnCount();
        
        DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
        
        df.setRowCount(0);
        while(rs.next()){
            Vector v2 = new Vector();
            
            for(int a=1; a<= q;a++){
                v2.add(rs.getString("ID"));
                v2.add(rs.getString("bookName"));
                v2.add(rs.getString("bookAuthor"));
                v2.add(rs.getString("bookDate"));
                v2.add(rs.getString("bookBorrow"));
            }
            df.addRow(v2);
        }
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jLabel4 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        addBook = new javax.swing.JButton();
        deleteBook = new javax.swing.JButton();
        updateBook = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        bookText = new javax.swing.JTextField();
        authorText = new javax.swing.JTextField();
        bookId = new javax.swing.JComboBox<>();
        updateBook1 = new javax.swing.JButton();
        exportBtn = new javax.swing.JButton();
        borrowText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("label1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Serif", 2, 48)); // NOI18N
        jLabel5.setText("LIBRARY MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(145, 145, 145))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1010, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Author", "Date", "Borrowed"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 260));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 650, 260));

        searchBtn.setText("SEARCH");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 130, 70));

        addBook.setText("ADD BOOK");
        addBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookActionPerformed(evt);
            }
        });
        getContentPane().add(addBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 130, 70));

        deleteBook.setText("DELETE BOOK");
        deleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookActionPerformed(evt);
            }
        });
        getContentPane().add(deleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 130, 70));

        updateBook.setText("UPDATE BOOK");
        updateBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookActionPerformed(evt);
            }
        });
        getContentPane().add(updateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 120, 70));

        jLabel1.setText("BOOK:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 100, 40));

        jLabel2.setText("AUTHOR:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel3.setText("DATE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 160, -1));

        bookText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTextActionPerformed(evt);
            }
        });
        getContentPane().add(bookText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 160, -1));
        getContentPane().add(authorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, -1));

        bookId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        updateBook1.setText("UPDATE BOOK");
        updateBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBook1ActionPerformed(evt);
            }
        });
        getContentPane().add(updateBook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 110, 70));

        exportBtn.setText("EXPORT DATA");
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });
        getContentPane().add(exportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 110, 70));
        getContentPane().add(borrowText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, -1));

        jLabel6.setText("Borrow:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookActionPerformed
     if(bookText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Book Name is Required! ");
        }else if(authorText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Author is Required! ");
        }else if(dateText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Date is Required! ");
        }else{
        try {
         String bookName = bookText.getText();
         String bookAuthor = authorText.getText();
         String bookDate = dateText.getText();
         String bookBorrow = borrowText.getText();
         String ID = bookId.getSelectedItem().toString();
         
         pst = con.prepareStatement("UPDATE library SET bookName=?,bookAuthor=?,bookDate=?, bookBorrow=? WHERE ID=?");
         
         pst.setString(1, bookName);
         pst.setString(2, bookAuthor);
         pst.setString(3, bookDate);
         pst.setString(4, bookBorrow);
         pst.setString(5, ID);
         
         
         
         int k = pst.executeUpdate();
         
         if(k==1){
              JOptionPane.showMessageDialog(this, "Record Updated ");
              
              bookText.setText("");
              authorText.setText("");
              dateText.setText("");
              borrowText.setText("");
              
              bookText.requestFocus();
              LoadLibraryNo();
              Fetch();
         }
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_updateBookActionPerformed
    }
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
     try {
         String ID = bookId.getSelectedItem().toString();
         
         pst = con.prepareStatement("SELECT * FROM library WHERE ID=?");
         pst.setString(1, ID);
         rs = pst.executeQuery();
         
         if(rs.next()==true){
            
             bookText.setText(rs.getString(2));
             authorText.setText(rs.getString(3));
             dateText.setText(rs.getString(4));
             borrowText.setText(rs.getString(5));
            
         }else{
             JOptionPane.showMessageDialog(this, "No Record Found! ");
         }
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookActionPerformed
        if(bookText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Book Name is Required! ");
        }else if(authorText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Author is Required! ");
        }else if(dateText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Date is Required! ");
        }else{
        
        try {
            String bookName = bookText.getText();
            String bookAuthor = authorText.getText();
            String bookDate = dateText.getText();
            String bookBorrow = borrowText.getText();
            
            pst = con.prepareStatement("INSERT INTO library (bookName,bookAuthor,bookDate,bookBorrow) VALUES (?,?,?,?) ");
            pst.setString(1, bookName);
            pst.setString(2, bookAuthor);
            pst.setString(3, bookDate);
            pst.setString(4, bookBorrow);
            
            int k = pst.executeUpdate();
            
            if(k == 1){
                
                JOptionPane.showMessageDialog(this, "Record Added! ");
                bookText.setText("");
                authorText.setText("");
                dateText.setText("");
                borrowText.setText("");
                
                Fetch();
                LoadLibraryNo();
            }else{
                JOptionPane.showMessageDialog(this, "Record Failed to saved!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_addBookActionPerformed

    private void bookTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTextActionPerformed

    private void deleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookActionPerformed
     try {
         String ID = bookId.getSelectedItem().toString();
         
         pst = con.prepareStatement("DELETE FROM library WHERE ID=?");
         pst.setString(1,ID);
         int k = pst.executeUpdate();
         
         if(k==1){
             JOptionPane.showMessageDialog(this, "Record Deleted");
              bookText.setText("");
                authorText.setText("");
                dateText.setText("");
                borrowText.setText("");
                LoadLibraryNo();
                Fetch();
         }else{
             JOptionPane.showMessageDialog(this, "Record Failed To Delete");
         }
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_deleteBookActionPerformed

    private void updateBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBook1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBook1ActionPerformed

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
    String filename = "D:\\ExportedFileJava.csv";
    
     try {
         FileWriter fw = new FileWriter(filename);
         pst = con.prepareStatement("SELECT * FROM library ");
         
         rs = pst.executeQuery();
         
         while(rs.next()){
             fw.append(rs.getString(1));
             fw.append(',');
             fw.append(rs.getString(2));
             fw.append(',');
             fw.append(rs.getString(3));
             fw.append(',');
             fw.append(rs.getString(4));
             fw.append(',');
             fw.append(rs.getString(5));
             fw.append('\n');
         }
         JOptionPane.showMessageDialog(this, "CSV File is exported Successfully");
         fw.flush();
         fw.close();
     } catch (IOException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(LibraryManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_exportBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBook;
    private javax.swing.JTextField authorText;
    private javax.swing.JComboBox<String> bookId;
    private javax.swing.JTextField bookText;
    private javax.swing.JTextField borrowText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField dateText;
    private javax.swing.JButton deleteBook;
    private javax.swing.JButton exportBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton updateBook;
    private javax.swing.JButton updateBook1;
    // End of variables declaration//GEN-END:variables
}
