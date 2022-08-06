package com.skylife_Transformation.service;

import com.skylife_Transformation.domain.BoardVO;
import com.skylife_Transformation.mapper.BoardMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BoardServiceTest {

    @Mock
    BoardMapper boardMapper;

    @InjectMocks
    BoardServiceImpl boardService;

    @Test
    void 게시글보기Test() {
        //given
        BoardVO book = new BoardVO();
        book.setB_num(2);
        book.setId("admin");
        book.setB_title("1234");
        book.setB_content("1234");

        //when
        boardMapper.insert(book);
        BoardVO boardVO = boardService.view(2);
        //then
        Assertions.assertEquals(book.getB_num(), boardVO.getB_num());
    }
}
