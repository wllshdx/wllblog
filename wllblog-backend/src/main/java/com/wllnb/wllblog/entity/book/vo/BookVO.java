package com.wllnb.wllblog.entity.book.vo;

import com.wllnb.wllblog.entity.book.Book;
import com.wllnb.wllblog.entity.book.BookNote;
import com.wllnb.wllblog.entity.book.BookSense;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookVo
 *
 * @author wllnb
 * @description
 */
@Data
public class BookVO extends Book {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属笔记
     */
    private List<BookNote> bookNoteList;

    /**
     * 读后感
     */
    private BookSense bookSense;
}
