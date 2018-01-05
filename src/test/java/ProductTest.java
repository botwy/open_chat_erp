

import com.botwy.erp.entity.Product;
import com.botwy.erp.repository.ProductRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProductTest {

    @Test
    public void write() {
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

    @Test
    public void read() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

        ProductRepository prodRepo = ctx.getBean(ProductRepository.class);

        prodRepo.findAll().forEach(System.out::println);
    }
}
