package com.wllnb.wllblog.manage.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.entity.book.BookSense;

/**
 * <p>
 * 读后感 服务类
 * </p>
 *
 * @author wllnb
 */
public interface BookSenseService extends IService<BookSense> {

    /**
     * 获取读后感
     * @param bookId
     * @return
     */
    BookSense getBookSense(Integer bookId);
}
