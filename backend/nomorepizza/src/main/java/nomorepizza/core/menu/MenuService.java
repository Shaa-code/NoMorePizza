package nomorepizza.core.menu;

import lombok.RequiredArgsConstructor;
import nomorepizza.core.menu.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public Page<Menu> findAllMenu(int page, int size){
        return menuRepository.findAll(PageRequest.of(page,size, Sort.by("id").ascending()));
    }

    public <S extends Menu> S save(S entity){
        return menuRepository.save(entity);
    }
}
