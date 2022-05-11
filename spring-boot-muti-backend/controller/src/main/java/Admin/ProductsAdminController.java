package Admin;

import IService.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Entity.Product;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductsAdminController {
    @Autowired
    IProductService productService;
    @GetMapping("/getall")
    public ResponseEntity<Product[]> getAllProduct(){
        List<Product> productList = productService.findAll();

        return ResponseEntity.ok().body(productList.stream().toArray(Product[]::new));
    }

}
