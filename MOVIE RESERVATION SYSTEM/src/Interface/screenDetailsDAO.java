package Interface;

import java.util.ArrayList;
import Resources.screenDetails;

public interface screenDetailsDAO {
    Object insertDetails(screenDetails obj) throws Exception;

    Object deleteDetails(screenDetails obj) throws Exception;

    Object updateDetails(screenDetails obj) throws Exception;

    ArrayList<screenDetails> viewDetails() throws Exception;

    String findMultiplexName(String id) throws Exception;

}