package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DownloadTableModel extends AbstractTableModel{
	
	private List<Pessoa> itens = new ArrayList<>(); 

	 
	@Override
	public int getColumnCount() {	
		return 3;
	}

	@Override
	public int getRowCount() {		
		return itens.size();
	}

	
	@Override
	public Object getValueAt(int row, int column) {
		
		
		Pessoa d = itens.get(row);
		switch(column) {
		case 0: 
			return d.getId();			
		case 1:
			return d.getEndereco();
		
			
			
		}
		return "maaaa";
	}

	public void addNovoDownload(Pessoa p1) {
		itens.add(p1);
		super.fireTableDataChanged();
	}
	


}
