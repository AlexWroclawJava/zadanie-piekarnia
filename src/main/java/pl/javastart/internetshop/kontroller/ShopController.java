package pl.javastart.internetshop.kontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.internetshop.ProductList;
import pl.javastart.internetshop.Product;
import pl.javastart.internetshop.ProductList;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShopController {

        private ProductList productList;

        @Autowired
        public ShopController(ProductList productlist){
                this.productList = productlist;
        }

        @GetMapping("/shop")
        public String pokazSklep(){
                return "success.html";
        }

        @GetMapping("/products")
        @ResponseBody
        public String wyswietlList(){
                List<Product> zwracanaLista = productList.getListaProduktow();
                return zwracanaLista.toString();
        }

        @GetMapping("/add1")
        public String dodajProdukt1(HttpServletRequest request) {
                String name = "Bułka";
                int price = 1;
                int quantity = Integer.valueOf(request.getParameter("quantity"));

                Product product1 = new Product(name, price, quantity);
                productList.add(product1);
                return "success2.html";
        }

        @GetMapping("/add2")
        public String dodajProdukt2(HttpServletRequest request) {
                String name = "Chleb";
                int price = 3;
                int quantity2 = Integer.valueOf(request.getParameter("quantity2"));

                Product product2 = new Product(name, price, quantity2);
                productList.add(product2);
                return "success2.html";
        }
}
