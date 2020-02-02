package com.wllnb.wllblog.portal.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.entity.book.Book;
import com.wllnb.wllblog.entity.book.vo.BookVO;

import java.util.Map;


/**
 * <p>
 * 图书表 服务类
 * </p>
 *
 * @author wllnb
 */
public interface BookService extends IService<Book> {

    /**
     * 分页分类获取列表
     * @param params
     * @return
     */
    PageUtils queryPageCondition(Map<String, Object> params);

    /**
     * 获取Book对象
     * @param id
     * @return
     */
    BookVO getBookVo(Integer id);
}
