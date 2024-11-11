package com.ebere.bookcatalog.service;

import com.ebere.bookcatalog.model.Book;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericType;
import org.springframework.stereotype.Service;


@Service
public class ManagementServiceClient {

    private final Client client;
    private final WebTarget baseTarget;

    public ManagementServiceClient() {
        this.client = ClientBuilder.newClient();
        this.baseTarget = client.target("http://localhost:8081/api/books");
    }

//    public List<Book> getAllBooks() {
//        Response response = baseTarget.request(MediaType.APPLICATION_JSON).get();
//        List<Book> books = response.readEntity(new GenericType<List<Book>>() {});
//        response.close();
//        return books;
//    }

    public List<Book> getAllBooks() {
        Response response = baseTarget.request()
                .accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            try {
                return response.readEntity(new GenericType<List<Book>>() {});
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to parse the response to List<Book>", e);
            } finally {
                response.close();
            }
        } else {
            String errorMessage = "Failed to retrieve books. Status code: " + response.getStatus();
            response.close();
            throw new RuntimeException(errorMessage);
        }
    }


    public Book getBookById(int id) {
        Response response = baseTarget.path(String.valueOf(id)).request(MediaType.APPLICATION_JSON).get();
        Book book = response.readEntity(Book.class);
        response.close();
        return book;
    }

    public void addBook(Book book) {
        baseTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(book, MediaType.APPLICATION_JSON));
    }

    public void updateBook(int id, Book book) {
        baseTarget.path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(book, MediaType.APPLICATION_JSON));
    }

    public void deleteBook(int id) {
        baseTarget.path(String.valueOf(id)).request().delete();
    }

    public void close() {
        client.close();
    }
}
