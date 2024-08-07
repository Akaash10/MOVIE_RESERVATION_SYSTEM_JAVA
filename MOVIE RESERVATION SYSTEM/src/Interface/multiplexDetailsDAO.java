package Interface;

import java.util.ArrayList;
import Resources.multiplexDetails;

public interface multiplexDetailsDAO {
    Object insertDetails(multiplexDetails obj) throws Exception;

    Object deleteDetails(multiplexDetails obj) throws Exception;

    Object updateDetails(multiplexDetails obj) throws Exception;

    ArrayList<multiplexDetails> viewDetails() throws Exception;
}
