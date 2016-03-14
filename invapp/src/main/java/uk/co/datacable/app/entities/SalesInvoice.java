package uk.co.datacable.app.entities;

public class SalesInvoice {
	
	private int invNumber;
	
	private String date;

	private String customerAccNum;
	
	private String ffor;
	
	private int deptNo;
	
	private String deptName;
	
	private double amount;
	
	private String url;
	
	private byte isPaid;
	
	private String paidDate;

	public int getInvNumber() {
		return invNumber;
	}

	public void setInvNumber(int invNumber) {
		this.invNumber = invNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerAccNum() {
		return customerAccNum;
	}

	public void setCustomerAccNum(String customerAccNum) {
		this.customerAccNum = customerAccNum;
	}

	public String getFfor() {
		return ffor;
	}

	public void setFfor(String ffor) {
		this.ffor = ffor;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	
	
	
	
	
}
