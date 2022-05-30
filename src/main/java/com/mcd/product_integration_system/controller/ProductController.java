package com.mcd.product_integration_system.controller;

import com.mcd.product_integration_system.model.Product;
import com.mcd.product_integration_system.service.ProductService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mahmutcandurak
 */

@Controller
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/adminHome")
    public ModelAndView getHome (Model model) {
        ModelAndView mav = new ModelAndView("product");
        List<Product> productList = productService.getProducts();

        mav.addObject("productList",productList);

        return mav;
    }

    @GetMapping("/userHome")
    public ModelAndView getUserHome (Model model) {
        ModelAndView mav = new ModelAndView("user_product");
        List<Product> productList = productService.getProducts();

        mav.addObject("productList",productList);

        return mav;
    }



    @RequestMapping("/new")
    public ModelAndView showNewProductForm(Model model) {
        Product product = new Product();
        ModelAndView mav = new ModelAndView("new_product");
        mav.addObject("product",product);
        return mav;
    }

    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String saveNewProduct(@ModelAttribute("product") Product product) {
        productService.saveProducts(product);
        return "redirect:/home";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name="id") Long id) {
        ModelAndView mav=new ModelAndView("edit_product");
        Product product = productService.getProduct(id);
        mav.addObject("product",product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/home";
    }


    @PostMapping("/import")
    public String mapReapExcelDatatoDB( @RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {


        Product tempProduct = new Product();
        List<Product> productList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++) {

            XSSFRow row = worksheet.getRow(i);

            tempProduct.setName(row.getCell(0).getStringCellValue());
            tempProduct.setBrand(row.getCell(1).getStringCellValue());
            tempProduct.setPrice((row.getCell(2).getStringCellValue()));

            productList.add(tempProduct);

        }

        productService.saveAll(productList);

        return "redirect:/home";
    }






}
