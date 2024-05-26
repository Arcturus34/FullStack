package controllers;

import java.util.ArrayList;

import dao.ProductsDAO;
import models.Product;
import webserver.WebServerContext;

public class ProductsController {
    static public ArrayList<Product> findAll(WebServerContext serveur_contexte){
        ProductsDAO products = new ProductsDAO();
        serveur_contexte.getResponse().json(products.findAll());
        return products.findAll();
    }
}
