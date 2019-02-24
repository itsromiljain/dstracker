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

import com.tracker.model.invoice.InvoiceFBDtls;
import com.tracker.model.invoice.InvoiceTMDtls;
import com.tracker.service.invoice.InvoiceFBService;

@RestController
@CrossOrigin
public class InvoiceFBController {

	@Autowired
	private InvoiceFBService invoiceFbService;

	@GetMapping("/invoicefb/")
	public ResponseEntity<List<InvoiceFBDtls>> getAllFbInvoice() {
		List<InvoiceFBDtls> invoice = new LinkedList<InvoiceFBDtls>();
		try {
			invoice = invoiceFbService.getAllFbInvoice();
			return ResponseEntity.ok().body(invoice);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/invoicefb/{poNo}")
	public ResponseEntity<Optional<InvoiceFBDtls>> getFbInvoice(@PathVariable("poNo") long poNo) {
		Optional<InvoiceFBDtls> invoiceFBDtls;
		try {
			invoiceFBDtls = invoiceFbService.getFbInvoice(poNo);
			return ResponseEntity.ok().body(invoiceFBDtls);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/invoicefb/")
	public  ResponseEntity<InvoiceFBDtls> registerFbInvoice(@RequestBody InvoiceFBDtls nwFbInvoice) {
		InvoiceFBDtls invoicefbDtls = invoiceFbService.addFbInvoice(nwFbInvoice);
		try {
			return ResponseEntity.status(201).body(invoicefbDtls);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/invoicefb/{poNo}/")
	public ResponseEntity<Void> updateFbInvoice(@PathVariable int poNo, @RequestBody InvoiceFBDtls exstFbInvoice) {
		try {
			invoiceFbService.UpdateFbInvoice(exstFbInvoice);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/invoicefb/{poNo}/")
	public ResponseEntity<Void> deleteFbInvoice(@PathVariable long poNo) {
		try {
			invoiceFbService.deleteFbInvoice(poNo);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
