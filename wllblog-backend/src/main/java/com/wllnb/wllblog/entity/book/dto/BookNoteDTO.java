package com.wllnb.wllblog.entity.book.dto;

import com.wllnb.wllblog.entity.book.BookNote;
import com.wllnb.wllblog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * BookNote
 *
 * @author wllnb
 * @description
 */
@Data
public class BookNoteDTO extends BookNote {

    private List<Tag> tagList;

}
