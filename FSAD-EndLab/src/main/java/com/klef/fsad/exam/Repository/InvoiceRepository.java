package com.klef.fsad.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.fsad.exam.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}