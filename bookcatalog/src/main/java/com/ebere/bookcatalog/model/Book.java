package com.ebere.bookcatalog.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Book {

    private Integer id;
    private String name;
    private String isbn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private double price;
    private String bookType;

}

