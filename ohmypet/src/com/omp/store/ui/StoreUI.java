package com.omp.store.ui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.omp.store.dao.BuyerDAO;
import com.omp.store.dao.ProductDAO;
import com.omp.store.domain.BuyerDM;
import com.omp.store.domain.ProductDM;

public class StoreUI {
	public StoreUI(){
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.상품관리");
			System.out.println("2.게시판관리");
			System.out.println("3.주문관리");
			System.out.println("4.종료");
			System.out.print("원하는 항목을 고르세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1 : 
				Product();
				break;
			case 2 : 
				ShBoard();
				break;
			case 3 : 
				Buyer();
				break;
			case 4 : 
				System.exit(0);
				break;
			}
		}
	}
	public static void Product(){
		Scanner sc = new Scanner(System.in);
		ProductDAO dao = new ProductDAO(); 
		
		while(true) {
			System.out.println("1.상품조회");
			System.out.println("2.상품상세");
			System.out.println("3.상품등록");
			System.out.println("4.상품수정");
			System.out.println("5.상품삭제");
			System.out.println("6.이전으로");
			System.out.print("원하는 항목을 고르세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1 : 
				List<ProductDM> list = dao.ProductList();
				for (ProductDM dm : list) {
					System.out.println(
						dm.getProductId() + "\t" + 
						dm.getCategoryVal()+ "\t" + 
						dm.getProductName()+ "\t" +
						dm.getQuantity()+ "\t" +
						dm.getPrice()+ "\t"
					);
				}
				if (list.isEmpty()) {
					System.out.println("상품이 존재하지 않습니다.");
				}
				break;
			case 2 : 
				System.out.print("찾고싶은 상품의 코드를 입력하세요 : ");
				String productId = sc.nextLine(); 
				ProductDM dm = dao.ProductSelect(productId);
				if (dm != null) {
					SimpleDateFormat sdf = 
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println("상품번호 : " + dm.getProductId());
					System.out.println("분류번호 : " + dm.getCategoryVal());
					System.out.println("상품이름 : " + dm.getProductName());
					System.out.println("총   수량 : " + dm.getQuantity());
					System.out.println("가      격 : " + dm.getPrice());
				}
				else {
					System.out.println(
							"상품코드"+ productId + "번에 해당하는 상품이 없습니다.");
				}
				break;
			case 3 : 
				ProductDM pdm = new ProductDM();
				System.out.print("상품코드 : ");
				pdm.setProductId(sc.nextLine());
				System.out.print("카테고리 : ");
				pdm.setCategoryVal(Integer.parseInt(sc.nextLine()));
				System.out.print("상품명 : ");
				pdm.setProductName(sc.nextLine());
				System.out.print("사진경로 : ");
				pdm.setPhotoPath(sc.nextLine());
				System.out.print("총수량 : ");
				pdm.setQuantity(Integer.parseInt(sc.nextLine()));
				System.out.print("가격 : ");
				pdm.setPrice(Integer.parseInt(sc.nextLine()));
				dao.ProductInsert(pdm);
				System.out.println("등록완료");
				break;
			case 4 : 
				System.out.print("수정할 상품 코드번호를 입력하세요 : ");
				String id = sc.nextLine(); 
				ProductDM domain = dao.ProductSelect(id);
				if (domain == null) {
					System.out.println(
							"상품코드"+ id + "번에 해당하는 상품이 없습니다.");
					return;
				}
				System.out.print("변경할 상품이름을 입력하세요 : ");
				domain.setProductName(sc.nextLine());
				System.out.print("변경할 상품분류를 입력하세요 : ");
				domain.setCategoryVal(Integer.parseInt(sc.nextLine()));
				System.out.print("변경할 상품가격을 입력하세요 : ");
				domain.setPrice(Integer.parseInt(sc.nextLine()));
				System.out.print("변경할 사진경로를 입력하세요 : ");
				domain.setPhotoPath(sc.nextLine());
				System.out.print("변경할 상품수량을 입력하세요 : ");
				domain.setQuantity(Integer.parseInt(sc.nextLine()));
				dao.ProductUpdate(domain);
				System.out.println("상품정보가 수정되었습니다.");
				break;
			case 5 : 
				System.out.print("삭제할 상품 코드번호를 입력하세요 : ");
				String delId = sc.nextLine();
				boolean result = dao.ProductDelete(delId);
				if (result) {
					System.out.println("상품이 삭제되었습니다.");
				}
				else {
					System.out.println(
							"상품코드"+ delId + "번에 해당하는 상품이 없습니다.");
				}
				return;
			case 6 : 
				return;
			}
		}
	}
	public static void ShBoard() {
		
	}
	public static void Buyer() {
		Scanner sc = new Scanner(System.in);
		BuyerDAO dao = new BuyerDAO(); 
		
		while(true) {
			System.out.println("1.구매자조회");
			System.out.println("2.구매자상세");
			System.out.println("3.구매자등록");
			System.out.println("4.구매자수정");
			System.out.println("5.구매자삭제");
			System.out.println("6.이전으로");
			System.out.print("원하는 항목을 고르세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1 : 
				List<BuyerDM> list = dao.BuyerList();
				for (BuyerDM dm : list) {
					System.out.println(
						dm.getBuyNo() + "\t" + 
						dm.getProductId()+ "\t" + 
						dm.getBuysAmount()+ "\t" +
						dm.getBuyDate()+ "\t" +
						dm.getId()+ "\t"
					);
				}
				if (list.isEmpty()) {
					System.out.println("상품이 존재하지 않습니다.");
				}
				break;
			case 2 : 
				System.out.print("찾고싶은 주문번호를 입력하세요 : ");
				String buyNo = sc.nextLine(); 
				BuyerDM dm = dao.BuyerSelect(buyNo);
				if (dm != null) {
					SimpleDateFormat sdf = 
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println("주문번호 : " + dm.getBuyNo());
					System.out.println("분류번호 : " + dm.getProductId());
					System.out.println("상품이름 : " + dm.getBuysAmount());
					System.out.println("총   수량 : " + dm.getBuyDate());
					System.out.println("가      격 : " + dm.getId());
					System.out.println(" : " + dm.getId());
					System.out.println("배송지 : " + dm.getId());
				}
				else {
					System.out.println(
							"상품코드"+ buyNo + "번에 해당하는 상품이 없습니다.");
				}
				break;
			case 3 : 
				BuyerDM bdm = new BuyerDM();
				System.out.print("상품코드 : ");
				bdm.setProductId(sc.nextLine());
				System.out.print("카테고리 : ");
				bdm.setCategoryVal(Integer.parseInt(sc.nextLine()));
				System.out.print("상품명 : ");
				bdm.setProductName(sc.nextLine());
				System.out.print("사진경로 : ");
				bdm.setPhotoPath(sc.nextLine());
				System.out.print("총수량 : ");
				bdm.setQuantity(Integer.parseInt(sc.nextLine()));
				System.out.print("가격 : ");
				bdm.setPrice(Integer.parseInt(sc.nextLine()));
				dao.ProductInsert(pdm);
				System.out.println("등록완료");
				break;
			case 4 : 
				System.out.print("수정할 상품 코드번호를 입력하세요 : ");
				String id = sc.nextLine(); 
				ProductDM domain = dao.BuyerSelect(id);
				if (domain == null) {
					System.out.println(
							"상품코드"+ id + "번에 해당하는 상품이 없습니다.");
					return;
				}
				System.out.print("변경할 상품이름을 입력하세요 : ");
				domain.setProductName(sc.nextLine());
				System.out.print("변경할 상품분류를 입력하세요 : ");
				domain.setCategoryVal(Integer.parseInt(sc.nextLine()));
				System.out.print("변경할 상품가격을 입력하세요 : ");
				domain.setPrice(Integer.parseInt(sc.nextLine()));
				System.out.print("변경할 사진경로를 입력하세요 : ");
				domain.setPhotoPath(sc.nextLine());
				System.out.print("변경할 상품수량을 입력하세요 : ");
				domain.setQuantity(Integer.parseInt(sc.nextLine()));
				dao.BuyerUpdate(domain);
				System.out.println("상품정보가 수정되었습니다.");
				break;
			case 5 : 
				System.out.print("삭제할 상품 코드번호를 입력하세요 : ");
				String delId = sc.nextLine();
				boolean result = dao.BuyerDelete(delId);
				if (result) {
					System.out.println("상품이 삭제되었습니다.");
				}
				else {
					System.out.println(
							"상품코드"+ delId + "번에 해당하는 상품이 없습니다.");
				}
				return;
			case 6 : 
				return;
			}
		}
	}
	public static void Exit() {
		
	}
}
