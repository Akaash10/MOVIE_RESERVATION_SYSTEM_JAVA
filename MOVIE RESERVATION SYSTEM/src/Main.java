import java.util.*;

import Interface.*;
import Resources.*;
import Utilities.*;

public class Main {
    public static statusHolder status = new statusHolder();
    public static movieDetailsClass movie = new movieDetailsClass(status);
    public static showDetailsClass show = new showDetailsClass(status);
    public static screenDetailsClass screen = new screenDetailsClass(status);
    public static multiplexDetailsClass multiplex = new multiplexDetailsClass(status);
    public static bookingDetailsClass book = new bookingDetailsClass(status);
    public static paymentDetailsClass payment = new paymentDetailsClass(status);
    public static userDetailsClass user = new userDetailsClass(status);

    public static void main(String[] args) throws Exception {
        Scanner num = new Scanner(System.in);
        connection c = new connection();
        c.dbConnection();
        if (c.con != null) {
            System.out.println("-----------------------------------");
            System.out.println("Welcome to IMAX Reservation");
            System.out.println("Enter 1 : To login");
            System.out.println("Enter 2 : To register");
            System.out.println("-----------------------------------");
            System.out.print("Enter Choice:");
            int choice = 0;
            try {
                choice = num.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }

            switch (choice) {
                case 1:
                    System.out.println("\n-----------------------------------");
                    System.out.println("Enter login details:");
                    System.out.println("-----------------------------------");
                    System.out.print("Email   :");
                    String checkEmail = num.next();
                    System.out.print("Password:");
                    String checkPassword = num.next();
                    userDetails userdetailsObject = new userDetails(checkEmail, checkPassword);
                    userDetailsClass u = new userDetailsClass(status);
                    u.loginDetails(userdetailsObject);
                    System.out.println(status.getStatusHolder());
                    boolean exit = false;
                    switch (userdetailsObject.getUserFlagCheck()) {
                        case 1:
                            while (!exit) {
                                System.out.println("\n-------------------------------------");
                                System.out.println("-----------WELCOME ADMIN-------------");
                                System.out.println("Enter 1: To access movie inventory");
                                System.out.println("Enter 2: To access show inventory");
                                System.out.println("Enter 3: To access screen inventory");
                                System.out.println("Enter 4: To access multiplex inventory");
                                System.out.println("Enter 5: To access user inventory");
                                System.out.println("Enter 6: Logout");
                                System.out.println("-------------------------------------");
                                System.out.print("Enter Choice:");
                                int adminChoice = num.nextInt();
                                switch (adminChoice) {
                                    case 1:
                                        while (!exit) {
                                            movieDetails moviedetailsObject = new movieDetails();
                                            System.out.println("\n-----------------------------------");
                                            System.out.println("MOVIE INVENTORY");
                                            System.out.println("-----------------------------------");
                                            System.out.println("Enter 1: Add movie");
                                            System.out.println("Enter 2: View movie");
                                            System.out.println("Enter 3: Delete movie");
                                            System.out.println("Enter 4: Update movie");
                                            System.out.println("Enter 5: Logout");
                                            System.out.println("-----------------------------------");
                                            System.out.print("Enter Choice:");
                                            int crudChoice = num.nextInt();
                                            switch (crudChoice) {
                                                case 1:
                                                    System.out.println("\n-----------------------------------");
                                                    System.out.println("Enter movie Details");
                                                    System.out.println("-----------------------------------");
                                                    System.out.print("Enter movie id         :");
                                                    int m_id = num.nextInt();
                                                    num.nextLine();
                                                    System.out.print("Enter movie name         :");
                                                    String m_name = num.nextLine();
                                                    System.out.print("Enter movie description:");
                                                    String m_description = num.nextLine();
                                                    System.out.print("Enter movie genre:");
                                                    String m_genre = num.next();
                                                    System.out.print("Enter movie language:");
                                                    String m_language = num.next();
                                                    System.out.print("Enter movie release date(YYYYMMDD):");
                                                    String m_releasedate = num.next();
                                                    System.out.print("Enter movie duration:");
                                                    int m_duration = num.nextInt();
                                                    if ((m_id > 0) && (!m_name.isEmpty())
                                                            && (!m_description.isEmpty()) && (!m_genre.isEmpty())
                                                            && (!m_language.isEmpty()) && (!m_releasedate.isEmpty())
                                                            && (m_duration > 0)) {
                                                        moviedetailsObject = new movieDetails(m_id, m_name,
                                                                m_description, m_genre, m_language, m_releasedate,
                                                                m_duration);
                                                        movie.insertDetails(moviedetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 2:
                                                    ArrayList<movieDetails> al = movie.viewDetails();
                                                    for (movieDetails value : al) {
                                                        System.out.println("\nMovie Id: " + value.getMovieId());
                                                        System.out.println("Movie Name: " + value.getMovieName());
                                                        System.out.println(
                                                                "Movie Description: " + value.getMovieDescription());
                                                        System.out.println("Movie Genre: " + value.getMovieGenre());
                                                        System.out
                                                                .println("Movie Language: " + value.getMovieLanguage());
                                                        System.out.println(
                                                                "Movie Release-Date: " + value.getMovieReleaseDate());
                                                        System.out
                                                                .println("Movie Duration: " + value.getMovieDuration());
                                                    }
                                                    break;
                                                case 3:
                                                    num.nextLine();
                                                    System.out.print("Enter Movie ID:");
                                                    int d_mid = num.nextInt();
                                                    if (d_mid > 0) {
                                                        moviedetailsObject.setMovieId(d_mid);
                                                        movie.deleteDetails(moviedetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 4:
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.println(
                                                            "\nUpdate movie_name, movie_description,movie_genre, movie_language, movie_release_date, movie_duration:");
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.print("Enter Column Name To Be Modified:");
                                                    String colname = num.next();
                                                    System.out.print("Enter value to be Modified:");
                                                    String colModValue = num.next();
                                                    System.out.print("Enter Movie ID:");
                                                    int colMid = num.nextInt();
                                                    moviedetailsObject.setColumnName(colname);
                                                    moviedetailsObject.setColumnValue((colModValue));
                                                    moviedetailsObject.setMovieId(colMid);
                                                    movie.updateDetails(moviedetailsObject);
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 5:
                                                    exit = true;
                                                    break;

                                                default:
                                                    System.out.println("Invalid Choice");
                                            }
                                        }
                                        break;
                                    case 2:
                                        while (!exit) {
                                            showDetails showdetailsObject = new showDetails();
                                            System.out.println("\n-----------------------------------");
                                            System.out.println("SHOW INVENTORY");
                                            System.out.print("-----------------------------------\n");
                                            System.out.println("Enter 1: Add show");
                                            System.out.println("Enter 2: View show");
                                            System.out.println("Enter 3: Delete show");
                                            System.out.println("Enter 4: Update show");
                                            System.out.println("Enter 5: Logout");
                                            System.out.println("-------------------------------------");
                                            System.out.print("Enter Choice: ");
                                            int showChoice = num.nextInt();
                                            switch (showChoice) {
                                                case 1:
                                                    System.out.println("\n-----------------------------------");
                                                    System.out.println("Enter Show Details");
                                                    System.out.println("-----------------------------------");
                                                    System.out.print("Enter Show Time(HHMMSS):");
                                                    String s_time = num.next();
                                                    System.out.print("Enter Show Session(AM/PM):");
                                                    String s_session = num.next();
                                                    System.out.print("Enter Show Date(YYYYMMDD):");
                                                    String s_date = num.next();
                                                    ArrayList<movieDetails> al = movie.viewDetails();
                                                    for (movieDetails value : al) {
                                                        System.out.println("\nMovie Id: " + value.getMovieId());
                                                        System.out.println("Movie Name: " + value.getMovieName());
                                                        System.out.println(
                                                                "Movie Description: " + value.getMovieDescription());
                                                        System.out.println("Movie Genre: " + value.getMovieGenre());
                                                        System.out
                                                                .println("Movie Language: " + value.getMovieLanguage());
                                                        System.out.println(
                                                                "Movie Release-Date: " + value.getMovieReleaseDate());
                                                        System.out
                                                                .println("Movie Duration: " + value.getMovieDuration());
                                                    }
                                                    System.out.println("Enter movie id:");
                                                    int s_mid = num.nextInt();
                                                    ArrayList<screenDetails> al2 = screen.viewDetails();
                                                    for (screenDetails value : al2) {
                                                        System.out.println("\nScreen Id: " + value.getScreenId());
                                                        System.out.println("Screen Name: " + value.getScreenName());
                                                        System.out.println(
                                                                "Screen Count: " + value.getScreenCount());
                                                        System.out
                                                                .println("Multiplex Name: " + value.getMultiplexName());
                                                    }
                                                    System.out.print("Enter Screen id:");
                                                    int s_sid = num.nextInt();
                                                    if ((!s_time.isEmpty())
                                                            && (!s_session.isEmpty()) && (!s_date.isEmpty())
                                                            && (s_mid > 0) && (s_sid > 0)) {
                                                        showdetailsObject = new showDetails(s_time, s_session, s_date,
                                                                s_mid, s_sid);
                                                        show.insertDetails(showdetailsObject);

                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;

                                                case 2:
                                                    ArrayList<showDetails> al1 = show.viewDetails();
                                                    for (showDetails value : al1) {
                                                        System.out.println("\nShow Id: " + value.getShowId());
                                                        System.out.println("Show time: " + value.getShowTime());
                                                        System.out.println(
                                                                "Show session: " + value.getShowSession());
                                                        System.out.println("Show date: " + value.getShowDate());
                                                        System.out
                                                                .println("Movie Id: " + value.getMovieId());
                                                        System.out.println(
                                                                "Movie Name : " + value.getMovieName());
                                                        System.out
                                                                .println("Screen id : " + value.getScreenId());
                                                    }
                                                    break;

                                                case 3:
                                                    num.nextLine();
                                                    System.out.print("Enter Show ID:");
                                                    int show_id = num.nextInt();
                                                    if (show_id > 0) {
                                                        showdetailsObject.setShowId(show_id);
                                                        show.deleteDetails(showdetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 4:
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.println(
                                                            "\nUpdate show_time, show_session, show_date, movie_id, screen_id");
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.print("Enter Column Name To Be Modified:");
                                                    String colname = num.next();
                                                    System.out.print("Enter value to be Modified:");
                                                    String colModValue = num.next();
                                                    System.out.print("Enter Show ID:");
                                                    int colMid = num.nextInt();
                                                    showdetailsObject.setColumnName(colname);
                                                    showdetailsObject.setColumnValue(colModValue);
                                                    showdetailsObject.setShowId(colMid);
                                                    show.updateDetails(showdetailsObject);
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 5:
                                                    exit = true;
                                                    break;

                                                default:
                                                    System.out.println("Invalid Choice");
                                            }
                                        }
                                        break;
                                    case 3:
                                        while (!exit) {
                                            screenDetails screendetailsObject = new screenDetails();
                                            System.out.println("\n-----------------------------------");
                                            System.out.println("SCREEN INVENTORY");
                                            System.out.print("-----------------------------------\n");
                                            System.out.println("Enter 1: Add screen");
                                            System.out.println("Enter 2: View screen");
                                            System.out.println("Enter 3: Delete screen");
                                            System.out.println("Enter 4: Update screen");
                                            System.out.println("Enter 5: Logout");
                                            System.out.println("-------------------------------------");
                                            System.out.print("Enter Choice: ");
                                            int screenChoice = num.nextInt();
                                            switch (screenChoice) {
                                                case 1:
                                                    System.out.println("\n-----------------------------------");
                                                    System.out.println("Enter Screen Details");
                                                    System.out.println("-----------------------------------");
                                                    System.out.print("Enter Screen Name:");
                                                    String s_name = num.next();
                                                    System.out.print("Enter Screen Count:");
                                                    int s_count = num.nextInt();
                                                    ArrayList<multiplexDetails> al3 = multiplex.viewDetails();
                                                    for (multiplexDetails value : al3) {
                                                        System.out.println("\nMultiplex Id: " + value.getMultiplexId());
                                                        System.out
                                                                .println("Multiplex Name: " + value.getMultiplexName());
                                                        System.out.println(
                                                                "Multiplex Total Screens: "
                                                                        + value.getMultiplexTotalScreens());
                                                        System.out
                                                                .println("Multiplex City: " + value.getMultiplexCity());
                                                        System.out.println(
                                                                "Multiplex Zipcode: " + value.getMultiplexZipcode());
                                                    }
                                                    System.out.print("Enter Multiplex ID:");
                                                    String s_mid = num.next();
                                                    if ((!s_name.isEmpty())
                                                            && (s_count > 0) && (!s_mid.isEmpty())) {
                                                        screendetailsObject = new screenDetails(s_name, s_count, s_mid);
                                                        screen.insertDetails(screendetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 2:
                                                    ArrayList<screenDetails> al2 = screen.viewDetails();
                                                    for (screenDetails value : al2) {
                                                        System.out.println("\nScreen Id: " + value.getScreenId());
                                                        System.out.println("Screen Name: " + value.getScreenName());
                                                        System.out.println(
                                                                "Screen Count: " + value.getScreenCount());
                                                        System.out
                                                                .println("Multiplex Name: " + value.getMultiplexName());
                                                    }
                                                    break;
                                                case 3:
                                                    num.nextLine();
                                                    System.out.print("Enter Screen ID:");
                                                    int screen_id = num.nextInt();
                                                    if (screen_id > 0) {
                                                        screendetailsObject.setScreenId(screen_id);
                                                        screen.deleteDetails(screendetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 4:
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.println(
                                                            "\nUpdate screen_name, screen_count, nultiplex_id");
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.print("Enter Column Name To Be Modified:");
                                                    String colname = num.next();
                                                    System.out.print("Enter value to be Modified:");
                                                    String colModValue = num.next();
                                                    System.out.print("Enter Screen ID:");
                                                    int colMid = num.nextInt();
                                                    screendetailsObject.setColumnName(colname);
                                                    screendetailsObject.setColumnValue(colModValue);
                                                    screendetailsObject.setScreenId(colMid);
                                                    screen.updateDetails(screendetailsObject);
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 5:
                                                    exit = true;
                                                    break;
                                                default:
                                                    System.out.println("Invalid Choice");
                                            }
                                        }
                                        break;
                                    case 4:
                                        while (!exit) {
                                            multiplexDetails multiplexdetailsObject = new multiplexDetails();
                                            System.out.println("\n-----------------------------------");
                                            System.out.println("MULTIPLEX INVENTORY");
                                            System.out.print("-----------------------------------\n");
                                            System.out.println("Enter 1: Add multiplex");
                                            System.out.println("Enter 2: View multiplex");
                                            System.out.println("Enter 3: Delete multiplex");
                                            System.out.println("Enter 4: Update multiplex");
                                            System.out.println("Enter 5: Logout");
                                            System.out.println("-------------------------------------");
                                            System.out.print("Enter Choice: ");
                                            int multiplexChoice = num.nextInt();
                                            switch (multiplexChoice) {
                                                case 1:
                                                    System.out.println("\n-----------------------------------");
                                                    System.out.println("Enter Multiplex Details");
                                                    System.out.println("-----------------------------------");
                                                    System.out.print("Enter Multiplex Id: ");
                                                    String m_id = num.next();
                                                    System.out.print("Enter Multiplex Name: ");
                                                    num.nextLine();
                                                    String m_name = num.nextLine();
                                                    System.out.print("Enter Total Screens: ");
                                                    int m_tscreens = num.nextInt();
                                                    System.out.print("Enter Multiplex City: ");
                                                    String m_city = num.next();
                                                    System.out.print("Enter Multiplex Zipcode: ");
                                                    String m_zipcode = num.next();
                                                    if ((!m_name.isEmpty())
                                                            && (m_tscreens > 0) && (!m_city.isEmpty())
                                                            && (!m_zipcode.isEmpty())) {
                                                        multiplexdetailsObject = new multiplexDetails(m_id, m_name,
                                                                m_tscreens, m_city, m_zipcode);
                                                        multiplex.insertDetails(multiplexdetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 2:
                                                    ArrayList<multiplexDetails> al3 = multiplex.viewDetails();
                                                    for (multiplexDetails value : al3) {
                                                        System.out.println("\nMultiplex Id: " + value.getMultiplexId());
                                                        System.out
                                                                .println("Multiplex Name: " + value.getMultiplexName());
                                                        System.out.println(
                                                                "Multiplex Total Screens: "
                                                                        + value.getMultiplexTotalScreens());
                                                        System.out
                                                                .println("Multiplex City: " + value.getMultiplexCity());
                                                        System.out.println(
                                                                "Multiplex Zipcode: " + value.getMultiplexZipcode());
                                                    }
                                                    break;
                                                case 3:
                                                    num.nextLine();
                                                    System.out.print("Enter Multiplex ID:");
                                                    String multiplex_id = num.nextLine();
                                                    if (!multiplex_id.isEmpty()) {
                                                        multiplexdetailsObject.setMultiplexId(multiplex_id);
                                                        multiplex.deleteDetails(multiplexdetailsObject);
                                                    } else {
                                                        status.setStatusHolder("Field should not be empty");
                                                    }
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 4:
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.println(
                                                            "\nUpdate multiplex_name,multiplex_totalscreens,multiplex_City,multiplex_Zipcode");
                                                    System.out.println(
                                                            "------------------------------------------------------------------");
                                                    System.out.print("Enter Column Name To Be Modified:");
                                                    String colname = num.next();
                                                    System.out.print("Enter value to be Modified:");
                                                    String colModValue = num.next();
                                                    System.out.print("Enter Multipelx ID:");
                                                    String colMid = num.next();
                                                    multiplexdetailsObject.setColumnName(colname);
                                                    multiplexdetailsObject.setColumnValue(colModValue);
                                                    multiplexdetailsObject.setMultiplexId(colMid);
                                                    multiplex.updateDetails(multiplexdetailsObject);
                                                    System.out.println(status.getStatusHolder());
                                                    break;
                                                case 5:
                                                    exit = true;
                                                    break;

                                                default:
                                                    System.out.println("Invalid Choice");
                                            }
                                        }
                                        break;
                                    case 5:
                                        while (!exit) {
                                            System.out.println("\n-----------------------------------");
                                            System.out.println("USER INVENTORY");
                                            System.out.print("-----------------------------------\n");
                                            System.out.println("Enter 1: To view userdetails");
                                            System.err.println("Enter 2: Logout");
                                            System.out.println("-------------------------------------");
                                            System.out.print("Enter Choice: ");
                                            int userChoice = num.nextInt();
                                            switch (userChoice) {
                                                case 1:
                                                    ArrayList<userDetails> al3 = user.findUsers();
                                                    for (userDetails value : al3) {
                                                        System.out.println("\nUser id: " + value.getUserId());
                                                        System.out
                                                                .println("User Name: " + value.getUserName());
                                                        System.out.println(
                                                                "User Email: "
                                                                        + value.getUserEmail());
                                                        System.out
                                                                .println("User DateOfBirth: "
                                                                        + value.getUserDateOfBirth());
                                                        System.out.println(
                                                                "User Phone_number: " + value.getUserNumber());
                                                    }
                                                    break;
                                                case 2:
                                                    exit = true;
                                                    break;
                                                default:
                                                    System.out.println("Invalid Chocie");
                                            }
                                        }
                                        break;
                                    case 6:
                                        exit = true;
                                        break;

                                    default:
                                        System.out.println("Invalid Choice");
                                }
                            }
                            break;
                        case 2:
                            while (!exit) {
                                availableShows availableshowsobject = new availableShows();
                                System.out.println("\n-------------------------------------");
                                System.out.println("-----------WELCOME USER-------------");
                                System.out.println("Enter 1: To book movies");
                                System.out.println("Enter 2: To view booking history");
                                System.out.println("Enter 3: Logout");
                                System.out.println("-------------------------------------");
                                System.out.print("Enter Choice:");
                                int userChoice = num.nextInt();
                                switch (userChoice) {
                                    case 1:
                                        ArrayList<multiplexDetails> al3 = multiplex.viewDetails();
                                        for (multiplexDetails value : al3) {
                                            System.out.println("\nMultiplex Id: " + value.getMultiplexId());
                                            System.out
                                                    .println("Multiplex Name: " + value.getMultiplexName());
                                            System.out.println(
                                                    "Multiplex Total Screens: "
                                                            + value.getMultiplexTotalScreens());
                                            System.out
                                                    .println("Multiplex City: " + value.getMultiplexCity());
                                            System.out.println(
                                                    "Multiplex Zipcode: " + value.getMultiplexZipcode());
                                        }
                                        System.out.print("--> Enter your Preferenced Multiplex ID:");
                                        String c_multiplexid = num.next();
                                        ArrayList<movieDetails> al = movie.viewDetails();
                                        for (movieDetails value : al) {
                                            System.out.println("\nMovie Id: " + value.getMovieId());
                                            System.out.println("Movie Name: " + value.getMovieName());
                                            System.out.println(
                                                    "Movie Description: " + value.getMovieDescription());
                                            System.out.println("Movie Genre: " + value.getMovieGenre());
                                            System.out
                                                    .println("Movie Language: " + value.getMovieLanguage());
                                            System.out.println(
                                                    "Movie Release-Date: " + value.getMovieReleaseDate());
                                            System.out
                                                    .println("Movie Duration: " + value.getMovieDuration());
                                        }
                                        System.out.print("--> Enter your Preferenced Movie ID:");
                                        int c_movieid = num.nextInt();
                                        availableshowsobject.setMultiplexId(c_multiplexid);
                                        availableshowsobject.setMovieId(c_movieid);
                                        ArrayList<availableShows> al4 = show.findAvailableShows(availableshowsobject);
                                        for (availableShows value : al4) {
                                            System.out.println("Show Id: " + value.getShowId());
                                            System.out.println("Screen Name: " + value.getScreenName());
                                            System.out.println("Movie Name: " + value.getMovieName());
                                            System.out.println(
                                                    "Show Time: " + value.getShowTime() + " " + value.getShowSession());
                                            System.out.println("Show Date: " + value.getShowDate());
                                        }
                                        System.out.print("--> Enter your Preferenced Show ID:");
                                        int c_showid = num.nextInt();
                                        System.out.print("--> Enter No Of Tickets:");
                                        int c_not = num.nextInt();
                                        bookingDetails bookingdetailsObject = new bookingDetails(c_not, checkEmail,
                                                c_showid);
                                        book.insertDetails(bookingdetailsObject);
                                        System.out.println(status.getStatusHolder());
                                        book.findBookingId(bookingdetailsObject);
                                        int bookingid = bookingdetailsObject.getBookingId();
                                        int price = c_not * 180;
                                        System.out.println("--> Price: " + price);
                                        System.out.println("--> Enter Mode Of Pay:\n1.Cash\t2.UPI");
                                        System.out.print("--> Enter Your Choice :");
                                        int modeofpaychoice = num.nextInt();
                                        String modeofpay = "";
                                        if (modeofpaychoice == 1) {
                                            modeofpay += "Cash";
                                        } else if (modeofpaychoice == 2) {
                                            modeofpay += "UPI";
                                        }
                                        paymentDetails paymentdetailsObject = new paymentDetails(price, modeofpay,
                                                "SUCCESS", bookingid);
                                        payment.insertDetails(paymentdetailsObject);
                                        System.out.println(status.getStatusHolder());
                                        break;
                                    case 2:
                                        bookingHistory bookinghistoryObject = new bookingHistory();
                                        bookinghistoryObject.setUserId(book.findUserId(checkEmail));
                                        ArrayList<bookingHistory> al5 = book.findBookingHistory(bookinghistoryObject);
                                        for (bookingHistory value : al5) {
                                            System.out.println();
                                            System.out.println("Movie: " + value.getMovieName() + "("
                                                    + value.getMovieLanguage() + ")");
                                            System.out.println("Screen No: " + value.getScreenNo());
                                            System.out.println("Show Date: " + value.getShowDate());
                                            System.out.println("Show Time: " + value.getShowTime() + " "
                                                    + value.getShowSession());
                                            System.out.println("Payment Id: " + value.getPaymentId());
                                            System.out.println(
                                                    "Payment Status: " + value.getPaymentStatus());
                                        }
                                        break;
                                    case 3:
                                        exit = true;
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                }
                            }
                            break;

                        default:
                            System.out.println("Invalid Choice");
                    }
                case 2:
                    System.out.println("\n-----------------------------------");
                    System.out.println("Enter registration details:");
                    System.out.println("-----------------------------------");
                    System.out.print("Enter Name                 :");
                    String getName = num.next();
                    System.out.print("Enter DateOfBirth(YYYYMMDD):");
                    String getDob = num.next();
                    System.out.print("Enter Mobile Number        :");
                    String getNumber = num.next();
                    System.out.print("Enter Email                :");
                    String getEmail = num.next();
                    System.out.print("Enter Password             :");
                    String getPassword = num.next();
                    System.out.print("Enter Confirm Password     :");
                    String getConformPassword = num.next();
                    if (getName.length() > 0
                            && getDob.length() > 0 && getNumber.length() > 0 && getEmail.length() > 0
                            && getConformPassword.length() > 0 && getPassword.length() > 0) {
                                userdetailsObject=new userDetails(getName,getEmail, getPassword, getConformPassword,getDob,getNumber);
                                user.registrationDetails(userdetailsObject);
                            } else {
                                status.setStatusHolder("All the input fields to be filled");
                            }
                            System.out.println(status.getStatusHolder());
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } else {
            System.out.println("DB Not Connected");
        }
    }
}
