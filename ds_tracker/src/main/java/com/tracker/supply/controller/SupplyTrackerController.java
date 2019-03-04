package com.tracker.supply.controller;

import com.tracker.admin.service.SkillService;
import com.tracker.common.FileStorageException;
import com.tracker.common.ResourceNotFoundException;
import com.tracker.supply.model.SupplyDetail;
import com.tracker.supply.model.UploadFileResponse;
import com.tracker.supply.service.SupplyService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.util.HashSet;
import java.util.List;

@RestController
@CrossOrigin
public class SupplyTrackerController {
	@Autowired
	private SupplyService supplyService;

	@Autowired
	private SkillService skillService;

	@GetMapping("/user/{emailId}/supply")
	public ResponseEntity<List<SupplyDetail>> getSupply(@PathVariable(name = "emailId", required = true) String emailId,
														@RequestParam(name = "role") String role) {
		try {
			if (StringUtils.isEmpty(role) || role.equalsIgnoreCase("TA"))
				return ResponseEntity.ok().body(supplyService.getAllSupply());
			else
				return ResponseEntity.ok().body(supplyService.getAllSupplyByUser(emailId));

		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{emailId}/supply/{id}")
	public ResponseEntity<SupplyDetail> getSupplyById(@PathVariable(name = "emailId", required = true) String emailId,
													  @PathVariable("id") long supplyId) {
		try {
			return ResponseEntity.ok().body(supplyService.getSupplyById(emailId, supplyId));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/user/{emailId}/supply")
	public ResponseEntity<SupplyDetail> addSupply(@PathVariable(name = "emailId", required = true) String emailId,
												  @RequestBody SupplyDetail newSupplyDtl) {
		try {
			return ResponseEntity.ok().body(supplyService.addSupply(emailId, newSupplyDtl));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/user/{emailId}/supply")
	public ResponseEntity<Void> updateSupply(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody SupplyDetail existingSupplyDtl) {
		try {
			supplyService.updateSupply(emailId, existingSupplyDtl);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{emailId}/archive/supply")
	public ResponseEntity<List<SupplyDetail>> getAllArchiveSupply() {
		try {
			return ResponseEntity.ok().body(supplyService.getAllArchiveSupply());
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/user/{emailId}/archive/supply")
	public ResponseEntity<Void> archiveSupply(@PathVariable(name = "emailId", required = true) String emailId, @RequestBody List<Long> supplyIds) {
		try {
			supplyService.archiveSupply(emailId, supplyIds);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/user/{emailId}/archive/supply/{id}")
	public ResponseEntity<Void> archiveSupplyById(@PathVariable(name = "emailId", required = true) String emailId, @PathVariable(name="id") long supplyId) {
		try {
			supplyService.archiveSupplyById(emailId, supplyId);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/user/{emailId}/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = supplyService.storeFile(file);
		// Check if the file's name contains invalid characters
		if (fileName.contains("..")) {
			throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
		}
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos;
		fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();

		List<String> skils = skillService.getAllSkillNames();
		HashSet<String> set = new HashSet<String>();
		for (String strTemp : skils) {

			if (file.getContentType().equalsIgnoreCase("application/msword")) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(convFile));
					String line = null;
					while ((line = reader.readLine()) != null) {
						if (line.contains(strTemp)) {
							set.add(strTemp);
						}
					}
					reader.close();
				} catch (Exception ex) {
					// TODO Log this Exception
				}
			} else if (file.getContentType().equalsIgnoreCase("application/pdf")) {
				try {
					PDDocument document = PDDocument.load(convFile);
					if (!document.isEncrypted()) {
						PDFTextStripperByArea stripper = new PDFTextStripperByArea();
						stripper.setSortByPosition(true);

						PDFTextStripper tStripper = new PDFTextStripper();

						String pdfFileInText = tStripper.getText(document);
						if (pdfFileInText.contains(strTemp)) {
							set.add(strTemp);
						}
					}
				} catch (Exception ex) {
					// TODO Log this Exception
				}

			}
		
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();
		return new UploadFileResponse(fileName, fileDownloadUri, set, file.getContentType(), file.getSize());
	}

}
