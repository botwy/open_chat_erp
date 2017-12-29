package com.botwy.erp;

import com.botwy.erp.pojo.Product;
import com.botwy.erp.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainRead {
    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

        ProductRepository prodRepo = ctx.getBean(ProductRepository.class);

        prodRepo.findAll().forEach(System.out::println);
    }
}
