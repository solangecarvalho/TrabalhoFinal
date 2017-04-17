package br.univel;

import java.awt.Color;
import java.awt.Component;
import java.util.EventObject;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class RendererComum extends JLabel implements TableCellRenderer {

	public RendererComum() {
		setOpaque(true);
		setBackground(Color.BLUE);
		setBackground(Color.RED);

	}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	int row, int column) {
		this.setText(String.valueOf(value));
		
		if (isSelected) {
			setBackground(Color.BLACK);			
		} else {			
			setBackground(Color.YELLOW);	
		}
	 return this;
}

}
