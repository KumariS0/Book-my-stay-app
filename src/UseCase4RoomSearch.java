import java.util.HashMap;

/**
 * Use Case 4 - Room Search & Availability Check
 * Book My Stay Application
 *
 * @version 4.1
 */

abstract class Room {

    String type;
    double price;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Price: $" + price);
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 100);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 180);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 300);
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }
}

public class gUseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("Book My Stay App - Version 4.1");
        System.out.println("Room Search Results\n");

        RoomInventory inventory = new RoomInventory();

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.type);

            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }

        System.out.println("Search completed.");
    }
}