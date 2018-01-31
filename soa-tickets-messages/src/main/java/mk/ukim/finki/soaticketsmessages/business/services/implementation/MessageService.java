package mk.ukim.finki.soaticketsmessages.business.services.implementation;

import mk.ukim.finki.soaticketsmessages.business.services.IMessageService;
import mk.ukim.finki.soaticketsmessages.business.view.models.CreateMessageViewModel;
import mk.ukim.finki.soaticketsmessages.business.view.models.MessageViewModel;
import mk.ukim.finki.soaticketsmessages.models.Message;
import mk.ukim.finki.soaticketsmessages.repository.IMessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService implements IMessageService {

    private ModelMapper mapper;

    public MessageService() { mapper = new ModelMapper(); }

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private INotificationService notificationService;

    @Override
    public List<MessageViewModel> getAllMessagesForSender(long senderId) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<MessageViewModel> results = new ArrayList<>();
        List<Message> messagesResults = messageRepository.getAllBySenderId(senderId);
        for(Message msg : messagesResults) {
            MessageViewModel messageViewModel = mapper.map(msg, MessageViewModel.class);
            messageViewModel.setDate(dateFormat.format(msg.getDate()));
            results.add(messageViewModel);
        }

        return results;
    }

    @Override
    public List<MessageViewModel> getAllMessagesForReceiver(long receiverId) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<MessageViewModel> results = new ArrayList<>();
        List<Message> messagesResults = messageRepository.getAllByReceiverId(receiverId);
        for(Message msg : messagesResults) {
            MessageViewModel messageViewModel = mapper.map(msg, MessageViewModel.class);
            messageViewModel.setDate(dateFormat.format(msg.getDate()));
            results.add(messageViewModel);
        }

        return results;
    }

    @Override
    public Long create(CreateMessageViewModel message) throws Exception {
        User sender = userRepository.findOne(message.getSenderId());
        if(sender == null) {
            throw new Exception("Sender not found");
        }

        User receiver = userRepository.findOne(message.getReceiverId());
        if(receiver == null) {
            throw new Exception("Receiver not found");
        }

        Message messageNew = new Message(sender, receiver, message.getSubject(), message.getMessage());

        Message savedMessage = messageRepository.save(messageNew);

        notificationService.sendNotification(sender.getId(), receiver.getId(), NotificationType.Message);

        return savedMessage.getId();
    }

    @Override
    public Long delete(long messageId) {
        messageRepository.delete(messageId);
        return messageId;
    }
}
