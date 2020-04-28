package com.ehsan.jwtScaffolder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoParams {
    int pageSize = 50;
    int pageNumber = 0;
    private String sortBy;
    private String sortParam;
}
