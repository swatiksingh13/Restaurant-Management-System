package in.coding;

import in.coding.Payment.Payment;
import in.coding.Payment.PaymentMethod;
import in.coding.Payment.PaymentStatus;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RestaurantManagementDemo {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        // Add menu items
        restaurant.addMenuItem(new MenuItem(1, "ButterMilk", "Summer's Best Drink", 30.00, true));
        MenuItem menuItem = new MenuItem(2, "Dosa", "Delicious Dosa", 80.00, true);
        restaurant.addMenuItem(menuItem);
        restaurant.addMenuItem(new MenuItem(3, "Panner Butter Masala", "Best panner masala", 120.00, true));
        restaurant.addMenuItem(new MenuItem(2, "Lassi", "Refreshing yogurt drink", 40.00, true));

        // Place an order
        Order order = new Order(1, Arrays.asList(
                new MenuItem(1, "ButterMilk", "Summer's Best drink", 30.00, true),
                menuItem,
                new MenuItem(3, "Panner Butter Masala", "Best panner masala", 120.00, true)
                ), 230.00, OrderStatus.PENDING, new Timestamp(System.currentTimeMillis()));

        restaurant.placeOrder(order);

        // Make a reservation
        Reservation  reservation = new Reservation(1, "Jacky", "9900223344", 4, new Timestamp(System.currentTimeMillis()));
        restaurant.makeReservation(reservation);

        // Process a payment
        Payment payment = new Payment(1,230.00, PaymentMethod.MOBILE_PAYMENT, PaymentStatus.PENDING);
        restaurant.processPayment(payment);

        // Update order status
        restaurant.updateOrderStatus(1, OrderStatus.PREPARING);
        restaurant.updateOrderStatus(1, OrderStatus.READY);
        restaurant.updateOrderStatus(1, OrderStatus.COMPLETED);

        // Add staff
        Staff staff = new Staff(1, "Alice", "Cook", "1234432111");
        restaurant.addStaff(staff);
        restaurant.addStaff(new Staff(2, "Bob", "Manager", "3455431212"));
        restaurant.addStaff(new Staff(3, "Charles", "Waiter", "34457737337"));
        restaurant.addStaff(new Staff(4, "Dan", "Cleaner", "9090808079"));
        restaurant.addStaff(new Staff(5, "Jack", "Cashier", "9090808079"));

        // Get menu
        List<MenuItem> menu = restaurant.getMenu();
        System.out.println("--- Menu ---");
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " - $" + item.getPrice() + (item.isAvailable() ? " (Available)" : " (Not Available)"));
        }
        System.out.println("------------");

        // Display Order Details
        Order retrievedOrder = restaurant.getOrders().get(1); // Assuming order ID is 1
        if (retrievedOrder != null) {
            System.out.println("\n--- Order Details ---");
            System.out.println("Order ID: " + retrievedOrder.getId());
            System.out.println("Items:");
            for (MenuItem item : retrievedOrder.getItems()) {
                System.out.println("\t" + item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total Amount: $" + retrievedOrder.getTotalAmount());
            System.out.println("Status: " + retrievedOrder.getStatus());
            System.out.println("Timestamp: " + retrievedOrder.getTimestamp());
            System.out.println("----------------------");
        } else {
            System.out.println("\nOrder with ID 1 not found.");
        }

        // Display Reservation Details
        List<Reservation> retrievedReservations = restaurant.getReservations();
        System.out.println("\n--- Reservation Details ---");
        if (!retrievedReservations.isEmpty()) {
            for (Reservation res : retrievedReservations) {
                System.out.println("Reservation ID: " + res.getId());
                System.out.println("Customer Name: " + res.getCustomerName());
                System.out.println("Phone Number: " + res.getContactNumber());
                System.out.println("Number of Guests: " + res.getPartySize());
                System.out.println("Reservation Time: " + res.getReservationTime());
                System.out.println("--------------------------");
            }
        } else {
            System.out.println("No reservations found.");
        }

        // Display Staff Details
        List<Staff> retrievedStaff = restaurant.getStaff();
        System.out.println("\n--- Staff Details ---");
        if (!retrievedStaff.isEmpty()) {
            for (Staff s : retrievedStaff) {
                System.out.println("Staff ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("Role: " + s.getRole());
                System.out.println("Phone Number: " + s.getContactNumber());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No staff members added.");
        }

        // Display Payment Details
        Map<Integer, Payment> retrievedPayments = restaurant.getPayments();
        System.out.println("\n--- Payment Details ---");
        if (!retrievedPayments.isEmpty()) {
            for (Map.Entry<Integer, Payment> entry : retrievedPayments.entrySet()) {
                Payment p = entry.getValue();
                System.out.println("Payment ID: " + p.getId());
                System.out.println("Amount: $" + p.getAmount());
                System.out.println("Method: " + p.getMethod());
                System.out.println("Status: " + p.getStatus());
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("No payments processed yet.");
        }

    }
}
