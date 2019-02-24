package com.tracker.service.invoice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.invoice.InvoiceTMDtls;
import com.tracker.repository.invoice.InvoiceTMRepository;

@Service
@Transactional
public class InvoiceTMServiceImpl implements InvoiceTMService {

	@Autowired
	private InvoiceTMRepository invoiceTMRepository;

	@Override
	public List<InvoiceTMDtls> getAllTmInvoice() {
		return invoiceTMRepository.findAll();
	}
	
	@Override
	public Optional<InvoiceTMDtls> getTmInvoice(long id) {
		return invoiceTMRepository.findById(id);
	}

	@Override
	public InvoiceTMDtls addTmInvoice(InvoiceTMDtls s) {
		return invoiceTMRepository.save(s) ;
	}

	@Override
	public void UpdateTmInvoice(InvoiceTMDtls s) {
		invoiceTMRepository.save(s) ;
		
	}

	@Override
	public void deleteTmInvoice(long id) {
		invoiceTMRepository.deleteById(id) ;
		
	}
	

}
