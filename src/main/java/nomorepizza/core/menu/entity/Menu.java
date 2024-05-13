package nomorepizza.core.menu.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @ColumnDefault("0")
    private Integer personalPrice;
    @Column
    @ColumnDefault("0")
    private Integer regularPrice;
    @Column
    @ColumnDefault("0")
    private Integer largePrice;
    @Column
    @ColumnDefault("0")
    private Integer sidePrice;
    @Column
    private String allergy; //알러지
    @Column
    private String origin; //원산지
    @Column
    @ColumnDefault("0")
    private Integer standard; //기준 100g
    @Column
    @ColumnDefault("0")
    private Double calorie; //칼로리
    @Column
    @ColumnDefault("0")
    private Double carbohydrate; //탄수화물
    @Column
    @ColumnDefault("0")
    private Double sugar; //당
    @Column
    @ColumnDefault("0")
    private Double protein; //단백질
    @Column
    @ColumnDefault("0")
    private Double fat; //지방
    @Column
    @ColumnDefault("0")
    private Double saturatedFat; //포화지방
    @Column
    @ColumnDefault("0")
    private Double cholesterol; //콜레스테롤
    @Column
    @ColumnDefault("0")
    private Double salt; //나트륨
    @Column
    private String menuImage;
    @Column
    @CreatedBy
    private String createdBy;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedBy
    private String lastModifiedBy;
    @Column
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
