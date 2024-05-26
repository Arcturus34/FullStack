import controllers.ProductsController;
import dao.ProductsDAO;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        WebServer server = new WebServer();
        server.listen(8080);

        server.getRouter().get("/products",(WebServerContext context) -> { ProductsController.findAll(context); });

        ProductsDAO produit = new ProductsDAO();

        System.out.println(produit.findAll());

    }
}
