package org.opencps.notificationmgt.listener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.opencps.accountmgt.model.Business;
import org.opencps.accountmgt.model.Citizen;
import org.opencps.accountmgt.service.BusinessLocalServiceUtil;
import org.opencps.accountmgt.service.CitizenLocalServiceUtil;
import org.opencps.backend.message.SendToEngineMsg;
import org.opencps.backend.message.UserActionMsg;
import org.opencps.backend.sync.SyncFromFrontOffice;
import org.opencps.backend.util.AutoFillFormData;
import org.opencps.backend.util.BackendUtils;
import org.opencps.dossiermgt.NoSuchDossierFileException;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.model.DossierPart;
import org.opencps.dossiermgt.model.DossierStatus;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierPartLocalServiceUtil;
import org.opencps.dossiermgt.service.DossierStatusLocalServiceUtil;
import org.opencps.servicemgt.model.ServiceInfo;
import org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil;
import org.opencps.util.PortletConstants;
import org.opencps.util.RESTfulUtils;
import org.opencps.util.WebKeys;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GroupThreadLocal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

public class ChannelPusherListener implements MessageListener {

	/* (non-Javadoc)
     * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
     */
    @Override
    public void receive(Message message)
        throws MessageListenerException {

        try {
        	_doReceiveDossier(message);
        }
        catch (Exception e) {
            _log.error("Unable to process message " + message, e);
        }	    
    }
    
	/**
	 * @param message
	 */
	private void _doReceiveDossier(Message message) {
		_log.info("PROCESS MESSAGE IN CHANNEL PUSHER=====================");
		
		UserActionMsg userActionMgs =
		    (UserActionMsg) message.get("msgToEngine");

		String action = userActionMgs.getAction();

		long dosserId = userActionMgs.getDossierId();
		boolean trustServiceMode = true;//_checkServiceMode(dosserId);

		if (trustServiceMode) {
			try {
				if (Validator.equals(WebKeys.ACTION_SUBMIT_VALUE, action) &&
				    _checkStatus(
				        userActionMgs.getDossierId(),
				        userActionMgs.getFileGroupId())) {

					if (Validator.equals(
					    PortletConstants.DOSSIER_STATUS_NEW,
					    BackendUtils.getDossierStatus(
					        userActionMgs.getDossierId(),
					        userActionMgs.getFileGroupId()))) {

					}

				}
				else if (Validator.equals(WebKeys.ACTION_RESUBMIT_VALUE, action) &&
				    _checkStatus(
				        userActionMgs.getDossierId(),
				        userActionMgs.getFileGroupId())) {
					


				}
				else if (Validator.equals(WebKeys.ACTION_REPAIR_VALUE, action)) {

				}
				else if (Validator.equals(WebKeys.ACTION_CLOSE_VALUE, action)) {

				}
				else if (Validator.equals(WebKeys.ACTION_CANCEL_VALUE, action)) {
				}
			}
			catch (Exception e) {
				_log.error(e);
			}

		}

	}

    /**
     * @param dossierId
     * @return
     */
    private boolean _checkServiceMode(long dossierId) {
    	boolean trustServiceMode = false;
    	
    	int serviceMode = 0;
    	
    	try {
	        Dossier dossier = DossierLocalServiceUtil.fetchDossier(dossierId);
	        
	        if (Validator.isNotNull(dossier)) {
	        	serviceMode = dossier.getServiceMode();
	        }
        }
        catch (Exception e) {
        }
    	
    	if (serviceMode == 3) {
    		trustServiceMode = true;
    	}
    	
    	return trustServiceMode;
    }
    
    private boolean _checkStatus(long dossierId, long fileGroupId) {
    	
    	boolean isValidatorStatus = false;
    	
    	DossierStatus status = null;
    	
    	try {
	        status = DossierStatusLocalServiceUtil.getStatus(dossierId, fileGroupId);
        }
        catch (Exception e) {
        	_log.error(e);
        	
        }
    	if (Validator.isNotNull(status)) {
			if (status.getDossierStatus().equals(PortletConstants.DOSSIER_STATUS_NEW) ||
			    status.getDossierStatus().equals(PortletConstants.DOSSIER_STATUS_WAITING)) {
				isValidatorStatus = true;
			}
    	}
    	return isValidatorStatus;
    }
    
    private Log _log = LogFactoryUtil.getLog(ChannelPusherListener.class);
}
