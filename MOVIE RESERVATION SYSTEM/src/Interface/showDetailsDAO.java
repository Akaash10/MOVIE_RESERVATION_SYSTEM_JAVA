package Interface;

import java.util.ArrayList;

import Resources.availableShows;
import Resources.showDetails;

public interface showDetailsDAO {
    Object insertDetails(showDetails obj) throws Exception;

    Object deleteDetails(showDetails obj) throws Exception;

    Object updateDetails(showDetails obj) throws Exception;

    ArrayList<showDetails> viewDetails() throws Exception;
    
    String findMovieName(int id) throws Exception;
    
    ArrayList<availableShows> findAvailableShows(availableShows obj) throws Exception;

}
