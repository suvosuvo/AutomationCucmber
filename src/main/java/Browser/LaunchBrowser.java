package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public WebDriver webDriver;
    final String[] allStr={""};
    final String[] allJsoupStr={""};
    public void initiateBrowser(String websiteName) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(websiteName);
    }
    public void closeBrowser() {
        webDriver.quit();
    }
    public HashMap getAllLinkFromBrowser() {
        HashMap<Object,Object> webLinksMap = new HashMap<Object,Object>();
        List<WebElement> list = webDriver.findElements(By.xpath("//a[@*]"));
        list.forEach(e -> {
              if (e.getAttribute("href").trim() == "") {
                  allStr[0] +=e.getAttribute("outerHTML")+"-------------BROKEN LINK\n";}
              else{
                  allStr[0] +=e.getAttribute("href")+e.getAttribute("innerText")+"\n";}
                  webLinksMap.put(e.getAttribute("href"),e.getAttribute("innerText"));
        });
        System.out.println(webLinksMap);
//        return allStr[0];
        return webLinksMap;
    }

}