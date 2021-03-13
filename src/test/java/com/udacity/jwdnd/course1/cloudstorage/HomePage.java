package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "logout-button")
    private WebElement logoutButton;

    @FindBy(id = "nav-notes-tab")
    private WebElement notesTab;

    @FindBy(id = "nav-credentials-tab")
    private WebElement credentialsTab;

    @FindBy(id = "createNote")
    private WebElement createNoteButton;

    @FindBy(id = "note-title")
    private WebElement noteTitleField;

    @FindBy(id = "note-message")
    private WebElement noteMessegeField;

    @FindBy(id = "interactiveSubmit")
    private WebElement submitNoteButton;

    @FindBy(id = "noteTitleView")
    private WebElement noteTitleView;

    @FindBy(id = "noteMessageView")
    private WebElement noteMessageView;

    @FindBy(id = "editButton")
    private WebElement editNoteButton;

    @FindBy(id = "editNoteTitle")
    private WebElement editNoteTitleField;

    @FindBy(id = "editNoteDescription")
    private WebElement editNoteMessageField;

    @FindBy(id = "editNoteInteractive")
    private WebElement editNoteSubmitButton;

    @FindBy(id = "deleteButton")
    private WebElement deleteNoteButton;

    @FindBy(id = "deleteButtonInteractive")
    private WebElement confirmNoteDelete;

    @FindBy(id = "createCredential")
    private WebElement createCredentialButton;

    @FindBy(id = "credential-url")
    private WebElement credentialUrlField;

    @FindBy(id = "credential-username")
    private WebElement credentialUsernameField;

    @FindBy(id = "credential-password")
    private WebElement credentialPasswordField;

    @FindBy(id = "createCredentialInteractive")
    private WebElement confirmCreationCredentialButton;

    @FindBy(id = "credentialUrlView")
    private WebElement credentialUrlView;

    @FindBy(id = "credentialUsernameView")
    private WebElement credentialUsernameView;

    @FindBy(id = "credentialPasswordView")
    private WebElement credentialPasswordView;

    @FindBy(id = "editCredentialButton")
    private WebElement editCredentialButton;

    @FindBy(id = "editCredential-url")
    private WebElement editCredentiualUrlField;

    @FindBy(id = "editCredential-username")
    private WebElement editCredentialUsernameField;

    @FindBy(id = "editCredential-password")
    private WebElement editCredentialPasswordField;

    @FindBy(id = "editCredentialInteractive")
    private WebElement editCredentialConfrimButton;

    @FindBy(id = "deleteCredential")
    private WebElement deleteCredentialButton;

    @FindBy(id = "deleteCredentialInteractive")
    private WebElement confirmDeleteCredentialButton;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void logout() {
        logoutButton.click();
    }

    public void createNote(String title, String message) throws InterruptedException {
        notesTab.click();
        Thread.sleep(1000);
        createNoteButton.click();
        Thread.sleep(1000);
        noteTitleField.sendKeys(title);
        noteMessegeField.sendKeys(message);
        submitNoteButton.click();
        Thread.sleep(1000);
    }

    public String getNoteTitle() throws InterruptedException {
        notesTab.click();
        Thread.sleep(1000);
        return noteTitleView.getText();
    }

    public String getNoteMessage() throws InterruptedException {
        notesTab.click();
        Thread.sleep(1000);
        return noteMessageView.getText();
    }

    public void editNote(String editedTitle, String editedMessage) throws InterruptedException {
        notesTab.click();
        Thread.sleep(1000);
        editNoteButton.click();
        Thread.sleep(1000);
        editNoteTitleField.clear();
        editNoteMessageField.clear();
        editNoteTitleField.sendKeys(editedTitle);
        editNoteMessageField.sendKeys(editedMessage);
        editNoteSubmitButton.click();
    }

    public void deleteNote() throws InterruptedException {
        notesTab.click();
        Thread.sleep(1000);
        deleteNoteButton.click();
        Thread.sleep(1000);
        confirmNoteDelete.click();
    }

    public void createCredential(String url, String username, String password) throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        createCredentialButton.click();
        Thread.sleep(1000);
        credentialUrlField.sendKeys(url);
        credentialUsernameField.sendKeys(username);
        credentialPasswordField.sendKeys(password);
        confirmCreationCredentialButton.click();
    }

    public String getCredentialUrl() throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        return credentialUrlView.getText();
    }

    public String getCredentialUsername() throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        return credentialUsernameView.getText();
    }

    public String getCredentialPassword() throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        return credentialPasswordView.getText();
    }

    public String editCredential(String editURl, String editUsername, String editPassword) throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        editCredentialButton.click();
        Thread.sleep(1000);
        String unencryptedPassword = editCredentialPasswordField.getText();
        Thread.sleep(1000);
        editCredentiualUrlField.clear();
        editCredentiualUrlField.sendKeys(editURl);
        editCredentialUsernameField.clear();
        editCredentialUsernameField.sendKeys(editUsername);
        editCredentialPasswordField.clear();
        editCredentialPasswordField.sendKeys(editPassword);
        editCredentialConfrimButton.click();
        return  unencryptedPassword;
    }

    public void deleteCredential() throws InterruptedException {
        credentialsTab.click();
        Thread.sleep(1000);
        deleteCredentialButton.click();
        Thread.sleep(1000);
        confirmDeleteCredentialButton.click();
    }
}
