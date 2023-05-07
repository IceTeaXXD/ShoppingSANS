import com.shoppingsans.Datastore.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;

public class AddKurs{
    public AddKurs()throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException {
        DataStore ds = new DataStore();
        ds.getConfig().getMapKurs().put("USD", 14000);
        ds.getConfig().getMapKurs().put("EUR", 16000);
        ds.saveAs();
    }
    public void run() {
        System.out.println("AddKurs is running");
    }
}