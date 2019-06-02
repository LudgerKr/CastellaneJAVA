package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {

	private Object donnees[][];
	private String entetes[];
	
	public Tableau(Object donnees[][], String entetes[]) {
		this.donnees = donnees;
		this.entetes = entetes;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return this.donnees[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.entetes[column];
	}
	
	public void deleteRow(int ligneSelectionnee) {
		Object matrice [][] = new Object[this.donnees.length - 1][this.entetes.length];
		int j = 0;
		for (int i = 0; i<this.donnees.length; i++) {
			if (i != ligneSelectionnee) {
				matrice [j] = this.donnees[i];
				j++;
			} 
		} 
		this.donnees = matrice;
		this.fireTableDataChanged(); // changer la table
	}
	
	public void addRow(Object ligne[]) {
		Object matrice [][] = new Object[this.donnees.length + 1][this.entetes.length];
		for (int i = 0; i<this.donnees.length; i++) {
			matrice[i] = this.donnees[i];
			} 
		matrice[this.donnees.length] = ligne;
		this.donnees = matrice;
		this.fireTableDataChanged(); // changer la table
	}
	
	public void UpdateRow(Object[] ligne, int ligneSelectionne) {
		this.donnees[ligneSelectionne] = ligne;
		this.fireTableDataChanged();
	}
}