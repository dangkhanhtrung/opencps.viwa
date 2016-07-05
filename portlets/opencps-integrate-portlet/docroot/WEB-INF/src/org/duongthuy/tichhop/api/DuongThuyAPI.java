package org.duongthuy.tichhop.api;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.duongthuy.tichhop.api.bean.ResponseBean;
import org.duongthuy.tichhop.api.dao.model.MessageFunctionData;
import org.duongthuy.tichhop.api.dao.service.MessageFunctionDataLocalServiceUtil;
import org.duongthuy.tichhop.util.DateTimeUtil;
import org.duongthuy.tichhop.util.RESTfulUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

@Path("/dossier")
public class DuongThuyAPI {

	@GET
	@Path("/new/messagefunction/{messagefunction}/messageid/{messageid}")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response getNewDossier(@NotNull @PathParam("messagefunction") String messagefunction,
			 @PathParam("messageid") String messageid) {
		String output = StringPool.BLANK;
		InputStream inputStream = null;
		try {
			_log.info("************** messagefunction: "+messagefunction);
			_log.info("************** messageid: "+messageid);
			
			//(\\w+)
			MessageFunctionData messageFunctionData = MessageFunctionDataLocalServiceUtil.getByF_O(messagefunction, messageid);
			
			//output = messageFunctionData.getMessageFileIdData();
			
//			long fileId = 0;
//			
//			if(Validator.isNotNull(messageFunctionData)){
//				
//				fileId = messageFunctionData.getMessageFileIdData();
//				
//			}
//			
//			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileId);
//			
//			_log.info(dlFileEntry);
//			
//			if(Validator.isNotNull(dlFileEntry)){
//				
//				//RESTfulUtils.acceptReadFile();
//				
//				inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getFileEntryId(), dlFileEntry.getVersion());
//				
//				int i;
//			    
//				char c;
//			    
//			    while((i=inputStream.read())!=-1)
//			    {
//			    	c=(char)i;
//			            
//			    	output += c;
//			            
//			    }
//				
//			}
			
			_log.info("************** output - new *******************: "+output);
//			File file = FileUtil.createTempFile(dlFileEntry.getContentStream());
//			_log.info("****************"+file.length() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{

			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/update/messagefunction/{messagefunction}/messageid/{messageid}")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response getUpdateDossier(@NotNull @PathParam("messagefunction") String messagefunction,
			 @PathParam("messageid") String messageid) {
		String output = StringPool.BLANK;
		InputStream inputStream = null;
		try {
			_log.info("************** messagefunction: "+messagefunction);
			_log.info("************** messageid: "+messageid);
			//(\\w+)
			MessageFunctionData messageFunctionData = MessageFunctionDataLocalServiceUtil.getByF_O(messagefunction, messageid);
			
			//output = messageFunctionData.getMessageFileIdData();
			
//			long fileId = 0;
//			
//			if(Validator.isNotNull(messageFunctionData)){
//				
//				fileId = messageFunctionData.getMessageFileIdData();
//				
//			}
//
//			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileId);
//
//			_log.info(dlFileEntry);
//			
//			if(Validator.isNotNull(dlFileEntry)){
//				
//				RESTfulUtils.acceptReadFile();
//				
//				inputStream = dlFileEntry.getContentStream();
//				
//				int i;
//			    
//				char c;
//			    
//			    while((i=inputStream.read())!=-1)
//			    {
//			    	c=(char)i;
//			            
//			    	output += c;
//			            
//			    }
//				
//			}
			
			_log.info("************** output - update *******************: "+output);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{

			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
		return Response.status(200).entity(output).build();
	}
	
	
	//POST insert messageId
	@POST
	@Path("/addMessageFunctionData")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response addMessageFunctionData(String input){
		String output = StringPool.BLANK;
		InputStream fileInputStream = null;
		try {
			//(\\w+)
			if(Validator.isNull(input)){
		        return Response.status(400).entity("Create packages fail!").build();
		    }
			JSONObject inputJsonObject = JSONFactoryUtil.createJSONObject(input);
			_log.info("userId: "+inputJsonObject.getString("userId").toString());
			_log.info("userName: "+inputJsonObject.getString("userName").toString());
			_log.info("messageFunction: "+inputJsonObject.getString("messageFunction").toString());
			_log.info("messageId: "+inputJsonObject.getString("messageId").toString());
			_log.info("version: "+inputJsonObject.getString("version").toString());
			_log.info("sendDate: "+inputJsonObject.getString("sendDate").toString());

			String userId = inputJsonObject.getString("userId");
			String userName = inputJsonObject.getString("userName");
			String messageFunction = inputJsonObject.getString("messageFunction");
			String messageId = inputJsonObject.getString("messageId");
			String messageFileIdData = inputJsonObject.getString("messageFileIdData");
			String version = inputJsonObject.getString("version");
			String sendDate = inputJsonObject.getString("sendDate");
			DateFormat dateFormat = DateFormatFactoryUtil
					.getSimpleDateFormat("YYYY-MM-DD HH:mm:ss");
			Date dateSend = null;
			if(Validator.isNotNull(sendDate)){
				dateSend = dateFormat.parse(sendDate);
			}
//			ServiceContext serviceContext = RESTfulUtils.getServiceContextIntegrate();
//			
//			
//			DLFolder dlFolderOPENCPS = DLFolderLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(), 0, PortletProps.get("OPENCPS")) ;
//			DLFolder dlFolderINTEGRATE = DLFolderLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(), dlFolderOPENCPS.getFolderId(), PortletProps.get("INTEGRATE")) ;
//			
//			long repositoryId = 0;
//			long folderId = 0;
//			String sourceFileName = "";
//			String mimeType = "";
//			String title = "";
//			byte[] bytes = null;
//			
//			repositoryId = dlFolderINTEGRATE.getRepositoryId();
//			folderId = dlFolderINTEGRATE.getFolderId();
//			mimeType = "text/html";
//			sourceFileName =
//					PortletProps.get("opencps.file.system.temp.dir")+"INTEGRATE/"+inputJsonObject.getString("messageFunction")+"_"+inputJsonObject.getString("messageId");
//			title = inputJsonObject.getString("messageFunction")+"_"+inputJsonObject.getString("messageId");
//			
//			fileInputStream = new ByteArrayInputStream(inputJsonObject.getJSONObject("messageFileIdData").toString().getBytes("UTF-8"));
////			
//			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), 
//					repositoryId, 
//					folderId, 
//					sourceFileName, 
//					mimeType, 
//					title, 
//					"Integrate", 
//					"Integrate ChangeLog", 
//					RESTfulUtils.getBytes(fileInputStream), 
//					serviceContext);
			
			MessageFunctionData meData =MessageFunctionDataLocalServiceUtil.addMessageFunctionData(userId, userName, messageFunction, messageId, messageFileIdData,version,dateSend);
//			_log.info("************** output - fileEntry *******************: "+fileEntry.getFileEntryId());
			JSONObject responeJson = JSONFactoryUtil.createJSONObject();
			responeJson.put("ReceiveDate", dateFormat.format(new Date()));
			output = responeJson.toString();
			_log.info("************** output - addMessageFunctionData *******************: "+output);
			String oid = StringPool.BLANK;
			if(Validator.isNotNull(meData) && meData.getMessageId().contains("_")){
				oid = meData.getMessageId().substring(0, meData.getMessageId().lastIndexOf("_"));
			
				JSONObject paramNotification = JSONFactoryUtil.createJSONObject();
				paramNotification.put("messagefunction", meData.getMessageFunction());
				paramNotification.put("messageid", meData.getMessageId());
				paramNotification.put("messagecontent", "Call responsePOSTAPI_Notification");
				paramNotification.put("reference", oid);
				String inputPOSTNotification = paramNotification.toString();
			RESTfulUtils.responsePOSTAPI_Notification("http://daotao.viwa.gov.vn/notifications/instance", inputPOSTNotification, "dvcviwa","dvc2016");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(fileInputStream != null || Validator.isNotNull(fileInputStream)){
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Response.status(201).entity(output).build();
	}
	
	@GET
	@Path("/instance/messagefunction/{messagefunction}/messageid/{messageid}")
	@Produces("application/json")
	public Response dossierInstance(@PathParam("messagefunction") String messagefunction, @PathParam("messageid") String messageid/*, @QueryParam("messagecontent") @DefaultValue("") String messagecontent*/) {
		String output = StringPool.BLANK;
		switch (messagefunction) {
		case "01":
			break;
		case "02":
			break;
		case "03":
			
			break;
		case "11":
			break;
		case "20":
			break;
		case "21":
			break;
		case "22":
			break;
		case "23":
			break;
		case "24":
			break;
		default:
			break;
		}
		JSONObject inputJsonObject = JSONFactoryUtil.createJSONObject();
		DateFormat df = new SimpleDateFormat(DateTimeUtil._VN_DATE_TIME_FORMAT);
		inputJsonObject.put("ReceiveDate", df.format(new Date()));
		
		ResponseBean bean = new ResponseBean();
		bean.setReceiveDate(df.format(new Date()));
		
		return Response.status(200).entity(inputJsonObject.toString()).build();
		//return bean;
	}
	
	//POST insert messageId
	@POST
	@Path("/cancelMessageFunctionData")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Response cancelMessageFunctionData(String input){
		String output = StringPool.BLANK;
		InputStream fileInputStream = null;
		try {
			//(\\w+)
			if(Validator.isNull(input)){
		        return Response.status(400).entity("Create packages fail!").build();
		    }
			JSONObject inputJsonObject = JSONFactoryUtil.createJSONObject(input);
			_log.info("userId: "+inputJsonObject.getString("userId").toString());
			_log.info("userName: "+inputJsonObject.getString("userName").toString());
			_log.info("messageFunction: "+inputJsonObject.getString("messageFunction").toString());
			_log.info("messageId: "+inputJsonObject.getString("messageId").toString());
			_log.info("version: "+inputJsonObject.getString("version").toString());
			_log.info("sendDate: "+inputJsonObject.getString("sendDate").toString());

			String userId = inputJsonObject.getString("userId");
			String userName = inputJsonObject.getString("userName");
			String messageFunction = inputJsonObject.getString("messageFunction");
			String messageId = inputJsonObject.getString("messageId");
			String messageFileIdData = inputJsonObject.getString("messageFileIdData");
			String version = inputJsonObject.getString("version");
			String sendDate = inputJsonObject.getString("sendDate");
			DateFormat dateFormat = DateFormatFactoryUtil
					.getSimpleDateFormat("YYYY-MM-DD HH:mm:ss");
			Date dateSend = null;
			if(Validator.isNotNull(sendDate)){
				dateSend = dateFormat.parse(sendDate);
			}
			
			MessageFunctionData meData =MessageFunctionDataLocalServiceUtil.addMessageFunctionData(userId, userName, messageFunction, messageId, messageFileIdData,version,dateSend);
//			_log.info("************** output - fileEntry *******************: "+fileEntry.getFileEntryId());
			JSONObject responeJson = JSONFactoryUtil.createJSONObject();
			responeJson.put("ReceiveDate", dateFormat.format(new Date()));
			output = responeJson.toString();
			_log.info("************** output - addMessageFunctionData *******************: "+output);
			String oid = StringPool.BLANK;
			if(Validator.isNotNull(meData) && meData.getMessageId().contains("_")){
				oid = meData.getMessageId().substring(0, meData.getMessageId().lastIndexOf("_"));
			
				JSONObject paramNotification = JSONFactoryUtil.createJSONObject();
				paramNotification.put("messagefunction", meData.getMessageFunction());
				paramNotification.put("messageid", meData.getMessageId());
				paramNotification.put("messagecontent", "Call responsePOSTAPI_Notification");
				paramNotification.put("reference", oid);
				String inputPOSTNotification = paramNotification.toString();
			RESTfulUtils.responsePOSTAPI_Notification("http://daotao.viwa.gov.vn/notifications/instance", inputPOSTNotification, "dvcviwa","dvc2016");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(fileInputStream != null || Validator.isNotNull(fileInputStream)){
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return Response.status(201).entity(output).build();
	}
	
	@GET
	@Path("/dossiertype/{dossiertype}/organizationcode/{organizationcode}/status/{status}/fromdate/{fromdate}/todate/{todate}/documentyear/{documentyear}/customername/{customername}")
	@Produces("application/json")
	public Response searchDossier(
			@PathParam("dossiertype") String dossiertype, 
			@PathParam("organizationcode") String organizationcode, 
			@PathParam("status") @DefaultValue("-1") String status, 
			@PathParam("fromdate") @DefaultValue("") String fromdate,
			@PathParam("todate") @DefaultValue("") String todate,
			@PathParam("documentyear") @DefaultValue("") String documentyear,
			@PathParam("customername") @DefaultValue("") String customername) {
		String output = StringPool.BLANK;
		
		return Response.status(200).entity(output).build();
	}
	
	private static Log _log = LogFactoryUtil.getLog(DuongThuyAPI.class);
}
