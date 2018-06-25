package ua.kiev.prog.automation.framework.product.app.progkievua.forum.blocks;

import org.openqa.selenium.By;
import ua.kiev.prog.automation.framework.core.product.Component;
import ua.kiev.prog.automation.framework.core.product.component.object.BlockObject;
import ua.kiev.prog.automation.framework.core.product.component.object.WidgetObject;
import ua.kiev.prog.automation.framework.product.app.progkievua.Forum;

public class TopLinksBlock extends BlockObject {


    @Override
    protected Class<? extends Component> componentClass() {
        return Forum.class;
    }

    @Override
    protected By readyLocator() {
        return By.xpath("//div[@id='main_menu']");
    }






}
