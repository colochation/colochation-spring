package cat.omnes.colochation.colochationback.controllers;

import cat.omnes.colochation.colochationback.domain.Grocery;

public record GroceryResponse(
        String name,
        Boolean checked) {

    public static GroceryResponse fromDomain(Grocery grocery){
        return new GroceryResponse(grocery.content, grocery.checked);

    }
}
