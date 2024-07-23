package com.workintech.ecommerce.converter;

import com.workintech.ecommerce.dto.OrderRequestDto;
import com.workintech.ecommerce.dto.ProductRequestDto;
import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.dto.CartResponseDto;
import com.workintech.ecommerce.dto.CategoryResponseDto;
import com.workintech.ecommerce.dto.LoginResponseDto;
import com.workintech.ecommerce.dto.OrderResponseDto;
import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.dto.ProductResponseForOrderDto;
import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.*;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Converter {

    //ROLES
    public static List<RoleResponseDto> findRoles(List<Role> roles) {
        List<RoleResponseDto> responses = new ArrayList<>();

        for (Role role : roles) {
            responses.add(new RoleResponseDto(role.getId(), role.getRole()));
        }
        return responses;
    }

    //USERS
    public static List<UserResponseDto> findUsers(List<User> users) {
        List<UserResponseDto> userResponses = new ArrayList<>();

        for (User user : users) {
            userResponses.add(new UserResponseDto(user.getId(), user.getName(), user.getEmail()));
        }
        return userResponses;
    }

    public static UserResponseDto findUser(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public static List<CategoryResponseDto> findCategories(List<Category> categories) {
        List<CategoryResponseDto> categoryResponses = new ArrayList<>();

        for (Category category : categories) {
            categoryResponses.add(new CategoryResponseDto(category.getId(), category.getCode(),
                    category.getTitle(), category.getImg(), category.getRating(), category.getGender()));
        }
        return categoryResponses;
    }

    public static CategoryResponseDto findCategory(Category category) {
        return new CategoryResponseDto(category.getId(), category.getCode(),
                category.getTitle(), category.getImg(), category.getRating(), category.getGender());
    }

    public static List<ProductResponseDto> findProducts(List<Product> products) {
        List<ProductResponseDto> productResponses = new ArrayList<>();

        for (Product product : products) {
            productResponses.add(new ProductResponseDto(product.getId(), product.getName(),
                    product.getDescription(), product.getPrice(), product.getStock(),
                    product.getCategoryId(), product.getRating(), product.getSellCount(), product.getImage()));
        }
        return productResponses;
    }

    public static ProductResponseDto findProduct(Product product) {
        return new ProductResponseDto(product.getId(), product.getName(),
                product.getDescription(), product.getPrice(), product.getStock(),
                product.getCategoryId(), product.getRating(), product.getSellCount(), product.getImage());
    }


    public static AddressResponseDto findAddress(Address address) {
        return new AddressResponseDto(address.getId(), address.getName(), address.getSurname(), address.getPhone(), address.getCity(),
                address.getDistrict(), address.getNeighborhood(), address.getAddress());
    }



}