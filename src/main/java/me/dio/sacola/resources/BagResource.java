package me.dio.sacola.resources;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacola.models.Bag;
import me.dio.sacola.models.Item;
import me.dio.sacola.resources.dtos.ItemDTO;
import me.dio.sacola.services.BagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood/bag")
@RequiredArgsConstructor
@Api(value="/ifood/bag")
public class BagResource {

    private final BagService bagService;

    @PostMapping
    public Item addItemInTheBag(@RequestBody ItemDTO itemDTO){
        return bagService.insertItemInTheBag(itemDTO);
    }

    @GetMapping("/{id}")
    public Bag viewBag(@PathVariable Long id){
        return bagService.viewBag(id);
    }

    @PatchMapping("/close/{bagId}")
    public Bag closeBag(@PathVariable("bagId") Long bagId, @RequestParam("payment") int payment) {
        return bagService.closeBag(bagId, payment);
    }
}
