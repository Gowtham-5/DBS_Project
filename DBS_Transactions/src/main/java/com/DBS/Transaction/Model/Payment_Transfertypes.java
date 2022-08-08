package com.DBS.Transaction.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment_Transfertypes {
	@Id
	private String transfertypecode;
	private String transfertypedescription;
	public String getTransfertypecode() {
		return transfertypecode;
	}
	public void setTransfertypecode(String transfertypecode) {
		this.transfertypecode = transfertypecode;
	}
	public String getTransfertypedescription() {
		return transfertypedescription;
	}
	public void setTransfertypedescription(String transfertypedescription) {
		this.transfertypedescription = transfertypedescription;
	}
	@Override
	public String toString() {
		return "Payment_Transfertypes [transfertypecode=" + transfertypecode + ", transfertypedescription="
				+ transfertypedescription + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(transfertypecode, transfertypedescription);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment_Transfertypes other = (Payment_Transfertypes) obj;
		return Objects.equals(transfertypecode, other.transfertypecode)
				&& Objects.equals(transfertypedescription, other.transfertypedescription);
	}

}
