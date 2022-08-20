import Utils.*;
import service.Auth;
import service.MainMenu;

public class NykaaApp {

    public static void main(String[] args) {
        UserUtils userUtils = new UserUtils();
        CategoryUtils categoryUtils = new CategoryUtils();
        categoryUtils.load();
        Auth auth = new Auth(userUtils);
        auth.printAuthMenu();

        MainMenu mainMenu = new MainMenu(userUtils, categoryUtils, auth);
        mainMenu.mainMenu();

    }
}

