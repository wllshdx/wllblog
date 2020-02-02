package com.wllnb.wllblog.entity.book.dto;

import com.wllnb.wllblog.entity.book.Book;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookDto
 *
 * @author wllnb
 * @description
 */
@Data
public class BookDTO extends Book {

    List<Tag> tagList;
}
