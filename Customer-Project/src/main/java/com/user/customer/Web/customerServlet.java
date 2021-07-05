package com.user.customer.Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.customer.Dao.customerDao;
import com.user.customer.Model.Customer;

@WebServlet("/")
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private customerDao customerdao;

	public void init() {
		customerdao = new customerDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getContextPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCustomer(request, response);
				break;
			case "/edit":
				showEditForm(request, response);

				break;
			case "/update":
				updateCustomer(request, response);

				break;
			case "/delete":
				deleteCustomer(request, response);
				break;

			default:
				listCustomer(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	// new
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher r1 = request.getRequestDispatcher("customer-form.jsp");
		r1.forward(request, response);

	}

	// insert
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String street = request.getParameter("street");
		String country = request.getParameter("country");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String city = request.getParameter("city");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int fax = Integer.parseInt(request.getParameter("fax"));
		String web = request.getParameter("web");
		String email = request.getParameter("email");
		String Notes = request.getParameter("Notes");

		Customer c1 = new Customer(name, addr1, addr2, street, country, zip, city, phone, fax, web, email, Notes);
		customerdao.insertCustomer(c1);
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));

		Customer c2 = customerdao.selectCustomer(id);
		RequestDispatcher r2 = request.getRequestDispatcher("customer-form.jsp");
		request.setAttribute("customer", c2);

		r2.forward(request, response);

	}

	// update
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String street = request.getParameter("street");
		String country = request.getParameter("country");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String city = request.getParameter("city");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int fax = Integer.parseInt(request.getParameter("fax"));
		String web = request.getParameter("web");
		String email = request.getParameter("email");
		String notes = request.getParameter("Notes");

		Customer c1 = new Customer(name, addr1, addr2, street, country, zip, city, phone, fax, web, email, notes);
		customerdao.updateCustomer(c1);
		response.sendRedirect("list");

	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		customerdao.delCustomer(id);
		response.sendRedirect("list");

	}

	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Customer> listCustomer = customerdao.selectAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher r6 = request.getRequestDispatcher("customer-list.jsp");
		r6.forward(request, response);

	}

}
