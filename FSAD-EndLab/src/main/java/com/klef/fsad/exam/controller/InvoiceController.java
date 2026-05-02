package com.klef.fsad.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.exam.model.Invoice;
import com.klef.fsad.exam.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
@CrossOrigin
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // POST → Add Invoice
    @PostMapping("/add")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        if (invoice.getInvoiceId() <= 0) {
            throw new IllegalArgumentException("Invoice ID must be greater than 0");
        }
        return invoiceService.addInvoice(invoice);
    }

    // GET → Fetch All
    @GetMapping("/all")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
    
}