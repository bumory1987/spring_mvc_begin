package hello.springmvc.basic.web.basic;


import hello.springmvc.basic.domain.item.Item;
import hello.springmvc.basic.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA" , 10000 , 20 ));
        itemRepository.save(new Item("itemB", 20000 ,20 ));
    }

    @GetMapping
    public String items(Model model){
        List<Item> items  = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }


    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model){
        Item byItem = itemRepository.findByItem(itemId);
        model.addAttribute("item", byItem);
        return "/basic/item";
    }



    @GetMapping("/add")
    public String addForm(){
        return "/basic/addForm";
    }



//    @PostMapping("/add")
//    public String saveForm(
//            @RequestParam String itemName,
//            @RequestParam Integer price,
//            @RequestParam Integer quantity,
//            Model model
//
//    ){
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
//        itemRepository.save(item);
//        model.addAttribute("item", item);
//        return "/basic/item";
//    }

//    @PostMapping("/add")
//    public String saveForm(@ModelAttribute Item item, Model model){
//        itemRepository.save(item);
//        model.addAttribute("item", item);
//        return "/basic/item";
//    }


//    @PostMapping("/add")
//    public String oterman(@ModelAttribute Item item){
//        itemRepository.save(item);
//        return "/basic/item";
//    }

//    @PostMapping("/add")
    public String oterman(@ModelAttribute Item item){
        Item save = itemRepository.save(item);
        return "redirect:/basic/items/"+save.getId();
    }

    @PostMapping("/add")
    public String safeSave(@ModelAttribute Item item, RedirectAttributes redirectAttributes){
        Item save = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", save.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model){
        Item item =itemRepository.findByItem(itemId);
        model.addAttribute("item", item);
        return "/basic/editForm";

    }


    @PostMapping("/{itemId}/edit")
    public String editFormPost(@PathVariable Long itemId, @ModelAttribute Item item, Model model){
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";

    }



}
