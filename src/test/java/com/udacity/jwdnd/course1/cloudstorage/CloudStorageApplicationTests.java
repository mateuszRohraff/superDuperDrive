package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	private String username = "user";
	private String password = "password";
	private String title = "Example Title";
	private String message = "Example Message";
	private String url = "testURL.com";

	/**
	 * perform login process
	 */
	private void login() {
		driver.get("http://localhost:" + this.port + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}

	/**
	 * perform SignUp process
	 */
	private void signUp() {
		driver.get("http://localhost:" + this.port + "/signup");
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.signUp("Mateusz", "Kowalski", username, password);
	}

	@LocalServerPort
	private int port;

	private WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void getSignUpPage() {
		driver.get("http://localhost:" + this.port + "/signup");
		Assertions.assertEquals("Sign Up", driver.getTitle());
	}

	@Test
	public void unauthorizedAccessHomePage() {
		driver.get("http://localhost:" + this.port + "/home");
		Assertions.assertEquals("Login", driver.getTitle());
		Assertions.assertNotEquals("Home", driver.getTitle());
	}

	@Test
	public void signUpAndLogin() throws InterruptedException {

		signUp();

		login();

		Thread.sleep(1000);

		Assertions.assertEquals("Home", driver.getTitle());
		HomePage homePage = new HomePage(driver);
		homePage.logout();

		Assertions.assertEquals("Login", driver.getTitle());

		driver.get("http://localhost:" + this.port + "/home");

		Assertions.assertNotEquals("Home", driver.getTitle());
		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	public void createEditDeleteNote() throws InterruptedException {

		signUp();

		login();

		Thread.sleep(1000);

		HomePage homePage = new HomePage(driver);
		homePage.createNote(title, message);

		Thread.sleep(1000);

		Assertions.assertEquals(homePage.getNoteTitle(), title);
		Assertions.assertEquals(homePage.getNoteMessage(), message);

		Thread.sleep(1000);

		String editedTitle = "Edited Example Title";
		String editedMessage = "Edited Example Message";
		homePage.editNote(editedTitle, editedMessage);

		Thread.sleep(1000);

		Assertions.assertEquals(homePage.getNoteTitle(), editedTitle);
		Assertions.assertEquals(homePage.getNoteMessage(), editedMessage);

		Thread.sleep(1000);

		homePage.deleteNote();

		Thread.sleep(1000);

		Assertions.assertThrows(NoSuchElementException.class, homePage::getNoteTitle);
		Assertions.assertThrows(NoSuchElementException.class, homePage::getNoteMessage);
	}

	@Test
	public void createEditDeleteCredentials() throws InterruptedException {
		signUp();

		login();

		Thread.sleep(1000);

		HomePage homePage = new HomePage(driver);
		homePage.createCredential(url, username, password);

		Thread.sleep(1000);

		Assertions.assertEquals(homePage.getCredentialUrl(), url);
		Assertions.assertEquals(homePage.getCredentialUsername(), username);
		Assertions.assertNotNull(homePage.getCredentialPassword());
		Assertions.assertNotEquals(homePage.getCredentialPassword(), password);

		Thread.sleep(1000);

		String editUrl = "editUrl.com";
		String editUsername = "editUsername";
		String editPassword = "editPassword";
		String unencryptedPassword = homePage.editCredential(editUrl, editUsername, editPassword);

		Thread.sleep(1000);

		Assertions.assertEquals(homePage.getCredentialUrl(), editUrl);
		Assertions.assertEquals(homePage.getCredentialUsername(), editUsername);
		Assertions.assertNotNull(homePage.getCredentialPassword());
		Assertions.assertNotEquals(homePage.getCredentialPassword(), editPassword);
		Assertions.assertEquals(password, unencryptedPassword);

		Thread.sleep(1000);

		homePage.deleteCredential();

		Thread.sleep(1000);

		Assertions.assertThrows(NoSuchElementException.class, homePage::getCredentialUrl);
		Assertions.assertThrows(NoSuchElementException.class, homePage::getCredentialUsername);
		Assertions.assertThrows(NoSuchElementException.class, homePage::getCredentialPassword);
	}
}
