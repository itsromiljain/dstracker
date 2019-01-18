package com.tracker.supply.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tracker.supply.model.ResumeUpload;
import com.tracker.supply.model.SupplyDtls;
import com.tracker.supply.model.UploadFileResponse;
import com.tracker.supply.service.FileStorageException;
import com.tracker.supply.service.SupplyService;

@RestController
@CrossOrigin
public class SupplyController {
	@Autowired
	private SupplyService supplyService;

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

	/*
	 * @GetMapping("/supply/{id}") public ResponseEntity<Optional<supplyDtls>>
	 * getaProject(@PathVariable("id") long id) { SupplyDtls supplyDtls; try {
	 * Optional<supplyDtls> = (SupplyDtls) supplyService.getSupply(id); return
	 * ResponseEntity.ok().body(supplyDtls); } catch (ResourceNotFoundException e) {
	 * return ResponseEntity.notFound().build(); } }
	 * 
	 * @PostMapping("/supply") public ResponseEntity<SupplyDtls> registerProject(
	 * , @RequestPart("file")MultipartFile[] file) {
	 * 
	 * 
	 * SupplyDtls supplyDtls = supplyService.addSupply(nwsupplyDtls,file); try {
	 * return ResponseEntity.status(201).body(supplyDtls); } catch (Exception e) {
	 * return ResponseEntity.status(404).build(); } }
	 */

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
		System.out.println(convFile);
		String[] s = { "Java", "Spring", "MySQL", "Kafka", "Casandra" };
		HashSet<String> set = new HashSet<String>();
		for (String strTemp : s) {

			System.out.println(strTemp);
			
//			if(file.getContentType().equalsIgnoreCase("application/msword")) {
//				System.out.println("Doc file");
//				
//			}else if(file.getContentType().equalsIgnoreCase("application/pdf")) {
//				System.out.println("Pdf file");
//				try {
//					PdfReader reader=new PdfReader("C:/Users/pc-hp/Desktop/Chetan_Bhagat_-_2_States_The_Story_of_My_Marriage.pdf");
//					int pages = reader.getNumberOfPages(); 
//					System.out.println(pages);
//					for(int i=1; i<=pages; i++) { 
//					String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
//					System.out.println(textFromPage);
//					}
//					reader.close();
//					} catch (Exception ex) {
//					System.out.println("exception: " + ex);
//					}
//
//			}
			try {
				BufferedReader reader = new BufferedReader(new FileReader(convFile));
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.contains(strTemp)) {
						set.add(strTemp);
					}
				}
			} catch (Exception ex) {
				System.out.println("exception: " + ex);
			}
		}
		System.out.println("set:  " + set);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		return new UploadFileResponse(fileName, fileDownloadUri, set, file.getContentType(), file.getSize());
	}
}
