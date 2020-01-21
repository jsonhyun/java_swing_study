package java_swing_study.ch11.exam;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class StudentTblPanel extends AbstractTblPanel<Student> {

	public StudentTblPanel() {

	}

	@Override
	protected void setTblWidthAlign() {
		//각 컬럼의 폭과 셀의 수평정렬
		tableSetWidth(50, 150, 50, 50, 50, 70, 70);
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 4);
		tableCellAlign(SwingConstants.RIGHT, 5, 6);
		tableCellAlign(SwingConstants.LEFT, 3);
	}

	@Override
	protected String[] getColNames() {
		return new String[] {"번호", "학생명", "국어", "영어", "수학", "총점", "평균"};
	}

	@Override
	protected Object[] toArray(Student item) {
		return new Object[] {
				String.format("%03d", item.getStdNo()), 
				item.getStdName(), 
				item.getKor(), 
				item.getEng(), 
				item.getMath(), 
				item.total(), 
				String.format("%.2f", item.avg())};
	}

	@Override
	public void updateRow(Student item, int updateIdx) {
		model.setValueAt(String.format("%03d", item.getStdNo()), updateIdx, 0);//학생번호
		model.setValueAt(item.getStdName(), updateIdx, 1);
		model.setValueAt(item.getKor(), updateIdx, 2);
		model.setValueAt(item.getEng(), updateIdx, 3);
		model.setValueAt(item.getMath(), updateIdx, 4);
		model.setValueAt(item.total(), updateIdx, 5);
		model.setValueAt(String.format("%.2f", item.avg()), updateIdx, 6);
		
	}

	@Override
	public Student getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		int stdNo = Integer.parseInt((String)model.getValueAt(selectedIdx, 0));
		String stdName = (String) model.getValueAt(selectedIdx, 1);
		int kor = (int) model.getValueAt(selectedIdx, 2);
		int eng = (int) model.getValueAt(selectedIdx, 3);
		int math = (int) model.getValueAt(selectedIdx, 4);
		return new Student(stdNo, stdName, kor, eng, math);
	}

}
