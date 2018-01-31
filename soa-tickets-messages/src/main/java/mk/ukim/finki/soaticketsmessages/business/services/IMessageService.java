package mk.ukim.finki.soaticketsmessages.business.services;


import mk.ukim.finki.soaticketsmessages.business.view.models.CreateMessageViewModel;
import mk.ukim.finki.soaticketsmessages.business.view.models.MessageViewModel;

import java.util.List;

public interface IMessageService {
    List<MessageViewModel> getAllMessagesForSender(long senderId);
    List<MessageViewModel> getAllMessagesForReceiver(long receiverId);
    Long create(CreateMessageViewModel message) throws Exception;
    Long delete(long messageId);
}
