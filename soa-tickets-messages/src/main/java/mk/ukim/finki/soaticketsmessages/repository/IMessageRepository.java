package mk.ukim.finki.soaticketsmessages.repository;

import mk.ukim.finki.soaticketsmessages.models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMessageRepository extends CrudRepository<Message, Long> {
    public List<Message> getAllBySenderId(long senderId);
    public List<Message> getAllByReceiverId(long receiverId);
}
