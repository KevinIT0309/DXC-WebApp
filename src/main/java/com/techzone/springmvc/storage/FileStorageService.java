package com.techzone.springmvc.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.techzone.springmvc.exception.FileStorageException;
import com.techzone.springmvc.util.ConvertUnicodeUtil;
import com.techzone.springmvc.util.SizeFolderUtil;
import com.techzone.springmvc.util.UUIDUtil;

@Service
public class FileStorageService {
	
	private final Path fileStorageLocation;
	
	/** ===================== DI ==================== **/
	@Autowired
	private UUIDUtil uuidUtil;
	
	@Autowired
	private ConvertUnicodeUtil convertUnicodeUtil;
	
	@Autowired
	private SizeFolderUtil sizeFolderUtil;
	/** ===================== DI ==================== **/
	
	private static final String rootDir = "C:/Users/ASUS/Desktop/test/TechZone/";
	private static final String uploadDir = "src/main/webapp/resources/images/";
	
	
//	@Autowired // DI Constructors //
	public FileStorageService() {
		
		this.fileStorageLocation = Paths.get(rootDir + uploadDir).toAbsolutePath().normalize();
		
		try {

			Files.createDirectories(this.fileStorageLocation);
			System.out.println("In FileStorageService Constructor");

		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}
	

	public void createFolderByNameProduct(String nameProduct) {// name product duoc convert san tu ben ngoai controller

		try {
			
			String pathStorage = rootDir + uploadDir + nameProduct + "/";

			File directory = new File(pathStorage);
			
			if (!directory.exists()) {
				directory.mkdirs();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getSuffixes(String fileName) {

		String[] strs = fileName.split("\\.");
		String type = strs[(strs.length - 1)];
		return type;

	}
	
	public List<String> storeFile( List<MultipartFile> files , String nameProductConvertedStandard) { // name product duoc convert san tu ben ngoai controller
		
		List<String> listPathStandard = new ArrayList<String>();
		
		String fileName = null;
		String fileNameUUID = null;
		
		try {
			
			if (files.equals(null)) {
				throw new FileStorageException(" Noob! Failed to store empty file " + nameProductConvertedStandard);
			}
			
			Path targetLocation = null;
			
			String pathSaveInResources = rootDir + uploadDir + nameProductConvertedStandard + "/";
			
			for (int i = 0 ; i < files.size() ; i++) {
				
				// reset //
				fileName = null;
				fileNameUUID = null;
				// reset //
				
				fileName = StringUtils.cleanPath(files.get(i).getOriginalFilename());
				fileName = convertUnicodeUtil.removeAccent(fileName);
				fileNameUUID = uuidUtil.generatorUUID() + "." + getSuffixes(fileName);
				
				targetLocation = Paths.get(pathSaveInResources).resolve(fileNameUUID);
				
				Files.copy(files.get(i).getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
				
				listPathStandard.add(nameProductConvertedStandard+"/"+fileNameUUID); // save , send back to save for list image of product
			}
			
			
		} catch (IOException ex) {

			throw new FileStorageException("Could not store file for " + nameProductConvertedStandard + ". Please try again!", ex);
		}
		return listPathStandard;
	}

	
	
	public Resource loadFileAsResources(String pathResource) {
		
		try {
            Path filePath = this.fileStorageLocation.resolve(pathResource).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileStorageException("File not found " + pathResource);
            }
        } catch (Exception ex) {
            throw new FileStorageException("File not found " + pathResource, ex);
        }
	}
	
	
	
} // END CLASS
