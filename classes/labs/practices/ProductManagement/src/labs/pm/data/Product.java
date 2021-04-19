/*
 * Copyright (C) 2021 Juanes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


/**
 * {@code Product} class represents properties and behaviors 
 * of product objects in the product management system
 * <br>
 * Each product has an id,name and price
 * <br>
 * Each product can have a discount,calculated based on a
 * {@link DISCOUNT_RATE discount rate}
 * @version 1.0
 * @author Juanes
 */
public abstract class Product {
    /**
     * A constant that defines a {link java.math.BigDecimal BigDecimal} value
     * of the discount rate
     * <br>
     * Discount rate is 10%
     */

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;
    
    /*Product(){
        this(0,"No Name",BigDecimal.ZERO);
        
    }*/
    
    Product(int id, String name, BigDecimal price, Rating rating) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id,name,price,Rating.NOT_RATED);
        
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }



    /**
 * Calculates discount based on a product price and
 * {@link DISCOUNT_RATE discount rate }
 * @return a {@link java.math.BigDecimal BigDecimal}
 * value of discount
 */
    public BigDecimal getDiscount() {

        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public abstract Product applyRating(Rating newRating);
    

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", getDiscount=" + getDiscount() +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj != null && getClass() == obj.getClass()){
       // if(obj instanceof Product)
            final Product other = (Product) obj;
            return this.id == other.id && Objects.equals(this.name,other.name);

        }

        /*if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }*/
        return true;
    }
    
    
    


}
