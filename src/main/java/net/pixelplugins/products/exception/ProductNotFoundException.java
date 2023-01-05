package net.pixelplugins.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhum produto foi encontrado com o ID especificado.")
public class ProductNotFoundException extends Exception {

}
