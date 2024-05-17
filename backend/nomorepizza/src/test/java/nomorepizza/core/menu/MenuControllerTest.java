package nomorepizza.core.menu;

import nomorepizza.core.menu.entity.Menu;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@SpringBootTest //Create ApplicationContext
@AutoConfigureMockMvc //MockMvc 생성 및 자동 구성
class MenuControllerTest {

    private static final String apiVersion = "/api/v1";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    MenuRepository menuRepository;


    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @DisplayName("메뉴 페이지네이션 테스트")
    void menuPageTest() throws Exception {
        //given
        final String url = apiVersion + "/menus";

        Menu menu = menuRepository.save(Menu.builder()
                .id(1L)
                .name("Spicy Chicken Burger")
                .description("A delicious spicy chicken burger with lettuce and mayo.")
                .personalPrice(800)
                .regularPrice(1000)
                .largePrice(1200)
                .sidePrice(300)
                .allergy("Contains gluten")
                .origin("USA")
                .standard(150)
                .calorie(320.5)
                .carbohydrate(25.2)
                .sugar(3.5)
                .protein(20.8)
                .fat(15.6)
                .saturatedFat(4.2)
                .cholesterol(65.3)
                .salt(1.8)
                .menuImage("spicy_chicken_burger.jpg")
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .lastModifiedBy("admin")
                .lastModifiedDate(LocalDateTime.now())
                .build());


        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .param("page","1")
                .param("size","1")
                .accept(MediaType.APPLICATION_JSON));

        //then
        result
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content[0].id").value(menu.getId()))
            .andExpect(jsonPath("$.content[0].name").value(menu.getName()))
            .andExpect(jsonPath("$.content[0].description").value(menu.getDescription()))
            .andExpect(jsonPath("$.content[0].menuImage").value(menu.getMenuImage()))
            .andExpect(jsonPath("$.content[0].allergy").value(menu.getAllergy()))
            .andExpect(jsonPath("$.content[0].origin").value(menu.getOrigin()))
            .andExpect(jsonPath("$.content[0].standard").value(menu.getStandard()))
            .andExpect(jsonPath("$.content[0].calorie").value(menu.getCalorie()))
            .andExpect(jsonPath("$.content[0].carbohydrate").value(menu.getCarbohydrate()))
            .andExpect(jsonPath("$.content[0].sugar").value(menu.getSugar()))
            .andExpect(jsonPath("$.content[0].protein").value(menu.getProtein()))
            .andExpect(jsonPath("$.content[0].fat").value(menu.getFat()))
            .andExpect(jsonPath("$.content[0].saturatedFat").value(menu.getSaturatedFat()))
            .andExpect(jsonPath("$.content[0].cholesterol").value(menu.getCholesterol()))
            .andExpect(jsonPath("$.content[0].salt").value(menu.getSalt()))
            .andExpect(jsonPath("$.content[0].createdBy").value(menu.getCreatedBy()))
            .andExpect(jsonPath("$.content[0].createdAt").value(menu.getCreatedDate().toString().substring(0,26)))
            .andExpect(jsonPath("$.content[0].lastModifiedBy").value(menu.getLastModifiedBy()))
            .andExpect(jsonPath("$.content[0].lastModifiedDate").value(menu.getLastModifiedDate().toString().substring(0,26)));
    }

    @AfterEach
    public void cleanUp() {
        menuRepository.deleteAll();
    }

}