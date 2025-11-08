package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditGistPage extends BasePage{
    private static final Logger log = LogManager.getLogger(EditGistPage.class);


    @FindBy (xpath = "//span[@class='text-bold flex-self-center']")
    private WebElement subHeadingEditPage;

    @FindBy (xpath = "//div[@class='CodeMirror-code']")
    private WebElement codeMirrorEditor;

    @FindBy(xpath = "//input[@placeholder='Gist description…']")
    private WebElement inputDescription;

    @FindBy(xpath = "//input[@placeholder='Filename including extension…']")
    private WebElement inputFileName;

    @FindBy (xpath = "//button[normalize-space()='Update public gist']")
    private WebElement submitUpdateButton;

    public EditGistPage (WebDriver driver){
        super(driver);
    }

    public void editContentPresentation(){
        waitForVisibility(inputFileName);
        inputFileName.sendKeys("_Updated");
        inputDescription.sendKeys("_Updated");
        // isi langsung
        String newContent = "Updated content for testing";

        // tunggu editor tampil
        waitForVisibility(codeMirrorEditor);

        // set value pakai JS
        ((JavascriptExecutor) driver)
                .executeScript(
                        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
                        newContent
                );
        log.info("Isi update content via JS");

        // klik tombol submit
        waitForVisibility(submitUpdateButton);
        submitUpdateButton.click();
        log.info("Click Update button");

//        waitForVisibility(subHeadingEditPage);
//        log.info("Sub Heading 'Code' tertampil");
//
//        waitForVisibility(codeMirrorEditor);
//        log.info("Click Code Mirror Editor");
//
//        // pakai JS untuk set content
//        String script = "arguments[0].innerText = arguments[1];";
//        ((JavascriptExecutor) driver).executeScript(script, codeMirrorEditor, "This content is updated.....");
//
//        submitUpdateButton.click();
//        log.info("Click Update button");





    }
}
