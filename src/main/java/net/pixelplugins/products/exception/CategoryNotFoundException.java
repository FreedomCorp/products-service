package net.pixelplugins.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhuma categoria foi encontrada com o ID especificado.")
public class CategoryNotFoundException extends Exception {
}
