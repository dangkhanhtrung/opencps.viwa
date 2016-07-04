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

package org.duongthuy.tichhop.api.dao.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MessageFunctionData. This utility wraps
 * {@link org.duongthuy.tichhop.api.dao.service.impl.MessageFunctionDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author binhth
 * @see MessageFunctionDataLocalService
 * @see org.duongthuy.tichhop.api.dao.service.base.MessageFunctionDataLocalServiceBaseImpl
 * @see org.duongthuy.tichhop.api.dao.service.impl.MessageFunctionDataLocalServiceImpl
 * @generated
 */
public class MessageFunctionDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.duongthuy.tichhop.api.dao.service.impl.MessageFunctionDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the message function data to the database. Also notifies the appropriate model listeners.
	*
	* @param messageFunctionData the message function data
	* @return the message function data that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData addMessageFunctionData(
		org.duongthuy.tichhop.api.dao.model.MessageFunctionData messageFunctionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMessageFunctionData(messageFunctionData);
	}

	/**
	* Creates a new message function data with the primary key. Does not add the message function data to the database.
	*
	* @param messagePackagesId the primary key for the new message function data
	* @return the new message function data
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData createMessageFunctionData(
		long messagePackagesId) {
		return getService().createMessageFunctionData(messagePackagesId);
	}

	/**
	* Deletes the message function data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messagePackagesId the primary key of the message function data
	* @return the message function data that was removed
	* @throws PortalException if a message function data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData deleteMessageFunctionData(
		long messagePackagesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMessageFunctionData(messagePackagesId);
	}

	/**
	* Deletes the message function data from the database. Also notifies the appropriate model listeners.
	*
	* @param messageFunctionData the message function data
	* @return the message function data that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData deleteMessageFunctionData(
		org.duongthuy.tichhop.api.dao.model.MessageFunctionData messageFunctionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMessageFunctionData(messageFunctionData);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.duongthuy.tichhop.api.dao.model.impl.MessageFunctionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.duongthuy.tichhop.api.dao.model.impl.MessageFunctionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData fetchMessageFunctionData(
		long messagePackagesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMessageFunctionData(messagePackagesId);
	}

	/**
	* Returns the message function data with the primary key.
	*
	* @param messagePackagesId the primary key of the message function data
	* @return the message function data
	* @throws PortalException if a message function data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData getMessageFunctionData(
		long messagePackagesId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMessageFunctionData(messagePackagesId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the message function datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.duongthuy.tichhop.api.dao.model.impl.MessageFunctionDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message function datas
	* @param end the upper bound of the range of message function datas (not inclusive)
	* @return the range of message function datas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.duongthuy.tichhop.api.dao.model.MessageFunctionData> getMessageFunctionDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMessageFunctionDatas(start, end);
	}

	/**
	* Returns the number of message function datas.
	*
	* @return the number of message function datas
	* @throws SystemException if a system exception occurred
	*/
	public static int getMessageFunctionDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMessageFunctionDatasCount();
	}

	/**
	* Updates the message function data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param messageFunctionData the message function data
	* @return the message function data that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData updateMessageFunctionData(
		org.duongthuy.tichhop.api.dao.model.MessageFunctionData messageFunctionData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMessageFunctionData(messageFunctionData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData getByF_O(
		java.lang.String messageFunction, java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByF_O(messageFunction, messageId);
	}

	public static org.duongthuy.tichhop.api.dao.model.MessageFunctionData addMessageFunctionData(
		java.lang.String userId, java.lang.String userName,
		java.lang.String messageFunction, java.lang.String messageId,
		java.lang.String messageFileIdData, java.lang.String version,
		java.util.Date sendDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMessageFunctionData(userId, userName, messageFunction,
			messageId, messageFileIdData, version, sendDate);
	}

	public static void clearService() {
		_service = null;
	}

	public static MessageFunctionDataLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MessageFunctionDataLocalService.class.getName());

			if (invokableLocalService instanceof MessageFunctionDataLocalService) {
				_service = (MessageFunctionDataLocalService)invokableLocalService;
			}
			else {
				_service = new MessageFunctionDataLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MessageFunctionDataLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MessageFunctionDataLocalService service) {
	}

	private static MessageFunctionDataLocalService _service;
}