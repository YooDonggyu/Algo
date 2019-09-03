import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	//기본설정
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "C:/Users/user/Desktop/selenium/chromedriver.exe";
	private static boolean isSameMonth;

	/* 변수 
	 * --- calDay : 달력일자  -----> text() 뒤의 숫자만 변경
	 * --- sTime : 시작시간, text10_1 = 15시~16시, text11_1 = 16시~17시 등 text00 값만 수정
	 * --- eTime : 종료시간, 16:00 ~17:00 , 20:00 ~21:00    ---> 띄어쓰기 맞추기!!! 맨 마지막 띄어쓰기 하나 있음, 시간만 수정!
	 * --- mYear, mMonth, mDay, mHour, mMin, mSec : 년,월,일,시,분,초
	 */
	private static final String calDay = "//a[contains (text(), '17')]";
	private static final String sTime = "text15_1"; //15~16 : text10_1, 19~20 : text14_1
	private static final String eTime = "//option[contains (text(), '21:00 ~22:00 ')]";
	private static final int mYear = 2019;
	private static final int mMonth = 9;
	private static final int mDay = 3;
	private static final int mHour = 9;
	private static final int mMin = 0;
	private static final int mSec = 0;
	
	
	//로그인
	private  WebElement login_id ;
	private  WebElement login_pw ;
	private  WebElement login_btn;
    private String login_url = "http://tancheonpark.com/kr/member/login.php";
    
    //예약
    private WebElement next_btn;
    private WebElement cal_btn;
    private WebElement day_btn;
    private WebElement end_btn;
    private WebElement member_txt;
    private WebElement encryp_txt;
    private WebElement encryp_txt1;
    private WebElement apply_tn;
    
    //생성자
    public Test() {
		super();
		
		//설정
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		
		ChromeOptions op = new ChromeOptions();
		//op.addArguments("headless"); //Chrome창 미실행
		op.addArguments("--start-maximized"); //Chrome창 최대화
		driver = new ChromeDriver(op);
		//driver = new ChromeDriver();
		
		//대기
		wait = new WebDriverWait(driver, 10); //로드 되는 시간 10초대기. 10초 이내에 로드되면 자동으로 넘어감
	
	}
    
    //메인함수
    public static void main(String[] args) {
    	
		new Test().crawl();
    	//System.out.println(addDate());
    	
	}
    
    //실행
    private void crawl() {
		try {			
			//로그인
			driver.get(login_url);
			login_id = driver.findElement(By.xpath("//input[@name='userid']"));
			login_id.sendKeys("dg931217");
			login_pw = driver.findElement(By.xpath("//input[@name='passwd']"));
			login_pw.sendKeys("ksnet12!@");
			login_btn = driver.findElement(By.xpath("//button[@class='style01']"));
			login_btn.click();
			
			
			//같은 달 확인
			isSameMonth = addDate();
			
			//로그인 후 정해진 시간까지 대기
			Thread.sleep( timeUntil( mYear, mMonth, mDay, mHour, mMin, mSec));
						
			//일원에코파크로 이동
			driver.get("http://tancheonpark.com/kr/reservation/reservation.php?part1_idx=69&part2_idx=2");
			
			//달력클릭
			while(true) {
				if(isSameMonth == false) {
					while(isElementPresent(By.xpath("//a[@title='Next']")) == false) {
						driver.navigate().refresh();
					}
					next_btn = driver.findElement(By.xpath("//a[@title='Next']"));
					next_btn.click();
					break;
				}
				/*if(isElementPresent(By.xpath(calDay))) {
					cal_btn = driver.findElement(By.xpath(calDay));
					cal_btn.click();
					break;
				}else {
					driver.navigate().refresh();
				}*/
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(calDay)));
			cal_btn = driver.findElement(By.xpath(calDay));
			cal_btn.click();
			
			//시작시간 선택
			wait.until(ExpectedConditions.elementToBeClickable((By.id(sTime))));
			day_btn = driver.findElement(By.id(sTime));
			day_btn.click();
			
			//신청서 작성
			member_txt = driver.findElement(By.xpath("//input[@name='h_num']"));
			member_txt.sendKeys("10");
			encryp_txt = driver.findElement(By.xpath("//div[@class='spam-inner-bx']"));
			encryp_txt1 = driver.findElement(By.xpath("//input[@name='spam']"));
			encryp_txt1.sendKeys(encryp_txt.getText());
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(eTime)));
			end_btn = driver.findElement(By.xpath(eTime));
			end_btn.click();
			//driver.findElement(By.xpath(eTime)).click();
			
			//신청
			apply_tn = driver.findElement(By.xpath("//a[contains (text(), '신청하기')]"));
			apply_tn.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.close();
		}
	}
    
    
    private static long timeUntil( int year, int month, int day, int hour, int minute, int msec){

    	Date now = new Date();
    	Calendar calUntil = Calendar.getInstance();
    	calUntil.set( Calendar.YEAR, year);
    	calUntil.set( Calendar.MONTH, month - 1);
    	calUntil.set( Calendar.DAY_OF_MONTH, day);
    	calUntil.set( Calendar.HOUR_OF_DAY, hour);
    	calUntil.set( Calendar.MINUTE, minute);
    	calUntil.set( Calendar.SECOND, msec);

    	Date until = calUntil.getTime();
    	
    	long sleep = until.getTime() - now.getTime();

    	return sleep;

    }

    private boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
    
    private static boolean addDate()   {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        
        Calendar cal = Calendar.getInstance();
        String today = format.format(cal.getTime()).substring(4, 6);
        
        cal.add(Calendar.DAY_OF_MONTH, 14);
        String twoWeeks = format.format(cal.getTime()).substring(4, 6);
        
        if(today.equals(twoWeeks)) {
        	return true;
        }else {
        	return false;
        }
 
    }
    
}
