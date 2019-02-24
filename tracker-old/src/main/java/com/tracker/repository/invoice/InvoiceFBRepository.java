package com.tracker.repository.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.invoice.InvoiceFBDtls;

@Repository
public interface InvoiceFBRepository extends JpaRepository<InvoiceFBDtls, Long> {

}
