package com.gehc.fx.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gehc.fx.constant.CommonConstant;

@Service
public class GenerateFlatFileService {

	public String filePath = "/home/deepak/Practice/Spring/Spring Boot/CommandTestApi/src/main/resources/ExcelFiles";
	// public static String fileName = "src/main/resources/ExcelFiles/test1.csv";
	// public static String fileNamePath = "src/main/resources/ExcelFiles";
	private static String generateLocation = "/home/deepak/Practice/Spring/Spring\\ Boot/CommandTestApi/src/main/resources/FlatFiles/";

	public boolean createFlatFile() {
		boolean flag = false;

		String b = String.format(CommonConstant.SECOND, generateLocation, generateLocation);
		String c = String.format(CommonConstant.THIRD, generateLocation, generateLocation);
		String d = String.format(CommonConstant.FOURTH, generateLocation, generateLocation);
		String e = String.format(CommonConstant.FIFTH, generateLocation, generateLocation);

		runFirst();
		flag = runBash(b);
		flag = runBash(c);
		flag = runBash(d);
		flag = runBash(e);
		return flag;
	}

	public boolean runFirst() {
		boolean flag = false;
		final File folder = new File(filePath);
		List<String> listOfFileNames = listFilesForFolder(folder, new ArrayList<String>());
		for (String fileName : listOfFileNames) {
			String filePathLocal = this.filePath.replace(" ", "\\ ");
			String a = String.format(CommonConstant.FIRST, filePathLocal.concat("/" + fileName), generateLocation);
			flag = runBash(a);
		}

		return flag;
	}

	public static boolean runBash(String command) {
		boolean flag = false;
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("bash", "-c", "ls && " + command);

		try {

			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				flag = true;
				// System.exit(0);
			} else {
				// abnormal...
				System.out.println("Failed!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<String> listFilesForFolder(final File folder, List<String> listOfFileNames) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry, listOfFileNames);
			} else {
				System.out.println(fileEntry.getName());
				listOfFileNames.add(fileEntry.getName());
			}
		}
		return listOfFileNames;
	}
}
