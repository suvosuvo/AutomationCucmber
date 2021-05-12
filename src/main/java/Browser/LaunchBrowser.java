package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {

    public WebDriver webDriver;
    public void initiateBrowser(String websiteName) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(websiteName);
    }
    public void initiateMobileBrowser(String websiteName) {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(websiteName);
    }
    public void closeBrowser() {
        webDriver.quit();
    }

    public String getAllWebDataFromBrowser(String inputTagName){
        HashMap<Object,Object> webDataMap = new HashMap<Object,Object>();
        String[] allStr={""};
        switch (inputTagName.trim().toLowerCase()) {
            case "a":
//                List<WebElement> list = webDriver.findElements(By.xpath("//"+inputTagName+"[@*]"));
                List<WebElement> listlnk = webDriver.findElements(By.xpath("//a[@*]"));
                listlnk.forEach(e -> {
                    if (e.getAttribute("href").trim().equals("")) {
                        allStr[0] +=e.getAttribute("outerHTML")+"-------------BROKEN LINK\n";
                        webDataMap.put(e.getAttribute("outerHTML"),"-------------BROKEN LINK");
                    }
                    else{
                        allStr[0] += e.getAttribute("href") + "       *********"+  e.getAttribute("innerText") + "*********\n";
                        webDataMap.put(e.getAttribute("href"), e.getAttribute("innerText"));
                    }
                });
            case "p":
                List<WebElement> listTxt = webDriver.findElements(By.xpath("//p[@*]"));
                listTxt.forEach(e -> {
                    if (e.getAttribute("innerText").trim().equals("")) {
                        allStr[0] +=e.getAttribute("outerHTML")+"-------------NO TEXT\n";
                        webDataMap.put(e.getAttribute("outerHTML"),"-------------NO TEXT");
                    }
                    else {
                        allStr[0] += e.getAttribute("class") + "       *********"+ e.getAttribute("innerText") + "*********\n";
                        webDataMap.put(e.getAttribute("class"), e.getAttribute("innerText"));
                    }
                });
            case "img":
                List<WebElement> listImg = webDriver.findElements(By.xpath("//img[@*]"));
                listImg.forEach(e -> {
                    if (e.getAttribute("src").trim().equals("")) {
                        allStr[0] +=e.getAttribute("outerHTML")+"-------------NO SOURCE\n";
                        webDataMap.put(e.getAttribute("outerHTML"),"-------------NO SOURCE");
                    }
                    else {
                        allStr[0] += e.getAttribute("alt") + "       *********"+ e.getAttribute("src") + "*********\n";
                        webDataMap.put(e.getAttribute("alt"), e.getAttribute("src"));
                    }
                });
            default:
                System.out.println("unknown tag");
                break;
        }
        System.out.println(webDataMap);
        return allStr[0];
    }

}