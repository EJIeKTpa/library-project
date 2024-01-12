package ru.kk.libraryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

}
// Вам необходимо сделать следующее:
//Расширить текущее приложения и добавить url: /genre/{id}
//По этому url нужно получать название жанра и список всех книг со всеми авторами у этого жанра.
//В ответе должен приходить json следующего вида:
//{
//    "id": 1,
//		"genre": "Роман"
//    "books": [
//        {
//            "id": 4,
//            "name": "Мастер и Маргарита",
//						"authors": [
//							{
//								"id": 4,
//								"name": "Михаил",
//						    "surname": "Булгаков",
//							}
//						]
//        }
//    ]
//}