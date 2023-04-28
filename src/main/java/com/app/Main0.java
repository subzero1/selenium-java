package com.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.List;

public class Main0 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime.getRuntime().exec("netsh interface set interface \"WLAN2\" admin=disabled");
        System.getProperties().setProperty("webdriver.chrome.driver", "D:\\Windows\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://10.92.228.154:8080/oa/km/imeeting/index.jsp#j_path=%2FlistWaitApproval1&tab=1");
        WebElement webElement=driver.findElement(By.name("j_username"));
        if (webElement!=null){
            webElement.sendKeys("guoct@csg.cn");
            webElement=driver.findElement(By.name("j_password"));
            webElement.sendKeys("1");
            webElement=driver.findElement(By.className("login_submit_btn"));
            webElement.click();
        }
//        webElement=driver.findElement(By.cssSelector("li[data-path='/topicDraft']"));
        webElement=driver.findElement(By.xpath("//li[@data-path='/topicDraft']"));
        webElement.click();
//        webElement=driver.findElement(By.xpath("//a[@title='决策会议议题（总部）']"));//不起作用
//        webElement=driver.findElement(By.partialLinkText("决策会议议题"));//不起作用
//        webElement=driver.findElement(By.xpath("//li/a/span[@title=\"会议通知\"]'"));//不起作用
        List <WebElement> webElements=driver.findElements(By.xpath("//li[@data-path='/myTodones']/a/span"));//起作用
//        webElement.click();
        webElements.forEach(element->{
            System.out.println(element.getText());
        });
        webElement=driver.findElement(By.xpath("//li/a[span='新起流程']/span"));
        webElement.click();
        Thread.sleep(5000);
        driver.quit();
    }
}