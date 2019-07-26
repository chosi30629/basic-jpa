package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    ItemService itemService;

    @Autowired
    OrderService orderService;

    @Test
    public void 검색() throws Exception, NotEnoughStockException {
        // Given
        Member member = createMember("hello");
        Book book = createItem("시골 Book", 10);
        orderService.order(member.getId(), book.getId(), 1);

        Member member1 = createMember("hello1");
        Book book1 = createItem("시골 Book1", 10);
        orderService.order(member1.getId(), book1.getId(), 1);

        // When
        OrderSearch orderSearch = new OrderSearch();
        orderSearch.setMemberName("hello");
        orderSearch.setOrderStatus(OrderStatus.ORDER);

        List<Order> search = orderRepository.search(orderSearch);

        // Then
        Assert.assertEquals(2, search.size());
    }

    private Member createMember(String name) {
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
        return member;
    }

    private Book createItem(String name, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setStockQuantity(stockQuantity);
        itemService.saveItem(book);
        return book;
    }

}