package gymarea.gymarea;

import java.util.Scanner;

public class GymArea {

    public static void main(String[] args) {
        
        try (Scanner Scanner = new Scanner(System.in)) {
          
            Gym gym = new Gym();
            Swimming pool = new Swimming();
            
            // Start with Gym as active area
            String activeArea = "G";
            
            System.out.println("Welcome to Speke Apartments Manager!");
            
            OUTER:
            while (true) {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("S - Select area (G=Gym, P=Swimming Pool)");
                System.out.println("W - Add occupants");
                System.out.println("X - Remove occupants");
                System.out.println("Y - Turn ON a light");
                System.out.println("Z - Turn OFF a light");
                System.out.println("R - Report status");
                System.out.println("Q - Quit");
                System.out.print("Enter your choice: ");
                String choice = Scanner.nextLine().toUpperCase();
                switch (choice) {
                    case "S" -> {
                        System.out.print("Select area (G for Gym, P for Pool): ");
                        String area = Scanner.nextLine().toUpperCase();
                        if (area.equals("G") || area.equals("P")) {
                            activeArea = area;
                            System.out.println("Active area is now: " + (activeArea.equals("G") ? "Gym" : "Swimming Pool"));
                        } else {
                            System.out.println("Invalid choice! Please enter G or P.");
                        }
                    }
                    case "W" -> {
                        System.out.print("How many people to add? ");
                        try {
                            int n = Integer.parseInt(Scanner.nextLine());
                            if (n > 0) {
                                if (activeArea.equals("G")) {
                                    gym.addOccupants(n);
                                } else {
                                    pool.addOccupants(n);
                                }
                            } else {
                                System.out.println("Please enter a positive number!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }
                    case "X" -> {
                        System.out.print("How many people to remove? ");
                        try {
                            int n = Integer.parseInt(Scanner.nextLine());
                            if (n > 0) {
                                if (activeArea.equals("G")) {
                                    gym.removeOccupants(n);
                                } else {
                                    pool.removeOccupants(n);
                                }
                            } else {
                                System.out.println("Please enter a positive number!");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }
                    case "Y" -> {
                        System.out.print("Which light to turn ON (1, 2, or 3)? ");
                        try {
                            int lightNum = Integer.parseInt(Scanner.nextLine());
                            if (lightNum >= 1 && lightNum <= 3) {
                                if (activeArea.equals("G")) {
                                    gym.turnOnLight(lightNum);
                                } else {
                                    pool.turnOnLight(lightNum);
                                }
                            } else {
                                System.out.println("Invalid! Please enter 1, 2, or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter 1, 2, or 3.");
                        }
                    }
                    case "Z" -> {
                        System.out.print("Which light to turn OFF (1, 2, or 3)? ");
                        try {
                            int lightNum = Integer.parseInt(Scanner.nextLine());
                            if (lightNum >= 1 && lightNum <= 3) {
                                if (activeArea.equals("G")) {
                                    gym.turnOffLight(lightNum);
                                } else {
                                    pool.turnOffLight(lightNum);
                                }
                            } else {
                                System.out.println("Invalid! Please enter 1, 2, or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter 1, 2, or 3.");
                        }
                    }
                    case "R" -> {
                        if (activeArea.equals("G")) {
                            gym.showReport();
                        } else {
                            pool.showReport();
                        }
                    }
                    case "Q" -> {
                        System.out.println("Thank you for using the system. Goodbye!");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }
}

// Gym class
class Gym {
    String name = "Gym Area";
    int occupants = 0;
    boolean light1 = false, light2 = false, light3 = false;

    void addOccupants(int n) {
        occupants += n;
        System.out.println("Added " + n + " people. Total: " + occupants);
    }

    void removeOccupants(int n) {
        if (occupants - n < 0)
            System.out.println("Error! Can't remove more people than present.");
        else {
            occupants -= n;
            System.out.println("Removed " + n + " people. Total: " + occupants);
        }
    }

    void turnOnLight(int num) {
        switch (num) {
            case 1 -> light1 = true;
            case 2 -> light2 = true;
            case 3 -> light3 = true;
            default -> {
            }
        }
        System.out.println("Light " + num + " is now ON");
    }

    void turnOffLight(int num) {
        switch (num) {
            case 1 -> light1 = false;
            case 2 -> light2 = false;
            case 3 -> light3 = false;
            default -> {
            }
        }
        System.out.println("Light " + num + " is now OFF");
    }

    void showReport() {
        System.out.println("\n----- REPORT -----");
        System.out.println("Area: " + name);
        System.out.println("Occupants: " + occupants);
        System.out.println("Light 1: " + (light1 ? "ON" : "OFF"));
        System.out.println("Light 2: " + (light2 ? "ON" : "OFF"));
        System.out.println("Light 3: " + (light3 ? "ON" : "OFF"));
        System.out.println("------------------\n");
    }
}

class Swimming {
    String name = "Swimming Pool Area";
    int occupants = 0;
    boolean light1 = false, light2 = false, light3 = false;

    void addOccupants(int n) {
        occupants += n;
        System.out.println("Added " + n + " people. Total: " + occupants);
    }

    void removeOccupants(int n) {
        if (occupants - n < 0)
            System.out.println("Error! Can't remove more people than present.");
        else {
            occupants -= n;
            System.out.println("Removed " + n + " people. Total: " + occupants);
        }
    }

    void turnOnLight(int num) {
        switch (num) {
            case 1 -> light1 = true;
            case 2 -> light2 = true;
            case 3 -> light3 = true;
            default -> {
            }
        }
        System.out.println("Light " + num + " is now ON");
    }

    void turnOffLight(int num) {
        switch (num) {
            case 1 -> light1 = false;
            case 2 -> light2 = false;
            case 3 -> light3 = false;
            default -> {
            }
        }
        System.out.println("Light " + num + " is now OFF");
    }

    void showReport() {
        System.out.println("\n----- REPORT -----");
        System.out.println("Area: " + name);
        System.out.println("Occupants: " + occupants);
        System.out.println("Light 1: " + (light1 ? "ON" : "OFF"));
        System.out.println("Light 2: " + (light2 ? "ON" : "OFF"));
        System.out.println("Light 3: " + (light3 ? "ON" : "OFF"));
        System.out.println("------------------\n");
    }
}
