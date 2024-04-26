package com.laptopstore.tests;

import java.time.LocalDateTime;
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

	private static void insert() {

		Categoria cat = new Categoria();
		cat.setNombreCategoria("Hogar");

		Cliente cli = new Cliente();
		cli.setNombres("Juan Pérez");
		cli.setApellidos("Gómez");
		cli.setCorreo("juan.perez@email.com");
		cli.setDireccion("Calle Mayor 123");
		cli.setTelefono("+51 987654321");

		Orden orden = new Orden();
		orden.setFechaOrden(LocalDateTime.now());
		orden.setCliente(cli);
		orden.setEstado("Pagado");

		Producto producto = new Producto();
		producto.setCodigoProducto("P123");
		producto.setCategoria(cat);
		producto.setNombreProducto("Silla de escritorio");
		producto.setDescripcionProducto("Silla ergonómica para oficina en color negro.");
		producto.setPrecio(59.99);
		producto.setOferta(10.0);

		DetalleOrden detalleOrden = new DetalleOrden();
		detalleOrden.setCantidad(2);
		detalleOrden.setOrden(orden);
		detalleOrden.setProducto(producto);

		Inventario inventario = new Inventario();
		inventario.setCantidad(10);
		inventario.setProducto(producto);

		session.beginTransaction();

		session.persist(cat);
		session.persist(producto);

		session.persist(cli);

		session.persist(orden);

		session.persist(inventario);
		session.getTransaction().commit();

		mostrarTodos();

	}

	@SuppressWarnings("unchecked")
	private static void mostrarTodos() {
		List<Orden> products = (List<Orden>) session.createQuery("FROM Orden").getResultList();
		products.forEach(System.out::println);

	}

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();

			// insert();
			System.out.println("Se pudo");
			close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getProductById(Long id) {

		session.beginTransaction();

		Producto product = session.get(Producto.class, id);
		System.out.println(product);
		// List<> colors = product.getAvailableColors();
		// colors.forEach(System.out::println);

		session.getTransaction().commit();
	}

	private static void close() {
		if (session != null) {
			session.close();
			sessionFactory.close();
		}
	}
}
