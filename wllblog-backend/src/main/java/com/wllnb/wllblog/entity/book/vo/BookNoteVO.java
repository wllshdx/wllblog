package com.wllnb.wllblog.entity.book.vo;

import com.wllnb.wllblog.entity.book.Book;
import com.wllnb.wllblog.entity.book.BookNote;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ArticleVo
 *
 * @author wllnb
 * @description 文章列表VO
 */
@Data
public class BookNoteVO extends BookNote {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属书本
     */
    private Book book;

}
