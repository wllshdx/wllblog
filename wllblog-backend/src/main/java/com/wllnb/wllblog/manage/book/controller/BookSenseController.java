package com.wllnb.wllblog.manage.book.controller;

import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.base.AbstractController;
import com.wllnb.wllblog.common.constants.RedisCacheNames;
import com.wllnb.wllblog.common.validator.ValidatorUtils;
import com.wllnb.wllblog.entity.book.BookSense;
import com.wllnb.wllblog.manage.book.service.BookSenseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 读后感 前端控制器
 * </p>
 *
 * @author wllnb
 */
@RestController
@CacheConfig(cacheNames ={RedisCacheNames.RECOMMEND,RedisCacheNames.TAG,RedisCacheNames.BOOK})
@RequestMapping("/admin/book/sense")
public class BookSenseController extends AbstractController {

    @Resource
    private BookSenseService bookSenseService;

    @GetMapping("/{bookId}")
    @RequiresPermissions("book:info")
    public Result getReadSense(@PathVariable Integer bookId) {
        BookSense bookSense = bookSenseService.getBookSense(bookId);
        return Result.ok().put("bookSense",bookSense);
    }
    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("book:save")
    @CacheEvict(allEntries = true)
    public Result save(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSenseService.save(bookSense);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("book:update")
    @CacheEvict(allEntries = true)
    public Result update(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSenseService.updateById(bookSense);
        return Result.ok();
    }
}
