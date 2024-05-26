package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.PolyBayDatabase;
import models.Product;

public class ProductsDAO {
    
    private PolyBayDatabase database;

    public ProductsDAO(){
        try {
            this.database = new PolyBayDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> findAll(){
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            PreparedStatement myStatement = database.prepareStatement("SELECT * FROM product ORDER BY name;");
            ResultSet results = myStatement.executeQuery();

            while(results.next())
            {
                final int id = results.getInt("id");
                final String name = results.getString("name");
                final String owner = results.getString("owner");
                final float bid = results.getFloat("bid");

                Product produit = new Product(id, name, owner, bid);
                products.add(produit);
            }
            return products;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
