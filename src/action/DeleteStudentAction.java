package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.StudentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import form.StudentForm;

public class DeleteStudentAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudentForm studentForm = (StudentForm) form;
		StudentBO studentBO=new StudentBO();

		boolean isDelete=false;
		isDelete=studentBO.deleteStudent(studentForm.getStudentID());
		if(isDelete==true){
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"delete.student.success"));
			saveMessages(request, messages);
			return mapping.findForward("success");
		}
		else{
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("delete.student.fail"));
			saveErrors(request, actionErrors);
		}
		return mapping.findForward("failure");
		

	}
}
