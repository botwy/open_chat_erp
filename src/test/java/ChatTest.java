

import com.botwy.erp.entity.ChatMessage;
import com.botwy.erp.entity.Product;
import com.botwy.erp.repository.ChatMessageRepository;
import com.botwy.erp.repository.ProductRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatTest {

    @Test
    public void writeMessage() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

        ChatMessageRepository repository = ctx.getBean(ChatMessageRepository.class);
        String sender = "Denis";
        String msg = "Привет! Я Денис";
        ChatMessage chatMessage = new ChatMessage(sender,msg);
        repository.save(chatMessage);

        sender = "Natasha";
        msg = "Привет, Денис! Я Наташа";
        chatMessage = new ChatMessage(sender,msg);
        repository.save(chatMessage);

        sender = "Denis";
        msg = "Как дела?";
        chatMessage = new ChatMessage(sender,msg);
        repository.save(chatMessage);

    }

    @Test
    public void readMessage () {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

        ChatMessageRepository repository = ctx.getBean(ChatMessageRepository.class);

        repository.findAll().forEach(System.out::println);
    }
}
