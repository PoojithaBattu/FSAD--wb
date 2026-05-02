package com.klef.fsad.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "invoice_table")
public class Invoice {

    @Id
    private int invoiceId;

    private String name;
    private Date date;
    private String status;
    private double amount;

    public Invoice() {}

    public Invoice(int invoiceId, String name, Date date, String status, double amount) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
}