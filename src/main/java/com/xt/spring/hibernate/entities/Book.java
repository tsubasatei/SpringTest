package com.xt.spring.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "sh_book", schema = "test")
public class Book {
    private Integer id;
    private String bookName;
    private String isbn;
    private Integer price;
    private Integer stock;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book shBook = (Book) o;

        if (id != null ? !id.equals(shBook.id) : shBook.id != null) return false;
        if (bookName != null ? !bookName.equals(shBook.bookName) : shBook.bookName != null) return false;
        if (isbn != null ? !isbn.equals(shBook.isbn) : shBook.isbn != null) return false;
        if (price != null ? !price.equals(shBook.price) : shBook.price != null) return false;
        if (stock != null ? !stock.equals(shBook.stock) : shBook.stock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        return result;
    }
}
