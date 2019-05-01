package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);//초기값을받습니다.
		
		students = initiateStudentArrayFromLines(lines);//line에 저장되어있는 정보를 사람이름 만 저장해 줍니다.
		
		System.out.println("Number of All Students: " + numOfStudents);//사람 몇명,누구들 인지 방출 
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);//line에 저장되어 있는 정보를 코스에 저장합니다.
		System.out.println("Number of All Courses: " + numOfCourses);//코스가 몇개인지, 뭐뭐있는지 알려줍니다.
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		String name;
		students=new Student[numOfStudents];
		int i=0;
		for(String oneline: lines) {
			name=oneline.substring(oneline.indexOf(" ")+1,oneline.lastIndexOf(','));
			if(!studentExist(students,name)) students[i++]=new Student(name);
		}
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, String student) {
		for(int i=0;i<numOfStudents;i++) {
			if(students[i]!=null)
				if(student.equals(students[i].getName())) return true;
		}
		
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		Course course;
		courses=new Course[this.numOfCourses];
		int i=0;
		for(String oneline: lines) {
			course=new Course(oneline.substring(oneline.lastIndexOf(',')+2,oneline.length()));
			if(!courseExist(courses,course)) this.courses[i++]=course;
			
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		for(int i=0;i<numOfCourses;i++) {
			if(courses[i]!=null)
				if(course.getCourseName().equals(courses[i].getCourseName())) return true;
		}
		return false;
	}

}
