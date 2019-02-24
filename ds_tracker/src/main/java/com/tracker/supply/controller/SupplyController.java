package com.tracker.supply.controller;

import com.tracker.common.ResourceNotFoundException;
import com.tracker.supply.model.SupplyDtls;
import com.tracker.supply.model.UploadFileResponse;
import com.tracker.supply.service.FileStorageException;
import com.tracker.supply.service.SupplyService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
public class SupplyController {
	@Autowired
	private SupplyService supplyService;
	
	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/getAllsupply/")
	public ResponseEntity<List<SupplyDtls>> getAllProjects() {
		List<SupplyDtls> projects = new LinkedList<SupplyDtls>();
		try {
			
			projects = supplyService.getAllSupply();
			return ResponseEntity.ok().body(projects);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/supply")
	public ResponseEntity<SupplyDtls> registerProject(@RequestBody SupplyDtls nwsupplyDtls) {

		SupplyDtls supplyDtls = supplyService.addSupply(nwsupplyDtls);
		try {
			return ResponseEntity.status(201).body(supplyDtls);
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/supply/{id}")
	public ResponseEntity<Void> updateProject(@PathVariable int id, @RequestBody SupplyDtls exstsupplyDtls) {
		try {
			supplyService.UpdateSupply(exstsupplyDtls);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/supply/{id}")
	public ResponseEntity<Void> deleteSupply(@PathVariable long id) {
		try {
			supplyService.deleteSupply(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	
	@PostMapping("/uploadFile")
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
	
			StringBuilder sb = new StringBuilder();
			sb.append("Select skill from skill");
			List<String> skil = entityManager.createNativeQuery(sb.toString()).getResultList();
			System.out.println("skill list");
			System.out.println(skil);
		
		//String[] s = { "Java", "Spring", "MySQL", "Kafka", "Casandra" };

		HashSet<String> set = new HashSet<String>();
		for (String strTemp : skil) {

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
					System.out.println("exception: " + ex);
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
					System.out.println("exception: " + ex);
				}

			}
		
		}
		System.out.println("set");
	System.out.println(set);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		return new UploadFileResponse(fileName, fileDownloadUri, set, file.getContentType(), file.getSize());
	}

}
