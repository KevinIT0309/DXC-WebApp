package com.techzone.springmvc.controller.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techzone.springmvc.entity.Brand;
import com.techzone.springmvc.entity.Category;
import com.techzone.springmvc.entity.Image;
import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.entity.ProductDetail;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.Sale;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.model.ProductModel;
import com.techzone.springmvc.service.BrandService;
import com.techzone.springmvc.service.CategoryService;
import com.techzone.springmvc.service.ImageService;
import com.techzone.springmvc.service.ProductDeTailService;
import com.techzone.springmvc.service.ProductService;
import com.techzone.springmvc.service.SaleService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.storage.FileStorageService;
import com.techzone.springmvc.util.ConvertUnicodeUtil;
import com.techzone.springmvc.util.SecurityUtil;
import com.techzone.springmvc.validator.ProductValidator;

@Controller
@RequestMapping(value= {"/admin/product","/staff/product"})
public class ProductController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	// TODO : Dependency Injection
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDeTailService productDetailService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private SaleService saleService;

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private ConvertUnicodeUtil convertUnicodeUtil;

	@Autowired
	private ImageService imageService;

	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private UserService userService;

	// TODO : Dependency Injection
	
	public boolean checkAdminAccess() {
		User theUser = userService.findByUsername(SecurityUtil.getPrincipal());
		Set<Role> roles = theUser.getRoles();
		for (Role x : roles) {
			if (x.getRoleName().toString().equalsIgnoreCase("ADMIN")) {
				return true;
			}
		}
		return false;
	}

	@GetMapping("/")
	public String handleOrigin() {
		if (checkAdminAccess() == true) {
			return "redirect:/admin/product/list";
		}
		return "redirect:/staff/product/list";
	}

	@GetMapping("/list")
	public String listProduct(Model theModel) {

		List<Product> theProducts = productService.getProducts();
		theModel.addAttribute("products", theProducts);
		return "/admin/list-products";
	}

	@GetMapping("/showForm")
	public String showFormProduct(ModelMap theModel) {

		LOG.debug("inside show customer-form handler method");

		theModel.addAttribute("productModel", new ProductModel());

		getDependencyForProductProcess(theModel);

		return "/admin/form-product";
	}


	public boolean checkIsValidFiles(List<MultipartFile> files) {

		int size = files.size();
		System.err.println("FILE SIZE : " + size);

		String fileName = "";

		for (int i = 0; i < size; i++) {

			fileName = files.get(i).getOriginalFilename();

			if (fileStorageService.getSuffixes(fileName).compareTo("") == 0) {
				return false;
			}
		}
		return true;
	}

	public void showListFileSelected(List<MultipartFile> files) {
		System.err.println("=============== LIST FILES ================");
		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		System.err.println("=============== LIST FILES ================");
	}

	
	@PostMapping("/saveProduct")
	@Transactional
	public String saveProduct(@ModelAttribute("productModel") ProductModel theProductModel, ModelMap theModel,
			BindingResult bindingResult) {

		// ============================================== VALIDATOR
		productValidator.validate(theProductModel, bindingResult);
		if (bindingResult.hasErrors()) {
			getDependencyForProductProcess(theModel);
			theModel.addAttribute("productModel", theProductModel);
			return "/admin/form-product";
		}
		// ============================================== VALIDATOR

		List<MultipartFile> files = theProductModel.getImages();

		// ============================================== CHECK FILE
		if (checkIsValidFiles(files) == false) {
			System.err.println("File Format is invalid");
			getDependencyForProductProcess(theModel);
			theModel.addAttribute("productModel", theProductModel);
			return "/admin/form-product";
		}
		// ============================================== CHECK FILE

		// ============================================== READY DATA
		String nameProductConvertedUnicode = convertUnicodeUtil.removeAccent(theProductModel.getProduct().getName());
		String nameProductConvertedStandard = nameProductConvertedUnicode.replaceAll("\\s", "-");
		System.out.println("After Converted : " + nameProductConvertedStandard);

		fileStorageService.createFolderByNameProduct(nameProductConvertedStandard);
		List<String> listPath = fileStorageService.storeFile(files, nameProductConvertedStandard);

		Product theProduct = theProductModel.getProduct();
		ProductDetail theProductDetail = theProductModel.getProductDetail();
		// ============================================== READY DATA

		showListFileSelected(files); // Both for Create and Update
		
		// ============================================= IF INSTANCE OF UPDATE PRODUCT
		try {

			if (productService.getProduct(theProductModel.getProduct().getId()) != null) {

				System.out.println("Product Id : " + theProduct.getId());
				productDetailService.deleteProductDetailByProductId(theProduct.getId());
				productService.updateProduct(theProduct);

				theProductDetail.setProduct(theProduct);
				theProductDetail.setImage(listPath.get(0));
				productDetailService.updateProductDetail(theProductDetail);

				if (checkAdminAccess() == true) {
					return "redirect:/admin/product/list";
				}
				return "redirect:/staff/product/list";
				
			}

		} catch (ResourceNotFoundException ex) {
			ex.getMessage();
		}
		System.err.println("INFO : Product Already In Database [ UPDATE ]");

		// ============================================= IF INSTANCE OF UPDATE PRODUCT
		
		// ============================================= IF INSTANCE OF CREATE NEW PRODUCT
		List<Image> images = new ArrayList<Image>();
		for (String path : listPath) {
			images.add(new Image(path, theProductModel.getProduct()));
		}
		
		theProduct.setProductDetail(theProductDetail);
		theProductDetail.setProduct(theProduct);
		theProductDetail.setImage(listPath.get(0));

		productService.saveProduct(theProduct);
		productDetailService.saveProductDetail(theProductDetail);
		imageService.saveImage(images);

		if (checkAdminAccess() == true) {
			return "redirect:/admin/product/list";
		}
		return "redirect:/staff/product/list";
		// ============================================= IF INSTANCE OF CREATE NEW PRODUCT
	}
	// ===== test create and update product with upload image
	
	

	@GetMapping("/update")
	public String updateProduct(@RequestParam("productId") int theId, ModelMap theModel) throws ResourceNotFoundException {

		getDependencyForProductProcess(theModel);

		List<Image> imagesOfProduct = imageService.getImagesByProductId(theId);
		List<String> pathResource = new ArrayList<String>();
		List<MultipartFile> listOldImage = new ArrayList<MultipartFile>();

		System.out.println("----- Path Image From Database -----");
		for (int i = 0; i < imagesOfProduct.size(); i++) {
			System.out.println(imagesOfProduct.get(i).getPath());
			pathResource.add(imagesOfProduct.get(i).getPath());
		}
		System.out.println("----- Path Image From Database -----");

		System.out.println("------ INFO IMAGE CONVERT FROM RESOURCE TO MULTIPARTFILE ------");
		//TODO : GetFile , Convert to Multiple and add to listOldImage
		for (int i = 0; i < pathResource.size(); i++) {

			Resource resource = fileStorageService.loadFileAsResources(pathResource.get(i));

			MultipartFile muFile = null;
			try {
				FileInputStream input = new FileInputStream(resource.getFile());

				muFile = new MockMultipartFile("file", resource.getFile().getName(), "text/plain",
						IOUtils.toByteArray(input));

				System.out.println("-----------------------------------------------------");
				System.out.println(muFile.getOriginalFilename() + " - " + muFile.getSize());

				listOldImage.add(muFile);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("--------------- SHOW IMAGE LOADED FROM RESOURCES ---------------");
		for (int i = 0; i < listOldImage.size(); i++) {
			System.out.println(listOldImage.get(i).getOriginalFilename());
		}
		System.out.println("--------------- SHOW IMAGE LOADED FROM RESOURCES ---------------");

		// add test
		theModel.addAttribute("productModel", new ProductModel(productService.getProduct(theId),
				productService.getProduct(theId).getProductDetail(), listOldImage));

		return "/admin/form-product";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {

		productService.deleteProduct(theId);

		if (checkAdminAccess() == true) {
			return "redirect:/admin/product/list";
		}
		return "redirect:/staff/product/list";

	}

	// ============================================== SUPPORT
	// ============================================== //
	public void getDependencyForProductProcess(ModelMap theModel) {

		List<Category> categorys = categoryService.getCategorys();
		List<Brand> brands = brandService.getBrands();
		List<Sale> sales = saleService.getSales();
		theModel.addAttribute("categorys", categorys);
		theModel.addAttribute("brands", brands);
		theModel.addAttribute("sales", sales);
	}
	// ============================================== SUPPORT
	// ============================================== //

} // END CLASS

//@PostMapping("/saveProduct")
//@Transactional
//public String saveProduct(@ModelAttribute ProductModel theProductModel, ModelMap theModel) {
//
//	// test print
//	Product theProduct = theProductModel.getProduct();
//	ProductDetail theProductDetail = theProductModel.getProductDetail();
//	productDetailService.deleteProductDetailByProductId(theProduct.getId());
//
//	// add to test
//	try {
//		System.out.println("Id Product : " + productService.getProduct(theProductModel.getProduct().getId()));
//		if (productService.getProduct(theProductModel.getProduct().getId()) != null) { // upadte
////			
//			productService.updateProduct(theProduct);
//
//			theProductDetail.setProduct(theProduct);
//			productDetailService.updateProductDetail(theProductDetail);
//
//			return "redirect:/admin/product/list";
//		}
//
//	} catch (ResourceNotFoundException e) {
//		e.printStackTrace();
//	}
//	// add to test
//	theProduct.setProductDetail(theProductDetail);
//	theProductDetail.setProduct(theProduct);
//
//	productService.saveProduct(theProduct);
//	productDetailService.saveProductDetail(theProductDetail);
//
//	return "redirect:/admin/product/list";
//}
