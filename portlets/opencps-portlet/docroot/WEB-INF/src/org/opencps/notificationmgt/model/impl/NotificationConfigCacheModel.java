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

package org.opencps.notificationmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.notificationmgt.model.NotificationConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificationConfig in entity cache.
 *
 * @author trungdk
 * @see NotificationConfig
 * @generated
 */
public class NotificationConfigCacheModel implements CacheModel<NotificationConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{notificationConfigId=");
		sb.append(notificationConfigId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventPattern=");
		sb.append(eventPattern);
		sb.append(", notificationURL=");
		sb.append(notificationURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificationConfig toEntityModel() {
		NotificationConfigImpl notificationConfigImpl = new NotificationConfigImpl();

		notificationConfigImpl.setNotificationConfigId(notificationConfigId);
		notificationConfigImpl.setCompanyId(companyId);
		notificationConfigImpl.setGroupId(groupId);
		notificationConfigImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			notificationConfigImpl.setCreateDate(null);
		}
		else {
			notificationConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			notificationConfigImpl.setModifiedDate(null);
		}
		else {
			notificationConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventPattern == null) {
			notificationConfigImpl.setEventPattern(StringPool.BLANK);
		}
		else {
			notificationConfigImpl.setEventPattern(eventPattern);
		}

		if (notificationURL == null) {
			notificationConfigImpl.setNotificationURL(StringPool.BLANK);
		}
		else {
			notificationConfigImpl.setNotificationURL(notificationURL);
		}

		notificationConfigImpl.resetOriginalValues();

		return notificationConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationConfigId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventPattern = objectInput.readUTF();
		notificationURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificationConfigId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventPattern == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventPattern);
		}

		if (notificationURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationURL);
		}
	}

	public long notificationConfigId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String eventPattern;
	public String notificationURL;
}