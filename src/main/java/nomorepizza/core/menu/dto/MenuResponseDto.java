package nomorepizza.core.menu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class MenuResponseDto {
    private Long id;
    private String menuImage;
    private String name;
    private String allergy; //알러지
    private String origin; //원산지
    private int standard; //기준 100g
    private double calorie; //칼로리
    private double carbohydrate; //탄수화물
    private double sugar; //당
    private double protein; //단백질
    private double fat; //지방
    private double saturatedFat; //포화지방
    private double cholesterol; //콜레스테롤
    private double salt; //나트륨
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
