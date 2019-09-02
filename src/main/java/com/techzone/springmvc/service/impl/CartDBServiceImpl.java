package com.techzone.springmvc.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Bill;
import com.techzone.springmvc.entity.BillDeTail;
import com.techzone.springmvc.entity.CartDB;
import com.techzone.springmvc.entity.Product;
import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.RoleName;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.exception.ResourceNotFoundException;
import com.techzone.springmvc.model.CartModel;
import com.techzone.springmvc.model.CartModelAction;
import com.techzone.springmvc.model.ItemModel;
import com.techzone.springmvc.model.UserCheckoutModel;
import com.techzone.springmvc.repository.CartRepository;
import com.techzone.springmvc.service.BillDetailService;
import com.techzone.springmvc.service.BillService;
import com.techzone.springmvc.service.CartDBService;
import com.techzone.springmvc.service.ProductService;
import com.techzone.springmvc.service.UserService;
import com.techzone.springmvc.util.SecurityUtil;
import com.techzone.springmvc.view.ResponseInfoShopping;

@Service
public class CartDBServiceImpl implements CartDBService {
	
	private static final String [] statusOrder = {
			"SHIPPHING",
			"FINISH",
			"CANCEL"
	};

	// TODO : Dependency Injection
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@Autowired
	private BillService billService;
	
	@Autowired
	private BillDetailService billDetailSerive;
	
	@Autowired
	private CartModelAction cartModelAction;
	
	private AuthenticationTrustResolver authenticationTrustResolver;

	@Autowired
	private HttpSession session;
	// TODO : Dependency Injection

	@Override
	@Transactional
	public List<CartDB> getCartDBByUserId(int theUserId) {
		return cartRepository.findAllCartDBsByUserId(theUserId);
	}

	@Override
	@Transactional
	public List<CartDB> getCartDBByProductId(int theProductId) {
		return cartRepository.findAllCartDBsByProductId(theProductId);
	}

	@Override
	@Transactional
	public List<CartDB> getCartDBs() {
		return cartRepository.findAll();
	}
	
	@Override
	@Transactional
	public List<ItemModel> getItemsInCartDB() {
		List<ItemModel> listItem = new ArrayList<ItemModel>();
		if (isCurrentAuthentication()) { // User Authenticated
			try {
				listItem = getListItemFromCartDB();
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // Is Anonymous
			listItem = getListItemFromCartModelInSession();
		}
		return listItem;
	}

	
	
	@SuppressWarnings("deprecation")
	public String createDateOrder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		date.setMonth(date.getMonth() + 1); // cart DB of User will be stored 1 month
		String dateOrder = sdf.format(date);
		return dateOrder;
	}
	
	public CartDB checkTheProductAddToCartIsExistingInListCartDbOfUser(List <CartDB> cartDBs , Product theProduct ) {
		for (CartDB cartdb : cartDBs) {
			if (cartdb.getProduct().getId() == theProduct.getId()) {
				return cartdb; // product is existing in list cartdb of user
			}
		}
		return null;
	}
	
