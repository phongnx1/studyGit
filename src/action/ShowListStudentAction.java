package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.StudentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.StudentForm;

public class ShowListStudentAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudentForm studentForm = (StudentForm) form;

		StudentBO studentBO = new StudentBO();
		studentForm.setListStudent(studentBO.getListStudent());
		studentForm.setSex("Nam");
		
		return mapping.findForward("success");
		

	}
}
