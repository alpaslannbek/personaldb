package com.personaldb.service.responses;

import com.personaldb.domain.Item;
import org.springframework.http.HttpStatus;

public record GetResponse(HttpStatus status, Item item) {
}