	public boolean checkTheProductAddToCartIsExistingInListItemCartModelInSession(CartModel cartModel , Product theProduct) {
		
		Set<Integer> setProduct = cartModel.getItems().keySet();
		
		for (Integer key : setProduct) { // key in Map Item is product Id
			if (key == theProduct.getId()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean addCart(int thePorductId) { // done

		Product theProduct = null;
		try {
			theProduct = productService.getProduct(thePorductId);
			if (theProduct.getInventory() == 0) {
				return false;
			}
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		
		// ADD CART FOR ANONYMOUS
		if (! isCurrentAuthentication()) { // Is Anonymous
			
			CartModel cartModel = getCartModelFromSession();
			
			if (cartModel.getItems().size() == 0) { // cartModel isn't exist in session
				
				// create new cartModel
				cartModel.getItems().put(thePorductId, new ItemModel(theProduct, 1));
				setCartModelIntoSession(cartModel);
				return true;
				
			}
			if (cartModel.getItems().size() > 0) { // cartModel is existing in session
				
				// check product add cart is existing in listItem cartModel in session
				if (checkTheProductAddToCartIsExistingInListItemCartModelInSession(cartModel , theProduct) == true) { // increase quantity at this item
					int newQuantity = cartModel.getItems().get(thePorductId).getQuantity() + 1;
					cartModel.getItems().get(thePorductId).setQuantity(newQuantity);
				} else { // add product to listItems
					cartModel.getItems().put(thePorductId, new ItemModel(theProduct, 1));
				}
				setCartModelIntoSession(cartModel);
				return true;
			}
			
		}
		
		// ADD CART FOR USER AUTHENTICATED
		if (isCurrentAuthentication()) { // User Authenticated
			
			System.out.println("User Principal is : " + SecurityUtil.getPrincipal());
			List <CartDB> cartDBs = new ArrayList<CartDB>();
			
			try {
				
				// TODO : Get all record of table Cartdb of user
				cartDBs = getCartDBByUserId(userService.findByUsername(SecurityUtil.getPrincipal()).getId());
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
				
			if (cartDBs.size() == 0) { // Cart of User is empty at this time
				CartDB cartDB = new CartDB(getUserOnCurrentLogin(), theProduct, 1, createDateOrder());
				// create //
				cartRepository.save(cartDB);
			}
			
			if (cartDBs.size() != 0) { // Cart of User is has some product advance
				
				CartDB cartdb = checkTheProductAddToCartIsExistingInListCartDbOfUser(cartDBs,theProduct);
				// check product add cart is existing in CartDB of user
				
				if (cartdb == null) {
					// create new record cartdb for this user
					CartDB newCartDB = new CartDB(getUserOnCurrentLogin(), theProduct, 1, createDateOrder());
					cartRepository.save(newCartDB);
					
				} else {
					// update quantity at this record existing this product
					cartdb.setQuantity(cartdb.getQuantity() + 1); // increase quantity of this product
					cartRepository.save(cartdb);
					
				}
				
			}
		}

		return true;
	}

	
	
	
	
	@Override
	@Transactional
	public boolean removeProductInCart(int theProductId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	@Transactional
	public void clearCartInSession() {
		session.removeAttribute("cartModel");
	}
	
	@Override
	@Transactional
	public void clearCartFromCartDBByUserId(int theUserId) {
		List<CartDB> cartDbs = cartRepository.findAllCartDBsByUserId(theUserId);
		for (CartDB cartdb : cartDbs) {
			cartRepository.delete(cartdb);
		}
	}
	
	
	@Override
	@Transactional // will handle listItem is empty will not appear button Buy
	public ResponseInfoShopping buy(User theUser , UserCheckoutModel theUserCheckoutModel , boolean isAuthenticated) {
		
		List<ItemModel> items = new ArrayList<ItemModel>();
		
		ResponseInfoShopping theResponseInfoShopping = null;
		
//		if (isAuthenticated == false) { // New User In Transaction
//			items = getListItemFromCartModelInSession();
//			
//			User newUser = createDefaultNewUser(theUser);
//			
//			Bill theBill = new Bill(generateBillId(),
//							generateDateOrder(),
//							(Long)cartModelAction.getTotal(items),
//							cartModelAction.getRevenue(items),
//							statusOrder[0],
//							theUserCheckoutModel.getAddress() + " - " + theUserCheckoutModel.getCity(),
//							theUserCheckoutModel.getPhone(),
//							theUserCheckoutModel.getNote(),
//							newUser,
//							randomStaffDelivery());
//			
//			billService.saveBill(theBill);
//			
//			BillDeTail theBillDetail = new BillDeTail();
//			
//			for (ItemModel i : items) {
//				theBillDetail = new BillDeTail(i.getQuantity(), i.getProduct().getPrice(), i.getProduct().getSale().getPercent(), i.getProduct(), theBill);
//				billDetailSerive.saveBillDetail(theBillDetail);
//			}
//			
//			theResponseInfoShopping = new ResponseInfoShopping(theBill.getBillId(), theUser, items ,(long)cartModelAction.getTotal(items));
//			
//		} // END
//		
//		
//		if (isAuthenticated == true) { // User Authenticated
//			
//			try {
//				items = getListItemFromCartDB();
//			} catch (ResourceNotFoundException e) {
//				e.printStackTrace();
//			}
//			Bill theBill = new Bill(generateBillId(),
//									generateDateOrder(),
//									(Long)cartModelAction.getTotal(items),
//									cartModelAction.getRevenue(items),
//									statusOrder[0],
//									theUserCheckoutModel.getAddress() + " - " + theUserCheckoutModel.getCity(),
//									theUserCheckoutModel.getPhone(),
//									theUserCheckoutModel.getNote(),
//									theUser,
//									randomStaffDelivery());
//			
//			billService.saveBill(theBill);
//			
//			BillDeTail theBillDetail = new BillDeTail();
//			
//			for (ItemModel i : items) {
//				theBillDetail = new BillDeTail(i.getQuantity(), i.getProduct().getPrice(), i.getProduct().getSale().getPercent(), i.getProduct(), theBill);
//				billDetailSerive.saveBillDetail(theBillDetail);
//			}
//			
//			theResponseInfoShopping = new ResponseInfoShopping(theBill.getBillId(), theUser, items,(long)cartModelAction.getTotal(items));
//			
//		}// END
		
		return theResponseInfoShopping;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == //
	
	public User createDefaultNewUser(User theUser) {
		
		User theDefaultUser = new User(theUser.getEmail(),
										"default",
										"default",
										theUser.getFirstName(),
										theUser.getLastName(),
										0);
		userService.save(theDefaultUser);
		return theDefaultUser;
	}
	
	public User randomStaffDelivery() {
		Random random = new Random();
		List <User> theUsers = userService.getUsers();
		List <User> staffs = new ArrayList<User>();
		for (User u : theUsers) {
			for (Role r : u.getRoles()) {
				if (r.getRoleName() == RoleName.STAFF) {
					staffs.add(u);
				}
			}
		}
		return staffs.get(random.nextInt(staffs.size()));
	}
	
	public String generateBillId() {
		String billId = null;
		billId = "BILL"+ new Date().getTime();
		return billId;
	}
	
	public String generateDateOrder() {
		String dateOrder = null;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		Calendar cal = Calendar.getInstance();
		dateOrder = sdf.format(cal.getTime());
		return dateOrder;
		
	}
	
	
	public boolean isCurrentAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.err.println("USER IS ON LOGIN");
			return true; // Authenticated User
		}
		System.err.println("IS ANONYMOUS");
		return false; // Anonymous
	}

	protected List<ItemModel> getListItemFromCartModelInSession() {
		List<ItemModel> listItems = new ArrayList<>();
		CartModel cartModel = getCartModelFromSession();
		for (ItemModel i : cartModel.getItems().values()) {
			listItems.add(new ItemModel(i.getProduct(), i.getQuantity()));
		}
		return listItems;
	}

	public void showCartOfUserAuthenticationLogin(List<CartDB> carts) throws ResourceNotFoundException {

		System.err.println("- - - - - - - - - - - - -CART OF USER - - - - - - - - - - - -");
		for (CartDB cart : carts) {
			System.out.println("Date Add Cart : " + cart.getDateOrder());
			System.out.println("Product : " + productService.getProduct(cart.getProduct().getId()).getName());
			System.out.println("Quantity : " + cart.getQuantity());
			System.out.println("User Cart : " + userService.getUser(cart.getUser().getId()).getLastName());

			System.out.println("----------------------------------------------------------");
		}
		System.err.println("- - - - - - - - - - - - -CART OF USER - - - - - - - - - - - -");

	}

	protected List<ItemModel> getListItemFromCartDB() throws ResourceNotFoundException { // get CartDB by UserName and
																							// convert
		List<ItemModel> listItems = new ArrayList<>();
		List<CartDB> cartDBs = cartRepository.findAllCartDBsByUserId(getUserOnCurrentLogin().getId());
		for (CartDB cart : cartDBs) {

			ItemModel item = new ItemModel(cart.getProduct(), (int) cart.getQuantity());
			listItems.add(item);
		}
		showCartOfUserAuthenticationLogin(cartDBs);
		return listItems;
	}

	protected User getUserOnCurrentLogin() {
		return userService.findByUsername(SecurityUtil.getPrincipal());
	}

	protected void setCartModelIntoSession(CartModel cartModel) {
		session.setAttribute("cartModel", cartModel);
	}

	protected CartModel getCartModelFromSession() {
		CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		if (cartModel == null) { // if in session don't have cartModel
			cartModel = new CartModel();
		}
		return cartModel;
	}


	// == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == == //

}
