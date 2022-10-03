package me.dio.sacola.services;

import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.resources.dtos.ItemDTO;

public interface BagService {
    Bag viewBag(Long id);
    Bag closeBag(Long id, int payamentForm);
    Item insertItemInTheBag(ItemDTO item);
    Bag updateBag(Bag bag);
}
