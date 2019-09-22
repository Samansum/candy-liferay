/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.candy.database.service.persistence;

import aQute.bnd.annotation.ProviderType;
import com.candy.database.model.Book;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the book service. This utility wraps {@link com.candy.database.service.persistence.impl.BookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see com.candy.database.service.persistence.impl.BookPersistenceImpl
 * @generated
 */
@ProviderType
public class BookUtil {
  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
   */

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
   */
  public static void clearCache () {
    getPersistence().clearCache();
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
   */
  public static void clearCache (Book book) {
    getPersistence().clearCache(book);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
   */
  public static long countWithDynamicQuery (DynamicQuery dynamicQuery) {
    return getPersistence().countWithDynamicQuery(dynamicQuery);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
   */
  public static Map<Serializable, Book> fetchByPrimaryKeys (
      Set<Serializable> primaryKeys) {
    return getPersistence().fetchByPrimaryKeys(primaryKeys);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
   */
  public static List<Book> findWithDynamicQuery (DynamicQuery dynamicQuery) {
    return getPersistence().findWithDynamicQuery(dynamicQuery);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery,
   * int, int)
   */
  public static List<Book> findWithDynamicQuery (DynamicQuery dynamicQuery,
      int start, int end) {
    return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery,
   * int, int, OrderByComparator)
   */
  public static List<Book> findWithDynamicQuery (DynamicQuery dynamicQuery,
      int start, int end, OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
   */
  public static Book update (Book book) {
    return getPersistence().update(book);
  }

  /**
   * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel,
   * ServiceContext)
   */
  public static Book update (Book book, ServiceContext serviceContext) {
    return getPersistence().update(book, serviceContext);
  }

  /**
   * Returns all the books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the matching books
   */
  public static List<Book> findByUuid (String uuid) {
    return getPersistence().findByUuid(uuid);
  }

  /**
   * Returns a range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param uuid  the uuid
   * @param start the lower bound of the range of books
   * @param end   the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public static List<Book> findByUuid (String uuid, int start, int end) {
    return getPersistence().findByUuid(uuid, start, end);
  }

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param uuid              the uuid
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public static List<Book> findByUuid (String uuid, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().findByUuid(uuid, start, end, orderByComparator);
  }

  /**
   * Returns an ordered range of all the books where uuid = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param uuid              the uuid
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public static List<Book> findByUuid (String uuid, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    return getPersistence()
        .findByUuid(uuid, start, end, orderByComparator,
            retrieveFromCache);
  }

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid              the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByUuid_First (String uuid,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().findByUuid_First(uuid, orderByComparator);
  }

  /**
   * Returns the first book in the ordered set where uuid = &#63;.
   *
   * @param uuid              the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByUuid_First (String uuid,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().fetchByUuid_First(uuid, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid              the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByUuid_Last (String uuid,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().findByUuid_Last(uuid, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where uuid = &#63;.
   *
   * @param uuid              the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByUuid_Last (String uuid,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
  }

  /**
   * Returns the books before and after the current book in the ordered set where uuid = &#63;.
   *
   * @param bookId            the primary key of the current book
   * @param uuid              the uuid
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book[] findByUuid_PrevAndNext (long bookId, String uuid,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findByUuid_PrevAndNext(bookId, uuid, orderByComparator);
  }

  /**
   * Removes all the books where uuid = &#63; from the database.
   *
   * @param uuid the uuid
   */
  public static void removeByUuid (String uuid) {
    getPersistence().removeByUuid(uuid);
  }

  /**
   * Returns the number of books where uuid = &#63;.
   *
   * @param uuid the uuid
   * @return the number of matching books
   */
  public static int countByUuid (String uuid) {
    return getPersistence().countByUuid(uuid);
  }

  /**
   * Returns all the books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the matching books
   */
  public static List<Book> findBypublishDate (Date publishDate) {
    return getPersistence().findBypublishDate(publishDate);
  }

  /**
   * Returns a range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param publishDate the publish date
   * @param start       the lower bound of the range of books
   * @param end         the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public static List<Book> findBypublishDate (Date publishDate, int start,
      int end) {
    return getPersistence().findBypublishDate(publishDate, start, end);
  }

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param publishDate       the publish date
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public static List<Book> findBypublishDate (Date publishDate, int start,
      int end, OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .findBypublishDate(publishDate, start, end, orderByComparator);
  }

  /**
   * Returns an ordered range of all the books where publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param publishDate       the publish date
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public static List<Book> findBypublishDate (Date publishDate, int start,
      int end, OrderByComparator<Book> orderByComparator,
      boolean retrieveFromCache) {
    return getPersistence()
        .findBypublishDate(publishDate, start, end,
            orderByComparator, retrieveFromCache);
  }

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findBypublishDate_First (Date publishDate,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findBypublishDate_First(publishDate, orderByComparator);
  }

  /**
   * Returns the first book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchBypublishDate_First (Date publishDate,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .fetchBypublishDate_First(publishDate, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findBypublishDate_Last (Date publishDate,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findBypublishDate_Last(publishDate, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where publishDate = &#63;.
   *
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchBypublishDate_Last (Date publishDate,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .fetchBypublishDate_Last(publishDate, orderByComparator);
  }

  /**
   * Returns the books before and after the current book in the ordered set where publishDate =
   * &#63;.
   *
   * @param bookId            the primary key of the current book
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book[] findBypublishDate_PrevAndNext (long bookId,
      Date publishDate, OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findBypublishDate_PrevAndNext(bookId, publishDate,
            orderByComparator);
  }

  /**
   * Removes all the books where publishDate = &#63; from the database.
   *
   * @param publishDate the publish date
   */
  public static void removeBypublishDate (Date publishDate) {
    getPersistence().removeBypublishDate(publishDate);
  }

  /**
   * Returns the number of books where publishDate = &#63;.
   *
   * @param publishDate the publish date
   * @return the number of matching books
   */
  public static int countBypublishDate (Date publishDate) {
    return getPersistence().countBypublishDate(publishDate);
  }

  /**
   * Returns all the books where author = &#63;.
   *
   * @param author the author
   * @return the matching books
   */
  public static List<Book> findByauthor (String author) {
    return getPersistence().findByauthor(author);
  }

  /**
   * Returns a range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author the author
   * @param start  the lower bound of the range of books
   * @param end    the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public static List<Book> findByauthor (String author, int start, int end) {
    return getPersistence().findByauthor(author, start, end);
  }

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author            the author
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public static List<Book> findByauthor (String author, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .findByauthor(author, start, end, orderByComparator);
  }

  /**
   * Returns an ordered range of all the books where author = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author            the author
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public static List<Book> findByauthor (String author, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    return getPersistence()
        .findByauthor(author, start, end, orderByComparator,
            retrieveFromCache);
  }

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author            the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByauthor_First (String author,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().findByauthor_First(author, orderByComparator);
  }

  /**
   * Returns the first book in the ordered set where author = &#63;.
   *
   * @param author            the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByauthor_First (String author,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().fetchByauthor_First(author, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author            the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByauthor_Last (String author,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().findByauthor_Last(author, orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where author = &#63;.
   *
   * @param author            the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByauthor_Last (String author,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().fetchByauthor_Last(author, orderByComparator);
  }

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63;.
   *
   * @param bookId            the primary key of the current book
   * @param author            the author
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book[] findByauthor_PrevAndNext (long bookId, String author,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findByauthor_PrevAndNext(bookId, author, orderByComparator);
  }

  /**
   * Removes all the books where author = &#63; from the database.
   *
   * @param author the author
   */
  public static void removeByauthor (String author) {
    getPersistence().removeByauthor(author);
  }

  /**
   * Returns the number of books where author = &#63;.
   *
   * @param author the author
   * @return the number of matching books
   */
  public static int countByauthor (String author) {
    return getPersistence().countByauthor(author);
  }

  /**
   * Returns all the books where author = &#63; and publishDate = &#63;.
   *
   * @param author      the author
   * @param publishDate the publish date
   * @return the matching books
   */
  public static List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate) {
    return getPersistence().findByauthorPublishedOnDate(author, publishDate);
  }

  /**
   * Returns a range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author      the author
   * @param publishDate the publish date
   * @param start       the lower bound of the range of books
   * @param end         the upper bound of the range of books (not inclusive)
   * @return the range of matching books
   */
  public static List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end) {
    return getPersistence()
        .findByauthorPublishedOnDate(author, publishDate, start, end);
  }

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching books
   */
  public static List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .findByauthorPublishedOnDate(author, publishDate, start,
            end, orderByComparator);
  }

  /**
   * Returns an ordered range of all the books where author = &#63; and publishDate = &#63;.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of matching books
   */
  public static List<Book> findByauthorPublishedOnDate (String author,
      Date publishDate, int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    return getPersistence()
        .findByauthorPublishedOnDate(author, publishDate, start,
            end, orderByComparator, retrieveFromCache);
  }

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByauthorPublishedOnDate_First (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findByauthorPublishedOnDate_First(author, publishDate,
            orderByComparator);
  }

  /**
   * Returns the first book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the first matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByauthorPublishedOnDate_First (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .fetchByauthorPublishedOnDate_First(author, publishDate,
            orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book
   * @throws NoSuchBookException if a matching book could not be found
   */
  public static Book findByauthorPublishedOnDate_Last (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findByauthorPublishedOnDate_Last(author, publishDate,
            orderByComparator);
  }

  /**
   * Returns the last book in the ordered set where author = &#63; and publishDate = &#63;.
   *
   * @param author            the author
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the last matching book, or <code>null</code> if a matching book could not be found
   */
  public static Book fetchByauthorPublishedOnDate_Last (String author,
      Date publishDate, OrderByComparator<Book> orderByComparator) {
    return getPersistence()
        .fetchByauthorPublishedOnDate_Last(author, publishDate,
            orderByComparator);
  }

  /**
   * Returns the books before and after the current book in the ordered set where author = &#63; and
   * publishDate = &#63;.
   *
   * @param bookId            the primary key of the current book
   * @param author            the author
   * @param publishDate       the publish date
   * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
   * @return the previous, current, and next book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book[] findByauthorPublishedOnDate_PrevAndNext (long bookId,
      String author, Date publishDate,
      OrderByComparator<Book> orderByComparator)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence()
        .findByauthorPublishedOnDate_PrevAndNext(bookId, author,
            publishDate, orderByComparator);
  }

  /**
   * Removes all the books where author = &#63; and publishDate = &#63; from the database.
   *
   * @param author      the author
   * @param publishDate the publish date
   */
  public static void removeByauthorPublishedOnDate (String author,
      Date publishDate) {
    getPersistence().removeByauthorPublishedOnDate(author, publishDate);
  }

  /**
   * Returns the number of books where author = &#63; and publishDate = &#63;.
   *
   * @param author      the author
   * @param publishDate the publish date
   * @return the number of matching books
   */
  public static int countByauthorPublishedOnDate (String author,
      Date publishDate) {
    return getPersistence().countByauthorPublishedOnDate(author, publishDate);
  }

  /**
   * Caches the book in the entity cache if it is enabled.
   *
   * @param book the book
   */
  public static void cacheResult (Book book) {
    getPersistence().cacheResult(book);
  }

  /**
   * Caches the books in the entity cache if it is enabled.
   *
   * @param books the books
   */
  public static void cacheResult (List<Book> books) {
    getPersistence().cacheResult(books);
  }

  /**
   * Creates a new book with the primary key. Does not add the book to the database.
   *
   * @param bookId the primary key for the new book
   * @return the new book
   */
  public static Book create (long bookId) {
    return getPersistence().create(bookId);
  }

  /**
   * Removes the book with the primary key from the database. Also notifies the appropriate model
   * listeners.
   *
   * @param bookId the primary key of the book
   * @return the book that was removed
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book remove (long bookId)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().remove(bookId);
  }

  public static Book updateImpl (Book book) {
    return getPersistence().updateImpl(book);
  }

  /**
   * Returns the book with the primary key or throws a {@link NoSuchBookException} if it could not
   * be found.
   *
   * @param bookId the primary key of the book
   * @return the book
   * @throws NoSuchBookException if a book with the primary key could not be found
   */
  public static Book findByPrimaryKey (long bookId)
      throws com.candy.database.exception.NoSuchBookException {
    return getPersistence().findByPrimaryKey(bookId);
  }

  /**
   * Returns the book with the primary key or returns <code>null</code> if it could not be found.
   *
   * @param bookId the primary key of the book
   * @return the book, or <code>null</code> if a book with the primary key could not be found
   */
  public static Book fetchByPrimaryKey (long bookId) {
    return getPersistence().fetchByPrimaryKey(bookId);
  }

  /**
   * Returns all the books.
   *
   * @return the books
   */
  public static List<Book> findAll () {
    return getPersistence().findAll();
  }

  /**
   * Returns a range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end   the upper bound of the range of books (not inclusive)
   * @return the range of books
   */
  public static List<Book> findAll (int start, int end) {
    return getPersistence().findAll(start, end);
  }

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of books
   */
  public static List<Book> findAll (int start, int end,
      OrderByComparator<Book> orderByComparator) {
    return getPersistence().findAll(start, end, orderByComparator);
  }

  /**
   * Returns an ordered range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances.
   * <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result
   * set. Thus, <code>0</code> refers to the first result in the set. Setting both
   * <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full
   * result set. If <code>orderByComparator</code> is specified, then the query will include the
   * given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required
   * (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query
   * will include the default ORDER BY logic from {@link BookModelImpl}. If both
   * <code>orderByComparator</code> and pagination are absent, for performance reasons, the query
   * will not have an ORDER BY clause and the returned result set will be sorted on by the primary
   * key in an ascending order.
   * </p>
   *
   * @param start             the lower bound of the range of books
   * @param end               the upper bound of the range of books (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @param retrieveFromCache whether to retrieve from the finder cache
   * @return the ordered range of books
   */
  public static List<Book> findAll (int start, int end,
      OrderByComparator<Book> orderByComparator, boolean retrieveFromCache) {
    return getPersistence()
        .findAll(start, end, orderByComparator, retrieveFromCache);
  }

  /**
   * Removes all the books from the database.
   */
  public static void removeAll () {
    getPersistence().removeAll();
  }

  /**
   * Returns the number of books.
   *
   * @return the number of books
   */
  public static int countAll () {
    return getPersistence().countAll();
  }

  public static Set<String> getBadColumnNames () {
    return getPersistence().getBadColumnNames();
  }

  public static BookPersistence getPersistence () {
    return _serviceTracker.getService();
  }

  private static ServiceTracker<BookPersistence, BookPersistence> _serviceTracker;

  static {
    Bundle bundle = FrameworkUtil.getBundle(BookPersistence.class);

    ServiceTracker<BookPersistence, BookPersistence> serviceTracker = new ServiceTracker<BookPersistence, BookPersistence>(
        bundle.getBundleContext(),
        BookPersistence.class, null);

    serviceTracker.open();

    _serviceTracker = serviceTracker;
  }
}