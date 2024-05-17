package nomorepizza.core.menu;

import lombok.RequiredArgsConstructor;
import nomorepizza.core.menu.dto.MenuResponseDto;
import nomorepizza.core.menu.entity.Menu;
import nomorepizza.core.menu.mapper.MenuMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {

    private final MenuService menuService;
    private final MenuMapper menuMapper;

    @GetMapping("/menus")
    public ResponseEntity<Page<MenuResponseDto>> getMenus(@RequestParam int page,
                                                          @RequestParam int size){
        Page<Menu> pageMenus = menuService.findAllMenu(page-1, size);
        Page<MenuResponseDto> pageMenuResponseDto = pageMenus.map(menuMapper::menuToMenuResponseDto);
        return new ResponseEntity<>(pageMenuResponseDto, HttpStatus.OK);
    }
}
