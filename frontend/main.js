import { ProductsService } from "./services/products-service.js";
import { ProductsView } from "./views/products-view.js";

function run(){
    ProductsService.findAll().then((data) => {
        if (data) {
            console.log("Tous les produits:", data);
            const prod = new ProductsView();
            prod.displayProducts();
        } else {
            console.log("Aucun produit trouvé");
        }
    }).catch(error => {
        console.log("Connexion refusée", error);
    });
}

window.addEventListener("load", run);