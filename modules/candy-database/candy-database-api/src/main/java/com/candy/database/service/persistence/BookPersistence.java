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

package com.candy.database.service.persistence;

import aQute.bnd.annotation.ProviderType;
import com.candy.database.exception.NoSuchBookException;
import com.candy.database.model.Book;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.candy.database.service.persistence.impl.BookPersistenceImpl
 * @see BookUtil
 * @generated
 */
@ProviderType
public interface BookPersistence extends BasePersistence<Book> {

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never modify or reference this interface directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
   */
  @Override
  public Map<Serializable, Book> fetchByPrimaryKeys (
      Set<Serializable> primaryKeys);

  /**
   * Returns all the books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the matching books
   */
  public java.util.List<Book> findByUuid (String uuid);

  /**
   * Returns a range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public java.util.List<Book> findByUuid (String uuid, int start, int end);

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByUuid (String uuid, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param uuid the uuid
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByUuid (String uuid, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache);

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByUuid_First (String uuid,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByUuid_First (String uuid,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByUuid_Last (String uuid,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByUuid_Last (String uuid,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the books before and after the current book in the ordered set where uuid = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param uuid the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book[] findByUuid_PrevAndNext (long bookId, String uuid,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Removes all the books where uuid = &#63; from the database.
   *
   * @param uuid the uuid
   */
  public void removeByUuid (String uuid);

  /**
   * Returns the number of books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the number of matching books
   */
  public int countByUuid (String uuid);

  /**
   * Returns all the books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the matching books
   */
  public java.util.List<Book> findBypublishDate (Date publishDate);

  /**
   * Returns a range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public java.util.List<Book> findBypublishDate (Date publishDate, int start,
      int end);

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findBypublishDate (Date publishDate, int start,
      int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findBypublishDate (Date publishDate, int start,
      int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache);

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findBypublishDate_First (Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchBypublishDate_First (Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findBypublishDate_Last (Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchBypublishDate_Last (Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the books before and after the current book in the ordered set where publishDate = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book[] findBypublishDate_PrevAndNext (long bookId, Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Removes all the books where publishDate = &#63; from the database.
   *
   * @param publishDate the publish date
   */
  public void removeBypublishDate (Date publishDate);

  /**
   * Returns the number of books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the number of matching books
   */
  public int countBypublishDate (Date publishDate);

  /**
   * Returns all the books where author = &#63;.
   *
   * @param author the author
   * @return the matching books
   */
  public java.util.List<Book> findByauthor (String author);

  /**
   * Returns a range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public java.util.List<Book> findByauthor (String author, int start, int end);

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByauthor (String author, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByauthor (String author, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache);

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByauthor_First (String author,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByauthor_First (String author,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByauthor_Last (String author,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByauthor_Last (String author,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param author the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book[] findByauthor_PrevAndNext (long bookId, String author,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Removes all the books where author = &#63; from the database.
   *
   * @param author the author
   */
  public void removeByauthor (String author);

  /**
   * Returns the number of books where author = &#63;.
   *
   * @param author the author
   * @return the number of matching books
   */
  public int countByauthor (String author);

  /**
   * Returns all the books where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @return the matching books
   */
  public java.util.List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate);

  /**
   * Returns a range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public java.util.List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end);

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param publishDate the publish date
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public java.util.List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache);

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByauthorPublishedOnDate_First (String author,
      Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByauthorPublishedOnDate_First (String author,
      Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public Book findByauthorPublishedOnDate_Last (String author,
      Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public Book fetchByauthorPublishedOnDate_Last (String author,
      Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param bookId the primary key of the current book
   * @param author the author
   * @param publishDate the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book[] findByauthorPublishedOnDate_PrevAndNext (long bookId,
      String author, Date publishDate,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator)
      throws NoSuchBookException;

  /**
   * Removes all the books where author = &#63; and publishDate = &#63; from the database.
   *
   * @param author the author
   * @param publishDate the publish date
   */
  public void removeByauthorPublishedOnDate (String author, Date publishDate);

  /**
   * Returns the number of books where author = &#63; and publishDate = &#63;.
   *
   * @param author the author
   * @param publishDate the publish date
   * @return the number of matching books
   */
  public int countByauthorPublishedOnDate (String author, Date publishDate);

  /**
   * Caches the book in the entity cache if it is enabled.
   *
   * @param book the book
   */
  public void cacheResult (Book book);

  /**
   * Caches the books in the entity cache if it is enabled.
   *
   * @param books the books
   */
  public void cacheResult (java.util.List<Book> books);

  /**
   * Creates a new book with the primary key. Does not add the book to the database.
   *
   * @param bookId the primary key for the new book
   * @return the new book
   */
  public Book create (long bookId);

  /**
   * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
   *
   * @param bookId the primary key of the book
   * @return the book that was removed
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book remove (long bookId) throws NoSuchBookException;

  public Book updateImpl (Book book);

  /**
   * Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not be found.
   *
   * @param bookId the primary key of the book
   * @return the book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public Book findByPrimaryKey (long bookId) throws NoSuchBookException;

  /**
   * Returns the book with the primary key or returns <code>null</code> if it could not be found.
   *
   * @param bookId the primary key of the book
   * @return the book, or <code>null</code> if a book with the primary key could not be found
   */
  public Book fetchByPrimaryKey (long bookId);

  /**
   * Returns all the books.
   *
   * @return the books
   */
  public java.util.List<Book> findAll ();

  /**
   * Returns a range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of books
   */
  public java.util.List<Book> findAll (int start, int end);

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of books
   */
  public java.util.List<Book> findAll (int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator);

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of books
   */
  public java.util.List<Book> findAll (int start, int end,
      com.liferay.portal.kernel.util.OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache);

  /**
   * Removes all the books from the database.
   */
  public void removeAll ();

  /**
   * Returns the number of books.
   *
   * @return the number of books
   */
  public int countAll ();

  @Override
  public Set<String> getBadColumnNames ();
}