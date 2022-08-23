package com.skylife_Transformation.service;

import com.skylife_Transformation.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    BoardMapper boardMapper;

    @InjectMocks
    private BoardService boardService;

    @Test
    void 게시글보기Test() {
        //given

        //stub

        //when

        //then
    }
    @Test
    void  책등록() {
        //given

        //stub
        //when(boardMapper.insert(any())).thenReturn(dto.toEntity());
        //when

        //then

    }
}
