package GBWeb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class Hotel {
    private String name;
    private String url;
    private int price;
    private double rating;
    private int revueNum;

    @Override
    public String toString() {
        return  "Название отеля: " + name + "\n" +
                "Url отзывов: " + url + "\n" +
                "Цена: " + price + "\n" +
                "Рейтинг: " + rating + "\n" +
                "Количество отзывов: " + revueNum;
    }

    public void setPrice(String priceStr) {
        try {
            priceStr = priceStr
                    .replace(" ", "")
                    .replace("руб", "");
            price = Integer.parseInt(priceStr);
        } catch (Exception e) {
            log.warn("Error parsing price: ()", priceStr);
        }
    }

    public void setRating(String ratingStr) {
        try {
            String[] parts = ratingStr.split(" ");
            rating = Double.parseDouble(parts[0].replace("," , "."));
        } catch (Exception e) {
            log.warn("Error parsing price: ()", ratingStr);
        }
    }

    public void setRevueNum(String revueNumStr) {
        try {
            String[] parts = revueNumStr.split(" ");
            revueNum = Integer.parseInt(parts[0]);
        } catch (Exception e) {
            log.warn("Error parsing price: ()", revueNumStr);
        }
    }
}
