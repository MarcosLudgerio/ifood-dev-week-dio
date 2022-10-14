package me.dio.sacola.services.impl;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.models.enumeration.PaymentForm;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.models.Restaurant;
import me.dio.sacola.repositories.BagRepository;
import me.dio.sacola.repositories.ItemRepository;
import me.dio.sacola.repositories.ProductRepository;
import me.dio.sacola.resources.dtos.ItemDTO;
import me.dio.sacola.services.BagService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BagServiceImpl implements BagService {

    private final BagRepository bagRepository;

    private final ProductRepository productRepository;

    private final ItemRepository itemRepository;

    @Override
    public Bag viewBag(Long id) {
        return bagRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Error: bag not found");
        });
    }

    @Override
    public Bag closeBag(Long id, int typePayment) {
        Bag bag = this.viewBag(id);
        if (bag.getItems().isEmpty()) throw new RuntimeException("Error: the bag is empty");
        PaymentForm paymentForm = typePayment == 0 ? PaymentForm.CASH : PaymentForm.CARD;
        bag.setPayamentForm(paymentForm);
        bag.setClosed(true);
        return this.bagRepository.save(bag);
    }

    @Override
    public Item insertItemInTheBag(ItemDTO item) {
        Bag bag = this.viewBag(item.getIdBag());
        if (bag.isClosed()) throw new RuntimeException("Error: the bag is closed");
        Item itemReturn = Item.builder()
                .quantity(item.getQuantity())
                .bag(bag)
                .product(this.productRepository.findById(item.getIdProduct()).orElseThrow(() -> {
                    throw new RuntimeException("Error: the product not found");
                }))
                .build();
        List<Item> currentItemsBag = bag.getItems();

        if (currentItemsBag.isEmpty()) currentItemsBag.add(itemReturn);
        else this.compareIfProductAreTheSameRestaurant(currentItemsBag, currentItemsBag.get(0), itemReturn);

        this.bagRepository.save(bag);
        this.itemRepository.save(itemReturn);
        return itemReturn;
    }

    public void compareIfProductAreTheSameRestaurant(List<Item> items, Item itemToAdd, Item itemWasAlreadyAdded) {
        Restaurant restaurantItemToAdd = itemToAdd.getProduct().getRestaurant();
        Restaurant currentRestaurant = itemWasAlreadyAdded.getProduct().getRestaurant();
        if (restaurantItemToAdd.equals(currentRestaurant)) items.add(itemToAdd);
        else throw new RuntimeException("Error: The items aren't the same restaurant. Please finish your bag");
    }


    @Override
    public Bag updateBag(Long id, Bag bag) {
        Bag bagUpdate = this.viewBag(id);
        bagUpdate.setClient(bag.getClient());
        bagUpdate.setItems(bag.getItems());
        bagUpdate.setPayamentForm(bag.getPayamentForm());
        bagUpdate.setTotalValue(bag.getTotalValue());
        return this.bagRepository.save(bag);
    }
}
