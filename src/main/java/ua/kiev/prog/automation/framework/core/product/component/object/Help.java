package ua.kiev.prog.automation.framework.core.product.component.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;

public class Help extends ForumPageObject{

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='helpmain']");
    }

    final public Help getHelp(String help) {
        By helpLink = By.xpath("//table[@class='table_list']//a[@class='subject' and contains(text(), '"+help+"')]");
        WebElement h = this.driver().findElement(helpLink);
        h.click();
        return new Help();
    }

    public void  helpText() {
       String text = this.driver().findElement(By.xpath("//div[@id='helpmain']")).getText();
        System.out.println(text);

    }


}
