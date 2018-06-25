package ua.kiev.prog.automation.framework.core.product.component.object;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.MainPageLoggedIn;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.usersPage.Users;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
 abstract public class BlockObject extends PageObject
{
    private WidgetObject _source    = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_home']"));
    private WidgetObject _help      = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_help']"));
    private WidgetObject _search    = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_search']"));
    private WidgetObject _users     = new WidgetObject(this.driver(), By.xpath("//div[@id='main_menu']//li[@id='button_mlist']"));



    public MainPageLoggedIn getSource ()
    {
        _source.click();
        return new MainPageLoggedIn();
    }
    public Help getHelp ()
    {
        _help.click();
        return new Help();// TODO return
    }

    public Search getSearch ()
    {
        _search.click();
        // TODO return
        return new Search();
    }
    public Users getUsers ()
    {
        _users.click();
        return new Users();// TODO return
    }



}
