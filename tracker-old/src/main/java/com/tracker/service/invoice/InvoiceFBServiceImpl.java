package com.tracker.service.invoice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.invoice.InvoiceFBDtls;
import com.tracker.repository.invoice.InvoiceFBRepository;

@Service
@Transactional
public class InvoiceFBServiceImpl implements InvoiceFBService {

	@Autowired
	private InvoiceFBRepository invoiceFBRepository;
	
	@Override
	public List<InvoiceFBDtls> getAllFbInvoice() {
		return invoiceFBRepository.findAll();
	}

	@Override
	public Optional<InvoiceFBDtls> getFbInvoice(long id) {
		return invoiceFBRepository.findById(id);
	}

	@Override
	public InvoiceFBDtls addFbInvoice(InvoiceFBDtls s) {
		return invoiceFBRepository.save(s) ;
	}

	@Override
	public void UpdateFbInvoice(InvoiceFBDtls s) {
		invoiceFBRepository.save(s) ;
		
	}

	@Override
	public void deleteFbInvoice(long id) {
		invoiceFBRepository.deleteById(id) ;
		
	}

}
