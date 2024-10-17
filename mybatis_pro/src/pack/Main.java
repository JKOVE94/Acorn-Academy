package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstance();

		/*
		 * try { // 자료추가 System.out.println("\n부분 자료 읽기 --------"); DataDto idto = new
		 * DataDto();
		 * 
		 * idto.setCode("5"); idto.setSang("바나나우유"); idto.setSu("10");
		 * idto.setDan("2000");
		 * 
		 * dao.insData(idto); } catch (Exception e) { System.out.println("err :" +
		 * e.getMessage()); }
		 */

		try {
			// 전체 자료 읽기
			List<DataDto> list = dao.selectAll();
			System.out.println("건수 :" + list.size());

			for (DataDto s : list) {
				System.out.println();
				System.out.println("코드 : " + s.getCode());
				System.out.println("상품 : " + s.getSang());
				System.out.println("개수 : " + s.getSu());
				System.out.println("단가 : " + s.getDan());
			}
		} catch (Exception e) {
		}

		try {
			// 부분 자료 읽기
			System.out.println("\n부분 자료 읽기 --------");
			DataDto dto2 = dao.selectPart("1");
			System.out.println();
			System.out.println("코드 : " + dto2.getCode());
			System.out.println("상품 : " + dto2.getSang());
			System.out.println("개수 : " + dto2.getSu());
			System.out.println("단가 : " + dto2.getDan());
		} catch (Exception e) {
			System.out.println("err :" + e.getMessage());
		}
		/*
		try {
			// 자료 수정
			System.out.println("\n 자료 수정 --------");
			DataDto udto = new DataDto();

			udto.setCode("5");
			udto.setSang("새우깡");
			udto.setSu("20");
			udto.setDan("1000");

			dao.upData(udto); //argument
		} catch (Exception e) {
			System.out.println("err :" + e.getMessage());
		}
		*/
		try {
			// 자료 삭제
			System.out.println("\n 자료 삭제--------");
			boolean b = dao.delData(5); //argument
			if(b) {
				System.out.println("삭제 성공");
			}
			else {
				System.out.println("삭제 실패");
			}
		} catch (Exception e) {
			System.out.println("err :" + e.getMessage());
		}

	}
}
