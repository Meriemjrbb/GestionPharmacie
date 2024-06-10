package view;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


import Métiers.Medicament;

public class TableModelMed1 extends AbstractTableModel {
	private String[] nomColonnes=new String[] {"ID","NOM Med","DESCRIPTION","STOCK"};
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
    public void loadData(List<Medicament> medicaments)
    {
    	rows=new Vector<String[]>();
    	for(Medicament m : medicaments)
    	{
    		rows.add(new String[] {
    				String.valueOf(m.getId()),
    				m.getNom(),
    				m.getDescription(),
    				String.valueOf(m.getStock())});
    	}
    	fireTableChanged(null);
    }
 // Méthode pour effacer les données actuellement affichées dans le tableau
    public void clearData() {
        rows.clear();
        fireTableDataChanged();
    }

    // Méthode pour ajouter une seule ligne de données à afficher dans le tableau
    public void addData(Medicament medicament) {
        rows.add(new String[] {
                String.valueOf(medicament.getId()),
                medicament.getNom(),
                medicament.getDescription(),
                String.valueOf(medicament.getStock())});

    }
}
    

