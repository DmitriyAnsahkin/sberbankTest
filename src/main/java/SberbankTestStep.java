import org.openqa.selenium.By;
import org.testng.Assert;

public class SberbankTestStep  extends CommonSteps{

    //выбор региона на странице https://www.sberbank.ru/ru/person
    final String SELECT_REGION = "//div[@class='header ']//*[@class='hd-ft-region__title']";
    //строка поиска в окне выбора региона
    final String SEARCH_REGION = "//input[@class='kit-input__control' and @type='search']";
    //Элемент footer с ссылками на соц сети
    final String FOOTER_SOCIAL = "//*[@class='footer__social']";

    SberbankTestStep (){

    };

    public SberbankTestStep clickSelectRegion(){
        waitVisibleAndScrollAndClick(SELECT_REGION);
        return this;
    }


    public SberbankTestStep clickByRegionAndInsText (String regionName){
        waitVisibilityOfElementLocated(SEARCH_REGION);
        insertTextIntoWebElement(SEARCH_REGION, regionName, "ENTER");
        return this;
    }

    public SberbankTestStep checkRegion (String region){
        checkEquals(region, SELECT_REGION);
        return this;
    }

    public SberbankTestStep scrollToFooter (){
        scrollToElement(FOOTER_SOCIAL);
        return this;
    }

    public SberbankTestStep checkExistenceElement (String...elements) {
        if (elements.length > 0){
            for (String element : elements) {
                Assert.assertTrue(driver.findElement(By.xpath(element)).isDisplayed());
            }
        }
        return this;
    }
}
