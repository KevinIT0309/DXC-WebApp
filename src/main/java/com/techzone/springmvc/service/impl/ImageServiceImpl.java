package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techzone.springmvc.entity.Image;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.repository.ImageRepository;
import org.springframework.transaction.annotation.Transactional;
import com.techzone.springmvc.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	@Transactional
	public Image getImage(int theId) throws ResourceNotFoundException {
		
		return imageRepository.findById(theId).orElseThrow(()-> new ResourceNotFoundException(theId));
	}
	
	@Override
	@Transactional
	public List<Image> getImagesByProductId(int theId) {
		return imageRepository.findImagesByProductId(theId);
	}

	@Override
	@Transactional
	public void saveImage(List<Image> theImages) {
		
		for (int i = 0 ; i < theImages.size() ; i++) {
			imageRepository.save(theImages.get(i));
		}
		
	}

	@Override
	@Transactional
	public void deleteImage(int theId) {
		imageRepository.deleteById(theId);
		
	}

}
