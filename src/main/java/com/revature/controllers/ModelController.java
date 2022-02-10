package com.revature.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.daka.repositories.ModelRepoImpl;
import com.revature.models.Customer;
import com.revature.models.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModelController {
    ModelRepoImpl mr;
    Gson gson = new Gson();

    Customer customer = new Customer();
    Product product = new Product();

    public ModelController(ModelRepoImpl mr) {
        this.mr = mr;
    }

    public void addCustomer(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        Customer cust = gson.fromJson(request.getReader(), Customer.class);
        mr.addRecord(cust);

        if (cust != null) {
            response.setStatus(201);
        } else {
            response.getWriter().append("{}");
        }
    }

    public void getCustomer(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String input = request.getAttribute("id").toString();
        int id = 0;

        if (input.matches("[0-9]+")) {
            id = Integer.parseInt(input);
        } else {
            response.sendError(400, "ID is not a number.");
            return;
        }

        Customer cust = (Customer) mr.getRecord("customers", id);

        response.getWriter().append((cust != null) ? gson.toJson(cust) : "{}");
    }

    public void getAllCustomers(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        List<Customer> custList = (List<Customer>) mr.getAllRecords("customers");

        response.getWriter().append(gson.toJson(custList));
    }


    public void updateCustomer(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        Customer cust = gson.fromJson(request.getReader(), Customer.class);

        cust.setId((int) request.getAttribute("id"));
        mr.updateRecord(cust);
    }

    public void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) request.getAttribute("id");
        customer.setId(id);
        mr.deleteRecord(customer);

        response.setStatus(204);
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        Product prod = gson.fromJson(request.getReader(), Product.class);
        mr.addRecord(prod);

        if (prod != null) {
            response.setStatus(201);
        } else {
            response.getWriter().append("{}");
        }
    }

    public void getProduct(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String input = request.getAttribute("id").toString();
        int id = 0;

        if (input.matches("[0-9]+")) {
            id = Integer.parseInt(input);
        } else {
            response.sendError(400, "ID is not a number.");
            return;
        }

        Product prod = (Product) mr.getRecord("products", id);

        response.getWriter().append((prod != null) ? gson.toJson(prod) : "{}");
    }

    public void getAllProducts(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        List<Product> prodList = (List<Product>) mr.getAllRecords("products");

        response.getWriter().append(gson.toJson(prodList));
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        Product prod = gson.fromJson(request.getReader(), Product.class);

        prod.setId((int) request.getAttribute("id"));
        mr.updateRecord(prod);
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) request.getAttribute("id");
        product.setId(id);
        mr.deleteRecord(product);

        response.setStatus(204);
    }
}
