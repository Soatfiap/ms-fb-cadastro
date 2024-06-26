package net.fiap.postech.fastburger.application.ports.inputports.product;

import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;

import java.util.List;

public interface FindProductByIdGateway {
    Product find(String id);
}
