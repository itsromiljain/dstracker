package com.tracker.controller.invoice;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.invoice.InvoiceTMDtls;
import com.tracker.service.invoice.InvoiceTMService;

@RestController
@CrossOrigin
public class InvoiceTMController {

	@Autowired
	private InvoiceTMService invoiceTMService;

	@GetMapping("/invoicetm/")
	public ResponseEntity<List<InvoiceTMDtls>> getAllTmInvoice() {
		List<InvoiceTMDtls> invoice = new LinkedList<InvoiceTMDtls>();
		try {
			invoice = invoiceTMService.getAllTmInvoice();
			return ResponseEntity.ok().body(invoice);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/invoicetm/{sow}")
	public ResponseEntity<Optional<InvoiceTMDtls>> getTmInvoice(@PathVariable("sow") long sow) {
		Optional<InvoiceTMDtls> invoiceTMDtls;
		try {
			invoiceTMDtls = invoiceTMService.getTmInvoice(sow);
			return ResponseEntity.ok().body(invoiceTMDtls);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/invoicetm/")
	public  ResponseEntity<InvoiceTMDtls> registerTmInvoice(@RequestBody InvoiceTMDtls nwTmInvoice) {
		InvoiceTMDtls invoiceTMDtls = invoiceTMService.addTmInvoice(nwTmInvoice);
		try {
			return ResponseEntity.status(201).body(invoiceTMDtls);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/invoicetm/{sow}/")
	public ResponseEntity<Void> updateTmInvoice(@PathVariable int sow, @RequestBody InvoiceTMDtls exstTmInvoice) {
		try {
			invoiceTMService.UpdateTmInvoice(exstTmInvoice);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/invoicetm/{sow}/")
	public ResponseEntity<Void> deleteTmInvoice(@PathVariable long id) {
		try {
			invoiceTMService.deleteTmInvoice(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
