package store.Citilink.pages;

import store.Citilink.elements.ButtonElement;

public class ListPage extends BasePage {
    ButtonElement removeListButton = ButtonElement.byTypeAndText("button", "Очистить список");

    protected ListPage(Class<? extends ListPage> pageClass, String partURL) {
        super(pageClass, partURL);
    }

    public void clickRemoveListButton() {
        removeListButton.click();
    }

//    public boolean IsEmpty() {
//
//    }
}
