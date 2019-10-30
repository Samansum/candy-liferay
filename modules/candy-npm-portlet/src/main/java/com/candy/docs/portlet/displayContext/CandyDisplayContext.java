package com.candy.docs.portlet.displayContext;

import com.candy.database.exception.NoSuchBookException;
import com.candy.database.model.Book;
import com.candy.database.service.BookLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CandyDisplayContext {

  public String getBooksAsJson () {
    JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
    return jsonSerializer.serializeDeep(
        getBooks().isEmpty() ? getDefaultBooks() : getBooks()
    );
  }

  private List<Book> getBooks () {
    try {
      return BookLocalServiceUtil.findAllBooks();
    } catch (NoSuchBookException e) {
      log.error("method=getBooks error={}", e);
      return Collections.emptyList();
    }
  }

  private List<Book> getDefaultBooks () {
    List<Book> defaultBooks = new ArrayList<>();
    Book book = BookLocalServiceUtil.createBook(0);
    book.setBookTitle("Candy's Life");
    book.setAuthor("Candy");
    book.setPublishDate(new Date());
    defaultBooks.add(book);
    return defaultBooks;
  }
}
