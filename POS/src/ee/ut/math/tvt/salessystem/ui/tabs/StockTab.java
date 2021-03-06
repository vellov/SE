package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class StockTab {

	private JButton addItem;

	private SalesSystemModel model;

	public StockTab(SalesSystemModel model) {
		this.model = model;
	}

	// warehouse stock tab - consists of a menu and a table
	public Component draw() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		panel.setLayout(gb);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.weightx = 1.0d;
		gc.weighty = 0d;

		panel.add(drawStockMenuPane(), gc);

		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.BOTH;
		panel.add(drawStockMainPane(), gc);
		return panel;
	}

	// warehouse menu
	private Component drawStockMenuPane() {
		JPanel panel = new JPanel();

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();

		panel.setLayout(gb);

		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.weightx = 0;

		addItem = new JButton("Add");
		gc.gridwidth = GridBagConstraints.RELATIVE;
		gc.weightx = 1.0;
		addItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Create window with frames
				createAddWindow();
			}
		});
		panel.add(addItem, gc);

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return panel;
	}

	// table of the wareshouse stock
	private Component drawStockMainPane() {
		JPanel panel = new JPanel();

		JTable table = new JTable(model.getWarehouseTableModel());

		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		panel.setLayout(gb);
		panel.add(scrollPane, gc);

		panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
		return panel;
	}
	private void createAddWindow() {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(6, 2));
		frame.add(new JLabel("Barcode: "));
		final JTextField barcodeText = new JTextField("barcode");
		frame.add(barcodeText);
		frame.add(new JLabel("Name: "));
		final JTextField nameText = new JTextField("name");
		frame.add(nameText);
		frame.add(new JLabel("Price: "));
		final JTextField priceText = new JTextField("price");
		frame.add(priceText);
		frame.add(new JLabel("Quantity: "));
		final JTextField quantityText = new JTextField("quantity");
		frame.add(quantityText);
		frame.add(new JLabel("Description: "));
		final JTextField descText = new JTextField("desc");
		frame.add(descText);
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					StockItem newItem = new StockItem(Long.valueOf(barcodeText.getText()), nameText.getText(), descText.getText(), Double.valueOf(priceText.getText()), Integer.parseInt(quantityText.getText()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Please enter valid inputs", "Error #01",
							JOptionPane.ERROR_MESSAGE);
				}
					//fireTableDataChanged();
			}
		});
		frame.add(confirm);
		frame.pack();
		frame.setVisible(true);
	}
}
