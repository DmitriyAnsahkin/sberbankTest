import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestItselfSberbank {
    SberbankTestStep imitationUser = new SberbankTestStep();
    // переменные используемые в тесте
    String region = "Нижегородская область";
    //элементы проверяемые на наличие
    String facebook = "//a[@class='footer__social_link' and @title='Поделиться в Фейсбук']";
    String twitter = "//a[@class='footer__social_link' and @title='Поделиться в Twitter']";
    String youtube = "//a[@class='footer__social_link' and @title='Поделиться в Ютьюб']";
    String insta = "//a[@class='footer__social_link' and @title='Поделиться в Инстаграм']";
    String vk = "//a[@class='footer__social_link' and @title='Поделиться в Вконтакте']";
    String odnoklass = "//a[@class='footer__social_link' and @title='Поделиться в Одноклассниках']";

    @BeforeTest
    public void begin() {
        imitationUser.begin(true);
    }

    @AfterTest
    public void end() {
        imitationUser.end(false);
    }

    @Test
    public void testItself() {
        //Step 1. Перейти на главную страницу  http://www.sberbank.ru/ru/person
        imitationUser.openLink("http://www.sberbank.ru/ru/person");
        //step 2. Кликнуть на ссылку с текущим вашим регионом/городом
        imitationUser.clickSelectRegion()
                //step 3. В появившемся div “Выбор региона”, в поле «Введите название региона» введите «Нижегородская область» и выполните поиск
                .clickByRegionAndInsText(region)
                //step 4. Вернитесь на главную страницу и проверьте , что регион изменился на  «Нижегородская область»
                .checkRegion(region)
                //step 5. При помощи  JavaScriptExecutor проскрольте страницу до элемента DOM footer
                .scrollToFooter()
                //step 6.  Проверьте, что footer содержит ссылки на социальные группы
                .checkExistenceElement(facebook, twitter, youtube, insta, vk, odnoklass);
    }
}
