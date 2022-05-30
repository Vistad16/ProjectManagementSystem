import com.goit.javacore5dev.feature.storage.Storage;
import com.goit.javacore5dev.feature.homeWorkSelect.HomeWork;

public class AppTest {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        //new DatabaseInitService().initDb(storage);//create and fill database

        HomeWork homeWork = new HomeWork(storage);

        homeWork.totalProjectSalary(HomeWork.SAURON_AND_MAIAR);

        homeWork.projectDevelopersList(HomeWork.GREEN_TATOOINE);

        homeWork.writesInLanguage(HomeWork.JAVA);

        homeWork.findDevelopersLevel(HomeWork.MIDDLE);
    }
}
