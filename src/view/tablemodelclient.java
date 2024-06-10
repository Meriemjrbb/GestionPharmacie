package view;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Métiers.Client;

public class tablemodelclient extends AbstractTableModel {
	private String[] nomColonnes=new String[] {"ID","NOM","CREDIT"};
	private Vector<String[]> rows=new Vector<String[]>();
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nomColonnes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rows.get(rowIndex)[columnIndex];
	}
	public String getColumnName(int column)
	{
		return nomColonnes[column];
	}
    public void loadData(List<Client> clients)
    {
    	rows=new Vector<String[]>();
    	for(Client c : clients)
    	{
    		rows.add(new String[] {
    				String.valueOf(c.getId()),
    				c.getNom(),
    				String.valueOf(c.getCredit())});
    	}
    	fireTableChanged(null);
    }
    
}