package com.study.order.model.dto;

import org.springframework.data.domain.Page;

public record PaginationResponse(
        Integer page,
        Integer size,
        Long total,
        Integer totalPages
) {
    public static PaginationResponse fromPage(Page<?> page) {
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
