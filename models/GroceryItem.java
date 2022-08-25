package com.revature.models;

public class GroceryItem{
    private Integer id, qty, userIdFk;
    private String name;
    private Boolean inCart;

    // replace default constructor w/o args
    public GroceryItem() {
    }
    // full constructor
    public GroceryItem(Integer id, String name, Integer qty,  Boolean inCart, Integer userIdFk) {
        this.id = id;
        this.qty = qty;
        this.userIdFk = userIdFk;
        this.name = name;
        this.inCart = inCart;
    }
    // qty/name constructor
    public GroceryItem(String name, Integer qty) {
        this.qty = qty;
        this.name = name;
    }

    // qty/name/UserIDForeignKey constructor
    public GroceryItem(String name, Integer qty, Integer userIdFK) {
        this.qty = qty;
        this.name = name;
        this.userIdFk = userIdFK;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getUserIdFk() {
        return this.userIdFk;
    }

    public void setUserIdFk(Integer userIdFk) {
        this.userIdFk = userIdFk;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isInCart() {
        return this.inCart;
    }

    public Boolean getInCart() {
        return this.inCart;
    }

    public void setInCart(Boolean inCart) {
        this.inCart = inCart;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", qty='" + getQty() + "'" +
            ", userIdFk='" + getUserIdFk() + "'" +
            ", name='" + getName() + "'" +
            ", inCart='" + isInCart() + "'" +
            "}";
    }
    
}