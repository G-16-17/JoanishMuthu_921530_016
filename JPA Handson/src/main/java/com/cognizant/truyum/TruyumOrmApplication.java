package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class TruyumOrmApplication {

	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumOrmApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TruyumOrmApplication.class, args);
		menuItemService = context.getBean(MenuItemService.class);
		testMenuItemService();
	}

	public static void testMenuItemService() {
		LOGGER.info("Start");
		LOGGER.info("AdminList: {}", menuItemService.getMenuItemListAdmin());
		LOGGER.info("CustomerList: {}", menuItemService.getMenuItemListCustomer());
		MenuItem menuItem = menuItemService.getMenuItem(1001);
		menuItem.setItemName("SANDWICHES");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End");
	}
}
