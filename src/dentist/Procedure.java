package dentist;

import java.io.Serializable;

public class Procedure implements Serializable{

	private TypeOfOperation operationType;
	private int operationPrice;
	private int jTableOpType;

	enum TypeOfOperation {
		DENTALPROSTHETICS, DENTALFILLING, DENTALIMPLANTATION;
	}

	Procedure(int jTableOpType) {
		this.jTableOpType = jTableOpType;
		
		setOperationPrice();
	}

	public int getOperationPrice() {
		return operationPrice;
	}
	
	public String toStringOpPrice() {
		return Integer.toString(operationPrice);
	}

	public TypeOfOperation getOperationType() {
		return operationType;
	}
	
	public String getOperationTypeToString() {
		return operationType.toString();
	}

	public void setOperationPrice() {

		switch (jTableOpType) {

		case 1:
			operationType = TypeOfOperation.DENTALPROSTHETICS;
			operationPrice = 344;
			break;

		case 2:
			operationType = TypeOfOperation.DENTALFILLING;
			operationPrice = 260;
			break;

		case 3:
			operationType = TypeOfOperation.DENTALIMPLANTATION;
			operationPrice = 120;
			break;

		default:
			System.out.println("Недопустимый тип операции.");
			break;
		}
	}

	public String toString() {
		return "Тип операции: " + operationType.toString() + "\nСтоимость операции: " + operationPrice;
	}
}
