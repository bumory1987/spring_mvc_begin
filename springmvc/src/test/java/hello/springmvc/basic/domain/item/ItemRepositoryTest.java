package hello.springmvc.basic.domain.item;

import hello.springmvc.basic.mvcone.domain.item.Item;
import hello.springmvc.basic.mvcone.domain.item.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;


    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        Item item = new Item("ItemA", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Item byItem = itemRepository.findByItem(saveItem.getId());

        assertThat(byItem).isEqualTo(item);

    }


    @Test
    void findAll(){
        Item item1 = new Item("ItemA", 10000, 10);
        Item item2 = new Item("ItemB", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> result = itemRepository.findAll();

        assertThat(result).contains(item1, item2);

    }

    @Test
    void updateItem(){

        Item item1 = new Item("ItemA", 10000, 10);
        itemRepository.save(item1);
        Item itemB = new Item("ItemB", 2000, 20);
        itemRepository.update(item1.getId(), itemB);

        Item byItem = itemRepository.findByItem(item1.getId());
        System.out.println("byItem = " + byItem);

        assertThat(byItem.getItemName()).isEqualTo(itemB.getItemName());


    }


}