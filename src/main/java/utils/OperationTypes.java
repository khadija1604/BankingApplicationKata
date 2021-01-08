package utils;

public enum OperationTypes {
	
	DEPOSIT("Deposit"),
	WITHDRAWAL("Withdrawal");
	
    private final String typeCode;
    
	OperationTypes(String typeCode) {
		this.typeCode= typeCode;
	}

	public String getTypeCode() {
		return typeCode;
	}
	
}
