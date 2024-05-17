package nomorepizza.core.menu;


import nomorepizza.core.menu.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Override
    Page<Menu> findAll(Pageable pageable);

    @Override
    <S extends Menu> S save(S entity);
}
