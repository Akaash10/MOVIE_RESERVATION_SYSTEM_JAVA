package Interface;

import java.util.ArrayList;
import Resources.movieDetails;

public interface movieDetailsDAO {
    Object insertDetails(movieDetails obj) throws Exception;

    Object deleteDetails(movieDetails obj) throws Exception;

    Object updateDetails(movieDetails obj) throws Exception;

    ArrayList<movieDetails> viewDetails() throws Exception;

}