package dentist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

	private int columnCount = 5;

	private ArrayList<String[]> dataList;
	//private ArrayList<String> copyList;

	public TableModel() {
		// TODO Auto-generated constructor stub
		dataList = new ArrayList<String[]>();
		//load("./patients.ser");
	}
	
	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			this.dataList = (ArrayList<String[]>) inStream.readObject();
			inStream.close();
			fileIn.close();
			
			FileOutputStream fileOutCopy = new FileOutputStream("./backup/copyFile" + (new Date().getTime()) + ".ser");
			ObjectOutputStream outStreamCopy = new ObjectOutputStream(fileOutCopy);
			outStreamCopy.writeObject(dataList);
			outStreamCopy.flush();
			outStreamCopy.close();
			fileOutCopy.flush();
			fileOutCopy.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnCount;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "FIO";
		case 1:
			return "Card number";
		case 2:
			return "Operation type";
		case 3:
			return "Price";
		case 4:
			return "Is debt";
		}
		return "";
	}

	@Override
	public Object getValueAt(int rowIndex, int colomnIndex) {
		// TODO Auto-generated method stub
		String[] rows = dataList.get(rowIndex);
		return rows[colomnIndex];
	}
	
	public void remData(int row) {
		dataList.remove(row);
	}

	public void addDate(String[] row) {
		String[] rowTable = new String[getColumnCount()];
		rowTable = row;
		dataList.add(rowTable);
	}

}
