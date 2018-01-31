package mk.ukim.finki.soaticketstickets.repository;

import mk.ukim.finki.soaticketstickets.models.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by DarkoM on 03.12.2017.
 */
public interface IInvoiceRepository extends CrudRepository<Invoice, Long> { }