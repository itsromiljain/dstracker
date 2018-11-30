package com.tracker.service.invoice;

import java.util.List;
import java.util.Optional;

import com.tracker.model.invoice.InvoiceFBDtls;

public interface InvoiceFBService {
	public List<InvoiceFBDtls> getAllFbInvoice();
	public Optional<InvoiceFBDtls> getFbInvoice(long id);
	public InvoiceFBDtls addFbInvoice(InvoiceFBDtls s);
	public void UpdateFbInvoice(InvoiceFBDtls s);
	public void deleteFbInvoice(long id);

}
