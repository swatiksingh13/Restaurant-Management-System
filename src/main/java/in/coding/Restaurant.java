package in.coding;

import in.coding.Payment.Payment;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Restaurant {
    private static Restaurant instance;
    private final List<MenuItem> menu;
    private final Map<Integer, Order> orders;
    private final List<Reservation> reservations;
    private final Map<Integer, Payment> payments;
    private final List<Staff> staff;

    private Restaurant() {
        menu = new CopyOnWriteArrayList<>();
        orders = new ConcurrentHashMap<>();
        reservations = new CopyOnWriteArrayList<>();
        payments = new ConcurrentHashMap<>();
        staff = new CopyOnWriteArrayList<>();
    }

    public static synchronized Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }

     public void removeMenuItem(MenuItem menuItem) {
        menu.remove(menuItem);
     }

     public List<MenuItem> getMenu() {
      return new ArrayList<>(menu);
     }

     public void placeOrder(Order order) {
        orders.put(order.getId(), order);
         // Notify kitchen staff to prepare the order
         notifyKitchen(order);
     }

    public Map<Integer, Order> getOrders() {
        return new ConcurrentHashMap<>(orders);
    }

     public void updateOrderStatus(int orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if(order != null) {
            order.setStatus(status);
            // Notify relevant staff about the order status update
            notifyStaff(order);
        }
     }

     public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
     }

     public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
     }

    public List<Reservation> getReservations() {
        return new CopyOnWriteArrayList<>(reservations);
    }

     public void processPayment(Payment payment) {
        payments.put(payment.getId(), payment);
         // Process the payment through a payment gateway
         // ...
     }

    public Map<Integer, Payment> getPayments() {
        return new ConcurrentHashMap<>(payments);
    }


    public void addStaff(Staff staff) {
         this.staff.add(staff);
     }

     public void removeStaff(Staff staff) {
        this.staff.remove(staff);
     }

    public List<Staff> getStaff() {
        return new CopyOnWriteArrayList<>(staff);
    }

    // Notify kitchen staff to prepare the order
    private void notifyKitchen(Order order) {

        System.out.println("Notifying kitchen about order: " + order.getId());
        // Implementation to send notification to kitchen staff
    }

    // Notify relevant staff about the order status update
    private void notifyStaff(Order order) {
        System.out.println("Notifying staff about order status update for order: " + order.getId() + " to " + order.getStatus());
        // Implementation to send notification to relevant staff
    }
}
