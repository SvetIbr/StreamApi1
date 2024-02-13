import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public record Order(String product, double cost) {
    // Группируйте заказы по продуктам
    // Для каждого продукта найдите общую стоимость всех заказов
    // Отсортируйте продукты по убыванию общей стоимости
    // Выберите три самых дорогих продукта
    // Выведите результат: список трех самых дорогих продуктов и их общая стоимость

    public static void getTopProductsWithSum(List<Order> orders) {
                orders
                .stream()
                .collect((groupingBy(Order::product, summingDouble(Order::cost))))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .limit(3)
                .forEach(System.out::println);
    }
}
