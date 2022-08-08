package com.DBS.Transaction.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment_Message {

    @Id
    private String messagecode;
    public String getMessagecode() {
        return messagecode;
    }
    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode;
    }
    public String getInstruction() {
        return instruction;
    }
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    private String instruction;
    @Override
    public int hashCode() {
        return Objects.hash(instruction, messagecode);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Payment_Message other = (Payment_Message) obj;
        return Objects.equals(instruction, other.instruction) && Objects.equals(messagecode, other.messagecode);
    }
    @Override
    public String toString() {
        return "Payment_Message [messagecode=" + messagecode + ", instruction=" + instruction + "]";
    }

}
