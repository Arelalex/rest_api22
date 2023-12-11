package tests;

import models.AddBooksListModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.TestData.credentials;

public class DeleteOneBookTests extends TestBase {

    @Test
    void deleteBookFromProfileTest() {

        String isbn = "9781449325862";

        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        step("Авторизоваться в профиле", () ->
                booksApi.deleteAllBooks(loginResponse));

        step("Добавить книгу в профиль", () ->
                booksApi.addBook(loginResponse, new AddBooksListModel()));

        step("Удалить книгу из профиля", () ->
                booksApi.deleteOneBook(loginResponse, isbn));

        step("Проверить, что книга в профиле отсутствует", () -> {
            profile.setCookie(loginResponse)
                    .openProfile()
                    .checkAvailabilityBook(isbn);
        });
    }


}
