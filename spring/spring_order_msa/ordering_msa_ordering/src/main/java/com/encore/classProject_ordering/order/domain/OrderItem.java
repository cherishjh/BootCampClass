package com.encore.classProject_ordering.order.domain;


import com.encore.classProject_ordering.order.domain.Ordering;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;          // 강사님:int  -> 체크

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name="ordering_id")
    private Ordering ordering;

    @JoinColumn(nullable = false)
    private Long itemId;

    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updatedTime;

}
