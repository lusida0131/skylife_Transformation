package com.skylife_Transformation.mapper;

import com.skylife_Transformation.domain.BoardVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @BeforeEach
    void 데이터준비() {
        BoardVO board = new BoardVO();
        board.setB_num(2);
        board.setId("admin");
        board.setB_title("1234");
        board.setB_content("1234");
        boardMapper.insert(board);
    }
    @Test
    void 등록조회() {
        //given
        String title = "1234";
        String content = "1234";
        //when
        BoardVO boardVO = boardMapper.view(2);

        //then
        Assertions.assertEquals(title, boardVO.getB_title());
        Assertions.assertEquals(content, boardVO.getB_content());
    }
    @Test
    void 삭제() {
        //given
        String title = "1234";
        String content = "1234";
        //when
        boardMapper.delete(2);
        //then
        assertEquals(boardMapper.view(2), null);
    }

    @Test // 보류 맞는지 모르겠음
    void 목록보기() {
        //given
        String title = "1234";
        String content = "1234";

        //when
        List<BoardVO> boards = boardMapper.list(title);

        //then
        assertEquals(title, boards.get(0).getB_title());
        assertEquals(content, boards.get(0).getB_content());
    }
    @Test
    void 수정() {
        //given
        BoardVO board = new BoardVO();
        board.setB_num(2);
        board.setId("admin");
        board.setB_title("수정");
        board.setB_content("수정");

        //when
        boardMapper.update(board);
        BoardVO boardVO = boardMapper.view(2);

        //then
        assertEquals(board.getB_title(), boardVO.getB_title());
        assertEquals(board.getB_content(), boardVO.getB_content());
    }
}
