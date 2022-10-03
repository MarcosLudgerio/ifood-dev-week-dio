package me.dio.sacola.services.impl;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.enumeration.PaymentForm;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.repositories.BagRepository;
import me.dio.sacola.resources.dtos.ItemDTO;
import me.dio.sacola.services.BagService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BagServiceImpl implements BagService {

    private final BagRepository bagRepository;

    @Override
    public Bag viewBag(Long id) {
        return bagRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
    }

    @Override
    public Bag closeBag(Long id, int typePayment) {
        Bag bag = this.viewBag(id);
        if (bag.getItems().isEmpty())  throw new RuntimeException("Error: the bag is empty");
        PaymentForm paymentForm = typePayment == 0 ? PaymentForm.CASH : PaymentForm.CARD;
        bag.setPayamentForm(paymentForm);
        bag.setClosed(true);
        return this.bagRepository.save(bag);
    }

    @Override
    public Item insertItemInTheBag(ItemDTO item) {
        return null;
    }

    @Override
    public Bag updateBag(Bag bag) {
        return null;
    }
}
