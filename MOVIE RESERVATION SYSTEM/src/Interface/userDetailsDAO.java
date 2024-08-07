package Interface;

import java.util.ArrayList;
import Resources.userDetails;

public interface userDetailsDAO {

    Object registrationDetails(userDetails obj) throws Exception;

    Object loginDetails(userDetails obj) throws Exception;

    ArrayList<userDetails> findUsers() throws Exception;
}
