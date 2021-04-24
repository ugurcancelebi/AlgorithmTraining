package com.company.JavaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame implements ActionListener
{
    JLabel lblText = new JLabel("TEXT:");
    JTextField txtName = new JTextField();

    JButton btnDelete = new JButton("DELETE");
    JButton btnClear = new JButton("CLEAR");
    JButton btnAdd = new JButton("ADD");

    JLabel lblHome = new JLabel("HOMETOWN:");
    String[] list = {"Item1", "Item2", "Item3", "Item4", "Item5"};
    JComboBox cmbHome = new JComboBox(list);

    public Form1()
    {
        super("Sample App");
        setLayout(new GridLayout(8, 2));

        JPanel pnlGender = new JPanel(new BorderLayout());
        pnlGender.add(lblText, BorderLayout.CENTER);

        JPanel pnlJob = new JPanel(new FlowLayout());
        pnlJob.add(cmbHome);

        JPanel pnlClear = new JPanel(new BorderLayout());
        pnlClear.add(btnClear,BorderLayout.WEST);

        JPanel pnlAdd = new JPanel(new BorderLayout());
        pnlAdd.add(btnAdd,BorderLayout.BEFORE_FIRST_LINE);

        JPanel pnlDelete = new JPanel(new BorderLayout());
        pnlDelete.add(btnDelete,BorderLayout.EAST);

        add(txtName);
        add(lblHome); add(cmbHome);
        add(pnlJob);
        add(pnlGender);
        add(pnlClear); add(pnlAdd);  add(pnlDelete);

        pack();

        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnDelete.addActionListener(this);
    }
    public static void main(String[] args)
    {
        new Form1().setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAdd) {
            String data = txtName.getText();
            if(((DefaultComboBoxModel)cmbHome.getModel()).getIndexOf(data) == -1) {
                cmbHome.addItem(data);
            }
        } else if (e.getSource() == btnClear){
            txtName.setText("");
        } else if(e.getSource() == btnDelete) {
            for (int i = 0;i<cmbHome.getItemCount();i++) {
                if (cmbHome.getItemAt(i).equals(txtName.getText())) {
                    cmbHome.removeItemAt(i);
                    break;
                }
            }
        }
    }
}
