package com.wllnb.wllblog.portal.book.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wllnb.wllblog.common.util.PageUtils;
import com.wllnb.wllblog.common.util.Query;
import com.wllnb.wllblog.entity.book.BookNote;
import com.wllnb.wllblog.entity.book.vo.BookNoteVO;
import com.wllnb.wllblog.mapper.book.BookNoteMapper;
import com.wllnb.wllblog.portal.book.service.BookNoteService;
import com.wllnb.wllblog.portal.book.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * bookNoteAdminServiceImpl
 *
 * @author wllnb
 * @description
 */
@Service("BookNotePortalService")
public class BookNoteServiceImpl extends ServiceImpl<BookNoteMapper, BookNote> implements BookNoteService {

    @Resource
    private BookService bookService;


    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<BookNoteVO> page = new Query<BookNoteVO>(params).getPage();
        List<BookNoteVO> bookNoteList = baseMapper.queryPageCondition(page, params);
        page.setRecords(bookNoteList);
        return new PageUtils(page);
    }

    /**
     * 获取简单对象
     *
     * @param bookNoteId
     * @return
     */
    @Override
    public BookNoteVO getSimpleBookNoteVo(Integer bookNoteId) {
        BookNoteVO bookNoteVo = baseMapper.getSimpleBookNoteVo(bookNoteId);
        bookNoteVo.setBook(bookService.getBookVo(bookNoteVo.getBookId()));
        return bookNoteVo;
    }

    /**
     * 获取简单List
     *
     * @param bookId
     * @return
     */
    @Override
    public List<BookNote> listSimpleBookNote(Integer bookId) {
        return baseMapper.listSimpleBookNote(bookId);
    }


}
