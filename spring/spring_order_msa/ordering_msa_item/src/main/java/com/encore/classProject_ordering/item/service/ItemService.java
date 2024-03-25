package com.encore.classProject_ordering.item.service;

import com.encore.classProject_ordering.item.domain.Item;
import com.encore.classProject_ordering.item.dto.ItemReqDto;
import com.encore.classProject_ordering.item.dto.ItemResDto;
import com.encore.classProject_ordering.item.dto.ItemSearchDto;
import com.encore.classProject_ordering.item.dto.ItemQuantityDto;
import com.encore.classProject_ordering.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(ItemReqDto itemReqDto){
        // 앞단에서 처리
//        if(itemReqDto.getItemImage().isEmpty()){
//            throw
//        } else {}

        MultipartFile multipartFile= itemReqDto.getItemImage();
        String fileName = multipartFile.getOriginalFilename();  // 확장자 포함한 파일명 추출
        Item new_item = Item.builder()
                .name(itemReqDto.getName())
                .category(itemReqDto.getCategory())
                .price(itemReqDto.getPrice())
                .stockQuantity(itemReqDto.getStockQuantity())
                .build();
        Item item= itemRepository.save(new_item);
        Path path = Paths.get("C:/Users/Playdata/Desktop/class/spring/classProject_ordering/itemimage/",item.getId()+"_"+fileName);
        item.setImagePath(path.toString());

        try {
            byte[] bytes= multipartFile.getBytes();
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new IllegalArgumentException("image not available");
        }
        return item;
    }

    public Item delete(Long id){
        Item item= itemRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("item not found"));
        item.deleteItem();
        return item;
    }

    public Resource getImage(Long id){
        Item item = itemRepository.findById(id).orElseThrow(()->new EntityNotFoundException("not found item"));
        String imagePath = item.getImagePath();
        Path path = Paths.get(imagePath);
        Resource resource = null;
        try {
            resource= new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("url form is not valid");
        }
        return resource;
    }
    public Item update(Long id, ItemReqDto itemReqDto){
        Item item= itemRepository.findById(id).orElseThrow(()->new EntityNotFoundException("not found item"));
        MultipartFile multipartFile= itemReqDto.getItemImage();
        String fileName = multipartFile.getOriginalFilename();  // 확장자 포함한 파일명 추출
        Path path = Paths.get("C:/Users/Playdata/Desktop/class/spring/classProject_ordering/itemimage/",item.getId()+"_"+fileName);
        item.updateItem(itemReqDto.getName(),itemReqDto.getCategory(), itemReqDto.getPrice(), itemReqDto.getStockQuantity(), path.toString());

        try {
            byte[] bytes= multipartFile.getBytes();
            Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new IllegalArgumentException("image not available");
        }
        return item;
    }

    public List<ItemResDto> findAll(ItemSearchDto itemSearchDto, Pageable pageable){
//       검색을 위해 specification 객체 사용
//       specification 객체는 복잡한 쿼리를 명세를 이용해 정의하여 쉽게 생성
        Specification<Item> spec= new Specification<Item>() {
            @Override
//                root: entity의 속성에 접근하기 위한 객체, criteriaBuilder는 쿼리를 생성하기 위한 객체
            public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (itemSearchDto.getName() != null) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + itemSearchDto.getName() + "%"));
                }
                if (itemSearchDto.getCategory() != null) {
                    predicates.add(criteriaBuilder.like(root.get("category"), "%" + itemSearchDto.getCategory() + "%"));
                }
                predicates.add(criteriaBuilder.equal(root.get("delYn"),"N"));
                Predicate[] predicatesArr = new Predicate[predicates.size()];
                for (int i = 0; i < predicates.size(); i++) {
                    predicatesArr[i] = predicates.get(i);
                }
                Predicate predicate = criteriaBuilder.and(predicatesArr);
                return predicate;
            }
        };
        Page<Item> items= itemRepository.findAll(spec, pageable);
        List<Item> itemList= items.getContent();
        List<ItemResDto> itemResDtos= new ArrayList<>();
        itemResDtos= itemList.stream().map(i -> ItemResDto.builder()
                .name(i.getName())
                .price(i.getPrice())
                .stockQuantity(i.getStockQuantity())
                .id(i.getId())
                .category(i.getCategory())
                .imagePath(i.getImagePath())
                .build()).collect(Collectors.toList());
        return itemResDtos;
    }

    public void updateQuantity(ItemQuantityDto itemQuantityDto) {
        Item item = itemRepository.findById(itemQuantityDto.getId()).orElseThrow(EntityNotFoundException::new);
        item.updateStockQuantity(itemQuantityDto.getStockQuantity());
    }

    public ItemResDto findById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ItemResDto.builder()
                .id(item.getId())
                .name(item.getName())
                .category(item.getCategory())
                .stockQuantity(item.getStockQuantity())
                .price(item.getPrice())
                .build();
    }
}
