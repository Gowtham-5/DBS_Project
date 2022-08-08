package com.DBS.Transaction.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    private Integer customerid;
    private String accountholdername;
    private Boolean overdraftflag;
    private Double clearbalance;
    public Integer getCustomerid() {
        return customerid;
    }
    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public String getAccountholdername() {
        return accountholdername;
    }
    public void setAccountholdername(String accountholdername) {
        this.accountholdername = accountholdername;
    }
    public Boolean getOverdraftflag() {
        return overdraftflag;
    }
    public void setOverdraftflag(Boolean overdraftflag) {
        this.overdraftflag = overdraftflag;
    }
    public Double getClearbalance() {
        return clearbalance;
    }
    public void setClearbalance(Double clearbalance) {
        this.clearbalance = clearbalance;
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountholdername, clearbalance, customerid, overdraftflag);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        return Objects.equals(accountholdername, other.accountholdername)
                && Objects.equals(clearbalance, other.clearbalance) && Objects.equals(customerid, other.customerid)
                && Objects.equals(overdraftflag, other.overdraftflag);
    }
    @Override
    public String toString() {
        return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraftflag="
                + overdraftflag + ", clearbalance=" + clearbalance + "]";
    }

    

}