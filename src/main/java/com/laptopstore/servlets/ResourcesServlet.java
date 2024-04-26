package com.laptopstore.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/static/*")
public class ResourcesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestedFile = request.getPathInfo();
		String realPath = getServletContext().getRealPath("/recursos/imagenes/") + requestedFile;
		System.out.println(realPath);

		File file = new File(realPath);
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				response.getOutputStream().write(buffer, 0, bytesRead);
			}
			fis.close();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}