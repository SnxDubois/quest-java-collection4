import java.util.*;

public class MapExample {
    public static void main(String... args) {

        User bernard = new User("Bernard");
        User lavergne = new User("Lavergne");
        User hoagie = new User("Hoagie");
        User surfer = new User("Jeff Woodie");
        Computer sx386 = new Computer("386SX-25");
        Computer dx486 = new Computer("486DX2-66");
        Computer c64 = new Computer("Commodore 64");

        // HashMap
        // Si l'ordre des clés importe peu, il est conseillé d'utiliser l'implémentation
        // HashMap.

        // L'insertion d'un couple clé-valeur se fait grâce à la méthode put(K key, V
        // value) :
        Map<User, Computer> classroom = new HashMap<>();
        classroom.put(bernard, dx486);
        classroom.put(lavergne, sx386);
        classroom.put(hoagie, sx386);
        classroom.put(surfer, c64);

        // Tu peux supprimer un élément grâce à sa clé. L'élément supprimé sera renvoyé
        // :
        Computer removed = classroom.remove(surfer);
        System.out.println(removed.getName());

        // Il est possible de récupérer l'ensemble des clés (Set) du tableau associatif
        // avec la méthode keySet() :
        for (User user : classroom.keySet()) {
            System.out.println(user.getName());
        }

        // Il est possible de récupérer la collection des valeurs (Collection) du
        // tableau associatif
        // avec la méthode values() :
        for (Computer computer : classroom.values()) {
            System.out.println(computer.getName());
        }
        // Il est possible de récupérer l'ensemble des couples clé-valeur (Set) du
        // tableau associatif
        // avec la méthode entrySet(). Le type du couple clé-valeur sera Map.Entry<K,
        // V>, de clé K et de valeur V.
        for (Map.Entry<User, Computer> entry : classroom.entrySet()) {
            User user = entry.getKey();
            Computer computer = entry.getValue();
            System.out.println(user.getName() + ": " + computer.getName());
        }

        // Il est possible de chercher si un tableau associatif contient une clé ou une
        // valeur, grace aux méthodes containsKey(Object o) et containsValue(Object o) :
        System.out.println(classroom.containsKey(bernard));
        System.out.println(classroom.containsValue(c64));

        // LinkedHashMap
        // Si tu désires avoir un tableau associatif classé par ordre d'insertion des
        // éléments,
        // c'est du côté de LinkedHashMap que tu vas devoir regarder !
        Map<User, Computer> linkedClassroom = new LinkedHashMap<>();
        linkedClassroom.put(bernard, dx486);
        linkedClassroom.put(lavergne, sx386);
        linkedClassroom.put(hoagie, sx386);
        linkedClassroom.put(surfer, c64);

        for (User user : linkedClassroom.keySet()) {
            Computer computer = linkedClassroom.get(user);
            System.out.println(user.getName() + ": " + computer.getName());
        }

        // TreeMap
        // Un tableau associatif TreeMap permet, quand à lui, de trier les éléments par
        // valeurs des clés.
        // Ci-dessous, tu peux observer comment créer une instance de TreeMap avec un
        // Comparator :

        Comparator<User> comparator = new Comparator<User>() {

            @Override
            public int compare(User orig, User compare) {
                return orig.getName().compareTo(compare.getName());
            }
        };

        Map<User, Computer> treeClassroom = new TreeMap<>(comparator);
        treeClassroom.put(bernard, dx486);
        treeClassroom.put(lavergne, sx386);
        treeClassroom.put(hoagie, sx386);
        treeClassroom.put(surfer, c64);

        // Ainsi, le parcours des éléments sera fera dans l'ordre alphabétique des clés
        // :
        for (User user : treeClassroom.keySet()) {
            Computer computer = treeClassroom.get(user);
            System.out.println(user.getName() + ": " + computer.getName());
        }
    }
}