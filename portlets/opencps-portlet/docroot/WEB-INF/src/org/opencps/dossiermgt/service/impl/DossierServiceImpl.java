
/*******************************************************************************
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/


package org.opencps.dossiermgt.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.opencps.datamgt.model.DictItem;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.base.DossierServiceBaseImpl;
import org.opencps.util.DateTimeUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the dossier remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.opencps.dossiermgt.service.DossierService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author trungnt
 * @see org.opencps.dossiermgt.service.base.DossierServiceBaseImpl
 * @see org.opencps.dossiermgt.service.DossierServiceUtil
 */

@JSONWebService
public class DossierServiceImpl extends DossierServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.opencps.dossiermgt.service.DossierServiceUtil} to access the dossier remote service.
	 */
	
	public JSONObject getByoid(
	    String oid)
	    throws SystemException {
		System.out.println("DossierServiceImpl.oid()"+oid);
		JSONObject declaration = JSONFactoryUtil.createJSONObject();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		JSONObject attachedFile = JSONFactoryUtil.createJSONObject();
		Dossier dossier =
				dossierLocalService.getByoid(oid);
		attachedFile.put(
				    "AttachedTypeCode",
				    dossier.getSubjectName());
		attachedFile.put(
				    "AttachedTypeName",
				    dossier.getSubjectName());
		attachedFile.put(
				    "AttachedDocName",
				    dossier.getSubjectName());
		attachedFile.put(
				    "AttachedNote",
				    dossier.getSubjectName());
		attachedFile.put(
				    "AttachedSequenceNo",
				    dossier.getSubjectName());
		attachedFile.put(
				    "FullFileName",
				    dossier.getSubjectName());
		attachedFile.put(
				    "Base64FileContent",
				    dossier.getSubjectName());
		jsonObject.put("AttachedFile", attachedFile);
		jsonObject.put("FromOrganization", dossier.getSubjectName());
		jsonObject.put("Division", dossier.getSubjectName());
		jsonObject.put("ToOrganization", dossier.getSubjectName());
		jsonObject.put("DocNumber", dossier.getSubjectName());
		jsonObject.put("BriefContent", dossier.getSubjectName());
		jsonObject.put("DocContent", dossier.getSubjectName());
		jsonObject.put("SignName", dossier.getSubjectName());
		jsonObject.put("SignTitle", dossier.getSubjectName());
		jsonObject.put("SignPlace", dossier.getSubjectName());
		jsonObject.put("SignDate", dossier.getSubjectName());
		declaration.put("Declaration", jsonObject);
		return jsonObject;
	}
	
	@JSONWebService(value = "search-dossier", method = "POST")
	public JSONObject searchDossier(
			String dossiertype, 
			String organizationcode, 
			String status, 
			String fromdate, 
			String todate, 
			String documentyear, 
			String customername) {
		JSONObject resultObj = JSONFactoryUtil.createJSONObject();
		JSONArray dossierArr = JSONFactoryUtil.createJSONArray();
		
		int documentyearInt = -1;
		if (!Validator.isNull(documentyear) && !"".equals(documentyear.trim())) {
			documentyearInt = Integer.parseInt(documentyear);
		}
		DateFormat sdf = new SimpleDateFormat(DateTimeUtil._VN_DATE_TIME_FORMAT);
		int end = DossierLocalServiceUtil.countDossierForRemoteService(dossiertype, organizationcode, status, fromdate, todate, documentyearInt, customername);
		System.out.println("---------NUMBER OF RESULT---------" + end);
		List<Dossier> lsDossiers = DossierLocalServiceUtil.searchDossierForRemoteService(dossiertype, organizationcode, status, fromdate, todate, documentyearInt, customername, 0, end);
		
		for (Dossier d : lsDossiers) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("oid", d.getOid());
			obj.put("externalRefNo", d.getExternalRefNo());
			obj.put("externalRefUrl", d.getExternalRefUrl());
			obj.put("ownerOrganizationId", d.getOwnerOrganizationId());
			obj.put("serviceInfoId", d.getServiceInfoId());
			obj.put("serviceDomainIndex", d.getServiceDomainIndex());
			obj.put("serviceAdministrationIndex", d.getServiceAdministrationIndex());
			obj.put("govAgencyCode", d.getGovAgencyCode());
			obj.put("govAgencyName", d.getGovAgencyName());
			obj.put("govAgencyOrganizationId", d.getGovAgencyOrganizationId());
			obj.put("serviceMode", d.getServiceMode());
			obj.put("subjectId", d.getSubjectId());
			obj.put("subjectName", d.getSubjectName());
			obj.put("address", d.getAddress());
			obj.put("cityCode", d.getCityCode());
			obj.put("cityName", d.getCityName());
			obj.put("districtCode", d.getDistrictCode());
			obj.put("districtName", d.getDistrictName());
			obj.put("wardCode", d.getWardCode());
			obj.put("wardName", d.getWardName());
			obj.put("contactName", d.getContactName());
			obj.put("contactTelNo", d.getContactTelNo());
			obj.put("contactEmail", d.getContactEmail());
			obj.put("note", d.getNote());
			if (Validator.isNotNull(d.getSubmitDatetime())) {
				obj.put("submitDatetime", sdf.format(d.getSubmitDatetime()));				
			}
			else {
				obj.put("submitDatetime", "");
			}
			if (Validator.isNotNull(d.getReceiveDatetime())) {
				obj.put("receiveDatetime", sdf.format(d.getReceiveDatetime()));				
			}
			else {
				obj.put("receiveDatetime", "");				
			}
			obj.put("receptionNo", d.getReceptionNo());
			if (Validator.isNotNull(d.getEstimateDatetime())) {
				obj.put("estimateDatetime", sdf.format(d.getEstimateDatetime()));				
			}
			else {
				obj.put("estimateDatetime", "");				
			}
			obj.put("dossierStatus", d.getDossierStatus());
			obj.put("delayStatus", d.getDelayStatus());
			
			dossierArr.put(obj);
		}
		resultObj.put("DossierList", dossierArr);
		return resultObj;
	}
}