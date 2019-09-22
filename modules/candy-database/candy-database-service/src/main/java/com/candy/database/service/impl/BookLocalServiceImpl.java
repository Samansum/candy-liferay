/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.candy.database.service.impl;

import com.candy.database.exception.NoSuchBookException;
import com.candy.database.model.Book;
import com.candy.database.service.BookLocalServiceUtil;
import com.candy.database.service.base.BookLocalServiceBaseImpl;
import com.liferay.portal.kernel.util.Validator;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the {@link com.candy.database.service.BookLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalServiceBaseImpl
 * @see com.candy.database.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this class directly. Always use {@link com.candy.database.service.BookLocalServiceUtil} to access the book local service.
   */
  public Book createBook (String bookTitle, String authorName, Date publishedDate) {

    long bookId = counterLocalService.increment();
    Book book = BookLocalServiceUtil.createBook(bookId);
    book.setBookTitle(bookTitle);
    book.setAuthor(authorName);
    book.setPublishDate(publishedDate);

    return bookPersistence.update(book);
  }

  public Book updateBook (long bookId, String bookTitle, String authorName, Date publishedDate)
      throws NoSuchBookException {
    Book book = BookLocalServiceUtil.fetchBook(bookId);
    if (Validator.isNull(book)) {
      return null;
    }
    book.setBookTitle(bookTitle);
    book.setAuthor(authorName);
    book.setPublishDate(publishedDate);

    return bookPersistence.update(book);
  }

  public List<Book> findBookByPublishedDate (Date date) throws NoSuchBookException {
    return bookPersistence.findBypublishDate(date);
  }

  public List<Book> findBookByAuthor (String authorName) throws NoSuchBookException {
    return bookPersistence.findByauthor(authorName);
  }

  public List<Book> findByAuthorAndPublishedDate (String authorName, Date publishedDate)
      throws NoSuchBookException {
    return bookPersistence.findByauthorPublishedOnDate(authorName, publishedDate);
  }

  public List<Book> findAllBooks () throws NoSuchBookException {
    return bookPersistence.findAll();
  }
}