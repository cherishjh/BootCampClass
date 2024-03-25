package com.encore.classProject_ordering.order.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@Builder
//@AllArgsConstructor
@NoArgsConstructor
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
//    @Builder.Default    : 마지막 빌딩할때 이 초기값 반영
    private OrderStatus orderStatus=OrderStatus.ORDERED;     //builder 특성상 만약 클래스 위에 @AllArgsConstructor, @Builder 셋팅하면 이렇게 초기값 셋팅해줘도 OrderStatus는 null로 들어감 => 그래서 builder 따로 생성

//    @Builder.Default
    @OneToMany(mappedBy = "ordering", cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems= new ArrayList<>();


    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    @Builder
    public Ordering(Long memberId){
        this.memberId=memberId;
    }

    public void cancelOrderStatus(){
        this.orderStatus=OrderStatus.CANCELED;
    }

}
