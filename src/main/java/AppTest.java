import com.goit.javacore5dev.feature.homeWork.PersonCrudService;
import com.goit.javacore5dev.feature.storage.Storage;

public class AppTest {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        //new DatabaseInitService().initDb(storage);//create and fill database

//        HomeWork homeWork = new HomeWork(storage);
//        System.out.println("-----------");
//        homeWork.totalProjectSalary(HomeWork.SAURON_AND_MAIAR);
//        System.out.println("-----------");
//        homeWork.projectDevelopersList(HomeWork.GREEN_TATOOINE);
//        System.out.println("-----------");
//        homeWork.writesInLanguage(HomeWork.JAVA);
//        System.out.println("-----------");
//        homeWork.findDevelopersLevel(HomeWork.MIDDLE);
//        System.out.println("-----------");
//        homeWork.NumberOfDevelopersOnProjects();
//        System.out.println("-----------");

        //CRUD
        PersonCrudService personCrudService = new PersonCrudService(storage);

        System.out.println(personCrudService.createNewDev(1, "Shrek", 45, "male", 850));
        System.out.println("-----------");
        personCrudService.printDeveloperInfo(31);//read
        System.out.println("-----------");

        //update
        System.out.println(personCrudService.updateDeveloperSalary(31, 3000));
        System.out.println("-----------");
        personCrudService.printDeveloperInfo(31);//read
        System.out.println("-----------");

        //delete
        System.out.println(personCrudService.deleteDeveloper(31));
        System.out.println("-----------");
        personCrudService.printDeveloperInfo(31);//read

        //The Exterminatus order can be given by any Team lead, Project lead, or Lord Mentor
//        personCrudService.exterminatus();

    }
}
