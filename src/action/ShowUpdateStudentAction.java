package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Student;
import model.bo.StudentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Convert;

import form.StudentForm;

public class ShowUpdateStudentAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudentForm studentForm = (StudentForm) form;

		StudentBO studentBO = new StudentBO();
		Student student = new Student();
		student = studentBO.getStudentInfo(studentForm.getStudentID());
		System.out.println("toi day chua...?");
		studentForm.setStudentID(student.getStudentID());
		studentForm.setFullName(student.getFullName());
		studentForm.setBirthday(student.getBirthday());

		studentForm.setSex(student.getSex());
		studentForm.setClass_name(student.getClass_name());
		studentForm.setSelectedHobbies(Convert.convertStringToArray(student
				.getHobbies()));
		return mapping.findForward("success");

	}
}
