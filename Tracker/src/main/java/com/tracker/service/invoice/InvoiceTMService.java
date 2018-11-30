package com.tracker.service.invoice;

import java.util.List;
import java.util.Optional;

import com.tracker.model.invoice.InvoiceTMDtls;

public interface InvoiceTMService {
	public List<InvoiceTMDtls> getAllTmInvoice();
	public Optional<InvoiceTMDtls> getTmInvoice(long id);
	public InvoiceTMDtls addTmInvoice(InvoiceTMDtls s);
	public void UpdateTmInvoice(InvoiceTMDtls s);
	public void deleteTmInvoice(long id);
}
