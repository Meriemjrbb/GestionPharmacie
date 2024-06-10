package view;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


public class TableModelOrdonnance extends AbstractTableModel {


private String[] nomColonnes = new String[] {"idordonnance","idCilent", "nomClient","idmedicament", "nommedicament","mois"};
private Vector<String[]> rows = new Vector<String[]>();

@Override
public int getColumnCount() {
    return nomColonnes.length;
}

@Override
public int getRowCount() {
    return rows.size();
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    return rows.get(rowIndex)[columnIndex];
}

@Override
public String getColumnName(int column) {
    return nomColonnes[column];
}

public void loadData(ResultSet rs) {
    rows.clear(); // Effacer les données existantes
    try {
        while (rs.next()) {
            rows.add(new String[] {
                String.valueOf(rs.getInt("idordonnance")),
                String.valueOf(rs.getInt("idClient")),
                rs.getString("nomClient"),
                String.valueOf(rs.getInt("idmedicament")),
                rs.getString("nommedicament"),
                rs.getString("mois")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    fireTableChanged(null);

}}