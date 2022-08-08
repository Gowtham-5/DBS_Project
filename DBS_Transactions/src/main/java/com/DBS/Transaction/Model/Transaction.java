package com.DBS.Transaction.Model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;
	private String receiveraccountholdernumber;
	private String receiveraccountholdername;
	private Double transferfees;
	private Date transferdate;
	private Double amount;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")
	private Customer customers;
	public Long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}
	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}
	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}
	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}
	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}
	public Double getTransferfees() {
		return transferfees;
	}
	public void setTransferfees(Double transferfees) {
		this.transferfees = transferfees;
	}
	public Date getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, customers, receiveraccountholdername, receiveraccountholdernumber, transactionid,
				transferdate, transferfees);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(customers, other.customers)
				&& Objects.equals(receiveraccountholdername, other.receiveraccountholdername)
				&& Objects.equals(receiveraccountholdernumber, other.receiveraccountholdernumber)
				&& Objects.equals(transactionid, other.transactionid)
				&& Objects.equals(transferdate, other.transferdate) && Objects.equals(transferfees, other.transferfees);
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", receiveraccountholdernumber="
				+ receiveraccountholdernumber + ", receiveraccountholdername=" + receiveraccountholdername
				+ ", transferfees=" + transferfees + ", transferdate=" + transferdate + ", amount=" + amount
				+ ", customers=" + customers + "]";
	}
	
	
}
