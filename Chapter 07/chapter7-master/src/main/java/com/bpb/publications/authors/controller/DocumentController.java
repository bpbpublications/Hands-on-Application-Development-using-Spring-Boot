package com.bpb.publications.authors.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentController {
	private String uploadDirectory = "C:\\users\\PCW\\docstore";
	private Path docStore;

	@PostConstruct
	public void setUp() throws IOException {
		docStore = Paths.get(uploadDirectory).toAbsolutePath().normalize();
		Files.createDirectories(docStore);
	}

	@PutMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), docStore.resolve(file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
		return ResponseEntity.ok("Successfully uploaded");
	}

	@GetMapping("/download")
	public ResponseEntity<?> download(@RequestParam("filename") String file) throws FileNotFoundException {
		InputStreamResource resource = new InputStreamResource(new FileInputStream(docStore.resolve(file).toFile()));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file + "\"").body(resource);
	}

}