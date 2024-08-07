package Interface;

import java.util.ArrayList;

import Resources.movieDetails;

public interface commonDAO<T> {
    Object insertDetails(T obj) throws Exception;

    Object deleteDetails(T obj) throws Exception;

    ArrayList<T> viewDetails() throws Exception;

}
