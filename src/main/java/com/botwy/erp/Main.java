package com.botwy.erp;

import com.botwy.erp.pojo.Product;
import com.botwy.erp.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

        ProductRepository prodRepo = ctx.getBean(ProductRepository.class);
        String title = "1943 черн";
        Double priceBuy = 1025d;
        Product prod = new Product(title, priceBuy);
        prodRepo.save(prod);

        title = "343 оливи коричн";
        priceBuy = 1130d;
        prod = new Product(title, priceBuy);
        prodRepo.save(prod);

        title = "1111 черн";
        priceBuy = 575d;
        prod = new Product(title, priceBuy);
        prodRepo.save(prod);

    }
}
