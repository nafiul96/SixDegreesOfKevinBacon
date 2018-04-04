
import java.util.Scanner;

/**
 * HOMEWORK#8 MD NAFIUL AZIM 110548047
 *
 * @author nafi
 * @author nafi
 *
 */
public class KBCalculator {

    private static Scanner input;
    private static ActorGraph graph;

    public static void main(String[] args) {
        graph = new ActorGraph();
        input = new Scanner(System.in);
        menuDriver();

    }

    public static void menu() {

        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("I) Import a Movie, "
                + "A) Print all Actors, "
                + "M) Print all Movies, \n"
                + "P) Print the shortest path between two actors, "
                + "B) Print the BFS from a give actor, \n"
                + "L) Lookup Actor by Name, \n"
                + "Q) Quit");
    }

    public static void menuDriver() {
        try {
            menu();
            System.out.println("Please select an option: ");
            String in = input.next().toLowerCase();
            input.nextLine();
            switch (in) {

                case "i":
                    importMovie();
                    break;
                case "a":
                    ActorGraph.actorPrint();
                    break;
                case "m":
                    ActorGraph.moviePrint();
                    break;
                case "p":
                    System.out.println("Enter the source actor: ");
                    String src = input.nextLine();
                    System.out.println("Enter the destinition actor: ");
                    String dest = input.nextLine();
                    ActorGraph.shortestPath(ActorGraph.getActorsByName().get(src), ActorGraph.getActorsByName().get(dest));
                    break;
                case "b":
                    System.out.println("Please enter the name of the actor: ");
                    in = input.nextLine();
                    ActorGraph.bfs(in);
                    break;
                case "l":
                    System.out.println("");
                    in = input.nextLine();
                    //input.nextLine();
                    ActorGraph.getActorsByName().get(in);
                    break;
                case "q":
                    System.out.println("Thank you and bye!");
                    return;
                default:
                    System.out.println("This is not an option! \n");

            }
        } catch (Exception e) {

            System.out.println("Error Occurred");
        } finally {
            menuDriver();
        }
    }

    public static void importMovie() {

        System.out.print("Enter the Movie Title: ");
        String title = input.nextLine();
        //  input.nextLine();
        Movie temp = new Movie(title);

        /*
        if (ActorGraph.getMoviesByTitle().containsValue(temp)) {
            
            return;
        }
         */
        ActorGraph.getMoviesByTitle().put(title, temp);

        for (int i = 0; i < temp.getActors().size(); i++) {

            for (int j = 0; j < temp.getActors().size(); j++) {

                if (!temp.getActors().get(i).equals(temp.getActors().get(j))) {

                    if (!temp.getActors().get(i).getFriends().contains(temp.getActors().get(j))) {

                        temp.getActors().get(i).getFriends().add(temp.getActors().get(j));
                    }
                }
            }

            if (ActorGraph.getActorsByName().containsValue(temp.getActors().get(i))) {

                ActorGraph.getActorsByName().get(temp.getActors().get(i).getName()).setMovies(title);
            } else {
                temp.getActors().get(i).setMovies(title);
                ActorGraph.getActorsByName().put(temp.getActors().get(i).getName(), temp.getActors().get(i));
            }

        }

        System.out.println("Size of movie data: " + ActorGraph.getMoviesByTitle().size());

        System.out.println("Size of Actor data: " + ActorGraph.getActorsByName().size());

        System.out.println("Movie has been imported successfully");
    }

}
