package com.wllnb.wllblog.portal.book.controller;

import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.constants.RedisCacheNames;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.book.BookNote;
import com.wllnb.wllblog.portal.book.service.BookNoteService;
import com.wllnb.wllblog.portal.common.annotation.LogLike;
import com.wllnb.wllblog.portal.common.annotation.LogView;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


/**
 * BookNoteNoteAdminController
 *
 * @author wllnb
 * @description
 */
@RestController("bookNotePortalController")
@CacheConfig(cacheNames = {RedisCacheNames.BOOKNOTE})
public class BookNoteController {

    @Resource
    private BookNoteService bookNoteService;
   

    @GetMapping("/bookNote/{bookNoteId}")
    @LogView(type = "bookNote")
    public Result getBookNote(@PathVariable Integer bookNoteId){
        BookNote bookNote = bookNoteService.getById(bookNoteId);
        return Result.ok().put("bookNote",bookNote);
    }

    @GetMapping("/bookNotes")
    @Cacheable
    public Result list(@RequestParam Map<String, Object> params){
        PageUtils page = bookNoteService.queryPageCondition(params);
        return Result.ok().put("page",page);
    }

    @PutMapping("/bookNote/like/{id}")
    @LogLike(type = "bookNote")
    public Result likeBookNote(@PathVariable Integer id) {
        return Result.ok();
    }


}
