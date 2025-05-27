package net.iouhase.gilbert;

import net.iouhase.gilbert.controller.LoginController;
import net.iouhase.gilbert.controller.ProductController;
import net.iouhase.gilbert.controller.UserController;
import net.iouhase.gilbert.model.Product;
import net.iouhase.gilbert.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GilbertApplicationTests {

    @Autowired
    private LoginController loginController;
    @Autowired
    private UserController userController;
    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() {
        assertThat(loginController).isNotNull();
        assertThat(userController).isNotNull();
        assertThat(productController).isNotNull();
    }

    @Test
    void userNotNegativeNumbers(){
        User user = new User();
        assertThat(user.setFollowers(-10)).isEqualTo(false);
        assertThat(user.setFollowing(-10)).isEqualTo(false);
        assertThat(user.setSales(-10)).isEqualTo(false);
        assertThat(user.getFollowers()).isEqualTo(0);
        assertThat(user.getFollowing()).isEqualTo(0);
        assertThat(user.getSales()).isEqualTo(0);
    }

    @Test
    void userSettersWork(){
        User user = new User();
        user.setSales(10);
        user.setFollowers(10);
        user.setFollowing(10);
        user.setUsername("nicklas");
        user.setRealName("nicklas");
        user.setPassword("nicklas");
        user.setEmail("nicklas");
        user.setImg("nicklas");
        user.setRole("nicklas");

        assertThat(user.getSales()).isEqualTo(10);
        assertThat(user.getFollowers()).isEqualTo(10);
        assertThat(user.getFollowing()).isEqualTo(10);
        assertThat(user.getUsername()).isEqualTo("nicklas");
        assertThat(user.getRealName()).isEqualTo("nicklas");
        assertThat(user.getPassword()).isEqualTo("nicklas");
        assertThat(user.getEmail()).isEqualTo("nicklas");
        assertThat(user.getImg()).isEqualTo("nicklas");
        assertThat(user.getRole()).isEqualTo("nicklas");
    }

    @Test
    void productNotNegativeNumbers(){
        Product product = new Product();
        assertThat(product.setPrice(-10)).isEqualTo(false);
        assertThat(product.setSize(-10)).isEqualTo(false);
        assertThat(product.getSize()).isEqualTo(0);
        assertThat(product.getPrice()).isEqualTo(0);
    }

    @Test
    void productSettersWork(){
        Product product = new Product();
        product.setSize(10);
        product.setPrice(10);
        product.setItemNumber(10);
        product.setCategory("nicklas");
        product.setModel("nicklas");
        product.setImage("nicklas");

        assertThat(product.getSize()).isEqualTo(10);
        assertThat(product.getPrice()).isEqualTo(10);
        assertThat(product.getItemNumber()).isEqualTo(10);
        assertThat(product.getCategory()).isEqualTo("nicklas");
        assertThat(product.getModel()).isEqualTo("nicklas");
        assertThat(product.getImage()).isEqualTo("nicklas");
    }
}
