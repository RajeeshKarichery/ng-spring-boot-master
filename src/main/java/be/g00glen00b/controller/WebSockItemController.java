package be.g00glen00b.controller;

import be.g00glen00b.model.Item;
import be.g00glen00b.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/websocket2")
public class WebSockItemController {
    @Autowired
    private ItemRepository repo;

    @RequestMapping(value="/items",method = RequestMethod.GET)
    public List<Item> findItems() {
        // return repo.findAll();
        return (List<Item>) repo.findAll();
    }
}
