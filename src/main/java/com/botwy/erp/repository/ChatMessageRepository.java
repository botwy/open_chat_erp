package com.botwy.erp.repository;

import com.botwy.erp.entity.ChatMessage;
import com.botwy.erp.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage,Long>{
}
