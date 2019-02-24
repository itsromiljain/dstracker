package com.tracker.repository.invoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.invoice.InvoiceTMDtls;

@Repository
public interface InvoiceTMRepository extends JpaRepository<InvoiceTMDtls, Long> {

}
