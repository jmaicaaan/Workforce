package com.workforce.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.workforce.models.NotificationModel;
import com.workforce.models.UserModel;
import com.workforce.repositories.CompanyRepository;
import com.workforce.repositories.NotificationRepository;
import com.workforce.repositories.ParticipantRepository;
import com.workforce.repositories.UserRepository;

public class GetNotification extends ActionSupport implements ModelDriven<UserModel>, ServletRequestAware, ServletResponseAware{
	
	private UserModel user = new UserModel();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserRepository _userRepository = new UserRepository();
	private ParticipantRepository _participantRepository = new ParticipantRepository();
	private CompanyRepository _companyRepository = new CompanyRepository();
	private NotificationRepository _notificationRepository = new NotificationRepository();
	private List<NotificationModel> list = new ArrayList<NotificationModel>();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		
		
		user = _companyRepository.GetCompanyDetailsByAccessToken("35c7e90b-e8b1-4eef-9dcc-602e5c84e2b3");
		

		
		try (PrintWriter writer = response.getWriter();) {
//			final String accessToken = AccessTokenHelper.getAccessToken(request.getCookies(), user);
//			_notificationRepository.Insert(notificiation);
			list = _notificationRepository.GetNotificationByUser(user);
//			list.forEach(i -> {
//				Hibernate.initialize(i.getUser());
//				Hibernate.initialize(i.getUser().getParticipantModel());
//				Hibernate.initialize(i.getUser().getCompanyModel());
//			});
//			String ac = _userRepository.GetUserAccountTypeByAccessToken(accessToken).getAccountTypeModel().getType();
			String data = "data: asdas \n\n";
			writer.write(data);
			writer.flush();
			
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			return INPUT;
		}
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	public List<NotificationModel> getList() {
		return list;
	}

	@Override
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
