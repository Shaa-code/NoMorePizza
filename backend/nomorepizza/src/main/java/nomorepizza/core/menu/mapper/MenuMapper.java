package nomorepizza.core.menu.mapper;

import nomorepizza.core.menu.dto.MenuResponseDto;
import nomorepizza.core.menu.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {
    public MenuResponseDto menuToMenuResponseDto(Menu menu) {
        return MenuResponseDto.builder()
                .id(menu.getId())
                .menuImage(menu.getMenuImage())
                .name(menu.getName())
                .allergy(menu.getAllergy())
                .origin(menu.getOrigin())
                .standard(menu.getStandard())
                .calorie(menu.getCalorie())
                .carbohydrate(menu.getCarbohydrate())
                .sugar(menu.getSugar())
                .protein(menu.getProtein())
                .fat(menu.getFat())
                .saturatedFat(menu.getSaturatedFat())
                .cholesterol(menu.getCholesterol())
                .salt(menu.getSalt())
                .description(menu.getDescription())
                .createdBy(menu.getCreatedBy())
                .createdAt(menu.getCreatedDate())
                .lastModifiedBy(menu.getLastModifiedBy())
                .lastModifiedDate(menu.getLastModifiedDate())
                .build();
    }
}
