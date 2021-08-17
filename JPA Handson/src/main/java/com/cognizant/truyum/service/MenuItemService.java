package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.getActiveAndNotFutureProduct();
	}

	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}

	public MenuItem getMenuItem(int id) {
		return menuItemRepository.getOne(id);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
	}
}
