package kr.ac.skuniv.realestate.controller;

import io.swagger.annotations.ApiOperation;
import kr.ac.skuniv.realestate.domain.dto.SearchReqDto;
import kr.ac.skuniv.realestate.domain.dto.SearchResDto;
import kr.ac.skuniv.realestate.domain.dto.SearchTmpDto;
import kr.ac.skuniv.realestate.service.SearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-02-16.
 */

@RestController @Log4j2
@RequestMapping(value = "/realestate/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @ApiOperation("매매 정보 검색")
    @PostMapping()
    public List<SearchResDto> searchBuilding(@RequestBody SearchReqDto searchReqDto){
        List<SearchResDto> searchResDtos = searchService.getBuildingList(searchReqDto);

        log.warn(searchReqDto.getAddress() + "  " + searchReqDto.getDeal() + "  " + searchReqDto.getHousingType() );
        return searchResDtos;
    }

//    @ApiOperation("매매 정보 검색 test")
//    @PostMapping("/test")
//    private List<SearchResDto> searchBuilding2(@RequestBody SearchReqDto searchReqDto){
//        List<SearchResDto> searchResDtos = searchService.getBuildingList(searchReqDto);
//
//        return searchResDtos;
//    }
}