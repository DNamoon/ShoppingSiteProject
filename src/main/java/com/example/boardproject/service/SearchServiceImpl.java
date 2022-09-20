package com.example.boardproject.service;


import com.example.boardproject.dto.BoardDTO;
import com.example.boardproject.dto.PageRequestDTO;
import com.example.boardproject.dto.PageResultDTO;
import com.example.boardproject.dto.ProductDTO;
import com.example.boardproject.entity.Board;
import com.example.boardproject.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Function;

import static com.example.boardproject.dto.ProductDTO.entityToDto;

//0916 ho 추가 - 검색기능 서비스 클래스
@Service
public class SearchServiceImpl implements SearchService{

    private SearchRepository searchRepository;

    private SearchService searchService;



    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    @Transactional
    public Page<Board> search(String keyword, int pId, Pageable pageable) {
        Page<Board> postsList = searchRepository.searchMethod(keyword,pId,pageable);
        return postsList;
    }

    public ProductDTO getByPId2() {

        ProductDTO productDTO = searchService.entityToDto(searchRepository.productList().get(0));


//        boardDTO = getReviewImage(boardDTO);
//        boardDTO = getAsteriskWriter (boardDTO);

        return productDTO;
    }

//    @Override
//    @Transactional
//    public PageResultDTO<BoardDTO, Board> search(String keyword, int pId, PageRequestDTO pageRequestDTO) {
//        Pageable pageable = pageRequestDTO.getPageable(Sort.by("bId").descending());
//        Page<Board> postsList = searchRepository.searchMethod(keyword,pId,pageable);
//        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));
//
//        return new PageResultDTO<>(postsList,fn);
//    }




}
