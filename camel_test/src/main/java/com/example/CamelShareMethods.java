package com.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;





import com.example.CamelBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import java.util.Date;

public class CamelShareMethods extends CamelBase {

    /**
     * 程序进行等待
     * @param sec 程序等待时间，单位秒
     */
    public static void GoSleep(int sec)
    {
        try
        {
            Thread.sleep(sec);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }



    /**
     * 设置个人信息的日，向下滑动
     * @param driver AppiumDriver对象
     * @param during 滑动持续时间，单位：毫秒
     * @param num 滑动次数
     */
    public static  void setDayToDown(AppiumDriver<MobileElement> driver, int during, int num)
    {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        for (int i=0;i<num;i++)
        {
            driver.swipe(width * 3 / 4, height * 7 / 10 ,width * 3 / 4 , height * 24 / 25,during);

        }
    }


    /**
     * 根据classname定位元素并点击
     * @param name 元素的name
     */
    boolean flag=true;
    public boolean clickByName(AppiumDriver<MobileElement>driver,String name) {
        if (flag) {
            try {
                driver.findElement(By.name(name)).click();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     *  点击无法点击的元素，并且不会失败
     * @param driver AppiumDriver对象
     * @param id 元素的id
     */
    public void clickIdWithError(AppiumDriver<MobileElement>driver,String id){
        try
        {
            MobileElement me=driver.findElement(By.id(id));
            me.click();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 根据id查找元素并多次点击
     * @param driver AppiumDriver对象
     * @param id 目标元素的resourc-id
     * @param count 点击总次数
     * @return 返回结果
     */
    public boolean clickById(AppiumDriver<MobileElement>driver,String id, int count) {
        if (flag) {
            try {
                if (id.startsWith("sel_img_") && !id.contains("sel_img_ct")) {
                    int i = Integer.parseInt(id.substring(8, id.length()));
                    int j = 4;
                    while (i > 3) {
                        driver.findElement(By.id("sel_img_" + j)).click();
                        i -= 4;
                        j += 4;
                    }
                }
                for (int i = 0; i < count; i++)
                {
                    driver.findElement(By.id(id)).click();
                }
                System.out.println("click element by id>>" + id);
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }

    /**
     * 根据id清空并输入值
     * @return 返回结果
     * @param driver AppiumDriver对象
     * @param Id 目标元素的resourc-id
     * @param inputWhat 输入的值
     * @return
     */
    public boolean InputValueById(AppiumDriver<MobileElement>driver,String Id,String inputWhat) {
        if (flag) {

            driver.findElement(By.id(Id)).clear();
            driver.findElement(By.id(Id)).sendKeys(inputWhat);
            return true;


        } else {
            System.out.println("flag is false, function is not excuted");
            return false;
        }
    }


    /**
     * 输入用户名和密码进行登录
     * @param driver
     * @param username 用户名
     * @param password 密码
     */
    public void loginWithPhoneNum(AppiumDriver<MobileElement> driver,String username,String password)
    {
        //根据ID查找输入帐号
        MobileElement me2 = driver.findElementById("login_number");
        me2.sendKeys(username);
        //根据ID查找输入密码
        MobileElement me3 = driver.findElementById("login_password");
        me3.sendKeys(password);
        //点击登录确认按钮
        MobileElement me4 = driver.findElementById("login_sure");
        me4.click();

    }

 /*
     *  @param driver AppiumDriver实例对象
     * @param appmode 填写 native 或者 webview

    public void changeAPPMode(AppiumDriver<MobileElement> driver, String appmode)
    {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames)
        {
            //System.out.println(contextName);

            //设定app是NATIVE_APP还是WEBVIEW模式
            if (contextName.toLowerCase().contains(appmode.toLowerCase()))
            {
                if(contextName.toLowerCase().contains("WEBVIEW_com.qktz.qkz"))
                {
                    driver.context("WEBVIEW_com.qktz.qkz");
                    System.out.println("切换到 "+contextName+" 模式");
                }
                else
                {
                    driver.context(contextName);
                    System.out.println("切换 "+contextName+" 模式");
                }

            }

        }
    }
*/
 /*
    public void changeAPPModeToWV(AppiumDriver<MobileElement> driver, String appmode)
    {
        Set<String> contextNames = driver.getContextHandles();

        for (String contextName : contextNames)
        {
            System.out.println("获取到: " + contextName);
        }

            if (appmode.toLowerCase()=="native")
            {
                driver.context("NATIVE_APP");
                System.out.println("切换到 "+"NATIVE"+ "模式");
            }
            if(appmode.toLowerCase()=="webview")
            {
                driver.context("WEBVIEW_com.qktz.qkz");
                System.out.println("切换 "+"WebView"+ "模式");
            }

    }
*/
    /**
     * 转换为NativeAPP模式
     * @param driver
     */

    public void  changeAPPToNative(AppiumDriver<MobileElement> driver)
    {
        Set<String> contextNames = driver.getContextHandles();

        for (String contextName : contextNames)

            System.out.println("获取到: " + contextName);

        driver.context("NATIVE_APP");
        System.out.println("切换到 "+"NATIVE"+ "模式");
    }

    /**
     * 转换为WEBVIEW模式
     * @param driver
     */
    public void changeAPPToWEBVIEW(AppiumDriver<MobileElement> driver)
    {
        Set<String> contextNames = driver.getContextHandles();

        for (String contextName : contextNames)

            System.out.println("获取到: " + contextName);


        driver.context("WEBVIEW_com.qktz.qkz");
        System.out.println("切换 "+"WebView"+ "模式");

    }



    /**
     *
     * @param driver AppiumDriver实例对象
     * @param what 页面查找的文本信息
     * @return
     */
    public  boolean isTextPresent(AppiumDriver<MobileElement> driver,String what) {
        try{
            return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含 文本 what
        }
        catch (Exception e)
        {
            return false;// 没有该文本 则 返回 false
        }
    }

    /**
     *根据名称判断某个元素是否存在
     * @param driver AppiumDriver实例对象
     * @param what 页面查找的文本信息
     */
    public  boolean DisplayedByName(AppiumDriver<MobileElement> driver,String what){

        return driver.findElement(By.name(what)).isDisplayed();

    }

    /**
     * 根据xy坐标的值点击
     * @param x
     * @param y
     * @param duration
     * @param drivers
     */
    public static void clickScreen(int x, int y, int duration, AppiumDriver drivers) {
        JavascriptExecutor js = drivers;
        HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
        tapObject.put("x", x);
        tapObject.put("y", y);
        tapObject.put("duration", duration);
        js.executeScript("mobile: tap", tapObject);
    }

    /**
     * 获取当前系统时间
     */
    public static void getTime(){
        Date nowdate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(nowdate);
        System.out.println(time);
    }

  /*
  截图
   */

    public static void takeScreenShot(AppiumDriver driver)
    {
        File screenShotFile = driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("D:\\AutoScreenCapture\\" + getCurrentDateTime()+ ".jpg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("已截图");
    }

    public static String getCurrentDateTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
        return df.format(new Date());
    }



    /**
     * 长按拖动  （拖动排序）
     */
    public static void setMoveById(AppiumDriver<MobileElement>driver,String startId,int a,int b,int c,int d,int e,int f,int g,int h,int during) {
        MobileElement me1 = driver.findElementById(startId);
        System.out.println("起始滑动的名称为："+me1.getText());
        me1.tap(1, 3000);
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        //  driver.swipe(width * 5 / 6, height * 336 / 1280, width * 5 / 6, height * 536 / 1280, during);
        driver.swipe(width * a / b, height * c / d, width * e / f, height * g / h, during);
    }


}