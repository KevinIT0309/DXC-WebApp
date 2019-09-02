package com.techzone.springmvc.service;

import java.util.List;

import com.techzone.springmvc.entity.Image;
import com.techzone.springmvc.exception.ResourceNotFoundException;

public interface ImageService {
	
	public Image getImage(int theId) throws ResourceNotFoundException;
	
	public List<Image> getImagesByProductId(int theId);
	
	public void saveImage(List<Image> theImages);
	
	public void deleteImage(int theId);
}
