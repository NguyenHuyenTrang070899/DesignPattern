public class TemplateMethod {
    public static void main(String[] args) {
        PageTemplate homePage = new HomePage();
        homePage.showPage();
        System.out.println();
        PageTemplate detailPage = new DetailPage();
        detailPage.showPage();
    }
}
abstract class PageTemplate {
    protected void showHeader() {
        System.out.println("<header />");
    }
    protected void showNavigation() {
        System.out.println("<nav />");
    }
    protected void showFooter() {
        System.out.println("<footer />");
    }
    protected abstract void showBody();
    public final void showPage() {
        showHeader();
        showNavigation();
        showBody();
        showFooter();
    }
}
class HomePage extends PageTemplate {
    @Override
    protected void showBody() {
        System.out.println("HOME PAGE");
    }
}
class DetailPage extends PageTemplate {
    @Override
    protected void showBody() {
        System.out.println("DETAIL");
    }
}