package com.klef.fsad.exam.service;

import java.util.List;
import com.klef.fsad.exam.model.Invoice;

public interface InvoiceService {
    public Invoice addInvoice(Invoice invoice);
    public List<Invoice> getAllInvoices();
}