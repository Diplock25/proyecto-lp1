package com.laptopstore.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.laptopstore.entities.*;

public class Test {
	static SessionFactory sessionFactory;
	static Session session;

	private static void insertProduct() {

		Supplier supplier = new Supplier();
		supplier.setCompanyName("comapany1");
		supplier.setAddress("address");
		supplier.setContactNumbers("contactNumbers");
		supplier.setContactPerson("contactPerson");

		Category category = new Category();
		category.setCategoryName("categoria-1");

		List<Size> availableSizes = new ArrayList<>();
		availableSizes.add(s1);
		availableSizes.add(s2);

		List<Color> availableColors = new ArrayList<>();
		availableColors.add(c1);
		availableColors.add(c2);

		Inventory inventory = new Inventory();

		Product p1 = new Product();
		p1.setName("p1");
		p1.setSupplier(supplier);
		p1.setCategory(category);
		p1.setProductCode("code-pro1");
		p1.setPrice(new BigDecimal(1.0));
		p1.setAvailableColors(availableColors);
		p1.setAvailableSizes(availableSizes);
		p1.setInventory(inventory);

		session.beginTransaction();
		// sizes
		session.persist(s1);
		session.persist(s2);

		// colors
		session.persist(c1);
		session.persist(c2);

		session.persist(category);

		session.persist(p1);
		session.getTransaction().commit();

		mostrarTodos();

	}

	@SuppressWarnings("unchecked")
	private static void mostrarTodos() {
		List<Product> products = (List<Product>) session.createQuery("FROM Product").getResultList();
		products.forEach(System.out::println);

	}

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();

			getProductById(1L);
			close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getProductById(Long id) {

		session.beginTransaction();

		Product product = session.get(Product.class, id);
		List<Color> colors = product.getAvailableColors();
		colors.forEach(System.out::println);

		session.getTransaction().commit();
	}

	private static void close() {
		if (session != null) {
			session.close();
			sessionFactory.close();
		}
	}
}
