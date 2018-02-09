package com.conductor.contacts.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Não encontrado")
public class NotFoundException extends RuntimeException {
}
