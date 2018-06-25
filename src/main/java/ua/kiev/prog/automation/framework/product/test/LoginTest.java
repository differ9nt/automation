package ua.kiev.prog.automation.framework.product.test;

import ua.kiev.prog.automation.framework.core.Test;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.*;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.usersPage.Users;
import ua.kiev.prog.automation.framework.product.app.progkievua.forum.widgets.UserWidget;

import java.util.List;

/**
 * ////////////////////////////////////////////////////////// *
 * Automation Framework                                       *
 * Automation Course for https://prog.kiev.ua/                *
 * ---------------------------------------------------------- *
 * Created by Yurii Voronenko                                 *
 * Email: yurii.voronenko@gmail.com                           *
 * ////////////////////////////////////////////////////////// *
 */
public class LoginTest extends Test
{

    @Override
    public String name()
    {
        return "Login to forum test";
    }

    @Override
    public void beforeTest()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: BEFORE RUN");
    }

    @Override
    public void test()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: TEST");

        // Получаем главную страницу
        MainPage mainPage   = Component.getSingleton(Forum.class).mainPage();
        // Переходим на страницу логина
        LoginPage loginPage = mainPage.getLoginPage();
        // Заходим на форум
        MainPageLoggedIn dashboard = loginPage.login("differ9nt", "1q2w3e4r");
        // Подтверждаем что вход осуществлен
        this.assertSuccess(dashboard, "Login");
        // Выводим в консоль имя пользователя на форуме
        System.out.println("Name: " + dashboard.getUsername());

        // TODO домашнее задание
        BoardPage board = dashboard.getBoardPage("QA Automation");
        TopicPAge topic = board.getTopicPage("QA Automation Tetris 14 02 2018");
        List<String> autors = topic.getAutors();
        for (String  printAutors :autors
             ) {
            System.out.println(printAutors);

        }
        topic.topLinks().getSource();
        topic.topLinks().getHelp().helpText();
        topic.topLinks().getSearch().findSearch();
        Users users = topic.topLinks().getUsers();


       String userName = "Ahtem";
       UserWidget user = users.findUser(userName);
       System.out.println(user.getRegistrationDate());

        // Ждём 10 сек, с перехватом исключения на прерывание выполнения потока и игнорируем его
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) { /* Игнорируем */ }

    }

    @Override
    public void afterTest()
    {
        // Вывод в консоль
        System.out.println("TEST: " + this.name() + " | PHASE: AFTER RUN");
    }
}
