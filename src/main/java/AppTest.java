import com.goit.javacore5dev.feature.storage.DatabaseInitService;
import com.goit.javacore5dev.feature.storage.Storage;
import com.goit.javacore5dev.feature.homeWorkSelect.HomeWork;

public class AppTest {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        //new DatabaseInitService().initDb(storage);//create and fill database

        HomeWork homeWork = new HomeWork(storage);
        System.out.println("-----------");
        homeWork.totalProjectSalary(HomeWork.SAURON_AND_MAIAR);
        System.out.println("-----------");
        homeWork.projectDevelopersList(HomeWork.GREEN_TATOOINE);
        System.out.println("-----------");
        homeWork.writesInLanguage(HomeWork.JAVA);
        System.out.println("-----------");
        homeWork.findDevelopersLevel(HomeWork.MIDDLE);
        System.out.println("-----------");
        homeWork.NumberOfDevelopersOnProjects();
        System.out.println("-----------");
    }
}
