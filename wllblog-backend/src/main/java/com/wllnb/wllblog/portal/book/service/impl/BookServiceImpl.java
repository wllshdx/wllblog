package com.wllnb.wllblog.portal.book.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.common.util.Query;
import com.wllnb.wllblog.entity.book.Book;
import com.wllnb.wllblog.entity.book.vo.BookVO;
import com.wllnb.wllblog.mapper.book.BookMapper;
import com.wllnb.wllblog.portal.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 图书表 服务实现类
 * </p>
 *
 * @author wllnb
 */
@Service("bookPortalService")
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<BookVO> page = new Query<BookVO>(params).getPage();
        List<BookVO> bookList = baseMapper.queryPageCondition(page, params);
        page.setRecords(bookList);
        return new PageUtils(page);
    }

    /**
     * 获取Book对象
     *
     * @param id
     * @return
     */
    @Override
    public BookVO getBookVo(Integer id) {
        return this.baseMapper.selectByIdWithSubList(id);
    }
}
