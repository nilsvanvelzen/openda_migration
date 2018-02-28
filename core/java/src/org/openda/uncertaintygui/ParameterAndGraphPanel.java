/* OpenDA v2.4.3 
* Copyright (c) 2017 OpenDA Association 
* All rights reserved.
* 
* This file is part of OpenDA. 
* 
* OpenDA is free software: you can redistribute it and/or modify 
* it under the terms of the GNU Lesser General Public License as 
* published by the Free Software Foundation, either version 3 of 
* the License, or (at your option) any later version. 
* 
* OpenDA is distributed in the hope that it will be useful, 
* but WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
* GNU Lesser General Public License for more details. 
* 
* You should have received a copy of the GNU Lesser General Public License
* along with OpenDA.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.openda.uncertaintygui;

import javax.swing.border.TitledBorder;

import org.openda.uncertaintygui.genericplot.*;

/**
 * General panel for displaying a table and a graph
 * and buttons for choosing the viewing mode for the graph.
 * Individual components can be set not-visible to get more simple
 * instances of this panel. The titles for the different components
 * can be set to create custom instances of this panel.
 */
public class ParameterAndGraphPanel extends javax.swing.JPanel {

	/**
     * Creates new form ParameterAndGraphPanel
     */
    public ParameterAndGraphPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        viewingModeButtonGroup = new javax.swing.ButtonGroup();
        graphPlotPanel = new GraphPlot();
        parametersTableScrollPane = new javax.swing.JScrollPane();
        parametersTable = new javax.swing.JTable();
        viewingModePanel = new javax.swing.JPanel();
        probabilityRadioButton = new javax.swing.JRadioButton();
        cumulativeRadioButton = new javax.swing.JRadioButton();

        graphPlotPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Graph"));
        org.jdesktop.layout.GroupLayout graphPlotPanelLayout = new org.jdesktop.layout.GroupLayout(graphPlotPanel);
        graphPlotPanel.setLayout(graphPlotPanelLayout);
        graphPlotPanelLayout.setHorizontalGroup(
            graphPlotPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 296, Short.MAX_VALUE)
        );
        graphPlotPanelLayout.setVerticalGroup(
            graphPlotPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 269, Short.MAX_VALUE)
        );

        parametersTableScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Parameters"));
        parametersTableScrollPane.setMinimumSize(new java.awt.Dimension(100, 100));
        parametersTableScrollPane.setPreferredSize(null);
        parametersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        parametersTable.setMinimumSize(new java.awt.Dimension(100, 100));
        parametersTable.setPreferredSize(null);
        parametersTableScrollPane.setViewportView(parametersTable);

        viewingModePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Viewing Mode"));
        viewingModeButtonGroup.add(probabilityRadioButton);
        probabilityRadioButton.setFont(new java.awt.Font("Verdana", 0, 10));
        probabilityRadioButton.setSelected(true);
        probabilityRadioButton.setText("Probability Density");
        probabilityRadioButton.setToolTipText("Show the probabilities of individual outcomes");
        probabilityRadioButton.setMaximumSize(new java.awt.Dimension(32000, 32));
        probabilityRadioButton.setMinimumSize(new java.awt.Dimension(10, 10));
        probabilityRadioButton.setPreferredSize(new java.awt.Dimension(32000, 32));

        viewingModeButtonGroup.add(cumulativeRadioButton);
        cumulativeRadioButton.setFont(new java.awt.Font("Verdana", 0, 10));
        cumulativeRadioButton.setText("Cumulative Probability");
        cumulativeRadioButton.setToolTipText("Show the cumulative probabilities (sum of probabilities below a threshold)");
        cumulativeRadioButton.setMaximumSize(new java.awt.Dimension(32000, 32));
        cumulativeRadioButton.setMinimumSize(new java.awt.Dimension(10, 10));
        cumulativeRadioButton.setPreferredSize(new java.awt.Dimension(32000, 32));

        org.jdesktop.layout.GroupLayout viewingModePanelLayout = new org.jdesktop.layout.GroupLayout(viewingModePanel);
        viewingModePanel.setLayout(viewingModePanelLayout);
        viewingModePanelLayout.setHorizontalGroup(
            viewingModePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(viewingModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(probabilityRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cumulativeRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewingModePanelLayout.setVerticalGroup(
            viewingModePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(viewingModePanelLayout.createSequentialGroup()
                .add(viewingModePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(probabilityRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cumulativeRadioButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, parametersTableScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(viewingModePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(graphPlotPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(graphPlotPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(viewingModePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(parametersTableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton cumulativeRadioButton;
    private javax.swing.JPanel graphPlotPanel;
    private javax.swing.JTable parametersTable;
    private javax.swing.JScrollPane parametersTableScrollPane;
    private javax.swing.JRadioButton probabilityRadioButton;
    private javax.swing.ButtonGroup viewingModeButtonGroup;
    private javax.swing.JPanel viewingModePanel;
    // End of variables declaration//GEN-END:variables
	public javax.swing.JTable getParametersTable() {
		return parametersTable;
	}

	public GraphPlot getGraphPlotPanel() {
		return (GraphPlot)graphPlotPanel;
	}

	public javax.swing.ButtonGroup getViewingModeButtonGroup() {
		return viewingModeButtonGroup;
	}

	public javax.swing.JRadioButton getCumulativeRadioButton() {
		return cumulativeRadioButton;
	}

	public javax.swing.JRadioButton getProbabilityRadioButton() {
		return probabilityRadioButton;
	}

	public javax.swing.JPanel getViewingModePanel() {
		return viewingModePanel;
	}

	/**
     * This method was added manually (not autogenerated code).
     * Method to change titles of borders.
     *
     * @param graphBorderTitle the title for the border of the graphPlotPanel
     * @param tableBorderTitle the title for the border of the parameterTable
     */
    public void setBorderTitles(String graphBorderTitle, String tableBorderTitle) {
    	//change titles of borders.
    	((TitledBorder) this.graphPlotPanel.getBorder()).setTitle(graphBorderTitle);
    	((TitledBorder) this.parametersTableScrollPane.getBorder()).setTitle(tableBorderTitle);
    }

}
