import com.goit.javacore5dev.feature.homeWork.HomeWork;
import com.goit.javacore5dev.feature.homeWork.model.dao.DeveloperDaoService;
import com.goit.javacore5dev.feature.homeWork.connection.Storage;

public class AppTest {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        HomeWork homeWork = new HomeWork(storage);
//        System.out.println("-----------");
//        homeWork.getTotalProjectSalaryByName(HomeWork.SAURON_AND_MAIAR);
//        System.out.println("-----------");
//        homeWork.projectDevelopersList(HomeWork.GREEN_TATOOINE);
//        System.out.println("-----------");
//        homeWork.writesInLanguage(HomeWork.JAVA);
//        System.out.println("-----------");
//        homeWork.findDevelopersLevel(HomeWork.MIDDLE);
//        System.out.println("-----------");
//        homeWork.NumberOfDevelopersOnProjects();
//        System.out.println("-----------");

//        //CRUD
        DeveloperDaoService developerDaoService = new DeveloperDaoService(storage);
//        //Create
//        developerDaoService.createNewDev(new Developer(1, "Shrek", 35, Developer.Sex.MALE, 450));
//
//        //Read
//        developerDaoService.listAll();
//        System.out.println("-----------");
//        developerDaoService.printDeveloperInfo(8);//read
//        System.out.println("-----------");
//
//        //update
//        developerDaoService.updateDeveloper(8, new Developer(3, "Bob", 25, Developer.Sex.UNKNOWN, 333));
//        System.out.println("-----------");
//        developerDaoService.printDeveloperInfo(8);//read
//        System.out.println("-----------");
//
//        //delete
//        developerDaoService.deleteDeveloperById(8);
//        System.out.println("-----------");
//        developerDaoService.printDeveloperInfo(8);//read
    }
}
