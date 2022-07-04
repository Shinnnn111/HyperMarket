package main;

import java.util.*;
import java.util.stream.*;
import javax.swing.table.*;

public class ItemsList extends javax.swing.JFrame {
    private String custID;
    private int counterNumber = 0;
    private double totalPayment = 0;

    public ItemsList(String custID, int counterNumber) {
        this.custID = custID;
        this.counterNumber = counterNumber;
        initComponents();
        itemtitlelabel.setText("List Item for customer " + custID);
        pack();
        setLocationRelativeTo(null);
        displayItem();
    }

    private void displayItem() {
        DefaultTableModel itemTableModel = (DefaultTableModel) itemTable.getModel();
        itemTableModel.setRowCount(0);
        //TO CONVERT, NEED TO FILTER ITEM ONLY AND ADD TO NEW LIST
        List<CustomerInformation> convertedItemList = null;
        List<CustomerInformation> filteredItemListCust = null;
        if (counterNumber == 1) {
            convertedItemList = (List<CustomerInformation>) main.Main.getCounter1().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 2) {
            convertedItemList = (List<CustomerInformation>) main.Main.getCounter2().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        } else if (counterNumber == 3) {
            convertedItemList = (List<CustomerInformation>) main.Main.getCounter3().stream().collect(Collectors.toList());
            filteredItemListCust = convertedItemList.stream().filter(items -> items.getCustID().equalsIgnoreCase(custID)).collect(Collectors.toList());
        }

        countlabelitem.setText(filteredItemListCust.size() + " Items");

        for (Iterator iterator = filteredItemListCust.iterator(); iterator.hasNext();) {
            CustomerInformation nextItemData = (CustomerInformation) iterator.next();
            //ALSO CALCULATE TOTAL PAYMENT HERE
            totalPayment = totalPayment + nextItemData.getitemPrice();
            itemTableModel.addRow(new Object[]{nextItemData.getItemID(), nextItemData.getItemName(), "RM " + nextItemData.getitemPrice(), nextItemData.getDatePurchase()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        itemtitlelabel = new javax.swing.JLabel();
        countlabelitem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ITEM");

        jPanel2.setBackground(new java.awt.Color(255, 0, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        itemtitlelabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        itemtitlelabel.setForeground(new java.awt.Color(255, 255, 255));
        itemtitlelabel.setText("List Item");

        countlabelitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countlabelitem.setForeground(new java.awt.Color(255, 255, 255));
        countlabelitem.setText("0 Items");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(countlabelitem))
                    .addComponent(itemtitlelabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(itemtitlelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(countlabelitem)
                .addContainerGap())
        );

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Price", "Date Purchased"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countlabelitem;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel itemtitlelabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
