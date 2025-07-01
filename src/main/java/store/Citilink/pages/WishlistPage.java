package store.Citilink.pages;

public class WishlistPage extends ListPage{
    protected WishlistPage() {
        super(WishlistPage.class, "wishlist");
    }

    public static WishlistPage openWishlistPage() {
        return new WishlistPage();
    }


}
