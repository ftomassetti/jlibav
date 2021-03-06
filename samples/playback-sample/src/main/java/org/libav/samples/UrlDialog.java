/*
 * Copyright (C) 2012 Ondrej Perutka
 *
 * This program is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.libav.samples;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.libav.avformat.IInputFormatWrapper;
import org.libav.avformat.InputFormatWrapperFactory;
import org.libav.avformat.bridge.AVFormatLibrary;

/**
 * Dialog for selecting URL.
 * 
 * @author Ondrej Perutka
 */
public class UrlDialog extends javax.swing.JDialog {

    public static final int RESULT_OK = 1;
    public static final int RESULT_CANCEL = 0;
    
    private int dialogResult;
    
    public UrlDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        
        dialogResult = RESULT_CANCEL;
        
        tfUrl.setPreferredSize(new Dimension(250, tfUrl.getPreferredSize().height));
        
        for (IInputFormatWrapper inputFormat : InputFormatWrapperFactory.getInstance()) {
            if ((inputFormat.getFlags() & AVFormatLibrary.AVFMT_NOFILE) != 0)
                cbInputFormats.addItem(new ComboBoxItem(inputFormat));
        }
        
        cbInputFormats.setSelectedIndex(0);
        cbInputFormats.setEnabled(false);
        
        chkbForceInputFormat.addActionListener(new ForceInputFormatChangeListener());
        buttonOk.addActionListener(new OkListener());
        buttonCancel.addActionListener(new CancelListener());
        
        pack();
        
        setLocationRelativeTo(null);
    }
    
    public int getDialogResult() {
        return dialogResult;
    }
    
    public String getUrl() {
        return tfUrl.getText();
    }
    
    public IInputFormatWrapper getInputFormat() {
        if (!chkbForceInputFormat.isSelected())
            return null;
        
        ComboBoxItem item = (ComboBoxItem)cbInputFormats.getSelectedItem();
        return item.getInputFormat();
    }
    
    private class ForceInputFormatChangeListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            cbInputFormats.setEnabled(chkbForceInputFormat.isSelected());
        }
    }
    
    private class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            dialogResult = RESULT_OK;
            setVisible(false);
        }
    }
    
    private class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            setVisible(false);
        }
    }
    
    private static class ComboBoxItem {
        private IInputFormatWrapper inputFormat;

        public ComboBoxItem(IInputFormatWrapper inputFormat) {
            this.inputFormat = inputFormat;
        }

        public IInputFormatWrapper getInputFormat() {
            return inputFormat;
        }

        @Override
        public String toString() {
            return inputFormat.getName();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        tfUrl = new javax.swing.JTextField();
        chkbForceInputFormat = new javax.swing.JCheckBox();
        cbInputFormats = new javax.swing.JComboBox();
        pnlControls = new javax.swing.JPanel();
        buttonOk = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open URL ...");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("URL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        getContentPane().add(tfUrl, gridBagConstraints);

        chkbForceInputFormat.setText("Force input format:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 0, 10);
        getContentPane().add(chkbForceInputFormat, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(cbInputFormats, gridBagConstraints);

        pnlControls.setLayout(new java.awt.GridBagLayout());

        buttonOk.setText("Ok");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 5);
        pnlControls.add(buttonOk, gridBagConstraints);

        buttonCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 10, 10);
        pnlControls.add(buttonCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(pnlControls, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonOk;
    private javax.swing.JComboBox cbInputFormats;
    private javax.swing.JCheckBox chkbForceInputFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlControls;
    private javax.swing.JTextField tfUrl;
    // End of variables declaration//GEN-END:variables
}
