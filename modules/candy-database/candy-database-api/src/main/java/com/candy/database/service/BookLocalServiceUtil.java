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

package com.candy.database.service;

import aQute.bnd.annotation.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Book. This utility wraps
 * {@link com.candy.database.service.impl.BookLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @see com.candy.database.service.base.BookLocalServiceBaseImpl
 * @see com.candy.database.service.impl.BookLocalServiceImpl
 * @generated
 */
@ProviderType
public class BookLocalServiceUtil {
  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never modify this class directly. Add custom service methods to {@link com.candy.database.service.impl.BookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
   */

  /**
   * Adds the book to the database. Also notifies the appropriate model listeners.
   *
   * @param book the book
   * @return the book that was added
   */
  public static com.candy.database.model.Book addBook (
      com.candy.database.model.Book book) {
    return getService().addBook(book);
  }

  /**
   * Creates a new book with the primary key. Does not add the book to the database.
   *
   * @param bookId the primary key for the new book
   * @return the new book
   */
  public static com.candy.database.model.Book createBook (long bookId) {
    return getService().createBook(bookId);
  }

  /**
   * Deletes the book from the database. Also notifies the appropriate model listeners.
   *
   * @param book the book
   * @return the book that was removed
   */
  public static com.candy.database.model.Book deleteBook (
      com.candy.database.model.Book book) {
    return getService().deleteBook(book);
  }

  /**
   * Deletes the book with the primary key from the database. Also notifies the appropriate model listeners.
   *
   * @param bookId the primary key of the book
   * @return the book that was removed
   * @throws PortalException if a book with the primary key could not be found
   */
  public static com.candy.database.model.Book deleteBook (long bookId)
      throws com.liferay.portal.kernel.exception.PortalException {
    return getService().deleteBook(bookId);
  }

  /**
   * @throws PortalException
   */
  public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel (
      com.liferay.portal.kernel.model.PersistedModel persistedModel)
      throws com.liferay.portal.kernel.exception.PortalException {
    return getService().deletePersistedModel(persistedModel);
  }

  public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery () {
    return getService().dynamicQuery();
  }

  /**
   * Performs a dynamic query on the database and returns the matching rows.
   *
   * @param dynamicQuery the dynamic query
   * @return the matching rows
   */
  public static <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
    return getService().dynamicQuery(dynamicQuery);
  }

  /**
   * Performs a dynamic query on the database and returns a range of the matching rows.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param dynamicQuery the dynamic query
   * @param start the lower bound of the range of model instances
   * @param end the upper bound of the range of model instances (not inclusive)
   * @return the range of matching rows
   */
  public static <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
      int end) {
    return getService().dynamicQuery(dynamicQuery, start, end);
  }

  /**
   * Performs a dynamic query on the database and returns an ordered range of the matching rows.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param dynamicQuery the dynamic query
   * @param start the lower bound of the range of model instances
   * @param end the upper bound of the range of model instances (not inclusive)
   * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
   * @return the ordered range of matching rows
   */
  public static <T> java.util.List<T> dynamicQuery (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
      int end,
      com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
    return getService()
        .dynamicQuery(dynamicQuery, start, end, orderByComparator);
  }

  /**
   * Returns the number of rows matching the dynamic query.
   *
   * @param dynamicQuery the dynamic query
   * @return the number of rows matching the dynamic query
   */
  public static long dynamicQueryCount (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
    return getService().dynamicQueryCount(dynamicQuery);
  }

  /**
   * Returns the number of rows matching the dynamic query.
   *
   * @param dynamicQuery the dynamic query
   * @param projection the projection to apply to the query
   * @return the number of rows matching the dynamic query
   */
  public static long dynamicQueryCount (
      com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
      com.liferay.portal.kernel.dao.orm.Projection projection) {
    return getService().dynamicQueryCount(dynamicQuery, projection);
  }

  public static com.candy.database.model.Book fetchBook (long bookId) {
    return getService().fetchBook(bookId);
  }

  public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery () {
    return getService().getActionableDynamicQuery();
  }

  /**
   * Returns the book with the primary key.
   *
   * @param bookId the primary key of the book
   * @return the book
   * @throws PortalException if a book with the primary key could not be found
   */
  public static com.candy.database.model.Book getBook (long bookId)
      throws com.liferay.portal.kernel.exception.PortalException {
    return getService().getBook(bookId);
  }

  /**
   * Returns a range of all the books.
   *
   * <p>
   * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.candy.database.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
   * </p>
   *
   * @param start the lower bound of the range of books
   * @param end the upper bound of the range of books (not inclusive)
   * @return the range of books
   */
  public static java.util.List<com.candy.database.model.Book> getBooks (
      int start, int end) {
    return getService().getBooks(start, end);
  }

  /**
   * Returns the number of books.
   *
   * @return the number of books
   */
  public static int getBooksCount () {
    return getService().getBooksCount();
  }

  public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery () {
    return getService().getIndexableActionableDynamicQuery();
  }

  /**
   * Returns the OSGi service identifier.
   *
   * @return the OSGi service identifier
   */
  public static String getOSGiServiceIdentifier () {
    return getService().getOSGiServiceIdentifier();
  }

  public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel (
      java.io.Serializable primaryKeyObj)
      throws com.liferay.portal.kernel.exception.PortalException {
    return getService().getPersistedModel(primaryKeyObj);
  }

  /**
   * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
   *
   * @param book the book
   * @return the book that was updated
   */
  public static com.candy.database.model.Book updateBook (
      com.candy.database.model.Book book) {
    return getService().updateBook(book);
  }

  public static BookLocalService getService () {
    return _serviceTracker.getService();
  }

  private static ServiceTracker<BookLocalService, BookLocalService> _serviceTracker;

  static {
    Bundle bundle = FrameworkUtil.getBundle(BookLocalService.class);

    ServiceTracker<BookLocalService, BookLocalService> serviceTracker = new ServiceTracker<BookLocalService, BookLocalService>(
        bundle.getBundleContext(),
        BookLocalService.class, null);

    serviceTracker.open();

    _serviceTracker = serviceTracker;
  }
}