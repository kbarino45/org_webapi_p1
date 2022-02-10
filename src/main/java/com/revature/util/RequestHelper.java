package com.revature.util;

import com.revature.controllers.ModelController;
import com.revature.daka.repositories.ModelRepoImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class RequestHelper {
    static ModelRepoImpl mr = new ModelRepoImpl();
    static ModelController mc = new ModelController(mr);

    public static void getProcess(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
            }
            case 3: {
                if (("customers").equals(uriTokens[2])) {
                    mc.getAllCustomers(request, response);
                } else if (("products").equals(uriTokens[2])) {
                    mc.getAllProducts(request, response);
                } else {
                    response.sendError(400, "Collection does not exist.");
                }
                break;
            }
            case 4: {
                request.setAttribute("id", uriTokens[3]);
                if (("customers").equals(uriTokens[2])) {
                    mc.getCustomer(request, response);
                } else if (("products").equals(uriTokens[2])) {
                    mc.getProduct(request, response);
                }

                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
    }

    public static void postProcess(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
            }
            case 3: {
                //Call a "get all <entities> in a collection" service method.
                if (("customers").equals(uriTokens[2])) mc.addCustomer(request, response);
                else if (("products").equals(uriTokens[2])) mc.addProduct(request, response);
                else response.sendError(400, "Collection does not exist.");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
    }

    public static void putProcess(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
            }
            case 4: {
                String input = uriTokens[3];
                int id = 0;

                if (input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number.");
                    return;
                }

                request.setAttribute("id", id);
                if (("customers").equals(uriTokens[2])) mc.updateCustomer(request, response);
                else if (("products").equals(uriTokens[2])) mc.updateProduct(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
    }

    public static void deleteProcess(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ResourceNotFoundException {
        String uri = request.getRequestURI();
        String[] uriTokens = uri.split("/");

        switch (uriTokens.length) {
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
            }
            case 4: {
                String input = uriTokens[3];
                int id = 0;

                if (input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number.");
                    return;
                }

                request.setAttribute("id", id);
                if (("customers").equals(uriTokens[2])) mc.deleteCustomer(request, response);
                else if (("products").equals(uriTokens[2])) mc.deleteProduct(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }
    }
}