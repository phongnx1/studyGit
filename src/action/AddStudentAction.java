package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Student;
import model.bo.StudentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import common.Convert;
import form.StudentForm;

public class AddStudentAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudentForm studentForm = (StudentForm) form;
		StudentBO studentBO = new StudentBO();
		Student stud = new Student();
		stud.setStudentID(studentForm.getStudentID());
		stud.setFullName(studentForm.getFullName());
		stud.setBirthday(Convert.untilDateToSqlDate(studentForm.getBirthday()));
		stud.setSex(studentForm.getSex());
		stud.setClass_name(studentForm.getClass_name());
		stud.setHobbies(Convert.convertArrToString(studentForm.getSelectedHobbies()));
		System.out.println("ma sv: "+stud.getStudentID());
		System.out.println("ho ten: "+stud.getFullName());
		System.out.println("ngay sinh: "+stud.getBirthday());
		System.out.println("gioi tinh: "+stud.getSex());
		System.out.println("lop: "+stud.getClass_name());
		System.out.println("so thich: "+stud.getHobbies());
		
		// def
		boolean isInsert=false;
		isInsert=studentBO.insertStudent(stud);
		if(isInsert==true){
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"insert.student.success"));
			saveMessages(request, messages);
			return mapping.findForward("success");
		}
		else{
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("insert.student.fail"));
			saveErrors(request, actionErrors);
		}
		return mapping.findForward("failure");

	}
}
