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
}
