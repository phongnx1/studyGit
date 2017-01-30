package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.bo.CheckLoginBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import form.CheckLoginForm;


public class CheckLoginAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		CheckLoginForm checkLoginForm = (CheckLoginForm) form;
		String userName = checkLoginForm.getUserName();
		String passWord = checkLoginForm.getPassword();
		
		// Check login
		CheckLoginBO checkLoginBO = new CheckLoginBO();
		if (checkLoginBO.checkLogin(userName, passWord)!=0)
			return mapping.findForward("success");
		else{
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"login.fail"));
			saveErrors(request, actionErrors);
			return mapping.findForward("failure");
		}
	}
}
