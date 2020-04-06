package com.gehc.fx.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gehc.fx.service.GenerateFlatFileService;

@RestController
public class GenerateFlatFileController {

	@Autowired
	private GenerateFlatFileService generateFlatFileService;

	@GetMapping("/generate")
	public String generateFlatFile() throws IOException {

		return generateFlatFileService.createFlatFile() ? "success!" : "failed!";

	}

}
