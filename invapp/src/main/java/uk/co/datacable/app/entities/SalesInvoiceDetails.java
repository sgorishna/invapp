package uk.co.datacable.app.entities;

public class SalesInvoiceDetails {
	
	private int salesInvoiceNum;
	
	private String item;
	
	private int count;
	
	private double priceEach;
	
	private double lineTotal;
	
	private int deptNo;
	
	private String deptName;

	public int getSalesInvoiceNum() {
		return salesInvoiceNum;
	}

	public void setSalesInvoiceNum(int salesInvoiceNum) {
		this.salesInvoiceNum = salesInvoiceNum;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	

}
