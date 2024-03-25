package com.encore.classProject_ordering.item.controller;

import com.encore.classProject_ordering.common.CommonResponse;
import com.encore.classProject_ordering.item.domain.Item;
import com.encore.classProject_ordering.item.dto.ItemReqDto;
import com.encore.classProject_ordering.item.dto.ItemResDto;
import com.encore.classProject_ordering.item.dto.ItemSearchDto;
import com.encore.classProject_ordering.item.repository.ItemRepository;
import com.encore.classProject_ordering.item.service.ItemService;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/item/create")
    public ResponseEntity<CommonResponse> itemCreate(ItemReqDto itemReqDto){
        Item item= itemService.create(itemReqDto);
        return new ResponseEntity<>(
                new CommonResponse(HttpStatus.CREATED,"Item successfully listed",item.getId()), HttpStatus.CREATED);
    }


    @GetMapping("/item/{id}/image")
    public ResponseEntity<Resource> getImage(@PathVariable Long id){
        Resource resource = itemService.getImage(id);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/item/{id}/update")
    public ResponseEntity<CommonResponse> itemUpdate(@PathVariable Long id, ItemReqDto itemReqDto){
        Item item = itemService.update(id,itemReqDto);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK,"Item successfully updated",item.getId()),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/item/{id}/delete")
    public ResponseEntity<CommonResponse> itemDelete(@PathVariable Long id){
        Item item= itemService.delete(id);
        return new ResponseEntity<>(
                new CommonResponse(HttpStatus.OK,"Item successfully listed",item.getId()), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemResDto>> items(ItemSearchDto itemSearchDto, Pageable pageable){
        List<ItemResDto> itemResDtos= itemService.findAll(itemSearchDto,pageable);
        return new ResponseEntity<>(itemResDtos,HttpStatus.OK);
    }

}
