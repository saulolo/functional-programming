package edu.functional_programming.unit7_EjerciciosRecopilatorios.ejercicio2_Ecommerce;

import java.util.List;

public class OrdersDataset {

    /**
     * Simula la obtención de pedidos recientes desde una base de datos.
     * @return Lista de pedidos de prueba.
     */
    public static List<Order> getOrdersFromDB() {

        return List.of(
                new Order(1L, "Luis", "luis@mail.com", 85000, State.PAID, PaymentMethod.CARD,
                        List.of(
                                new Product("P1", "Notebook Lenovo", Category.TECHNO, 1, 80000),
                                new Product("P2", "Mouse Logitech", Category.TECHNO, 1, 5000)
                        )),
                new Order(2L, "Carla", "carla@mail.com", 45000, State.PENDING, PaymentMethod.TRANSFER,
                        List.of(
                                new Product("P3", "Aspiradora", Category.HOUSE, 1, 45000)
                        )),
                new Order(3L, "Marcos", "marcos@mail.com", 120000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P4", "iPhone", Category.TECHNO, 1, 120000)
                        )),
                new Order(4L, "Lucia", null, 30000, State.CANCELED, PaymentMethod.CASH,
                        List.of(
                                new Product("P5", "Silla Oficina", Category.HOUSE, 1, 30000)
                        )),
                new Order(5L, "Pedro", "", 60000, State.PAID, PaymentMethod.TRANSFER,
                        List.of(
                                new Product("P6", "Monitor Samsung", Category.TECHNO, 2, 30000)
                        )),
                new Order(6L, "Sofia", "sofia@mail.com", 20000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P7", "Libro Java", Category.BOOKS, 2, 10000)
                        )),
                new Order(7L, "Valeria", "valeria@mail.com", 15000, State.PENDING, PaymentMethod.CASH,
                        List.of(
                                new Product("P8", "Lampara", Category.HOUSE, 3, 5000)
                        )),
                new Order(8L, "Martin", "martin@mail.com", 95000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P9", "Tablet Samsung", Category.TECHNO, 1, 90000),
                                new Product("P2", "Mouse Logitech", Category.TECHNO, 1, 5000)
                        )),
                new Order(9L, "Ana", "ana@mail.com", 70000, State.PAID, PaymentMethod.TRANSFER,
                        List.of(
                                new Product("P10", "Heladera", Category.HOUSE, 1, 70000)
                        )),
                new Order(10L, "Javier", null, 18000, State.CANCELED, PaymentMethod.CASH,
                        List.of(
                                new Product("P11", "Libro Spring", Category.BOOKS, 1, 18000)
                        )),
                new Order(11L, "Paula", "paula@mail.com", 40000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P12", "Auriculares Sony", Category.TECHNO, 2, 20000)
                        )),
                new Order(12L, "Diego", "", 25000, State.PAID, PaymentMethod.TRANSFER,
                        List.of(
                                new Product("P13", "Cafetera", Category.HOUSE, 1, 25000)
                        )),
                new Order(13L, "Flor", "flor@mail.com", 110000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P4", "iPhone", Category.TECHNO, 1, 110000)
                        )),
                new Order(14L, "Nicolas", "nico@mail.com", 10000, State.PENDING, PaymentMethod.CASH,
                        List.of(
                                new Product("P14", "Libro Clean Code", Category.BOOKS, 1, 10000)
                        )),
                new Order(15L, "Camila", "camila@mail.com", 52000, State.PAID, PaymentMethod.CASH,
                        List.of(
                                new Product("P15", "Smartwatch", Category.TECHNO, 1, 52000)
                        ))
        );
    }
}
