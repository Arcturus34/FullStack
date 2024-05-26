import { ProductsService } from "../services/products-service.js";

export class ProductsView {
    constructor() { }

    displayProducts() {
        ProductsService.findAll().then(produits => {
            for (let i = 0; i < produits.length; i++) {
                this.#displayProduct(produits[i]);
            }
        }).catch(error => {
            console.error("Erreur lors de l'affichage des produits", error);
        });
    }

    #displayProduct(product) {
        const products = document.querySelector(".products");
        let enfant = document.createElement("p");
        let button = document.createElement("button")
        button.innerHTML = `Enchérir`;
        enfant.innerHTML = `${product.name} ${product.owner} ${product.bid}€`;
        products.appendChild(enfant);
        products.appendChild(button);
    }
}