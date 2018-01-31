package mk.ukim.finki.soaticketstickets.business.services;
import mk.ukim.finki.soaticketstickets.business.view.InvoiceViewModel;
import mk.ukim.finki.soaticketstickets.models.PaymentMethod;

import java.util.List;

/**
 * Created by DarkoM on 03.12.2017.
 */
public interface IInvoiceService {
    List<InvoiceViewModel> getAllForUser(long userId) throws Exception;
    long createInvoice(long userId, long eventId, float amountPayed, PaymentMethod paymentMethod) throws Exception;
}