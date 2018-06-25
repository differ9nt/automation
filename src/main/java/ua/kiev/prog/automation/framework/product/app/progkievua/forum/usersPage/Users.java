package ua.kiev.prog.automation.framework.product.app.progkievua.forum.usersPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.base.ForumPageObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.widgets.UserWidget;

import java.util.ArrayList;
import java.util.List;

public class Users extends ForumPageObject {

    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='main_content_section']");
    }

    final public Users getUsers(String users) {
        By usersLink = By.xpath("//table[@class='table_list']//a[@class='subject' and contains(text(), '" + users + "')]");
        WebElement us = this.driver().findElement(usersLink);
        us.click();
        return new Users();
    }

    public UserWidget findUser(String userName) {
        List<WebElement> list = this.driver().findElements(By.xpath("//div[@id='mlist']/table//tbody/tr"));
        List<UserWidget> usersList = new ArrayList();

        for (int i = 1; i <= list.size(); i++) {
            usersList.add(new UserWidget(this.driver(), By.xpath("//div[@id='mlist']/table//tbody/tr[" + i + "]")));

        }

        UserWidget resultUser = null;
        for (UserWidget user : usersList
                ) {
            if (userName.equals((user.getUserName()))) {
                resultUser = user;
                break;
            }
        }
            if (resultUser == null) {
                WebElement nextPage = this.driver().findElement(By.xpath("(//div[contains(@class, 'pagelinks')]//strong/following-sibling::a)[1]"));

                nextPage.click();
                return this.findUser(userName);
            }
            return resultUser;

        }
    }


